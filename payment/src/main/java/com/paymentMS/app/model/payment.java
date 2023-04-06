package com.paymentMS.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "paymentid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentid;
    
    @Column(name = "bookingnumber")
    private int bookingnumber;
    
   
    @Column(name = "dateofpayment")
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date dateofpayment;

	public Payment(int paymentid, int bookingnumber, Date dateofpayment) {
		super();
		this.paymentid = paymentid;
		this.bookingnumber = bookingnumber;
		this.dateofpayment = dateofpayment;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getpaymentid() {
		return paymentid;
	}

	public void setpaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public int getbookingnumber() {
		return bookingnumber;
	}

	public void setbookingnumber(int bookingnumber) {
		this.bookingnumber = bookingnumber;
	}

	public Date getdateofpayment() {
		
		return dateofpayment;
	}

	public void setdateofpayment(Date dateofpayment) {
		this.dateofpayment = dateofpayment;
	}

    
}

