package org.fresh.rent.proxy.feign;

import org.fresh.rent.proxy.feign.dto.point.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class VideoProxy {
	@Autowired
	private VideoClient videoClient;

	public Video getVideo(Long id) {
		Resource<Video> resource = videoClient.getVideo(id);
		if (resource == null) {
			return null;
		}
		return resource.getContent();
	}

	@FeignClient(name = "video", url = "http://fresh-video.videoshop:11004", configuration = FeignClientConfiguration.class)
	interface VideoClient {
		@GetMapping("v1/video/{id}")
		Resource<Video> getVideo(@PathVariable("id") Long id);
	}
}
