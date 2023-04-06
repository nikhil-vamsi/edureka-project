package com.bookingMS.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingMS.app.model.Booking;

import java.util.List;

public interface Bookingrepository extends JpaRepository<Booking, Integer> {

	Booking findByBookingnumber(int id);


}
