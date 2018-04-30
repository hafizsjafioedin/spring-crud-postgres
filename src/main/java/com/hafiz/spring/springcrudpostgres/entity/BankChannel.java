package com.hafiz.spring.springcrudpostgres.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import lombok.Data;


@Data
@Entity
@Table(name = "bank_channel")
public class BankChannel {



	@Id
	@Column(name = "bank_channel_id", nullable = false)
	@SequenceGenerator(name = "seq_bank_channel_id", sequenceName = "seq_bank_channel_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bank_channel_id")	
	private Integer bankChannelId;

	@Column(name = "bank_channel_status")
	private Boolean bankChannelStatus;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bankId;	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "channel_id", nullable = false)
	private Channel channelId;	
	
	@Column(name = "description", length=100)
	private String description;		
	
	
}
