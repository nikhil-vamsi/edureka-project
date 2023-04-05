package com.bookingMS.app.activeMQ;

import java.util.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JMSConfig {
	
	    @Bean
	    public ActiveMQQueue queue(){
	        return new ActiveMQQueue("paymentQueue");
	    }
	    
	    @Bean
	    public ActiveMQQueue errorQueue(){
	        return new ActiveMQQueue("errorQueue");
	    }
	}

