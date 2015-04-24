import java.util.ArrayList;


public class Sale {
	
	private ArrayList<OrderlineSale> orderlineSale;
	private static int id;
	private String date;
	private Customer c;
	
	
	public Sale(String date, Customer c) {
		orderlineSale = new ArrayList<>();
		this.date=date;
		this.c=c;
		
	}

	public void addOrderlineSale(OrderlineSale ols){
		id++;
		orderlineSale.add(ols);
		ols.setId(id);
	}

	public ArrayList<OrderlineSale> getOrderlineSale() {
		return orderlineSale;
	}

	public static int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public Customer getC() {
		return c;
	}

	public void setOrderlineSale(ArrayList<OrderlineSale> orderlineSale) {
		this.orderlineSale = orderlineSale;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Sale [orderlineSale=" + orderlineSale + ", date=" + date
				+ ", c=" + c + "]";
	}
	
}
