import java.util.ArrayList;


public class ItemContainer {
	

	private static int idS;
	private static ItemContainer instance = null;
	private ArrayList<Item> items;
	
	public ItemContainer() {
		items = new ArrayList<>();
	}

	 public static ItemContainer getInstance(){
	        if(instance == null){
	            instance = new ItemContainer();
	        }
	        return instance;
	    }
	 
	 public void addItem(Item i){
		 idS++;
		 items.add(i);
	 }
	 
	 public int getId(){
		 return idS;
	 }
	 
	 public void getInfo(){
		 System.out.println("Number of items in Item container : "+ items.size());
	 }
	 
	 public Item findItem(int idS){
		 for(Item i : items){
			 if(i.getId() == idS){
				 return i;
			 }
		 }
		 
		 return null;
	 }
	 
	 
}
