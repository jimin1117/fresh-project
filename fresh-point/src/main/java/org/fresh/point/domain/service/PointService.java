package org.fresh.point.domain.service;

import java.util.List;

import org.fresh.point.domain.model.Point;


public interface PointService {

	Point findByCustomerId(Long customerId);
	List<Point> findAll();
	
	Point resister(Point Point);
	
	
	
	
}
