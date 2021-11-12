package Beans;

public class Country {
	
	public Country(String countryId,String countryName)
	{
		this.countryId=countryId;
		this.countryName=countryName;
	}
	public String countryId;
	
	
	public String countryName;


	public String getCountryId() {
		return countryId;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
