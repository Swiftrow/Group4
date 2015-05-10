package Model;

public class Contract {

	private int id, customerID;
	private String date, period;
	private Subscription sub;
	private Customer customer;
	
	public Contract(int id, int customerID, String date, String period,
			Subscription sub, Customer customer) {
		super();
		this.id = id;
		this.customerID = customerID;
		this.date = date;
		this.period = period;
		this.sub = sub;
		this.customer = customer;
	}

	public Contract() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getDate() {
		return date;
	}

	public String getPeriod() {
		return period;
	}

	public Subscription getSub() {
		return sub;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setSub(Subscription sub) {
		this.sub = sub;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
