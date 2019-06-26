package org.fresh.rent.application.sp.web;

import org.fresh.rent.domain.model.Rent;
import org.fresh.rent.domain.service.RentService;
import org.fresh.rent.exception.CustomerHasNotEnoughMoneyException;
import org.fresh.rent.exception.VideoAlreadyRentedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@RestController
@RequestMapping("/rent")
public class RentRestController {
	@Autowired 
	RentService rentService;

	@PostMapping("/")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "req", value = "대여할 대상 비디오의 id와 고객의 id 전달", required = true, dataTypeClass = RentVideoRequest.class, example = "{ \"videoId\": 0, \"customerId\": 0 }", defaultValue = "asdf")
//    	@ApiImplicitParam(name = "req", value = "대여할 대상 비디오의 id와 고객의 id 전달", required = true, dataType = RentVideoRequest.class, paramType = "query", defaultValue="Niklas") 
    })
	public Rent rentVideo(@RequestBody RentVideoRequest req) throws VideoAlreadyRentedException, CustomerHasNotEnoughMoneyException {
		return rentService.rentVideo(req.getVideoId(), req.getCustomerId());
	}

	public Rent returnVideo(Long id) {
		return rentService.returnVideo(id);
	}

	@Data
	public class RentVideoRequest {
		private Long videoId;
		private Long customerId;
	}
}
