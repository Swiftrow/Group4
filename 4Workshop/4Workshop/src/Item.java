
public class Item {
	
	private String name, origin, reorder;
	private int id, purchasePrice, salesPrice, rentPrice, amountInStock, minStock, maxPurchase;

	public Item(int id,String name, String origin, String reorder, int purchasePrice,
			int salesPrice, int rentPrice, int amountInStock, int minStock,
			int maxPurchase) {

		this.id=id;
		
		this.name = name;
		this.origin = origin;
		this.reorder = reorder;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.amountInStock = amountInStock;
		this.minStock = minStock;
		this.maxPurchase = maxPurchase;
	}

	public String getName() {
		return name;
	}

	public String getOrigin() {
		return origin;
	}

	public String getReorder() {
		return reorder;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getSalesPrice() {
		return salesPrice;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public int getAmountInStock() {
		return amountInStock;
	}

	public int getMinStock() {
		return minStock;
	}

	public int getMaxPurchase() {
		return maxPurchase;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setReorder(String reorder) {
		this.reorder = reorder;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public void setAmountInStock(int amountInStock) {
		this.amountInStock = amountInStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	public void setMaxPurchase(int maxPurchase) {
		this.maxPurchase = maxPurchase;
	}


	public void info() {
		System.out.println(name+" " + origin+" " + reorder+" " +id+" "+ purchasePrice+" "+ salesPrice+" "+ rentPrice+" "+ amountInStock+" "+ minStock+" "+ maxPurchase);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
