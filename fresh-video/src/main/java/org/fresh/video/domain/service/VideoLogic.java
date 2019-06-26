package org.fresh.video.domain.service;

import java.util.List;

import org.fresh.video.domain.model.Video;
import org.fresh.video.domain.repository.VideoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("VideoLogic")
public class VideoLogic implements VideoService {
   	
	@Autowired 
	private VideoRepository videoRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Video findById(Long id) {
		return videoRepository.findOne(id);
	}

	@Override
	@Transactional
	public Video insert(Video video) {
		return videoRepository.save(video);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		videoRepository.delete(id);
	}
	

}
