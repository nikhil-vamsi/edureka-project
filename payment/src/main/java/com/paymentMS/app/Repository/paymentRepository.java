package com.paymentMS.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentMS.app.model.payment;

import java.util.List;

public interface paymentRepository extends JpaRepository<payment, Integer> {

	payment findByPaymentid(int id);

	void deleteByPaymentid(int id);


}
