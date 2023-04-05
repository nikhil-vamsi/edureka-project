package com.paymentMS.app;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.paymentMS.app")
@EnableWebMvc
public class paymentApplication  {
	 
    public static void main(String[] args) {
        SpringApplication.run(paymentApplication.class, args);
        
       
    }

   

}