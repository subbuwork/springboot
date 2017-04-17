/**
 * 
 */
package com.spring.boot.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author subbu
 *
 */

@Component
public class Receiver {
    @Autowired	
    JmsTemplate jmstemp;
    
	@JmsListener(destination="${inbound.endpoint}")
	public void messageReceiver(String message){
		System.out.println("Received message::::"+message);
	}

}
