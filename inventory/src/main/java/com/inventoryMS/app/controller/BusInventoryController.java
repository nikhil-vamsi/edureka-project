package com.inventoryMS.app.controller;

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

import com.inventoryMS.app.model.businventory;
import com.inventoryMS.app.service.businventoryservice;


@RestController
public class BusInventoryController {


	@Autowired
	private businventoryservice busInvService;
	
	@GetMapping("/getBusInv")
	public List<businventory> getAll(){
		return busInvService.getAll();
	}
	
	
	@PostMapping("/busInv")
	public businventory create(@RequestBody businventory req) {
		return busInvService.create(req);
	}
	@PutMapping("/updBusInv/{id}")
	public businventory update(@RequestBody businventory req,@PathVariable int id) {
		return busInvService.update(req, id);
	}
	@DeleteMapping("/delBusInv/{id}")
	@Transactional
	public String delete(@PathVariable int id) {
		return busInvService.delete(id);
	}
	
	@GetMapping("/getByBus/{id}")
	public businventory getByBusNum(@PathVariable int id) {
		return busInvService.getByBusNum(id);
		 
	}
}
