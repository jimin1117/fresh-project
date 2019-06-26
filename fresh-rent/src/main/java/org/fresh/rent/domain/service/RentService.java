package org.fresh.rent.domain.service;

import org.fresh.rent.exception.CustomerHasNotEnoughMoneyException;
import org.fresh.rent.exception.VideoAlreadyRentedException;

public interface RentService {
	void rentVideo(Long videoId, Long customerId) throws VideoAlreadyRentedException, CustomerHasNotEnoughMoneyException;
	void returnVideo(Long videoId);
}
