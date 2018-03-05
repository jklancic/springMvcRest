package guru.springfamework.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).isPresent() ? customerRepository.findById(id).get() : new Customer();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer;
	}
}
