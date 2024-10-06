package funanaco.thymeleaf.controllers;

import funanaco.thymeleaf.commands.FilterCommand;
import funanaco.thymeleaf.dtos.CompanyDto;
import funanaco.thymeleaf.services.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                           Model model) {
        Page<CompanyDto> pageOfCompanies = service.findAll(page, size, sort, direction);
        model.addAttribute("filterCommand", new FilterCommand());
        model.addAttribute("listOfCompanies", pageOfCompanies.getContent());
        model.addAttribute("totalPages", pageOfCompanies.getTotalPages());
        model.addAttribute("currentPage", pageOfCompanies.getNumber());
        model.addAttribute("sortField", sort);
        model.addAttribute("sortDirection", direction);
        model.addAttribute("reverseSortDirection", direction.equals("asc") ? "desc" : "asc");
        return INDEX_PAGE;
    }

    @PostMapping(path = INDEX_PATH)
    public String postIndex(@RequestParam(value = "page", defaultValue = "0") int page,
                            @RequestParam(value = "size", defaultValue = "10") int size,
                            @Valid FilterCommand filterCommand, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:" + INDEX_PATH;
        }
        //Pageable pageable = PageRequest.of(page, size);
        //Page<CompanyDto> pageOfCompanies = service.findAll(pageable);
        //model.addAttribute("filterCommand", filterCommand);
        //model.addAttribute("listOfCompanies", service.findAll(pageable));
        return INDEX_PAGE;
    }

}
