package org.fresh.point.application.sp.web;

import org.fresh.point.domain.model.Point;
import org.fresh.point.domain.service.PointService;
import org.fresh.point.dto.RegisterPointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("/v1/point")
public class PointRestController {
	@Autowired
	private PointService pointService;

	// 포인트 생성
	@PostMapping
	@ApiImplicitParams({
			@ApiImplicitParam(name = "req", value = "추가할 대상 고객의 id와 point", required = true, paramType = "body", dataType = "RegisterPointDTO")
		})
	public Point register(@RequestBody RegisterPointDTO req) {
		Point point = new Point(req.getCustomerId(), req.getAmount());

		return pointService.register(point);
	}

	@GetMapping("/user/{customerId}")
	public Point findByCustomerId(@PathVariable("customerId") Long customerId) {
		return pointService.findByCustomerId(customerId);
	}

	@ApiImplicitParams({
		@ApiImplicitParam(name = "customerId", value = "추가할 대상 고객의 id", required = true, dataType = "long"),
		@ApiImplicitParam(name = "amount", value = "추가할 point", required = true, dataType = "long")
	})
	@PutMapping("/user/{customerId}")
	public Point update(@PathVariable("customerId") Long customerId, @RequestBody Long amount) {
		return pointService.update(customerId, amount);
	}
}
