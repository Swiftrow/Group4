package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class DBGunReplicas {
	
	public GunReplicas findByBarcode( int barcode, boolean retrieveAssociation)
	{
		String wClause =" barcode= "+ barcode;
		return singleWhere(wClause, retrieveAssociation);
	}
	
	private GunReplicas singleWhere( String where, boolean retrieveAssociation){
		List<GunReplicas> gunReplicas =miscWhere(where, retrieveAssociation);
		if(gunReplicas.size()>0)
			return gunReplicas.get(0);
		return null;
	}
	
	private List<GunReplicas> miscWhere( String where, boolean retrieveAssociation){
		ResultSet rs;
		List<GunReplicas> gunReplicas = new ArrayList<>();
		String query=buildQuery(where);
		try( Statement s= DBConnection.getInstance().getDBcon().createStatement()){
			s.setQueryTimeout(5);
			rs=s.executeQuery(query);
			while(rs.next()){
				GunReplicas g= buildGunReplicas(rs);
				gunReplicas.add(g);
			}
		}
		catch(SQLException e){
			
		}
		
		return gunReplicas;
	}
	
	private String buildQuery( String where){
		String q="select calibre, fabric from GunReplicas";
		if(where!=null& where.length()>0)
			q=q+ "where" + where;
		return q;
	}
	
	private GunReplicas buildGunReplicas(ResultSet rs){
		GunReplicas g= new GunReplicas();
		
		try{
			g.setFabric(rs.getString("fabric"));
			g.setCalibre(rs.getString("calibre"));
		}
		catch(SQLException e){
			
		}

		return null;
	}
	
	
	
	
	
	
}
