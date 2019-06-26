package org.fresh.video.domain.service;

import org.fresh.video.domain.model.Video;

public interface VideoService {
   Video findById (Long id);

   Video insert(Video video);
  
   
   void delete(Long id);


}
