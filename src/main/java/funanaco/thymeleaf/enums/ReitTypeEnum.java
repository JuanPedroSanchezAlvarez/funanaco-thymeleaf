package funanaco.thymeleaf.enums;

public enum ReitTypeEnum {

	EQUITY("Equity"),
	MORTGAGE("Mortgage"),
	HYBRID("Hybrid");

	private final String displayValue;

    ReitTypeEnum(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
