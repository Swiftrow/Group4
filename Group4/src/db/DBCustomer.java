package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class DBCustomer  implements IFDBCustomer {

	@Override
	public List<Customer> getAllCustomers(boolean retrieveAssociation) {
		return miscWhere("", retrieveAssociation);
		
	}

	@Override
	public Customer findCustomer(int cpr, boolean retrieveAssociation) {
		Customer c = singleWhere("cpr = " + cpr, retrieveAssociation);
		return c;
	}

	@Override
	public List<Customer> searchCustomer(int cpr, boolean retrieveAssociation) {
		return miscWhere("cpr like '%" + cpr + "%'", retrieveAssociation);
		
	}

	@Override
	public int updateCustomer(Customer c) {
		String q = "update Customer set  cpr=?, name=? , phone=?, email=?, street=?, customerType=?";
		int res = 0;
		try(PreparedStatement s = DBConnection.getInstance().getDBcon().prepareStatement(q)) {
			s.setInt(1, c.getCpr());
			s.setString(2, c.getName());
			s.setString(3, c.getPhone());
			s.setString(4, c.getEmail());
			s.setString(5, c.getStreet());
			s.setString(6, c.getCustomerType());
			
			res = s.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
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
		String q = "delete from Customer where cpr = " + c.getCpr();
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			res = s.executeUpdate(q);
		} 
		catch (SQLException e) {
			
		}
		return res;
	}

	@Override
	public int insertCustomer(Customer c) {
		Address a= c.getAddress();
		int res = 0;
		int resOne = 0;
		String q = "insert into Customer (cpr,name, phone, email,street,customerType) values ('" + c.getCpr() + "', '" + c.getName() +"', "+ c.getPhone()+"', "+ c.getEmail()+ "', "+c.getStreet()+"', "+ c.getCustomerType() +"')";
		String w = "insert into Address(country,city,zipcode) values ('"+ a.getCountry() + "', '" + a.getCity() +"', '" + a.getZipcode() +"')";
		try (Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			res = s.executeUpdate(q);	
			resOne = s.executeUpdate(w);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(q);
		return res;
	}
	
	
	private Customer singleWhere(String where, boolean retrieveAssociation) {
		List<Customer> customer = miscWhere(where, retrieveAssociation);
		if(customer.size() > 0) {
			return customer.get(0);
		}
		return null;
	}
	
	private List<Customer> miscWhere(String where, boolean retrieveAssociation) {
		ResultSet rs;
		List<Customer> customer = new ArrayList<>();
		String query = buildQuery(where);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			s.setQueryTimeout(5);
			rs = s.executeQuery(query);
			while(rs.next()) {
				Customer c = buildCustomer(rs);			
				customer.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	private String buildQuery(String where) {
		String q = "select cpr, name, phone, email, street, customerType from Customer";
		if(where != null && where.length() > 0) {
			q += " where " + where;
		}
		return q;
	}
	
	private Customer buildCustomer(ResultSet rs) {
		Customer c = null;
		try {
			c = new Customer();
			c.setCpr(rs.getInt("cpr"));
			c.setName(rs.getString("name"));
			c.setAddress(new DBAddress().findByCpr(rs.getInt("cpr"), false));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
