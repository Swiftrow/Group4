package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Router;

public class DbRouter implements IFDBRouter {

	@Override
	public List<Router> getAllRouters(boolean retrieveAssociation){
		return miscWhere("", retrieveAssociation);
	}

	@Override
	public Router findRouter(int serialNo, boolean retrieveAssociation) {
		Router r = singleWhere("serialNo = " + serialNo, retrieveAssociation);
		return r;
	}

	@Override
	public List<Router> searchRouter(int serialNo,
			boolean retrieveAssociation) {
		
		return miscWhere("serialNo like '%"+ serialNo + "%'", retrieveAssociation);
	}

	@Override
	public int updateRouter(Router r) {
		String q = "update Router set serialNo=?, type=?";
		int res = 0;
		try(PreparedStatement s = DbConnection.getInstance().getDBcon().prepareStatement(q)){
			s.setInt(1, r.getSerialNo());
			s.setString(2, r.getType());
			
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
	public int removeRouter(Router r) {
		if(r == null)
		return 0;
		int res = 0;
		String q = "delete from Router where serialNo = " + r.getSerialNo();
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()){
			res = s.executeUpdate(q);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
			return res;	
	}

	@Override
	public int insertRouter(Router r) {
		int res = 0;
		
		String q = "inster into Router (serialNo,type) values ('"+ r.getSerialNo() + "', '"+ r.getType()+"')";
		try (Statement s = DbConnection.getInstance().getDBcon().createStatement()){
			res = s.executeUpdate(q);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return res;
	}
	
	private Router singleWhere(String where, boolean retrieveAssociation){
		List<Router> Router = miscWhere(where, retrieveAssociation);
		if(Router.size() > 0){
			return Router.get(0);
		}
		return null;
	}
	
	private List<Router> miscWhere(String where, boolean retrieveAssociation){
		ResultSet rs;
		List<Router> Router = new ArrayList<>();
		String query = buildQuery(where);
		try(Statement s = DbConnection.getInstance().getDBcon().createStatement()){
			s.setQueryTimeout(5);
			rs = s.executeQuery(query);
			while(rs.next()){
				Router r = buildRouter(rs);
				Router.add(r);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return Router;
		}
	
	
	private String buildQuery(String where){
		String q = "select serialNo,type from Router";
		if(where != null && where.length() > 0){
			q += "where" + where;
		}
		return q;
	}
	
	private Router buildRouter(ResultSet rs){
		Router r = null;
		try{
			r = new Router();
			r.setSerialNo(rs.getInt("serialNo"));
			r.setType(rs.getString("type"));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return r;
	}


}
