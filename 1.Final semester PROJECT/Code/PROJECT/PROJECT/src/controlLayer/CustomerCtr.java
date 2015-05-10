package controlLayer;


import modelLayer.*;

public class CustomerCtr
{
    private CustomerContainer customerContainer;
    
    public CustomerCtr(){
        customerContainer = CustomerContainer.getInstance();
    }
    
    public int createCustomer(String name, String address, String phoneNo, String email,String type){
        Customer c = new Customer(name,address,phoneNo,email,type);
        customerContainer.addCustomer(c);
        return c.getId();
    }
    
    public Customer findCustomer(int idC){
        return customerContainer.findCustomer(idC);
    }
    
    public void updateCustomer(int idC, String name, String address, String phoneNo, String email,String type){
        customerContainer.updateCustomer(idC,name,address,phoneNo,email,type);
    }
    
    public void deleteCustomer(int idC){
        customerContainer.deleteCustomer(idC);
    }
    
    public int getDiscountType(int idC){
        return customerContainer.findCustomer(idC).getDiscountType();
    }
}
