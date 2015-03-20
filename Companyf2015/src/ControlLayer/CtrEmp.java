

package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;
/**
 * CtrEmp.java
 * @author kbh
 * @version 5. oktober 2006
 * @version 2011.11.02 change to illustrate transaction
 * @version 2012.02.12 changed to eclipse
 */
public class CtrEmp {
   
    
    /** Creates a new instance of CtrEmp */
    public CtrEmp() {
        
    }
    public ArrayList<Employee> findAllEmployee()
    {
      IFDBEmp dbEmp = new DBEmployee();
      ArrayList<Employee> allEmp = new ArrayList<Employee>();
      allEmp = dbEmp.getAllEmployees(false);
      return allEmp;
    }
    public Employee findByFname(String fname)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeFname(fname, true);
    }
     public Employee findByLname(String lname)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeLname(lname, true);
    }
      public Employee findBySsn(String ssn)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeSsn( ssn, true);
    }
      public int updateEmp(String fname, String lname, String ssn, double salary, String superssn)
      {
          IFDBEmp dbEmp = new DBEmployee();
          Employee emp = new Employee();
          emp.setSsn(ssn);
          emp.setFname(fname);
          emp.setLname(lname);
          emp.setSupervisor(new Employee(superssn));
          emp.setSalary(salary);
          return  dbEmp.updateEmployee(emp);
          
          
      }
      //find the projects the employee is working on
      public ArrayList<WorksOn> findProject(String ssn)
      {
          IFDBWorksOn dbWorksOn = new DBWorksOn();
          ArrayList<WorksOn> result = dbWorksOn.findWorksOn(ssn);
          return result;
      }
      public void insertNew(String fname, String lname, double salary, String superssn) throws Exception
      {    
           Employee empObj = new Employee();
           empObj.setFname(fname);
                
           empObj.setLname(lname);
           empObj.setSupervisor(new Employee(superssn));
    
           try{
            DbConnection.startTransaction();
            DBEmployee dbEmp = new DBEmployee();
            dbEmp.insertEmployee(empObj);
            DbConnection.commitTransaction();
           }
           catch(Exception e)
           {
               DbConnection.rollbackTransaction();
               throw new Exception("Employee not inserted");
           }
      }
    
}
