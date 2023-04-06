package com.inventoryMS.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventoryMS.app.model.Businventory;
import com.inventoryMS.app.repository.BusInventoryRepository;

@Service
public class Businventoryservice {
	
	@Autowired
	private BusInventoryRepository busInvRepo;
	
	public List<Businventory> getAll(){
		return busInvRepo.findAll();
	}
	public Businventory update( Businventory req, int id) {
		Businventory busInv = busInvRepo.findByBusnumber(id);
		busInv.setAvailableseats(req.getAvailableseats());
		busInv.setLastupdateddate(req.getLastupdateddate());
		return busInvRepo.save(busInv);
	}
	
	public Businventory create( Businventory req) {
		return busInvRepo.save(req);
	}
	public String delete( int id) {
		 busInvRepo.deleteByBusnumber(id);
		 return "deleted";
	}
	public Businventory getByBusNum( int id) {
		 return busInvRepo.findByBusnumber(id);
		 
	}
}
