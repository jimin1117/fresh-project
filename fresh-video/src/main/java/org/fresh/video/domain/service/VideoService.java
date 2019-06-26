package org.fresh.video.domain.service;

import java.util.List;

import org.fresh.video.domain.model.Video;

public interface VideoService {
   Video findById (Long id);

   Video insert(Video video);
     
   void delete(Long id);

}
