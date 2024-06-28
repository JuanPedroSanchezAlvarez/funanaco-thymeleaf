package funanaco.thymeleaf.services;

import funanaco.thymeleaf.dtos.CompanyDto;
import funanaco.thymeleaf.enums.CountryEnum;
import funanaco.thymeleaf.enums.RegionEnum;
import funanaco.thymeleaf.enums.SectorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Override
    public List<CompanyDto> findAll() {
        return findAllDummy();
    }

    @Override
    public CompanyDto findById(Integer id) {
        return findOneDummy();
    }

    private List<CompanyDto> findAllDummy() {
        List<CompanyDto> list = new ArrayList<>();
        list.add(new CompanyDto(1, "CompanyDummy 1", SectorEnum.AIRLINES, CountryEnum.AFGHANISTAN, RegionEnum.AFRICA));
        list.add(new CompanyDto(2, "CompanyDummy 2", SectorEnum.AUTOMOBILES, CountryEnum.ARGENTINA, RegionEnum.ASIA));
        list.add(new CompanyDto(3, "CompanyDummy 3", SectorEnum.BIOTECHNOLOGY, CountryEnum.BENIN, RegionEnum.EUROPE));
        list.add(new CompanyDto(4, "CompanyDummy 4", SectorEnum.CHEMICALS, CountryEnum.CROATIA, RegionEnum.ANTARCTICA));
        list.add(new CompanyDto(5, "CompanyDummy 5", SectorEnum.COMMERCIAL_BANKS, CountryEnum.DOMINICAN_REPUBLIC, RegionEnum.SOUTH_AMERICA));
        for (int i = 0; i < 48; i++) {
            list.add(new CompanyDto(6 + i, "CompanyDummy " + (6 + i), SectorEnum.COMMERCIAL_BANKS, CountryEnum.DOMINICAN_REPUBLIC, RegionEnum.SOUTH_AMERICA));
        }
        return list;
    }

    private CompanyDto findOneDummy() {
        return new CompanyDto(1, "CompanyDummy 1", SectorEnum.AIRLINES, CountryEnum.AFGHANISTAN, RegionEnum.AFRICA);
    }

}
