package org.fresh.video.application.sp.web;


import org.fresh.video.domain.model.Video;
import org.fresh.video.domain.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/video")
public class VideoRestController implements VideoService {
    
	@Autowired
	private VideoService videoService;
	
	@Override
	@GetMapping("/{id}")
	public Video findById(@PathVariable("id") Long id) {
		return videoService.findById(id);
	}
	
	@Override
	@PostMapping
	public Video insert(@RequestBody Video video) {
		return videoService.insert(video);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(Long id) {
		videoService.delete(id);
		
	}	
}
