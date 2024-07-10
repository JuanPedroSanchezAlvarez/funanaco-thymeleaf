package funanaco.thymeleaf.commands;

import funanaco.thymeleaf.enums.CountryEnum;
import funanaco.thymeleaf.enums.RegionEnum;
import funanaco.thymeleaf.enums.SectorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterCommand {

    private String name;
    private SectorEnum sector;
    private CountryEnum country;
    private RegionEnum region;

}
