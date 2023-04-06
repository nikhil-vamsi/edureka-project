
package com.bookingMS.app.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="application-payment")
public interface PaymentFeignClient {
	@DeleteMapping("/delPay/{id}")
	 String delete(@PathVariable int id);
}
