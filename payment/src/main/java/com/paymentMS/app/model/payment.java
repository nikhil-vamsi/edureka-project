package com.paymentMS.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class payment {
    @Id
    @Column(name = "paymentid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentid;
    
    @Column(name = "bookingnumber")
    private int bookingnumber;

    @Column(name = "dateofpayment")
    private Date dateofpayment;

	public payment(int paymentid, int bookingnumber, Date dateofpayment) {
		super();
		this.paymentid = paymentid;
		this.bookingnumber = bookingnumber;
		this.dateofpayment = dateofpayment;
	}

	public payment() {
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

