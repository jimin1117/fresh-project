package org.fresh.rent.domain.repository;

import java.util.List;

import org.fresh.rent.domain.model.Rent;
import org.fresh.rent.domain.model.StatusType;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RentRepository extends PagingAndSortingRepository<Rent, Long>, QueryDslPredicateExecutor<Rent> {
	List<Rent> findByVideoIdAndStatus(Long videoId, StatusType status);
}
