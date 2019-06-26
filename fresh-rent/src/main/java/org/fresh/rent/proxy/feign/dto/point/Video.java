package org.fresh.rent.proxy.feign.dto.point;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Video {
	private Long id;
	private String title;
	private String desc;
	
	public Video(Long id, String title, String desc) {
		this.id = id;
		this.title = title;
		this.desc = desc;
	}
}
