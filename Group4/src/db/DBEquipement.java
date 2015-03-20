package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Equipement;

public class DBEquipement {
	
	public Equipement findByBarcode( int barcode, boolean retrieveAssociation)
	{
		String wClause =" barcode= "+ barcode;
		return singleWhere(wClause, retrieveAssociation);
	}
	
	private Equipement singleWhere( String where, boolean retrieveAssociation){
		List<Equipement> equipement =miscWhere(where, retrieveAssociation);
		if(equipement.size()>0)
			return equipement.get(0);
		return null;
	}
	
	private List<Equipement> miscWhere( String where, boolean retrieveAssociation){
		ResultSet rs;
		List<Equipement> equipement = new ArrayList<>();
		String query=buildQuery(where);
		try( Statement s= DBConnection.getInstance().getDBcon().createStatement()){
			s.setQueryTimeout(5);
			rs=s.executeQuery(query);
			while(rs.next()){
				Equipement e= buildEquipement(rs);
				equipement.add(e);
			}
		}
		catch(SQLException e){
			
		}
		
		return equipement;
	}
	
	private String buildQuery( String where){
		String q="select size, colour from Equipement";
		if(where!=null& where.length()>0)
			q=q+ "where" + where;
		return q;
	}
	
	private Equipement buildEquipement(ResultSet rs){
		Equipement e= new Equipement();
		
		try{
			e.setType(rs.getString("type"));
			e.setDescription(rs.getString("description"));
		}
		catch(SQLException ex){
			
		}

		return null;
	}
	
	
	
	
	
	
}
