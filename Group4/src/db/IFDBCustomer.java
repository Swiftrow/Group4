package db;

import java.util.List;

import model.Customer;


public interface IFDBCustomer {
	public List<Customer> getAllCustomers(boolean retrieveAssociation);
	public Customer findCustomer(int cpr, boolean retrieveAssociation) ;
	public List<Customer> searchCustomer(int cpr, boolean retrieveAssociation);
	public int updateCustomer(Customer c);
	public int removeCustomer (Customer c);
	public int insertCustomer(Customer c);
}
