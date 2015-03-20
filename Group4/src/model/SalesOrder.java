package model;

public class SalesOrder {
	public int idS;
	public String date;
	public String deliveryStatus, deliveryDate;
	
	public SalesOrder(int idS, String date, String deliveryStatus,
			String deliveryDate) {
		super();
		this.idS = idS;
		this.date = date;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
	}

	public int getIdS() {
		return idS;
	}

	public String getDate() {
		return date;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setIdS(int idS) {
		this.idS = idS;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	
	
	
	
	

}
