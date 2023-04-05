package com.inventoryMS.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventoryMS.app.model.businventory;
import com.inventoryMS.app.repository.BusInventoryRepository;

@Service
public class businventoryservice {
	
	@Autowired
	private BusInventoryRepository busInvRepo;
	
	public List<businventory> getAll(){
		return busInvRepo.findAll();
	}
	public businventory update( businventory req, int id) {
		businventory busInv = busInvRepo.findByBusnumber(id);
		busInv.setAvailableseats(req.getAvailableseats());
		busInv.setLastupdateddate(req.getLastupdateddate());
		return busInvRepo.save(busInv);
	}
	
	public businventory create( businventory req) {
		return busInvRepo.save(req);
	}
	public String delete( int id) {
		 busInvRepo.deleteByBusnumber(id);
		 return "deleted";
	}
	public businventory getByBusNum( int id) {
		 return busInvRepo.findByBusnumber(id);
		 
	}
}
