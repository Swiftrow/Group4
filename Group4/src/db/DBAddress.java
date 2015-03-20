package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Address;
import model.Customer;

public class DBAddress {

	public Address findByCpr(int cpr, boolean retrieveAssociation) {
		String wClause = " cpr= "+ cpr;
		
		return singleWhere (wClause, retrieveAssociation);
	}
	
	private Address singleWhere(String where, boolean retrieveAssociation) {
		List<Address> address = miscWhere(where, retrieveAssociation);
		if(address.size() > 0) {
			return address.get(0);
		}
		return null;
	}
	
	private List<Address> miscWhere(String where, boolean retrieveAssociation) {
		ResultSet rs;
		List<Address> address = new ArrayList<>();
		String query = buildQuery(where);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			s.setQueryTimeout(5);
			rs = s.executeQuery(query);
			while(rs.next()) {
				Address a = buildAddress(rs);
			
				address.add(a);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return address;
	}

	private Address buildAddress(ResultSet rs) {
		Address a= new Address();
		
		try {
			a.setCity(rs.getString("city"));
			a.setCountry(rs.getString("country"));
			a.setZipcode(rs.getString("zipcode"));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	private String buildQuery(String where) {
		String q = "select country, city, zipcode  from Address";
		if(where != null && where.length() > 0) {
			q += " where " + where;
		}
		return q;
	}

}
