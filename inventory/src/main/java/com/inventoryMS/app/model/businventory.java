package com.inventoryMS.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "businventory")
public class Businventory {

	@Id
    private int busnumber;

    private int availableseats;

    @JsonFormat(pattern="yyyy-mm-dd")
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

	public Businventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Businventory(int busnumber, int availableseats, Date lastupdateddate) {
		super();
		this.busnumber = busnumber;
		this.availableseats = availableseats;
		this.lastupdateddate = lastupdateddate;
	}

}
