package com.worldpay.goodsoffer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Offers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String description;
	@NotNull
	private double price;
	@NotNull
	@NotEmpty
	private String currency;
	@NotNull
	private Date startDate;
	@NotNull
	private int offerDaysDuration;
	@NotNull
	private boolean expired;

	public Offers() {

	}

	public Offers(int id, String name, String description, double price, String currency, Date startDate, int offerDaysDuration, boolean expired) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.currency = currency;
		this.startDate = startDate;
		this.offerDaysDuration = offerDaysDuration;
		this.expired = expired;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getOfferDaysDuration() {
		return offerDaysDuration;
	}
	public void setOfferDaysDuration(int offerDaysDuration) {
		this.offerDaysDuration = offerDaysDuration;
	}

	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}

}
