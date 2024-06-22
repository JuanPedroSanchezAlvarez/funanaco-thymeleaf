package funanaco.thymeleaf.dtos;

import funanaco.thymeleaf.enums.CountryEnum;
import funanaco.thymeleaf.enums.RegionEnum;
import funanaco.thymeleaf.enums.SectorEnum;

public class CompanyDto {

    private Integer id;
    private String name;
    private SectorEnum sector;
    private CountryEnum country;
    private RegionEnum region;

    public CompanyDto(Integer id, String name, SectorEnum sector, CountryEnum country, RegionEnum region) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.country = country;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SectorEnum getSector() {
        return sector;
    }

    public void setSector(SectorEnum sector) {
        this.sector = sector;
    }

    public CountryEnum getCountry() {
        return country;
    }

    public void setCountry(CountryEnum country) {
        this.country = country;
    }

    public RegionEnum getRegion() {
        return region;
    }

    public void setRegion(RegionEnum region) {
        this.region = region;
    }

}
