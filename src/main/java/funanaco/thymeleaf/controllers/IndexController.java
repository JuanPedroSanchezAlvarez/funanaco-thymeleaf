package funanaco.thymeleaf.controllers;

import funanaco.thymeleaf.services.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private static final String INDEX_PATH = "/";
    private static final String INDEX_PAGE = "index";

    private final CompanyService service;

    @GetMapping(path = INDEX_PATH)
    public String getIndex(Model model) {
        model.addAttribute("listOfCompanies", service.findAll());
        return INDEX_PAGE;
    }

}
