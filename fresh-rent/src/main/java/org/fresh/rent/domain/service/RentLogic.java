package org.fresh.rent.domain.service;

import java.util.Date;
import java.util.List;

import org.fresh.rent.domain.model.Rent;
import org.fresh.rent.domain.model.StatusType;
import org.fresh.rent.domain.repository.RentRepository;
import org.fresh.rent.exception.CustomerHasNotEnoughMoneyException;
import org.fresh.rent.exception.VideoAlreadyRentedException;
import org.fresh.rent.exception.VideoNotFoundException;
import org.fresh.rent.proxy.feign.PointProxy;
import org.fresh.rent.proxy.feign.VideoProxy;
import org.fresh.rent.proxy.feign.dto.point.Point;
import org.fresh.rent.proxy.feign.dto.point.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentLogic implements RentService {
	@Autowired
	private RentRepository rentRepository;
	
	@Autowired
	private PointProxy pointProxy;
	
	@Autowired
	private VideoProxy videoProxy;
	
	@Override
	public Rent rentVideo(Long videoId, Long customerId) throws VideoAlreadyRentedException, CustomerHasNotEnoughMoneyException, VideoNotFoundException {
		Long amount = 100L;
		
		if (!isVideoExist(videoId)) {
			throw new VideoNotFoundException();
		}
		
		if (!isVideoRentable(videoId)) {
			throw new VideoAlreadyRentedException();
		}
		
		if (!isCustomerHasEnoughPoint(customerId, amount)) {
			throw new CustomerHasNotEnoughMoneyException();
		}
		
		decreaseCustomerPoint(customerId, amount);
		
		Rent rent = new Rent(videoId, customerId, new Date(), null, StatusType.RENTED);
		rentRepository.save(rent);
		return rent;
	}

	@Override
	public Rent returnVideo(Long id) {
		Rent rent = rentRepository.findOne(id);
		rent.setReturnDate(new Date());
		rent.setStatus(StatusType.AVAILABLE);
		rentRepository.save(rent);
		return rent;
	}
	
	protected boolean isVideoExist(Long videoId) {
		Video video = videoProxy.getVideo(videoId);
		return video != null;
	}
	
	protected boolean isVideoRentable(Long videoId) {
		List<Rent> rentedVideos = rentRepository.findByVideoIdAndStatus(videoId, StatusType.RENTED);
		return rentedVideos.size() == 0;
	}
	
	protected boolean isCustomerHasEnoughPoint(Long customerId, Long amount) {
		Point point = pointProxy.getPointByCustomerId(customerId);
		return point.getAmount() >= amount;
	}
	
	protected void decreaseCustomerPoint(Long customerId, Long amount) {
		pointProxy.changePointAmount(customerId, -amount);
	}
}
