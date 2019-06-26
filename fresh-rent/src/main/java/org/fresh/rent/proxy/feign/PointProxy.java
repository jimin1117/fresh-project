package org.fresh.rent.proxy.feign;

import org.fresh.rent.proxy.feign.dto.point.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PointProxy {
	@Autowired
	private PointClient pointClient;
	
	public void changePointAmount(Long id, Long amount) {
		pointClient.changePointAmount(id, amount);
	}
	
	public Point getPointByCustomerId(Long customerId) {
		return pointClient.getPointByCustomerId(customerId).getContent();
	}
}

