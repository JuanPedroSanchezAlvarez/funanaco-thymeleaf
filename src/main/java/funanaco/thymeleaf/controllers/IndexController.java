package funanaco.thymeleaf.controllers;

import funanaco.thymeleaf.commands.FilterCommand;
import funanaco.thymeleaf.services.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private static final String INDEX_PATH = "/";
    private static final String INDEX_PAGE = "index";

    private final CompanyService service;

    @GetMapping(path = INDEX_PATH)
    public String getIndex(Model model) {
        model.addAttribute("filterCommand", new FilterCommand());
        model.addAttribute("listOfCompanies", service.findAll());
        return INDEX_PAGE;
    }

    @PostMapping(path = INDEX_PATH)
    public String postIndex(@Valid FilterCommand filterCommand, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:" + INDEX_PATH;
        }
        model.addAttribute("filterCommand", filterCommand);
        model.addAttribute("listOfCompanies", service.findAll());
        return INDEX_PAGE;
    }

}
