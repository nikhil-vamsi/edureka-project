
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

import com.paymentMS.app.Repository.paymentRepository;
import com.paymentMS.app.model.payment;
import com.paymentMS.app.service.paymentService;

@RestController
public class paymentController {

	@Autowired
	private paymentRepository paymentRepo;
	
	@Autowired
	private paymentService payService;

	@GetMapping("/getpayment")
	public List<payment> getAll() {
		return payService.getPayments();
	}

	@PostMapping("/pay")
	public payment doPayment(@RequestBody payment req) {

		return payService.savePayment(req);
	}
	
	@PutMapping("/updPay/{id}")
	public payment update(@RequestBody payment req,@PathVariable int id) {
		return payService.updatePayment(req, id);
	}
	
	@DeleteMapping("/delPay/{id}")
	@Transactional
	public String delete(@PathVariable int id) {

		return payService.deletePayment(id);
	}

}
