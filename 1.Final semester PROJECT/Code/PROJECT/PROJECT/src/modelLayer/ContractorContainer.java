package modelLayer;

import java.util.*;
public class ContractorContainer{

    private static ContractorContainer instance = null;
    private ArrayList<Contractor> contractors;

    public ContractorContainer(){
        contractors = new ArrayList<>();
    }

    public static ContractorContainer getInstance(){
        if(instance == null){
            instance = new ContractorContainer();
        }
        return instance;
     } 

    public void addContractor(Contractor newContractor){
        contractors.add(newContractor);
    }

    public Contractor findContractor(int id){
        for(Contractor cont: contractors){
            if(cont.getId() == id){
                return cont;
            }
        }
        return null;
    }
    
    public void updateContractor(int id,String name,String deliveryTime){
        for(Contractor cont: contractors){
            if(cont.getId() == id){
                cont.setName(name);
                cont.setDeliveryTime(deliveryTime);
            }
        }
    }

    public void deleteContractor(int id){
        for(Iterator<Contractor> i = contractors.iterator(); i.hasNext();){
            Contractor contractor = i.next();
            if(contractor.getId()==id){
                i.remove();
            }
        }
    }
}
