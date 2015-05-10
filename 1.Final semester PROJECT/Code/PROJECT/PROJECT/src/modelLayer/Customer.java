package modelLayer;
/**
 * Customer is a class that contain all the Customer objects
 * @author group 6 - Robert Ivan, Cosmin Stan, Cristian Moldovan, Tamasan Dacian, Andrei Razvan.  
 */
public class Customer 
{
    private int idC;
    private String name, address, phoneNo, email,type;
   	

    /**
     * Create a Customer object.
     * @param idC The ID of the customer.
     * @param name The name of the customer.
     * @param address The address of the customer.
     * @param phoneNo The phone number of the customer.
     * @param email The email of the customer.
     */
    public Customer(String name, String address, String phoneNo, String email,String type){
        this.name=name;
        this.address=address;
        this.phoneNo=phoneNo;
        this.email=email;
        this.type=type;
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
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getAddress(){
        return address;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }
    
    public int getDiscountType(){
        if(getType().equals("gold")){
            return 10;
        }
        if(getType().equals("silver")){
            return 6;
        }
        if(getType().equals("bronze")){
            return 3;
        }
        return 0;
    }
    
    
}
