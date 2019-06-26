package org.fresh.rent.application.sp.web;

import org.fresh.rent.domain.model.Rent;
import org.fresh.rent.domain.service.RentService;
import org.fresh.rent.dto.RentVideoDTO;
import org.fresh.rent.exception.CustomerHasNotEnoughMoneyException;
import org.fresh.rent.exception.VideoAlreadyRentedException;
import org.fresh.rent.exception.VideoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("/v1/rent")
public class RentRestController {
	@Autowired
	RentService rentService;

	@PostMapping("/")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "req", value = "대여할 대상 비디오의 id와 고객의 id 전달", required = true, paramType = "body", dataType = "RentVideoDTO")
	})
	public Rent rentVideo(@RequestBody RentVideoDTO req)
			throws VideoAlreadyRentedException, CustomerHasNotEnoughMoneyException, VideoNotFoundException {
		return rentService.rentVideo(req.getVideoId(), req.getCustomerId());
	}

	@PutMapping("/{id}")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "반납할 대상 비디오의 id", required = true) })
	public Rent returnVideo(@PathVariable("id") Long id) {
		return rentService.returnVideo(id);
	}
}
