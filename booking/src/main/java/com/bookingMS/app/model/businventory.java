package com.bookingMS.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "businventory")
public class businventory {

	@Id
    private int busnumber;

    private int availableseats;

    private Date lastupdateddate;

	public int getBusnumber() {
		return busnumber;
	}

	public void setBusnumber(int busnumber) {
		this.busnumber = busnumber;
	}

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public Date getLastupdateddate() {
		return lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

	public businventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public businventory(int busnumber, int availableseats, Date lastupdateddate) {
		super();
		this.busnumber = busnumber;
		this.availableseats = availableseats;
		this.lastupdateddate = lastupdateddate;
	}

}
