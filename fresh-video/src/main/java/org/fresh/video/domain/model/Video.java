package org.fresh.video.domain.model;

import javax.persistence.Entity;

import org.fresh.shared.base.AbstractEntity;
import org.fresh.shared.base.AggregateRoot;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Video extends AbstractEntity implements AggregateRoot  {
  private long id;
  private String title;
  private String desc;
  
  public Video(long id,String title,String desc) {
	  this.id = id;
	  this.title = title;
	  this.desc = desc;
  }
  
}
  
  

