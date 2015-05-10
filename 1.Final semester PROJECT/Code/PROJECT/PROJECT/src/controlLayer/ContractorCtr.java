package controlLayer;
import modelLayer.*;

public class ContractorCtr
{
   private ContractorContainer contractorContainer;
   
   public ContractorCtr(){
    contractorContainer = ContractorContainer.getInstance();
    }
    
    public void createContractor(int id,String name,String deliveryTime){
        Contractor cont = new Contractor(id,name,deliveryTime);
        contractorContainer.addContractor(cont);
    }
    
    public Contractor findContractor(int id){
        return contractorContainer.findContractor(id);
    }
    
    public void updateContractor(int id,String name,String deliveryTime){
        contractorContainer.updateContractor(id,name,deliveryTime);
    }
    
    public void deleteContractor(int id){
        contractorContainer.deleteContractor(id);
    }
}
