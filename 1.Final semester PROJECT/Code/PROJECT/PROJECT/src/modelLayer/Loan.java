package modelLayer;

import java.util.*;
public class Loan
{
    private ArrayList<OrderLineLoan> orderLineLoans;
    private String date, period;
    private int idL;
    private static int idOll;
    private int price;
    private String status;
    private Customer c;
    private Employee e;
    private boolean ok=false;
    
    public Loan(String date, String period, Customer c, Employee e){
        orderLineLoans= new ArrayList<>();
        this.date=date;
        this.period=period;
        price=0;
        this.c=c;
        status = "ongoing";
        this.e=e;
        e.setNoOfLoans(1);
    }
    
    public void addOrderLineLoan(OrderLineLoan oll){
        idOll++;
        orderLineLoans.add(oll);
        oll.setId(idOll);
        price =+ oll.getPrice();
    }
    
    public int getTotalPrice(){
        return price;
    }
    
    public int getDiscountType(){
        if(c.getType().equals("gold")){
            return 10;
        }
        if(c.getType().equals("silver")){
            return 6;
        }
        if(c.getType().equals("bronze")){
            return 3;
        }
        return 0;
    }
   
    
    public int discountPrice(){
        price = price-price* getDiscountType()/100;
        if (!ok) {e.setMoneyMade(price);}
        ok=true;
        return price;
    }
    
    public void setDate(String date){
        this.date=date;
    }

    public String getDate(){
        return date;
    }

    public void setId(int idL){
        this.idL=idL;
    }

    public int getId(){
        return idL;
    }

    public void setStatus(String status){
        this.status=status;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setPeriod(String period){
        this.period=period;
    }
    
    public String getPeriod(){
        return period;
    }
    
    public void setPrice(int price){
        this.price=price;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setCustomer(Customer c){
        this.c=c;
    }
    
    public String getCustomerName(){
        return c.getName();
    }
}
