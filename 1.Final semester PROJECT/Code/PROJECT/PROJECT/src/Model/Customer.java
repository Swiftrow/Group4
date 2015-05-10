package Model;

public class Customer {

	private int id;
	private String cpr, fName, lName, address, phone;
	
	public Customer(){}
	
	public Customer(int id, String cpr, String fName, String lName,
			String address, String phone) {
		super();
		this.id = id;
		this.cpr = cpr;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public String getCpr() {
		return cpr;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCpr(String cpr) {
		this.cpr = cpr;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
