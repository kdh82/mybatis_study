package kr.or.dgit.mybatis_study.dto;

public class PhoneNumber {
	private String countrycode;
	private String stateCode;
	private String number;
	public PhoneNumber() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return String.format("%s-%s-%s", countrycode, stateCode, number);
	}
	public PhoneNumber(String str){
		if(str != null){
			String[] parts = str.split("-");
			if(parts.length >0){
				this.countrycode = parts[0];
			}if(parts.length >1){
				this.stateCode = parts[1];
			}if(parts.length >2){
				this.number = parts[2];
			}
		}
		
		
	}
	public PhoneNumber(String countrycode, String stateCode, String number) {
		super();
		this.countrycode = countrycode;
		this.stateCode = stateCode;
		this.number = number;
	}
}
