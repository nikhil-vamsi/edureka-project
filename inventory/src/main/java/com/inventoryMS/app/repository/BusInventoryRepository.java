package com.inventoryMS.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventoryMS.app.model.businventory;

import java.util.List;

public interface BusInventoryRepository extends JpaRepository<businventory, Integer> {
	businventory findByBusnumber(int Id);

	void deleteByBusnumber(int id);
	

}
