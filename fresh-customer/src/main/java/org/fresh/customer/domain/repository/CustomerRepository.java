package org.fresh.customer.domain.repository;

import java.util.List;

import org.fresh.customer.domain.model.Customer;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;

@RepositoryRestResource
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>,
											QueryDslPredicateExecutor<Customer> {
	Customer findByEmail(@Param("email") String email);
	List<Customer> findByNameLike(@Param("name") String name);
	List<Customer> findAll();
	List<Customer> findAll(Predicate predicate); 
	
}

