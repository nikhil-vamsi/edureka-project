
package com.adminMS.app.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adminMS.app.model.Busroute;
import com.adminMS.app.repository.BusRouteRepository;

@RestController
public class BusRouteController {

	@Autowired
	private BusRouteRepository busRouteRepo;

	@GetMapping("/getBusRoute")
	public List<Busroute> getAll() {
		return busRouteRepo.findAll();
	}

	@PostMapping("/busRoute")
	public Busroute Book(@RequestBody Busroute req) {

		return busRouteRepo.save(req);
	}
	@PutMapping("/updBusRoute/{id}")
	public Busroute Book(@RequestBody Busroute req,@PathVariable int id) {
		Busroute busRou = busRouteRepo.findByBusnum(id);
		busRou.setDestinationname(req.getDestinationname());
		busRou.setPrice(req.getPrice());
		busRou.setSourcename(req.getSourcename());
		return busRouteRepo.save(busRou);
	}
	@DeleteMapping("/delBusRoute/{id}")
	@Transactional
	public String Book(@PathVariable int id) {
		busRouteRepo.deleteByBusnum(id);
		 return "deleted";
	}

}
