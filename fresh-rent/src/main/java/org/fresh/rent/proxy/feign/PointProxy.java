package org.fresh.rent.proxy.feign;

import org.fresh.rent.proxy.feign.dto.point.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
	
	@FeignClient(name="point", url= "http://localhost:11002", configuration=FeignClientConfiguration.class)
	interface PointClient {
		@PutMapping("point/{id}")
		void changePointAmount(@PathVariable("id") Long id, @RequestBody Long amount);
		
		@GetMapping("point/user/{customerId}") 
		Resource<Point> getPointByCustomerId(@PathVariable("customerId") Long customerId);
	}
}
