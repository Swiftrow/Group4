package model;

public class Equipement extends Product{
	private String eqType;
	private String eqDescription;
	
	public Equipement(){
		
	}
	public Equipement(String name, int sPrice, int rPrice, int barcode,int minStock,String productType,String type, String description) {
		super(name, sPrice, rPrice, barcode, minStock, productType);
		this.eqDescription=description;
		this.eqType=type;
	}
	public String getType() {
		return eqType;
	}
	public String getDescription() {
		return eqDescription;
	}
	public void setType(String type) {
		this.eqType = type;
	}
	public void setDescription(String description) {
		this.eqDescription = description;
	}
	
	

}
