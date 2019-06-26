package org.fresh.rent.proxy.feign.dto.point;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Point {
	private Long id;
	private Long customerId;
	private Long amount;
	
	public Point(Long id, Long customerId, Long amount) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.amount = amount;
	}
}
