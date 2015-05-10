package modelLayer;

import java.util.*;

public class EmployeeContainer
{
    private static EmployeeContainer instance = null;
    private ArrayList<Employee> employees;
    
    
     /**
     * Constructor af an ArrayList of type Employee.
     * @param Employees The  array list that holds all the Employee objects.
     */
    public EmployeeContainer(){
        employees = new ArrayList<>();   
    }

     /**
     * Singleton pattern which ensure that only one instance of a class is created.
     * @param instance The instance of the PersonContainer class.
     */
    public static EmployeeContainer getInstance() {
        if (instance == null) {
            instance = new EmployeeContainer();
        }
        return instance;
    }
    
    public void addEmployee(Employee e){
        employees.add(e);
    }


    public Employee findEmployee(int employeeId){
        for(Employee e: employees){
            if(e.getId()==employeeId){
                return e;
            }
        }
        return null;
    }

    public void updateEmployee(int employeeId, String name, String address, String phoneNo, String email){
            for(Employee e : employees){
                if(e.getId() == employeeId){
                e.setName(name);
                e.setAddress(address);
                e.setPhoneNo(phoneNo);
                e.setEmail(email);
            }
        }
    }
   
    public void deleteEmployee(int employeeId){
        for(Iterator<Employee> i = employees.iterator(); i.hasNext();){
            Employee employee = i.next();
            if(employee.getId() == employeeId){
                i.remove();
            }
        }
        } 
    }
    

