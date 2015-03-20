package db;

import  model.*;
import java.util.*;


public interface IFDBProduct {
	public List<Product> getAllProducts(boolean retreiveAssociation);
	public List<Product> searchProduct (int barcode, boolean retreiveAssociation);
	public Product findProduct (int barcode, boolean retreiveAssociation);
	public int updateProduct(Product p);
	public int insertProduct(Product p);
	public int removeProduct(Product p);
}
