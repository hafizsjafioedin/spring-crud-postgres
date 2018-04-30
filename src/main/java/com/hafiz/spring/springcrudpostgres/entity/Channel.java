package com.hafiz.spring.springcrudpostgres.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "channel")
public class Channel {

	
	@Id
	@Column(name = "channel_id", columnDefinition = "bpchar(2)", length=2, nullable = false)
	private String channelId;

	@Column(name = "channel_name", length=50, nullable = false)
	private String channelName;	
	

	
}
