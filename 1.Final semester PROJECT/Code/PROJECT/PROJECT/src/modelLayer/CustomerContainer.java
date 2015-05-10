package modelLayer;

import java.util.*;
/**
 * CustomerContainer is a class that contain all the Customer objects
 * @author group 6 - Robert Ivan, Cosmin Stan, Cristian Moldovan, Tamasan Dacian, Andrei Razvan.  
 */
public class CustomerContainer
{
    private static CustomerContainer instance = null;
    private ArrayList<Customer> customers;
    private static int idC = 0;
    
     /**
     * Constructor af an ArrayList of type Customer.
     * @param customers The  array list that holds all the Customer objects.
     */
    public CustomerContainer(){
        customers = new ArrayList<>();
        
    }

     /**
     * Singleton pattern which ensure that only one instance of a class is created.
     * @param instance The instance of the PersonContainer class.
     */
    public static CustomerContainer getInstance() {
        if (instance == null) {
            instance = new CustomerContainer();
        }
        return instance;
    }
    
    /**
     * Add a given Customer object in the customers ArrayList.
     * @param c The new Customer object.
     * @param idC The id that keeps incrementing for every customer you add.
     */
    public void addCustomer(Customer c){
        customers.add(c);
        idC++;
        c.setId(idC);
    }

     /**
     * Get a Customer object by a given ID.
     * @param idC The ID of a person.
     */
    public Customer findCustomer(int idC){
        for(Customer c: customers){
            if(c.getId()==idC){
                return c;
            }
        }
        return null;
    }

    /**
     * Update the Customer object information such as name, address, phone number, email.
     * @param idC the ID of the soon to be updated Customer object.
     * @param name The name of the customer.
     * @param address The address of the customer.
     * @param phoneNo The phone number of the customer.
     * @param email The email of the customer.
     */
    public void updateCustomer(int idC, String name, String address, String phoneNo, String email,String type){
        for(Customer c : customers){
            if(c.getId() == idC){
                c.setName(name);
                c.setAddress(address);
                c.setPhoneNo(phoneNo);
                c.setEmail(email);
                c.setType(type);
                
            }
        }
    }
    
    
    /**
     * Delete a Customer object from the customers ArryList.
     * @param idC The ID of the Customer object to be deleted.
     */
    public void deleteCustomer(int idC){
        for(Iterator<Customer> i = customers.iterator(); i.hasNext();){
            Customer customer = i.next();
            if(customer.getId() == idC){
                i.remove();
            }
        }
        }
        
        
    
}
    

