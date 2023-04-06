package com.paymentMS.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.paymentMS.app.Repository.PaymentRepository;
import com.paymentMS.app.model.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	public Payment savePayment(Payment req) {

		return paymentRepo.save(req);
	}
	
	public List<Payment> getPayments() {
		return paymentRepo.findAll();
	}
	
	public Payment updatePayment( Payment req,int id) {
		Payment p = paymentRepo.findByPaymentid( id);
		p.setbookingnumber(req.getbookingnumber());
		p.setdateofpayment(req.getdateofpayment());
		return paymentRepo.save(req);
	}
	public String deletePayment( int id) {

		paymentRepo.deleteByPaymentid(id);
		return "deleted";
	}
}
