package Model;

public class CreditCard {

	private String number;
	private String name;
	private String securityCode;
	private Integer validationDay;
	private Integer validationMonth;
	private String type;
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
	public Integer getValidationDay() {
		return validationDay;
	}
	public void setValidationDay(Integer validationDay) {
		this.validationDay = validationDay;
	}
	
	public Integer getValidationMonth() {
		return validationMonth;
	}
	public void setValidationMonth(Integer validationMonth) {
		this.validationMonth = validationMonth;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
