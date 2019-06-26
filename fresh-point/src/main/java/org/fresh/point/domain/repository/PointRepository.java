package org.fresh.point.domain.repository;

import java.util.List;

import org.fresh.point.domain.model.Point;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PointRepository extends PagingAndSortingRepository<Point, Long>,
QueryDslPredicateExecutor<Point> {
	
	List<Point> findAll();
	Point findByCustomerId(Long customerId);
}
