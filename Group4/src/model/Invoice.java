package model;

public class Invoice {
	public int invoiceNo;
	public String paymentDate;
	public int finalPrice;
	
	public Invoice(int invoiceNo, String paymentDate, int finalPrice) {
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.finalPrice = finalPrice;
	}
	
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	

}
