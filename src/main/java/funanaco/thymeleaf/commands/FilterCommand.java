package funanaco.thymeleaf.commands;

import funanaco.thymeleaf.enums.CountryEnum;
import funanaco.thymeleaf.enums.NicheEnum;
import funanaco.thymeleaf.enums.RegionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterCommand {

    private String name;
    private NicheEnum niche;
    private CountryEnum country;
    private RegionEnum region;

}
