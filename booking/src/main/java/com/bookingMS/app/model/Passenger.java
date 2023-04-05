package com.bookingMS.app.model;

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
@Table(name="passenger")
public class Passenger {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerId;

    private int booking_number;

	public int getPassengerId() {
		return passengerId;
	}

	public Passenger() {
		super();
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public int getBooking_number() {
		return booking_number;
	}

	public void setBooking_number(int booking) {
		this.booking_number = booking;
	}

	public Passenger(int passengerId, int booking) {
		super();
		this.passengerId = passengerId;
		this.booking_number = booking;
	}

	
	

}

