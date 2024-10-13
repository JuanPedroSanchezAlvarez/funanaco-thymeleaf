package funanaco.thymeleaf.services;

import funanaco.thymeleaf.commands.FilterCommand;
import funanaco.thymeleaf.dtos.CompanyDto;
import funanaco.thymeleaf.enums.CountryEnum;
import funanaco.thymeleaf.enums.NicheEnum;
import funanaco.thymeleaf.enums.RegionEnum;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Override
    public Page<CompanyDto> findAll(int page, int size, String sort, String direction, FilterCommand filterCommand) {
        // Get the list of companies.
        List<CompanyDto> listOfCompanies = findAllDummy();
        // Filter it.
        listOfCompanies = filterListOfCompanies(listOfCompanies, filterCommand);
        // Order it.
        listOfCompanies = orderListOfCompanies(listOfCompanies, sort, direction);
        // Page it.
        return pageListOfCompanies(listOfCompanies, page, size);
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

    private List<CompanyDto> filterListOfCompanies(List<CompanyDto> listOfCompanies, FilterCommand filterCommand) {
        if (StringUtils.isNotBlank(filterCommand.getName())) {
            listOfCompanies = listOfCompanies.stream().filter(c -> c.getName().toLowerCase().contains(filterCommand.getName().toLowerCase())).collect(Collectors.toList());
        }
        if (filterCommand.getNiche() != null) {
            listOfCompanies = listOfCompanies.stream().filter(c -> c.getNiche().equals(filterCommand.getNiche())).collect(Collectors.toList());
        }
        if (filterCommand.getCountry() != null) {
            listOfCompanies = listOfCompanies.stream().filter(c -> c.getCountry().equals(filterCommand.getCountry())).collect(Collectors.toList());
        }
        if (filterCommand.getRegion() != null) {
            listOfCompanies = listOfCompanies.stream().filter(c -> c.getRegion().equals(filterCommand.getRegion())).collect(Collectors.toList());
        }
        return listOfCompanies;
    }

    private List<CompanyDto> orderListOfCompanies(List<CompanyDto> listOfCompanies, String sort, String direction) {
        Comparator<CompanyDto> comparator = switch (sort) {
            case "name" -> Comparator.comparing(CompanyDto::getName);
            case "niche" -> Comparator.comparing(CompanyDto::getNiche);
            case "country" -> Comparator.comparing(CompanyDto::getCountry);
            case "region" -> Comparator.comparing(CompanyDto::getRegion);
            default -> throw new IllegalArgumentException("Invalid sort field: " + sort);
        };
        if (direction.equalsIgnoreCase("desc")) {
            comparator = comparator.reversed();
        }
        listOfCompanies.sort(comparator);
        return listOfCompanies;
    }

    private Page<CompanyDto> pageListOfCompanies(List<CompanyDto> listOfCompanies, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), listOfCompanies.size());
        List<CompanyDto> contentPageOfCompanies = listOfCompanies.subList(start, end);
        return new PageImpl<>(contentPageOfCompanies, pageable, listOfCompanies.size());
    }

}
