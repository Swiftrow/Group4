package model;

public class Clothing extends Product {
	private String size;
	private String colour;
	
	
	
	public Clothing(String name, int sPrice, int rPrice, int barcode, int minStock,String productType, String size, String colour) {
		super(name, sPrice, rPrice,barcode, minStock, productType);
		this.size=size;
		this.colour=colour;		
	}
	public Clothing(){}

	public String getSize() {
		return size;
	}

	public String getColour() {
		return colour;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
	
	

}
