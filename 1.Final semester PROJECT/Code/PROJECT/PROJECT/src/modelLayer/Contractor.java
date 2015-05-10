package modelLayer;

public class Contractor{
    
    private int id;
    private String name;
    private String deliveryTime;
    private Item i;
    
    public Contractor(int id,String name,String deliveryTime){
        this.id = id;
        this.name = name;
        this.deliveryTime = deliveryTime;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getDeliveryTime(){
        return deliveryTime;
    }
    
    public void setDeliveryTime(String deliveryTime){
        this.deliveryTime = deliveryTime;
    }
}


