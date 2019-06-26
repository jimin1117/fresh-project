package org.fresh.customer.domain.service;

import org.fresh.customer.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service("customerLogic")
public class CustomerLogic implements CustomerService{

	private CustomerRepository customerRepository;
}
