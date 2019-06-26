package org.fresh.video.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class InsertVideoDTO {
	private String title;
	private String desc;
}