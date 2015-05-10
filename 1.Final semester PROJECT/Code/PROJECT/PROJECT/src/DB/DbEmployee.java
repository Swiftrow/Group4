package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Employee;

public class DbEmployee  implements IFDBEmployee {

	@Override
	public List<Employee> getAllEmployees(boolean retrieveAssociation) {
		return miscWhere("", retrieveAssociation);
		
	}
 
	@Override
	public Employee findEmployee(int id, boolean retrieveAssociation) {
		Employee e = singleWhere("id = " + id, retrieveAssociation);
		return e;
	}

	@Override
	public List<Employee> searchEmployee(int id, boolean retrieveAssociation) {
		return miscWhere("id like '%" + id + "%'", retrieveAssociation);
		
	}

	@Override
	public int updateEmployee(Employee e) {
		String q = "update Employee set  id=?, name=? , phone=?, email=?, street=?, EmployeeType=?";
		int res = 0;
		try(PreparedStatement s = DbConnection.getInstance().getDBcon().prepareStatement(q)) {
			s.setInt(1, e.getId());
			s.setInt(2, e.getQualifications());
			s.setString(3, e.getPhone());
			s.setString(4, e.getfName());
			s.setString(5, e.getlName());
			s.setString(6, e.getAddress());
			s.setString(7, e.getPhone());
			s.setString(8, e.getType());
			
			res = s.executeUpdate();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch(NullPointerException  npe) {
			// Employee c could be null
		}
		return res;
		
	}

	@Override
	public int removeEmployee(Employee e) {
		if(e == null)
			return 0;
		int res = 0;
		String q = "delete from Employee where id = " + e.getId();
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()) {
			res = s.executeUpdate(q);
		} 
		catch (SQLException ex) {
			
		}
		return res;
	}

	@Override
	public int insertEmployee(Employee e) {
		
		int res = 0;
		
		String q = "insert into Employee (id,qualifications, lName, fName,address, phone, type) values ('" + e.getId() + "', '" + e.getQualifications() +"', "+ e.getfName()+"', "+ e.getlName()+ "', "+e.getAddress()+"', "+ e.getPhone() +"',"+e.getType()+"')";
		
		try (Statement s = DbConnection.getInstance().getDBcon().createStatement()) {
			res = s.executeUpdate(q);	
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		//System.out.println(q);
		return res;
	}
	
	
	private Employee singleWhere(String where, boolean retrieveAssociation) {
		List<Employee> Employee = miscWhere(where, retrieveAssociation);
		if(Employee.size() > 0) {
			return Employee.get(0);
		}
		return null;
	}
	
	private List<Employee> miscWhere(String where, boolean retrieveAssociation) {
		ResultSet rs;
		List<Employee> Employee = new ArrayList<>();
		String query = buildQuery(where);
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()) {
			s.setQueryTimeout(5);
			rs = s.executeQuery(query);
			while(rs.next()) {
				Employee e = buildEmployee(rs);			
				Employee.add(e);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return Employee;
	}
	private String buildQuery(String where) {
		String q = "select id,qualifications, lName, fName,address, phone, type from Employee";
		if(where != null && where.length() > 0) {
			q += " where " + where;
		}
		return q;
	}
	
	private Employee buildEmployee(ResultSet rs) {
		Employee e = null;
		try {
			e = new Employee();
			e.setId(rs.getInt("id"));
			e.setQualifications(rs.getInt("qualifications"));
			e.setfName(rs.getString("fname"));
			e.setlName(rs.getString("lname"));
			e.setAddress(rs.getString("address"));
			e.setPhone(rs.getString("phone"));
			e.setType(rs.getString("type"));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	

}