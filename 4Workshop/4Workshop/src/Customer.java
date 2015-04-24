public class Customer 
{
    private int idC;
    private String name;
   	

    /**
     * Create a Customer object.
     * @param idC The ID of the customer.
     * @param name The name of the customer.
     * @param address The address of the customer.
     * @param phoneNo The phone number of the customer.
     * @param email The email of the customer.
     */
    public Customer(String name){
        this.name=name;
       

    }
   
    
    public void setId(int idC){
        this.idC=idC;
    }

    public int getId(){
        return idC;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

  
    
}