package org.fresh.rent.proxy.feign;

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
		pointClient.changePointAmount(customerId, amount);
	}
	
	public Long getAmount(Long customerId) {
		return pointClient.getAmount(customerId).getContent();
	}
	
	@FeignClient(name="point", url= "http://localhost:11002", configuration=FeignClientConfiguration.class)
	interface PointClient {
		@PutMapping("point/{id}")
		void changePointAmount(@PathVariable("id") Long id, @RequestBody Long amount);
		
		@GetMapping("point/{id}") 
		Resource<Long> getAmount(@PathVariable("id") Long id);
	}
}
