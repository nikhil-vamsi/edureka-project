package com.bookingMS.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingMS.app.model.Passenger;

import java.util.List;

public interface passengerRepository extends JpaRepository<Passenger,Integer> {


}
