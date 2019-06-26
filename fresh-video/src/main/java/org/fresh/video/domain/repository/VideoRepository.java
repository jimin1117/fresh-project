package org.fresh.video.domain.repository;

import org.fresh.video.domain.model.Video;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface VideoRepository extends PagingAndSortingRepository<Video, Long>,
											QueryDslPredicateExecutor<Video>  {

	Video findById(@Param("id") Long id);
	

}
