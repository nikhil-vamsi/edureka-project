package com.adminMS.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages= {"com.adminMS.model"})
@EnableWebMvc
@EnableDiscoveryClient
@EnableEurekaClient
public class BusRouteApplication  {

    public static void main(String[] args) {
        SpringApplication.run(BusRouteApplication.class, args);
    }

   

}