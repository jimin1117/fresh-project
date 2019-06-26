package org.fresh.rent.domain.service;

import java.util.Date;
import java.util.List;

import org.fresh.rent.domain.model.Rent;
import org.fresh.rent.domain.model.StatusType;
import org.fresh.rent.domain.repository.RentRepository;
import org.fresh.rent.exception.CustomerHasNotEnoughMoneyException;
import org.fresh.rent.exception.VideoAlreadyRentedException;
import org.fresh.rent.proxy.feign.PointProxy;
import org.springframework.beans.factory.annotation.Autowired;

public class RentLogic implements RentService {
	@Autowired
	private RentRepository rentRepository;
	
	@Autowired
	private PointProxy pointProxy;
	
	@Override
	public void rentVideo(Long videoId, Long customerId) throws VideoAlreadyRentedException, CustomerHasNotEnoughMoneyException {
		Long amount = 100L;
		
		if (isVideoRentable(videoId)) {
			throw new VideoAlreadyRentedException();
		}
		
		if (isCustomerHasEnoughPoint(customerId, amount)) {
			throw new CustomerHasNotEnoughMoneyException();
		}
		
		decreaseCustomerPoint(customerId, amount);
		
		Rent rent = new Rent(videoId, customerId, new Date(), null, StatusType.RENTED);
		rentRepository.save(rent);
	}

	@Override
	public void returnVideo(Long videoId) {
		
	}
	
	protected boolean isVideoRentable(Long videoId) {
		List<Rent> rentedVideos = rentRepository.findByVideoIdAndStatus(videoId, StatusType.RENTED);
		return rentedVideos.size() == 0;
	}
	
	protected boolean isCustomerHasEnoughPoint(Long customerId, Long amount) {
		Long existingAmount = pointProxy.getAmount(customerId);
		return existingAmount > amount;
	}
	
	protected void decreaseCustomerPoint(Long customerId, Long amount) {
		Long amount = pointProxy.getAmount(customerId);
	}
}
