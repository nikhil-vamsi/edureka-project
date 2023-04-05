package com.inventoryMS.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.inventoryMS.app")
@EnableWebMvc
@EnableEurekaClient
public class InventoryApplication  {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

   

}