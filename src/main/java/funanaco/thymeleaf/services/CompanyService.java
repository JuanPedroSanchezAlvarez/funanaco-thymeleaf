package funanaco.thymeleaf.services;

import funanaco.thymeleaf.dtos.CompanyDto;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> findAll();
    CompanyDto findById(Integer id);

}
