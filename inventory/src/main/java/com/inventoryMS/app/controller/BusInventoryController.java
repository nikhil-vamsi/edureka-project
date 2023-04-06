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

import com.inventoryMS.app.model.Businventory;
import com.inventoryMS.app.service.Businventoryservice;


@RestController
public class BusInventoryController {


	@Autowired
	private Businventoryservice busInvService;
	
	@GetMapping("/getBusInv")
	public List<Businventory> getAll(){
		return busInvService.getAll();
	}
	
	
	@PostMapping("/busInv")
	public Businventory create(@RequestBody Businventory req) {
		return busInvService.create(req);
	}
	@PutMapping("/updBusInv/{id}")
	public Businventory update(@RequestBody Businventory req,@PathVariable int id) {
		return busInvService.update(req, id);
	}
	@DeleteMapping("/delBusInv/{id}")
	@Transactional
	public String delete(@PathVariable int id) {
		return busInvService.delete(id);
	}
	
	@GetMapping("/getByBus/{id}")
	public Businventory getByBusNum(@PathVariable int id) {
		return busInvService.getByBusNum(id);
		 
	}
}
