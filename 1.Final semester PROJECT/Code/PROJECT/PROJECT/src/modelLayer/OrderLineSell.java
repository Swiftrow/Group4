package modelLayer;

public class OrderLineSell
{
    private int idOls,quantity, barcode,price;
    private ItemContainer itemContainer;
    private Item item;

    public OrderLineSell(int quantity, Item i){
        this.quantity=quantity;
        item=i;
        price=item.getPrice()*quantity;
    }
    
    public void setId(int idOls){
        this.idOls=idOls;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void decreaseNoInStock(){
        item.setNoInStock(item.getNoInStock()-quantity);
    }
    
    public String getItemName(){
        return item.getName();
    }
    
    public int getPrice(){
       return price;
    }
}

