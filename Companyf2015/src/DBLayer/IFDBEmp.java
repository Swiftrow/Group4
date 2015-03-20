/*
 * IFDBEmp.java
 *
 * Created on 5. oktober 2006, 13:53
 *
 
 */

package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;
/**
 * Interface to the DBEmployeer
 * @author kbh
 */
public interface IFDBEmp {
    // get all employees
    public ArrayList<Employee> getAllEmployees(boolean retriveAssociation);
    //get one employee having the ssn
    public Employee findEmployee(String empssn, boolean retriveAssociation);
    //find one employee having the name
    public Employee searchEmployeeFname( String fname, boolean retriveAssociation);
    public Employee searchEmployeeLname( String Lname, boolean retriveAssociation);
    
    //insert a new employee
    public int insertEmployee(Employee emp) throws Exception;
    //update information about an employee
    public int updateEmployee(Employee emp);
	public Employee searchEmployeeSsn(String ssn, boolean b);
    
}
