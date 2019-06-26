package org.fresh.customer.domain.model;

import javax.persistence.Entity;

import org.fresh.customer.base.AbstractEntity;
import org.fresh.customer.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Customer extends AbstractEntity implements AggregateRoot {
	private String name; 
	private String mobile;
	private String email;
	
	public Customer(String name, String mobile, String email) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}
}
