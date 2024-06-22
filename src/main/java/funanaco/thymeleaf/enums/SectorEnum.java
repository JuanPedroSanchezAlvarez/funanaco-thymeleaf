package funanaco.thymeleaf.enums;

public enum SectorEnum {

    AIRLINES("Airlines"),
	AUTOMOBILES("Automobiles"),
	BIOTECHNOLOGY("Biotechnology"),
	CHEMICALS("Chemicals"),
	COMMERCIAL_BANKS("Commercial Banks"),
	CONSTRUCTION("Construction"),
    CONSUMER("Consumer"),
	DISTRIBUTION("Distribution"),
	ELECTRIC_UTILITIES("Electric Utilities"),
	FOOD("Food"),
	GAS_UTILITIES("Gas Utilities"),
	HIGHWAYS_AND_INFRASTRUCTURE("Highways and Infrastructure"),
	HOLDINGS("Holdings"),
	INDUSTRIALS("Industrials"),
	INSURANCE("Insurance"),
	INVESTMENT_BANKS("Investment Banks"),
	MEDIA("Media"),
	OIL_COMPANIES("Oil Companies"),
	PHARMACEUTICALS("Pharmaceuticals"),
	REAL_ESTATE("Real Estate"),
	TECHNOLOGY("Technology"),
    TELECOMMUNICATIONS("Telecommunications"),
    WATER("Water");

	private final String displayValue;

    SectorEnum(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
