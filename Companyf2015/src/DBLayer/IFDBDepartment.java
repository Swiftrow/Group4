
package DBLayer;
import ModelLayer.*;
import java.util.ArrayList;
/**
 * Interface to the DBEmployeer
 * @author kbh
 */
public interface IFDBDepartment {
    // get all Department
    public ArrayList<Department> getAllDepartment(boolean retriveAssociation);
    //get one Departmen having the dno
    public Department findDepartment(int dno, boolean retriveAssociation);
    //find one department having the department name 
    public Department searchDeparmentOnName( String dname, boolean retriveAssociation);
    //insert new department
    public int insert(Department dept);
    //update department
    public int update(Department dept);
    //delete department
    public int delete(Department dept);
    
}