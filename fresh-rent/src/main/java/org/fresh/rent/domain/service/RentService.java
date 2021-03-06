package org.fresh.rent.domain.service;

import org.fresh.rent.domain.model.Rent;
import org.fresh.rent.exception.CustomerHasNotEnoughMoneyException;
import org.fresh.rent.exception.VideoAlreadyRentedException;
import org.fresh.rent.exception.VideoNotFoundException;

public interface RentService {
	public Rent rentVideo(Long videoId, Long customerId) throws VideoAlreadyRentedException, CustomerHasNotEnoughMoneyException, VideoNotFoundException;
	public Rent returnVideo(Long id);
}
