package funanaco.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyController {

    @RequestMapping("/company")
    public String getCompany() {
        return "company";
    }

}
