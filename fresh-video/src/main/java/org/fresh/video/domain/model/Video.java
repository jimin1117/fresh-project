package org.fresh.video.domain.model;

import javax.persistence.Entity;

import org.fresh.video.base.AbstractEntity;
import org.fresh.video.base.AggregateRoot;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Video extends AbstractEntity implements AggregateRoot  {
  
  private String title;
  private String desc;
  
  public Video(String title,String desc) {
	  this.title = title;
	  this.desc = desc;
  }
  
}
  
  

