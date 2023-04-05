package com.adminMS.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages= {"com.adminMS.model"})
@EnableWebMvc
public class busRouteApplication  {

    public static void main(String[] args) {
        SpringApplication.run(busRouteApplication.class, args);
    }

   

}