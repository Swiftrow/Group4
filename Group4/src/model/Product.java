package model;

public class Product {
	private String name;
	private int sPrice;
	private int rPrice;
	private int barcode;
	private int minStock;
	private String productType;
	
	
	public Product(String name, int sPrice, int rPrice, int barcode,
			int minStock, String productType) {
		super();
		this.name = name;
		this.sPrice = sPrice;
		this.rPrice = rPrice;
		this.barcode = barcode;
		this.minStock = minStock;
		this.productType= productType;
	}
	public Product(){
		
	}

	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getName() {
		return name;
	}

	public int getsPrice() {
		return sPrice;
	}

	public int getrPrice() {
		return rPrice;
	}

	public int getBarcode() {
		return barcode;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", sPrice=" + sPrice + ", rPrice="
				+ rPrice + ", barcode=" + barcode + ", minStock=" + minStock
				+ "]";
	}
	
	
	
	
	
}
