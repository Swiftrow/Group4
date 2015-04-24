import org.junit.Test;


public class test1 {

	private String name, origin, reorder, backorder;
	private int amount, id, purchasePrice, salesPrice, rentPrice, amountInStock, minStock, maxPurchase;
	
	private Item itemOne;
	private ItemContainer itemContainer;
	private OrderlineSale orderlineSaleOne;

	private Customer c;
	private Sale sale;
	
	
	public void setUpSecondItem(){
		
	}
	
	@Test
	public void test() {
		backorder = "No backorder";
		itemOne = new Item(id = 1,name = "Maceta",origin = "Acasa",reorder = "nu",purchasePrice = 120,salesPrice = 500,rentPrice = 75,amountInStock = 3,minStock = 0,maxPurchase = 90);
		
		itemOne.info();
		
		itemContainer = new ItemContainer();
		
		
		
		itemContainer.addItem(itemOne);

		
		
		orderlineSaleOne = new OrderlineSale(3, backorder, itemOne);
		orderlineSaleOne.updateAmount();

		
		
		orderlineSaleOne.info();
		
		c = new Customer("Vasile");
		sale = new Sale("20/04/24", c);
		
		sale.addOrderlineSale(orderlineSaleOne);
	
	
		
		
		
		
		itemContainer.getInfo();
		

	
		
	}

}
