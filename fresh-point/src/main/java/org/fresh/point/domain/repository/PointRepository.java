package org.fresh.point.domain.repository;

import java.util.List;

import org.fresh.point.domain.model.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



import feign.Param;

@RepositoryRestResource
public interface PointRepository {
	
	Point findByCustomerId(@Param("customerId") long customerId);
	
	@Query("select all from Point where a.customerId like %?1%")
	//List<Point> findByCustomerId(@Param("customerId") long customerId );
	List<Point> findAll();


}
