package controlLayer;

import modelLayer.*;
import java.util.*;

public class SellCtr{
   private SellContainer sellContainer;

   private static int idS;
   private int idOls;
   
   public SellCtr(){
       sellContainer = SellContainer.getInstance();
   }
   
   public void createSell(String date, Customer c, Employee e){
       Sell sell = new Sell(date,c,e);
       sellContainer.addSell(sell);
       idS = sell.getId();
   } 
   
   public void addItemToSell(OrderLineSell orderLineSell){
       sellContainer.findSell(idS).addOrderLineSell(orderLineSell);
   }
   
   public int getId(){
       return idS;
   }
   
   public int getIdOls(){
       return idOls;
    }
   
   public Sell findSell(int idS){
      return sellContainer.findSell(idS);
   }
   
   public void deleteSell(int idS){
       sellContainer.deleteSell(idS);
   }
   public int getSellsNo(){
        return sellContainer.getSellsNo();
    }
    public int getTotalAmountSells(){
        return sellContainer.getTotalAmountSells();
    }
}
