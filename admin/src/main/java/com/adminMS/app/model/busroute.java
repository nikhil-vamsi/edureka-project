package com.adminMS.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="busroute")
public class busroute {
    
    @Id
    private int busnum;
    
	private String sourcename;
    
    private String destinationname ;
	private float  price;
    
    public int getBusnum() {
		return busnum;
	}
	public void setBusnum(int busNum) {
		this.busnum = busNum;
	}
	public String getSourcename() {
		return sourcename;
	}
	public void setSourcename(String sourceName) {
		this.sourcename = sourceName;
	}
	public String getDestinationname() {
		return destinationname;
	}
	public void setDestinationname(String destinationName) {
		this.destinationname = destinationName;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	public busroute(int busNum, String sourceName, String destinationName, int price) {
		super();
		this.busnum = busNum;
		this.sourcename = sourceName;
		this.destinationname = destinationName;
		this.price = price;
	}
	public float getPrice() {
		return price;
	}
	public busroute() {
		super();
		// TODO Auto-generated constructor stub
	}

}

