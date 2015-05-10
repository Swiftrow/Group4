package controlLayer;
import modelLayer.*;

public class EmployeeCtr
{
    private EmployeeContainer employeeContainer;
    
    public EmployeeCtr(){
        employeeContainer = employeeContainer.getInstance();
    }
    
    public void createEmployee(String name, String address, String phoneNo, String email,int employeeId){
        Employee e = new Employee(name,address,phoneNo,email,employeeId);
        employeeContainer.addEmployee(e);
    }
    
    public Employee findEmployee(int employeeId){
        return employeeContainer.findEmployee(employeeId);
    }
    
    public void updateEmployee( int employeeId, String name, String address, String phoneNo, String email){
        employeeContainer.updateEmployee(employeeId,name,address,phoneNo,email);
    }
    
    public void deleteEmployee(int employeeId){
        employeeContainer.deleteEmployee(employeeId);
    }
    
    public int getNoOfSells(int employeeId) {
        return employeeContainer.findEmployee(employeeId).getNoOfSells();
    }
    public int getNoOfLoans(int employeeId) {
        return employeeContainer.findEmployee(employeeId).getNoOfLoans();
    }
    public int getMoneyMade(int employeeId) {
        return employeeContainer.findEmployee(employeeId).getMoneyMade();
    }
}
