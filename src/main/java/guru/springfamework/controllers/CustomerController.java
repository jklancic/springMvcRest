package guru.springfamework.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springfamework.domain.Customer;
import guru.springfamework.services.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}

	@PostMapping("/post")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("error")
	@ResponseStatus(HttpStatus.OK)
	public Customer createError() {
		throw new EntityNotFoundException("Testing exception handling and throwing exception.");	
	}
}
