package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Clothing;
import model.Equipement;
import model.GunReplicas;
import model.Product;

public class DBProduct implements IFDBProduct {

	@Override
	public List<Product> getAllProducts(boolean retrieveAssociation) {
		return miscWhere("", retrieveAssociation);

	}

	@Override
	public List<Product> searchProduct(int barcode, boolean retrieveAssociation) {
		return miscWhere("cpr like '%"+ barcode +"%'", retrieveAssociation);
	}

	@Override
	public Product findProduct(int barcode, boolean retrieveAssociation) {
		Product p = singleWhere("barcode = "+ barcode , retrieveAssociation);
		return p;
	}

	@Override
	public int updateProduct(Product p) {
		String w=null;
		Clothing c= new Clothing();
		Equipement e= new Equipement();
		GunReplicas g= new GunReplicas();
		String q="update Product set barcode=?, name=?, sPrice=?, rPrice=?, minStock=?, productType=?";
		int res=0;
		try(PreparedStatement s= DBConnection.getInstance().getDBcon().prepareStatement(q))
		{
		s.setInt(1,p.getBarcode());
		s.setString(2, p.getName());
		s.setInt(3, p.getsPrice());
		s.setInt(4, p.getrPrice());
		s.setInt(5, p.getMinStock());
		s.setString(6, p.getProductType());
		if( p.getProductType()=="clothing"||p.getProductType()=="Clothing"){
			s.setString(7, c.getColour());
			s.setString(8, c.getSize());			
		}
		if(p.getProductType()=="equipement"||p.getProductType()=="Equipement"){
			s.setString(7, e.getType());
			s.setString(8, e.getDescription());			
		}
		if(p.getProductType()=="gunReplicas"||p.getProductType()=="GunReplicas"){
			s.setString(7, g.getCalibre());
			s.setString(8, g.getFabric());	
		}		
		
		res=s.executeUpdate();
		}
		catch(SQLException ex){
			
		}
		
		
		return res;
		
				
	}

	@Override
	public int insertProduct(Product p) {
		Clothing c= new Clothing();
		Equipement e= new Equipement();
		GunReplicas g= new GunReplicas();
		int res=0;
		int resOne=0;
		String w = null;
		String q="insert into Product (barcode,name, sPrice, rPrice,minStock, productType) values('"+p.getBarcode()+ "','"+ p.getName()+"','"+p.getsPrice()+"','"+p.getrPrice()+"','"+p.getMinStock()+"','"+p.getProductType()+"')";
		if( p.getProductType()=="clothing"||p.getProductType()=="Clothing"){
			 w="insert into Clothing(colour, size) values('"+c.getColour()+"','"+c.getSize()+"')";
		}
		if(p.getProductType()=="equipement"||p.getProductType()=="Equipement"){
			 w="insert into Equipement(eqType, eqDescription) values('"+e.getType()+"','"+e.getDescription()+"')";
		}
		if(p.getProductType()=="gunReplicas"||p.getProductType()=="GunReplicas"){
			w="insert into GunReplica (calibre, fabric) values('"+g.getCalibre()+"','"+g.getFabric()+"')";
		}
		
		try(Statement s=DBConnection.getInstance().getDBcon().createStatement()){
			res= s.executeUpdate(q);
			resOne= s.executeUpdate(w);
		}
		catch(SQLException ex){
			
		}
		return res;
	}

	@Override
	public int removeProduct(Product p) {
		if (p ==null)
			return 0;
		int res=0;
		String q="delete from Product where barcode = "+p.getBarcode();
		try(Statement s= DBConnection.getInstance().getDBcon().createStatement()){
			res= s.executeUpdate(q);
		}
		catch ( SQLException e){}
		return res;
	}
	
	private Product singleWhere(String where, boolean retrieveAssociation){
		List<Product> product = miscWhere(where,retrieveAssociation);
		if (product.size()>0)
			return product.get(0);
		return null;
	}
	
	private List<Product> miscWhere(String where, boolean retrieveAssociation){
		ResultSet rs;
		List<Product> product = new ArrayList<>();
		String query= buildQuery(where);
		try(Statement s =DBConnection.getInstance().getDBcon().createStatement()){
			s.setQueryTimeout(6);
			rs= s.executeQuery(query);
			while(rs.next()){
				Product p= buildProduct(rs);
				product.add(p);
			}
		}
		catch(Exception e){
			
		}
		return product;
	}
	
	private String buildQuery(String where){
		String w="select barcode, name, sPrice, rPrice, minStock, productType";
		if(where!=null&&where.length()>0){
			w+="where"+ where;
		}
		return w;
	}
	
	private Product buildProduct(ResultSet rs){
		Product p= null;
		try{
			p=new Product();
			p.setBarcode(rs.getInt("barcode"));
			p.setName(rs.getString("name"));
			p.setsPrice(rs.getInt("sPrice"));
			p.setrPrice(rs.getInt("rPrice"));
			p.setMinStock(rs.getInt("minStock"));
			p.setProductType(rs.getString("productType"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
