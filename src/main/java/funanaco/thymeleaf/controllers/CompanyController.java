package funanaco.thymeleaf.controllers;

import funanaco.thymeleaf.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService companyService) {
        this.service = companyService;
    }

    @GetMapping("/company/{id}")
    public String getCompanyById(@PathVariable Integer id, Model model) {
        model.addAttribute("company", service.findById(id));
        return "company"; // "redirect:/index"
    }

}
