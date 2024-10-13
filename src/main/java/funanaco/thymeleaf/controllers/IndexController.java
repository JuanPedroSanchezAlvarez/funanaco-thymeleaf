package funanaco.thymeleaf.controllers;

import funanaco.thymeleaf.commands.FilterCommand;
import funanaco.thymeleaf.dtos.CompanyDto;
import funanaco.thymeleaf.enums.CountryEnum;
import funanaco.thymeleaf.enums.NicheEnum;
import funanaco.thymeleaf.enums.RegionEnum;
import funanaco.thymeleaf.services.CompanyService;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private static final String INDEX_PATH = "/";
    private static final String INDEX_PAGE = "index";

    private final CompanyService service;

    @GetMapping(path = INDEX_PATH)
    public String getIndex(@RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size,
                           @RequestParam(value = "sort", defaultValue = "name") String sort,
                           @RequestParam(value = "direction", defaultValue = "asc") String direction,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "niche", required = false) String niche,
                           @RequestParam(value = "country", required = false) String country,
                           @RequestParam(value = "region", required = false) String region,
                           Model model) {
        FilterCommand filterCommand = new FilterCommand(
                StringUtils.isBlank(name) ? null : name.trim(),
                StringUtils.isBlank(niche) ? null : NicheEnum.valueOf(niche),
                StringUtils.isBlank(country) ? null : CountryEnum.valueOf(country),
                StringUtils.isBlank(region) ? null : RegionEnum.valueOf(region));
        Page<CompanyDto> pageOfCompanies = service.findAll(page, size, sort, direction, filterCommand);
        model.addAttribute("filterCommand", filterCommand);
        model.addAttribute("listOfCompanies", pageOfCompanies.getContent());
        model.addAttribute("totalPages", pageOfCompanies.getTotalPages());
        model.addAttribute("currentPage", pageOfCompanies.getNumber());
        model.addAttribute("sortField", sort);
        model.addAttribute("sortDirection", direction);
        model.addAttribute("reverseSortDirection", direction.equals("asc") ? "desc" : "asc");
        return INDEX_PAGE;
    }

    @PostMapping(path = INDEX_PATH)
    public String postIndex(@Valid FilterCommand filterCommand, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:" + INDEX_PATH;
        }
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromPath(INDEX_PATH)
                .queryParam("name", filterCommand.getName().trim())
                .queryParam("niche", filterCommand.getNiche() == null ? "" : filterCommand.getNiche().name())
                .queryParam("country", filterCommand.getCountry() == null ? "" : filterCommand.getCountry().name())
                .queryParam("region", filterCommand.getRegion() == null ? "" : filterCommand.getRegion().name());
        return "redirect:" + uriBuilder.toUriString();
    }

}
