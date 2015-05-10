package modelLayer;

import java.util.*;

public class SellContainer{
    private ArrayList<Sell> sales;
    private static int idS=0;
    private static SellContainer instance=null;

    public SellContainer(){
        sales = new ArrayList<>();
    }

    public static SellContainer getInstance(){
        if(instance == null){
            instance = new SellContainer();
        }
        return instance;
    } 

    public void addSell(Sell s){
        idS++;
        s.setId(idS);
        sales.add(s);
       

    }

    public Sell findSell(int idS){
    	for(Sell sell : sales){
            if(sell.getId()==idS){
                return sell;
            }
        }
        return null;
    }

    public void deleteSell(int idS){
        for(Iterator<Sell> i = sales.iterator(); i.hasNext();){
            Sell sell = i.next();
            if(sell.getId()==idS){
                i.remove();
            }
        }
    }

    public int getSellsNo(){
        return sales.size();
    }

    public int getTotalAmountSells(){
        int price=0,x;
        for(Sell sell: sales){
            x = sell.getTotalPrice();
            x = sell.discountPrice();
            price=price+x;
        }

        return price;
    }

}
