package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Clothing;

public class DBClothing {
	
	public Clothing findByBarcode( int barcode, boolean retrieveAssociation)
	{
		String wClause =" barcode= "+ barcode;
		return singleWhere(wClause, retrieveAssociation);
	}
	
	private Clothing singleWhere( String where, boolean retrieveAssociation){
		List<Clothing> clothing =miscWhere(where, retrieveAssociation);
		if(clothing.size()>0)
			return clothing.get(0);
		return null;
	}
	
	private List<Clothing> miscWhere( String where, boolean retrieveAssociation){
		ResultSet rs;
		List<Clothing> clothing = new ArrayList<>();
		String query=buildQuery(where);
		try( Statement s= DBConnection.getInstance().getDBcon().createStatement()){
			s.setQueryTimeout(5);
			rs=s.executeQuery(query);
			while(rs.next()){
				Clothing c= buildClothing(rs);
				clothing.add(c);
			}
		}
		catch(SQLException e){
			
		}
		
		return clothing;
	}
	
	private String buildQuery( String where){
		String q="select size, colour from Clothing";
		if(where!=null& where.length()>0)
			q=q+ "where" + where;
		return q;
	}
	
	private Clothing buildClothing(ResultSet rs){
		Clothing c= new Clothing();
		
		try{
			c.setColour(rs.getString("colour"));
			c.setSize(rs.getString("size"));
		}
		catch(SQLException e){
			
		}

		return null;
	}
	
	
	
	
	
	
}
