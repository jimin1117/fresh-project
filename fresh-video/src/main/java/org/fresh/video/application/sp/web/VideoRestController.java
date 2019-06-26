package org.fresh.video.application.sp.web;


import org.fresh.video.domain.model.Video;
import org.fresh.video.domain.service.VideoService;
import org.fresh.video.dto.InsertVideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@RestController
@RequestMapping("/v1/video")
public class VideoRestController {
    
	@Autowired
	private VideoService videoService;
	
	@GetMapping("/{id}")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "조회 대상 video id", required = true)
    })
	public Video findById(@PathVariable("id") Long id) {
		return videoService.findById(id);
	}
	
	@PostMapping
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "req", value = "추가할 비디오 정보", required = true, paramType="body", dataType = "InsertVideoDTO")
    })
	public Video insert(@RequestBody InsertVideoDTO req) {
		Video video = new Video(req.getTitle(), req.getDesc());
		return videoService.insert(video);
	}

	@DeleteMapping("/{id}")
    @ApiImplicitParams({ 
    	@ApiImplicitParam(name = "id", value = "삭제 대상 video id", required = true)
    })
	public void delete(Long id) {
		videoService.delete(id);
	}	
}
