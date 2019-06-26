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

	public void changePointAmount(Long customerId, Long amount) {
		pointClient.update(customerId, amount);
	} 
	public Point getPointByCustomerId(Long customerId) {
		Resource<Point> resource = pointClient.getPointByCustomerId(customerId);
		System.out.println("resource id: " + resource.getId());
		return resource.getContent();
	}

	@FeignClient(name = "point", url = "http://fresh-point.videoshop:11002", configuration = FeignClientConfiguration.class)
	interface PointClient {
		@PutMapping("v1/point/user/{customerId}")
		Resource<Point> update(@PathVariable("customerId") Long customerId, @RequestBody Long amount);

		@GetMapping("v1/point/user/{customerId}")
		Resource<Point> getPointByCustomerId(@PathVariable("customerId") Long customerId);
	}
}
