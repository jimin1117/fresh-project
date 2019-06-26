package org.fresh.point.domain.service;

import java.util.List;

import org.fresh.point.domain.model.Point;




public interface PointService {
	
	Point register(Point point);
	Point findByCustomerId(Long customerId);
	Point update(Long id, Long amount);
	//List<Point> findAll();
	
}
