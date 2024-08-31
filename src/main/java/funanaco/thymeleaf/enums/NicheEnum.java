package funanaco.thymeleaf.enums;

public enum NicheEnum {

	HEALTHCARE("Healthcare"),
	HOSPITALITY("Hospitality"),
	INDUSTRIAL("Industrial"),
	INFRASTRUCTURE("Infrastructure"),
	OFFICE("Office"),
	RESIDENTIAL("Residential"),
	RETAIL("Retail"),
	SPECIALTY("Specialty"),
	TIMBERLAND("Timberland");

	private final String displayValue;

    NicheEnum(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
