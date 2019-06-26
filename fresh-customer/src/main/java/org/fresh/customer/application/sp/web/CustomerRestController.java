package org.fresh.customer.application.sp.web;

import java.util.List;

import org.fresh.customer.domain.model.Customer;
import org.fresh.customer.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer")
public class CustomerRestController implements CustomerService {
	@Autowired
	private CustomerService customerService;


	@Override
	@GetMapping
	public List<Customer> findAll() {
		return customerService.findAll(); 
	}
	
	@Override
	@PostMapping
	public Customer register(@RequestBody Customer customer) {
		return customerService.register(customer);
	}


	@Override
	@PutMapping("/{id}")
	public Customer update(@PathVariable("id") Long id, @RequestBody Customer newCustomer) {
		return customerService.update(id, newCustomer);
	}
	
	@Override
	@GetMapping("/{id}")
	public Customer findById(@PathVariable("id") Long id) {
		return customerService.findById(id);
	}



	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		customerService.delete(id);
	}
	
	@Override
	@GetMapping("/search/name")
	public List<Customer> findByNameLike(@RequestParam("name") String name) {
		return customerService.findByNameLike(name);
	}

	@Override
	@GetMapping("/search/email")
	public Customer findByEmail(@RequestParam("email") String email) {
		return customerService.findByEmail(email);
	}

	@Override
	//@GetMapping
	public Page<Customer> findAll(Pageable pageable) {
		return customerService.findAll(pageable); 
	}


}
