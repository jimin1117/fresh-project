package org.fresh.point.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RegisterPointDTO {
	private Long customerId;
	private Long amount;
}
