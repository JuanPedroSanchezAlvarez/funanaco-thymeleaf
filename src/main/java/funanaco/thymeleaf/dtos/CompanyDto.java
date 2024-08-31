package funanaco.thymeleaf.dtos;

import funanaco.thymeleaf.enums.CountryEnum;
import funanaco.thymeleaf.enums.NicheEnum;
import funanaco.thymeleaf.enums.RegionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private Integer id;

    private String name;
    private NicheEnum niche;
    private CountryEnum country;
    private RegionEnum region;

    private Integer ratioDividendYield; // Annual dividends paid per share / Price per share. Best between 2% and 6%.
    private Integer ratioReturnOnEquity; // Return generated on the total equity. Best top 50% of the group.
    private Integer ratioPriceToBook; // Price per share / Book value per share. Best 1 or less.
    private Integer ratioPayout; // Percentage of profits paid out as dividends. Best under 80%.
    private Integer ratioDebtToEquity; // Debt / Equity. Best 2 or less.

}
