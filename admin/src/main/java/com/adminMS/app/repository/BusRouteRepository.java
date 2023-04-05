package com.adminMS.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.adminMS.app.model.busroute;

import java.util.List;

@Repository
public interface BusRouteRepository extends JpaRepository<busroute, Integer> {

	busroute findByBusnum(int id);

	void deleteByBusnum(int id);
	

}
