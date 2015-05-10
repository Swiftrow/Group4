package modelLayer;

import java.util.*;
public class OrderLineLoan
{
    private int quantity, idOll,price;
    private ItemContainer itemContainer;
    private Item item;
    
    public OrderLineLoan(int quantity, Item i){
        this.quantity=quantity;
        item = i;
        price=item.getPrice()*quantity;
    }
    
    public void setId(int idOll){
        this.idOll=idOll;
    }
    
    public int getQuantity(){
        return quantity;
    }
    public int getPrice(){
        return price;
    }
    
    public void decreaseNoInStock(){
        item.setNoInStock(item.getNoInStock()-quantity);
    }
    
   
}
