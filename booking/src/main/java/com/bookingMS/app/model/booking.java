package com.bookingMS.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="booking")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingnumber;
    
    private int busnumber;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date bookingdate;
    private String sourcename;
    private String destinationname;
    private int noofseats;
    private String bookingstatus;
	public Booking(int bookingnumber, int busnumber, Date bookingdate, String sourcename, String destinationname,
			int noofseats, String bookingstatus) {
		super();
		this.bookingnumber = bookingnumber;
		this.busnumber = busnumber;
		this.bookingdate = bookingdate;
		this.sourcename = sourcename;
		this.destinationname = destinationname;
		this.noofseats = noofseats;
		this.bookingstatus = bookingstatus;
	}
	public Booking() {
		super();
	}
	public int getBookingnumber() {
		return bookingnumber;
	}
	public void setBookingnumber(int bookingnumber) {
		this.bookingnumber = bookingnumber;
	}
	public int getBusnumber() {
		return busnumber;
	}
	public void setBusnumber(int busnumber) {
		this.busnumber = busnumber;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getSourcename() {
		return sourcename;
	}
	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}
	public String getDestinationname() {
		return destinationname;
	}
	public void setDestinationname(String destinationname) {
		this.destinationname = destinationname;
	}
	public int getNoofseats() {
		return noofseats;
	}
	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}
	public String getBookingstatus() {
		return bookingstatus;
	}
	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}
   
}
