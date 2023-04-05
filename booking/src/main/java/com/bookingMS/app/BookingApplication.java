package com.bookingMS.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.bookingMS.app")
@EnableFeignClients
@EnableEurekaClient
@EnableWebMvc
public class BookingApplication  {

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }

   

}