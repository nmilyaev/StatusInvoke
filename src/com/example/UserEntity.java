package com.example;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class UserEntity {
	
	@NotNull
	@Size(min = 1, max = 128)
	private String name;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date date;

	@NotNull
	@NumberFormat(style = Style.CURRENCY)	
	private Double balance;	

	public UserEntity(String name, Date date, Double balance) {
		super();
		this.name = name;
		this.date = date;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	

}
