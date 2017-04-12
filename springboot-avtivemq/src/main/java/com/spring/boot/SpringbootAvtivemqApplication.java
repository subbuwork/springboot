package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
public class SpringbootAvtivemqApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringbootAvtivemqApplication.class, args);
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("test2","test message2 from spring boot app.....");
		
		//jmsTemplate.getMessageConverter();
		
		
		
	}
}
