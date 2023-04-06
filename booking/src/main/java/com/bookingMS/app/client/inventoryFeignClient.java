
package com.bookingMS.app.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bookingMS.app.model.Businventory;

@FeignClient(name="application-inventory")
public interface InventoryFeignClient {
	@GetMapping("/getByBus/{id}")
	Businventory getBusInventory(@PathVariable int id);
}
