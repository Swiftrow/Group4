package DB;

import java.util.List;

import Model.Employee;

public interface IFDBEmployee {
	public List<Employee> getAllEmployees (boolean retrieveAssociation);
	public Employee findEmployee (int id, boolean retrieveAssociation);
	public List<Employee> searchEmployee( int id, boolean retrieveAssociation);
	public int updateEmployee(Employee e);
	public int removeEmployee (Employee e);
	public int insertEmployee (Employee e);

}
