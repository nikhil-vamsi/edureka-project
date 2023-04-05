package com.paymentMS.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.paymentMS.app.Repository.paymentRepository;
import com.paymentMS.app.model.payment;

@Service
public class paymentService {
	
	@Autowired
	private paymentRepository paymentRepo;
	
	public payment savePayment(payment req) {

		return paymentRepo.save(req);
	}
	
	public List<payment> getPayments() {
		return paymentRepo.findAll();
	}
	
	public payment updatePayment( payment req,int id) {
		payment p = paymentRepo.findByPaymentid( id);
		p.setbookingnumber(req.getbookingnumber());
		p.setdateofpayment(req.getdateofpayment());
		return paymentRepo.save(req);
	}
	public String deletePayment( int id) {

		paymentRepo.deleteByPaymentid(id);
		return "deleted";
	}
}
