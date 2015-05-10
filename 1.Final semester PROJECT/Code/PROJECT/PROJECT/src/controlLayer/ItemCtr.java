package controlLayer;
import modelLayer.*;

public class ItemCtr
{
    private ItemContainer itemContainer;
    public ItemCtr(){
        itemContainer = ItemContainer.getInstance();
    }
    
    public void createItem(int barcode, int minimumNo,int price, int maximumNo, int noInStock, String name, String description, String type){
        Item i = new Item(barcode, minimumNo,price, maximumNo, noInStock, name, description, type);
        itemContainer.addItem(i);
    }
    
    public Item findItem(int barcode){
        return itemContainer.findItem(barcode);
    }
    
    public void updateItem(int barcode, int noInStock,String name,String description, String type, int minimumNo, int maximumNo, int price){
        itemContainer.updateItem(barcode, noInStock, name, description,type,minimumNo, maximumNo, price);
    }
    
    public void deleteItem(int barcode){
        itemContainer.deleteItem(barcode);
    }
    
    public int getNoInStock(int barcode){
        return itemContainer.findItem(barcode).getNoInStock();
    }
    
    public void reorderStock(int barcode){
        itemContainer.findItem(barcode).reorderStock();
    }
}
