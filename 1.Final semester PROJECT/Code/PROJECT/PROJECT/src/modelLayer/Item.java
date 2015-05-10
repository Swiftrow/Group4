package modelLayer;

public class Item{
   private int barcode, minimumNo, maximumNo, noInStock, price;
   private String name, description, type;
   
    public Item(int barcode, int minimumNo, int price ,int maximumNo, int noInStock, String name, String description, String type){ 
       this.barcode=barcode;
       this.minimumNo=minimumNo;
       this.maximumNo=maximumNo;
       this.noInStock=noInStock;
       this.name=name;
       this.description=description;
       this.type=type; // for sale/loan!
       this.price=price;
    }
    
    public void setPrice(int price){
        this.price=price;
    }
    
    public int getPrice(){
        return price;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getBarcode(){
        return barcode;
    }

    public void setBarcode(int barcode){
        this.barcode = barcode;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getType(){
        return type;
    } 

    public void setType(String type){
        this.type = type;
    }

    public int getMinimumNo(){
        return minimumNo;
    }

    public void setMinimumNo(int minimumNo){
        this.minimumNo = minimumNo;
    }

    public int getMaximumNo(){
        return maximumNo;
    }

    public void setMaximumNo(int maximumNo){
        this.maximumNo = maximumNo;
    }

    public int getNoInStock(){
        return noInStock;
    }

    public void setNoInStock(int noInStock){
        this.noInStock = noInStock;
    }
    
    public void reorderStock(){
        if(this.getNoInStock() < this.getMinimumNo()){
            this.setNoInStock(this.getNoInStock()+this.getMaximumNo()-this.getNoInStock());
        }
    }
}
