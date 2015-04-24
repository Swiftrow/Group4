
public class OrderlineSale {

	private int id, amount, amountInStock;;
	private String backorder;
	private Item item;
	
	
	public OrderlineSale(int amount, String backorder, Item i) {
		this.amount=amount;
		this.backorder=backorder;
		item = i;
		
	}

	public void updateAmount(){
		
		amountInStock = item.getAmountInStock();
		
		if(amountInStock<=amount){
			item.setReorder("Yes reorder");
			setBackorder("Yes reorder");
			}
		if(amountInStock>=amount){
			
			
			amountInStock = amount - amountInStock;
			item.setAmountInStock(amountInStock);
		}
		
	}
	
	public void setBackorder(String backorder){
		this.backorder=backorder;
	}
	
	public void setId(int id){
		this.id=id;
		
	}
	
	public int getAmount(){
		return amount;
	}
	
	public int getID(){
		return id;
	}
	
	public String getBackorder(){
		return backorder;
	}


	public void info() {
		System.out.println(amount+" " + backorder);
	}
	

}
