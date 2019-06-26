package org.fresh.point.domain.model;

import javax.persistence.Entity;

import org.fresh.point.base.AbstractEntity;
import org.fresh.point.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Point extends AbstractEntity implements AggregateRoot { 

	private long customerId;
	private long amount;	
	

	
}
