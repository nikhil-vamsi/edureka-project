package com.bookingMS.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingMS.app.model.booking;

import java.util.List;

public interface bookingrepository extends JpaRepository<booking, Integer> {

	booking findByBookingnumber(int id);


}
