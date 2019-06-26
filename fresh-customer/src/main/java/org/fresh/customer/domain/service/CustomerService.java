package org.fresh.customer.domain.service;

import java.util.List;

import org.fresh.customer.domain.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
	public Customer register(Customer customer);
	public Customer update(Long id, Customer newCustomer);
	public Customer findById(Long id) ;
	public void delete(Long id) ;
	public List<Customer> findByNameLike(String name);
	public Customer findByEmail(String email);
	public Page<Customer> findAll(Pageable pageable);
	public List<Customer> findAll();
	

}
