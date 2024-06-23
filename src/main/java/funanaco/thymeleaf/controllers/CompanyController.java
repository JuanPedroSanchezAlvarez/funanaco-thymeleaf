package funanaco.thymeleaf.controllers;

import funanaco.thymeleaf.services.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CompanyController {

    private static final String COMPANY_PATH = "/company/{id}";
    private static final String COMPANY_PAGE = "company";

    private final CompanyService service;

    @GetMapping(path = COMPANY_PATH)
    public String getCompanyById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("company", service.findById(id));
        return COMPANY_PAGE; // "redirect:/index"
    }

}
