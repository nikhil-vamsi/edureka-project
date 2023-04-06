
package com.paymentMS.app.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paymentMS.app.Repository.PaymentRepository;
import com.paymentMS.app.model.Payment;
import com.paymentMS.app.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private PaymentService payService;

	@GetMapping("/getpayment")
	public List<Payment> getAll() {
		return payService.getPayments();
	}

	@PostMapping("/pay")
	public Payment doPayment(@RequestBody Payment req) {

		return payService.savePayment(req);
	}
	
	@PutMapping("/updPay/{id}")
	public Payment update(@RequestBody Payment req,@PathVariable int id) {
		return payService.updatePayment(req, id);
	}
	
	@DeleteMapping("/delPay/{id}")
	@Transactional
	public String delete(@PathVariable int id) {

		return payService.deletePayment(id);
	}

}
