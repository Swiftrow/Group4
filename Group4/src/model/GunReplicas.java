package model;

public class GunReplicas extends Product{
	public String fabric;
	public String calibre;
	
	public GunReplicas(){
		
	}
	public GunReplicas(String name, int sPrice, int rPrice, int barcode,int minStock,String productType,String fabric,String calibre) {
		super(name, sPrice, rPrice, barcode, minStock, productType);
		this.calibre=calibre;
		this.fabric=fabric;
	}

	public String getFabric() {
		return fabric;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}
	
	

}
