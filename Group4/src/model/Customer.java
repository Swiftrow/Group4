package model;

public class Customer {
	private int cpr;
	private String name;
	private Address address;
	private String email;
	private String zipcode;
	private String city;
	private String phone;
	private String street;
	private String customerType;
	
	public Customer(){
		
	}
	public Customer(int cpr, String name, Address address, String email,
			String zipcode, String city, String phone,String street, String customerType) {
		
		this.cpr = cpr;
		this.name = name;
		this.address = address;
		this.email = email;
		this.zipcode = zipcode;
		this.city = city;
		this.phone = phone;
		this.street= street;
		this.customerType = customerType;
	}

	

	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public int getCpr() {
		return cpr;
	}


	public String getName() {
		return name;
	}


	public Address getAddress() {
		return address;
	}


	public String getEmail() {
		return email;
	}


	public String getZipcode() {
		return zipcode;
	}


	public String getCity() {
		return city;
	}


	public String getPhone() {
		return phone;
	}


	public String getCustomerType() {
		return customerType;
	}


	public void setCpr(int cpr) {
		this.cpr = cpr;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setCustomerType(String type) {
		this.customerType = type;
	}


	@Override
	public String toString() {
		return "Customer [cpr=" + cpr + ", name=" + name + ", address="
				+ address + ", email=" + email + ", zipcode=" + zipcode
				+ ", city=" + city + ", phone=" + phone + ", street=" + street
				+ ", customerType=" + customerType + "]";
	}
	
	


	
	
	

}
