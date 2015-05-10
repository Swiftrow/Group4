package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Telephone;

public class DbTelephone implements IFDBTelephone {

	@Override
	public List<Telephone> getAllTelephones(boolean retrieveAssociation){
		return miscWhere("", retrieveAssociation);
	}

	@Override
	public Telephone findTelephone(int serialNo, boolean retrieveAssociation) {
		Telephone t = singleWhere("serialNo = " + serialNo, retrieveAssociation);
		return t;
	}

	@Override
	public List<Telephone> searchTelephone(int serialNo,
			boolean retrieveAssociation) {
		
		return miscWhere("serialNo like '%"+ serialNo + "%'", retrieveAssociation);
	}

	@Override
	public int updateTelephone(Telephone t) {
		String q = "update Telephone set serialNo=?, type=?";
		int res = 0;
		try(PreparedStatement s = DbConnection.getInstance().getDBcon().prepareStatement(q)){
			s.setInt(1, t.getSerialNo());
			s.setString(2, t.getType());
			
			res = s.executeUpdate();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		catch(NullPointerException npe){
			npe.printStackTrace();
		}
		return res;
	}

	@Override
	public int removeTelephone(Telephone t) {
		if(t == null)
		return 0;
		int res = 0;
		String q = "delete from Telephone where serialNo = " + t.getSerialNo();
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()){
			res = s.executeUpdate(q);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
			return res;	
	}

	@Override
	public int insertTelephone(Telephone t) {
		int res = 0;
		
		String q = "inster into Telephone (serialNo,type) values ('"+ t.getSerialNo() + "', '"+ t.getType()+"')";
		try (Statement s = DbConnection.getInstance().getDBcon().createStatement()){
			res = s.executeUpdate(q);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return res;
	}
	
	private Telephone singleWhere(String where, boolean retrieveAssociation){
		List<Telephone> Telephone = miscWhere(where, retrieveAssociation);
		if(Telephone.size() > 0){
			return Telephone.get(0);
		}
		return null;
	}
	
	private List<Telephone> miscWhere(String where, boolean retrieveAssociation){
		ResultSet rs;
		List<Telephone> Telephone = new ArrayList<>();
		String query = buildQuery(where);
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()){
			s.setQueryTimeout(5);
			rs = s.executeQuery(query);
			while(rs.next()){
				Telephone t = buildTelephone(rs);
				Telephone.add(t);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return Telephone;
		}
	
	
	private String buildQuery(String where){
		String q = "select serialNo,type from Telephone";
		if(where != null && where.length() > 0){
			q += "where" + where;
		}
		return q;
	}
	
	private Telephone buildTelephone(ResultSet rs){
		Telephone t = null;
		try{
			t = new Telephone();
			t.setSerialNo(rs.getInt("serialNo"));
			t.setType(rs.getString("type"));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return t;
	}

}
