package org.fresh.customer.domain.service;

import org.fresh.customer.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("customerLogic")
public class CustomerLogic implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
}
