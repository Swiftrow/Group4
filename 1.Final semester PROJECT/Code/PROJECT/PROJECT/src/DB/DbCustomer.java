package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;

public class DbCustomer  implements IFDBCustomer {

	@Override
	public List<Customer> getAllCustomers(boolean retrieveAssociation) {
		return miscWhere("", retrieveAssociation);
		
	}
 
	@Override
	public Customer findCustomer(int id, boolean retrieveAssociation) {
		Customer c = singleWhere("id = " + id, retrieveAssociation);
		return c;
	}

	@Override
	public List<Customer> searchCustomer(int id, boolean retrieveAssociation) {
		return miscWhere("id like '%" + id + "%'", retrieveAssociation);
		
	}

	@Override
	public int updateCustomer(Customer c) {
		String q = "update Customer set  id=?, name=? , phone=?, email=?, street=?, CustomerType=?";
		int res = 0;
		try(PreparedStatement s = DbConnection.getInstance().getDBcon().prepareStatement(q)) {
			s.setInt(1, c.getId());
			s.setString(2, c.getCpr());
			s.setString(3, c.getfName());
			s.setString(4, c.getlName());
			s.setString(5, c.getAddress());
			s.setString(6, c.getPhone());
			
			res = s.executeUpdate();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch(NullPointerException  npe) {
			// Customer c could be null
		}
		return res;
		
	}

	@Override
	public int removeCustomer(Customer c) {
		if(c == null)
			return 0;
		int res = 0;
		String q = "delete from Customer where id = " + c.getId();
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()) {
			res = s.executeUpdate(q);
		} 
		catch (SQLException ex) {
			
		}
		return res;
	}

	@Override
	public int insertCustomer(Customer c) {
		
		int res = 0;
		
		String q = "insert into Customer (id, cpr, fName, lName, address, phone) values ('" + c.getId() + "', '" + c.getCpr() +"', "+ c.getfName()+"', "+ c.getlName()+ "', "+c.getAddress()+"', "+ c.getPhone()+"')";
		
		try (Statement s = DbConnection.getInstance().getDBcon().createStatement()) {
			res = s.executeUpdate(q);	
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		//System.out.println(q);
		return res;
	}
	
	
	private Customer singleWhere(String where, boolean retrieveAssociation) {
		List<Customer> Customer = miscWhere(where, retrieveAssociation);
		if(Customer.size() > 0) {
			return Customer.get(0);
		}
		return null;
	}
	
	private List<Customer> miscWhere(String where, boolean retrieveAssociation) {
		ResultSet rs;
		List<Customer> Customer = new ArrayList<>();
		String query = buildQuery(where);
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()) {
			s.setQueryTimeout(5);
			rs = s.executeQuery(query);
			while(rs.next()) {
				Customer c = buildCustomer(rs);			
				Customer.add(c);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return Customer;
	}
	private String buildQuery(String where) {
		String q = "select id, cpr, lName, fName,address, phone from Customer";
		if(where != null && where.length() > 0) {
			q += " where " + where;
		}
		return q;
	}
	
	private Customer buildCustomer(ResultSet rs) {
		Customer c = null;
		try {
			c = new Customer();
			c.setId(rs.getInt("id"));
			c.setCpr(rs.getString("cpr"));
			c.setfName(rs.getString("fname"));
			c.setlName(rs.getString("lname"));
			c.setAddress(rs.getString("address"));
			c.setPhone(rs.getString("phone"));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return c;
	}

	

}