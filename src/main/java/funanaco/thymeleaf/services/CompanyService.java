package funanaco.thymeleaf.services;

import funanaco.thymeleaf.dtos.CompanyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    Page<CompanyDto> findAll(Pageable pageable);
    CompanyDto findById(Integer id);

}
