package guru.springfamework.services;

import java.util.List;

import guru.springfamework.domain.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();

	Customer getCustomer(Long id);
	
	Customer saveCustomer(Customer customer);
}
