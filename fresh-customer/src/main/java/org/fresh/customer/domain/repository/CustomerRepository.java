package org.fresh.customer.domain.repository;

import org.fresh.customer.domain.model.Customer;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>,
											QueryDslPredicateExecutor<Customer> {

}

