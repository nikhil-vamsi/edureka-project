package com.bookingMS.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="booking")
public class booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingnumber;
    
    private int busnumber;
    private Date bookingdate;
    private String sourcename;
    private String destinationname;
    private int noofseats;
    private String bookingstatus;
    
    public int getBookingNumber() {
        return bookingnumber;
    }
    
    public void setBookingNumber(int bookingNumber) {
        this.bookingnumber = bookingNumber;
    }
    
    public int getBusNumber() {
        return busnumber;
    }
    
    public void setBusNumber(int busNumber) {
        this.busnumber = busNumber;
    }
    
    public Date getBookingDate() {
        return bookingdate;
    }
    
    public void setBookingDate(Date bookingDate) {
        this.bookingdate = bookingDate;
    }
    
    public String getSourceName() {
        return sourcename;
    }
    
    public void setSourceName(String sourceName) {
        this.sourcename = sourceName;
    }
    
    public String getDestinationName() {
        return destinationname;
    }
    
    public void setDestinationName(String destinationName) {
        this.destinationname = destinationName;
    }
    
    public int getNoOfSeats() {
        return noofseats;
    }
    
    public void setNoOfSeats(int noOfSeats) {
        this.noofseats = noOfSeats;
    }
    
    public String getBookingStatus() {
        return bookingstatus;
    }
    
    public void setBookingStatus(String status) {
        this.bookingstatus = status;
    }
}
