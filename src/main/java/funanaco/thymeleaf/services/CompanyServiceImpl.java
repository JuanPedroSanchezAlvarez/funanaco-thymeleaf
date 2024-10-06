package funanaco.thymeleaf.services;

import funanaco.thymeleaf.dtos.CompanyDto;
import funanaco.thymeleaf.enums.CountryEnum;
import funanaco.thymeleaf.enums.NicheEnum;
import funanaco.thymeleaf.enums.RegionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Override
    public Page<CompanyDto> findAll(Pageable pageable) {
        List<CompanyDto> listOfCompanies = findAllDummy();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), listOfCompanies.size());
        List<CompanyDto> contentPageOfCompanies = listOfCompanies.subList(start, end);
        return new PageImpl<>(contentPageOfCompanies, pageable, listOfCompanies.size());
    }

    @Override
    public CompanyDto findById(Integer id) {
        return findOneDummy();
    }

    private List<CompanyDto> findAllDummy() {
        List<CompanyDto> list = new ArrayList<>();
        list.add(new CompanyDto(1, "Realty Income Corp.", NicheEnum.HEALTHCARE, CountryEnum.AFGHANISTAN, RegionEnum.AFRICA, 0, 0, 0, 0, 0));
        list.add(new CompanyDto(2, "CompanyDummy 2", NicheEnum.HEALTHCARE, CountryEnum.ARGENTINA, RegionEnum.ASIA, 0, 0, 0, 0, 0));
        list.add(new CompanyDto(3, "CompanyDummy 3", NicheEnum.HEALTHCARE, CountryEnum.BENIN, RegionEnum.EUROPE, 0, 0, 0, 0, 0));
        list.add(new CompanyDto(4, "CompanyDummy 4", NicheEnum.HEALTHCARE, CountryEnum.CROATIA, RegionEnum.ANTARCTICA, 0, 0, 0, 0, 0));
        list.add(new CompanyDto(5, "CompanyDummy 5", NicheEnum.HEALTHCARE, CountryEnum.DOMINICAN_REPUBLIC, RegionEnum.SOUTH_AMERICA, 0, 0, 0, 0, 0));
        for (int i = 0; i < 48; i++) {
            list.add(new CompanyDto(6 + i, "CompanyDummy " + (6 + i), NicheEnum.HEALTHCARE, CountryEnum.DOMINICAN_REPUBLIC, RegionEnum.SOUTH_AMERICA, 0, 0, 0, 0, 0));
        }
        return list;
    }

    private CompanyDto findOneDummy() {
        return new CompanyDto(1, "CompanyDummy 1", NicheEnum.HEALTHCARE, CountryEnum.AFGHANISTAN, RegionEnum.AFRICA, 0, 0, 0, 0, 0);
    }

}
