package guru.springfamework.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner {
	
	private CategoryRepository categoryRepository;
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		initCategoryData();
		initCustomerData();
	}

	private void initCustomerData() {
		Customer jernej = new Customer();
		jernej.setFirstname("Jernej");
		jernej.setLastname("Van Hallen");
		jernej.setUrl("http://jernej.awesome.com");

		Customer teja = new Customer();
		teja.setFirstname("Teja");
		teja.setLastname("Van Hallen");
		teja.setUrl("http://teja.awesome.com");

		Customer dejan = new Customer();
		dejan.setFirstname("Dejan");
		dejan.setLastname("Johnson");
		dejan.setUrl("http://dejan.awesome.com");
		
		customerRepository.save(jernej);
		customerRepository.save(teja);
		customerRepository.save(dejan);
		
		System.out.println("Customer data loaded = " + customerRepository.count());
	}

	private void initCategoryData() {
		Category fruits = new Category();
		fruits.setName("Fruits");

		Category dried = new Category();
		dried.setName("Dried");

		Category fresh = new Category();
		fresh.setName("Fresh");

		Category exotic = new Category();
		exotic.setName("Exotic");

		Category nuts = new Category();
		nuts.setName("Nuts");

		categoryRepository.save(fruits);
		categoryRepository.save(dried);
		categoryRepository.save(fresh);
		categoryRepository.save(exotic);
		categoryRepository.save(nuts);

		System.out.println("Category data loaded = " + categoryRepository.count());
	}
}
