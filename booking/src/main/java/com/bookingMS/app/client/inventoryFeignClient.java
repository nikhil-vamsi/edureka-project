
package com.bookingMS.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookingMS.app.model.businventory;

@FeignClient(name="inventoryMS",url="http://localhost:8081")
public interface inventoryFeignClient {
	@GetMapping("/getByBus/{id}")
	businventory getBusInventory(@PathVariable int id);
}
