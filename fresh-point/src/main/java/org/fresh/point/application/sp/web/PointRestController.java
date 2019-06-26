package org.fresh.point.application.sp.web;

import org.fresh.point.domain.model.Point;
import org.fresh.point.domain.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/point")
public class PointRestController implements PointService {
	@Autowired
	private PointService pointService;

	// 포인트 생성 
	@Override
	@PostMapping
	public Point register(@RequestBody Point point) {
		return pointService.register(point);
	}
	
	@Override
	@GetMapping("/user/{customerId}")
	public Point findByCustomerId(@PathVariable("customerId") Long customerId) {
		return pointService.findByCustomerId(customerId);
	}
	
	@Override
	@PutMapping("/{id}")
	public Point update(@PathVariable("id") Long id, @RequestBody Long amount) {
		return pointService.update(id, amount);
	}




}
