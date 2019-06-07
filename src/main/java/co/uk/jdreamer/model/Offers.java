package co.uk.jdreamer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_goodsoffer")
public class Offers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String currency;
	private String description;
	private boolean expired;
	private String name;
	private int offerDaysDuration;
	private double price;
	private Date startDate;

	public Offers() {

	}

	public Offers(String name, String description, double price, String currency, Date startDate, int offerDaysDuration, boolean expired) {
		super();
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

	@Override
	public String toString() {
		return "Offers [id=" + id + ", currency=" + currency + ", description=" + description + ", expired=" + expired
				+ ", name=" + name + ", offerDaysDuration=" + offerDaysDuration + ", price=" + price + ", startDate="
				+ startDate + "]";
	}

}
