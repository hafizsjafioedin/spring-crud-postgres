package com.hafiz.spring.springcrudpostgres.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bank")
public class Bank {

	
	@Id
	@Column(name = "bank_id", columnDefinition = "bpchar(3)", length=3, nullable = false)
	private String bankId;

	@Column(name = "bank_name", length=50, nullable = false)
	private String bankName;	
	
	

	
}
