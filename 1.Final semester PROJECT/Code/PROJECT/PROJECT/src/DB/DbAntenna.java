package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Antenna;

public class DbAntenna implements IFDBAntenna{

	@Override
	public List<Antenna> getAllAntennas(boolean retrieveAssociation){
		return miscWhere("", retrieveAssociation);
	}

	@Override
	public Antenna findAntenna(int serialNo, boolean retrieveAssociation) {
		Antenna a = singleWhere("serialNo = " + serialNo, retrieveAssociation);
		return a;
	}

	@Override
	public List<Antenna> searchAntenna(int serialNo,
			boolean retrieveAssociation) {
		
		return miscWhere("serialNo like '%"+ serialNo + "%'", retrieveAssociation);
	}

	@Override
	public int updateAntenna(Antenna a) {
		String q = "update Antenna set serialNo=?, type=?";
		int res = 0;
		try(PreparedStatement s = DbConnection.getInstance().getDBcon().prepareStatement(q)){
			s.setInt(1, a.getSerialNo());
			s.setString(2, a.getType());
			
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
	public int removeAntenna(Antenna a) {
		if(r == null)
		return 0;
		int res = 0;
		String q = "delete from Antenna where serialNo = " + a.getSerialNo();
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()){
			res = s.executeUpdate(q);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
			return res;	
	}

	@Override
	public int insertAntenna(Antenna a) {
		int res = 0;
		
		String q = "inster into Antenna (serialNo,type) values ('"+ a.getSerialNo() + "', '"+ a.getType()+"')";
		try (Statement s = DbConnection.getInstance().getDBcon().createStatement()){
			res = s.executeUpdate(q);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return res;
	}
	
	private Antenna singleWhere(String where, boolean retrieveAssociation){
		List<Antenna> Antenna = miscWhere(where, retrieveAssociation);
		if(Antenna.size() > 0){
			return Antenna.get(0);
		}
		return null;
	}
	
	private List<Antenna> miscWhere(String where, boolean retrieveAssociation){
		ResultSet rs;
		List<Antenna> Antenna = new ArrayList<>();
		String query = buildQuery(where);
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()){
			s.setQueryTimeout(5);
			rs = s.executeQuery(query);
			while(rs.next()){
				Antenna a = buildAntenna(rs);
				Antenna.add(a);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return Antenna;
		}
	
	
	private String buildQuery(String where){
		String q = "select serialNo,type from Antenna";
		if(where != null && where.length() > 0){
			q += "where" + where;
		}
		return q;
	}
	
	private Antenna buildAntenna(ResultSet rs){
		Antenna a = null;
		try{
			a = new Antenna();
			a.setSerialNo(rs.getInt("serialNo"));
			a.setType(rs.getString("type"));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return a;
	}


}
