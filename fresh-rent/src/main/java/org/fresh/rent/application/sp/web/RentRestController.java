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

import lombok.Data;

@RestController
@RequestMapping("/rent")
public class RentRestController {
	@Autowired 
	RentService rentService;

	@PostMapping("/")
	public Rent rentVideo(@RequestBody RentVideoRequest req) throws VideoAlreadyRentedException, CustomerHasNotEnoughMoneyException {
		return rentService.rentVideo(req.getVideoId(), req.getCustomerId());
	}

	public Rent returnVideo(Long id) {
		return rentService.returnVideo(id);
	}

	@Data
	class RentVideoRequest {
		private Long videoId;
		private Long customerId;
	}
}
