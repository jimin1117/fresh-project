package org.fresh.rent.domain.model;

import java.util.Date;

import javax.persistence.Entity;

import org.fresh.shared.base.AbstractEntity;
import org.fresh.shared.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Rent extends AbstractEntity implements AggregateRoot {
	private Long videoId;
	private Long customerId;
	private Date rentDate;
	private Date returnDate;
	private StatusType status;
	
	public Rent(Long videoId, Long customerId, Date rentDate, Date returnDate, StatusType status) {
		this.videoId = videoId;
		this.customerId = customerId;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.status = status;
	}
}
