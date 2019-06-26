package org.fresh.point.domain.model;

import org.fresh.shared.base.AbstractEntity;
import org.fresh.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;


@EqualsAndHashCode
@Entity
public class Point extends AbstractEntity implements AggregateRoot { 

	private long id;
	private long customerId;
	private long amount;	
	
	public Point (long id, long customerId, long amount) {
		this.id = id;
		this.customerId = customerId;
		this.amount = amount;
		
	}
	
}
