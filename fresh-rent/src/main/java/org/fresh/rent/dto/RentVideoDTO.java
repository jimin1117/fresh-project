package org.fresh.rent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RentVideoDTO {
	private Long videoId;
	private Long customerId;
}
