package com.example;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;
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
	private DateTime date;

	@NotNull
	@NumberFormat(style = Style.CURRENCY)	
	private Double balance;	
	
	private UserType type;
	
	/** To make bean happy */
	public UserEntity() {
		
	}

	public UserEntity(String name, DateTime date, Double balance, UserType type) {
		super();
		this.name = name;
		this.date = date;
		this.balance = balance;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DateTimeFormat(iso = ISO.NONE)
	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	@NumberFormat(style = Style.CURRENCY)	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}	

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserEntity [name=");
		builder.append(name);
		builder.append(", date=");
		builder.append(date);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	
}
