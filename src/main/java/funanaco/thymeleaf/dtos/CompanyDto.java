package funanaco.thymeleaf.dtos;

import funanaco.thymeleaf.enums.CountryEnum;
import funanaco.thymeleaf.enums.RegionEnum;
import funanaco.thymeleaf.enums.SectorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private Integer id;
    private String name;
    private SectorEnum sector;
    private CountryEnum country;
    private RegionEnum region;

}
