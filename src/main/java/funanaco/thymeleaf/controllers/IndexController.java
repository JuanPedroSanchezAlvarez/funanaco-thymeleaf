package funanaco.thymeleaf.controllers;

import funanaco.thymeleaf.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final CompanyService service;

    public IndexController(CompanyService companyService) {
        this.service = companyService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

}
