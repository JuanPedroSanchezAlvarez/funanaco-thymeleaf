package funanaco.thymeleaf.enums;

public enum RegionEnum {

	AFRICA("Africa"),
	ANTARCTICA("Antarctica"),
	ASIA("Asia"),
	AUSTRALIA("Australia"),
	EUROPE("Europe"),
	NORTH_AMERICA("North America"),
	SOUTH_AMERICA("South America");

    private final String displayValue;

    RegionEnum(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
