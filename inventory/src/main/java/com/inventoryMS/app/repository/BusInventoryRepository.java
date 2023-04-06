package com.inventoryMS.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventoryMS.app.model.Businventory;

import java.util.List;

public interface BusInventoryRepository extends JpaRepository<Businventory, Integer> {
	Businventory findByBusnumber(int Id);

	void deleteByBusnumber(int id);
	

}
