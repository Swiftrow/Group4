package modelLayer;

import java.util.*;

public class Sell{
    private String date;
    private ArrayList<OrderLineSell> orderLineSells;
    private int idS;
    private static int idOls;
    private Customer c;
    private int price,amount;
    private Employee e;
    private boolean ok=false;
   
    
    public Sell(String date, Customer c, Employee e){
        orderLineSells = new ArrayList<>();
        this.date=date;
        this.c=c;
        this.e=e;
        e.setNoOfSells(1);
    }
    
    
    public void addOrderLineSell(OrderLineSell ols){
        idOls++;
        orderLineSells.add(ols);
        ols.setId(idOls);
    }
    
    public int getTotalPrice(){
        price=0;
        for(OrderLineSell os : orderLineSells){
            price = price + os.getPrice();
        }
        return price;
    }
    
    public int getDiscountAmount(){
        amount=0;
        for(OrderLineSell o : orderLineSells){
            amount = amount + o.getQuantity();
        }
        if(amount>207){
            return 10;
        }
        if(amount>100){
            return 6;
        }
        if(amount>50){
            return 3;
        }
        return 0;
    }
    
     public int discountPrice(){
        price = price - price * (c.getDiscountType()+ getDiscountAmount() )/ 100;
        if (!ok) {e.setMoneyMade(price);}
        ok=true;
        return price;
    }
    
    
    public void setId(int idS){
        this.idS=idS;
    }
    
    public int getId(){
        return idS;
    }
    
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    
    public void setDate(String date){
        this.date=date;
    }
    
    public String getDate(){
        return date;
    }
   
    public String getCustomerName(){
        return c.getName();
    }
    public int getCustomerId(){
        return c.getId();
    }
    public String getBoughtItemInfo(){
        for(OrderLineSell a : orderLineSells){
            System.out.println("Item Name:\t\t "+a.getItemName());
            System.out.println("Quantity:\t\t "+a.getQuantity());
            
        }
        return"\n";
    }
}
