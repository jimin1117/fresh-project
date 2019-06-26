package org.fresh.customer.domain.service;

import java.util.List;

import org.fresh.customer.domain.model.Customer;
import org.fresh.customer.domain.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("customerLogic")
public class CustomerLogic implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public Customer register(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	@Transactional
	public Customer update(Long id, Customer newCustomer) {
		Customer oldCustomer = customerRepository.findOne(id);
		if(oldCustomer != null) {
			BeanUtils.copyProperties(newCustomer,  oldCustomer, "id");
			return customerRepository.save(oldCustomer);
		} else {
			return null;
		}
	}

	
	@Override
	@Transactional(readOnly=true)
	public Customer findById(Long id) {
		return customerRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Customer> findByNameLike(String name) {
		return customerRepository.findByNameLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		customerRepository.delete(id);
	}
}
