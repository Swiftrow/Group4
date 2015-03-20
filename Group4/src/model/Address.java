package model;

public class Address {
	private String country, city, zipcode;

	public Address()
	{
		
	}
	public Address(String country, String city, String zipcode) {
		
		this.country = country;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
