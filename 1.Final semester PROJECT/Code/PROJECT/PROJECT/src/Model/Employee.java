package Model;

public class Employee {

	private int id, qualifications;
	private String fName, lName, address, phone, type;
	
	public Employee(){}
	

	public Employee(int id, int qualifications, String fName, String lName,
			String address, String phone, String type) {
		super();
		this.id = id;
		this.qualifications = qualifications;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
		this.type = type;
	}


	public int getId() {
		return id;
	}


	public int getQualifications() {
		return qualifications;
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


	public String getType() {
		return type;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setQualifications(int qualifications) {
		this.qualifications = qualifications;
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


	public void setType(String type) {
		this.type = type;
	}

}
