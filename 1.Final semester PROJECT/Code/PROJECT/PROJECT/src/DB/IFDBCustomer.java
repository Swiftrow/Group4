package DB;

import java.util.List;

import Model.*;

public interface IFDBCustomer {
	public List<Customer> getAllCustomers (boolean retrieveAssociation);
	public Customer findCustomer (int id, boolean retrieveAssociation);
	public List<Customer> searchCustomer( int id, boolean retrieveAssociation);
	public int updateCustomer(Customer c);
	public int removeCustomer (Customer c);
	public int insertCustomer (Customer c);

}
