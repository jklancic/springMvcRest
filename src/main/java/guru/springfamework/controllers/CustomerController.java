package guru.springfamework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springfamework.domain.Customer;
import guru.springfamework.services.CustomerService;

@Controller
@RequestMapping("api/v1/customers")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		return new ResponseEntity<Customer>(customerService.getCustomer(id), HttpStatus.OK);
	}

	@PostMapping("/post")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}
}
