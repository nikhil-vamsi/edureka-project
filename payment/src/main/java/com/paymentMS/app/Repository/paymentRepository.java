package com.paymentMS.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentMS.app.model.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByPaymentid(int id);

	void deleteByPaymentid(int id);


}
