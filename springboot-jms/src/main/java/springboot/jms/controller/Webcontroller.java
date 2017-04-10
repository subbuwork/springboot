package springboot.jms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.jms.clt.JmsClient;

@RestController
@RequestMapping(value="/springbootjms/")
public class Webcontroller {
	Logger log = LoggerFactory.getLogger(Webcontroller.class);
	
	@Autowired
	JmsClient jmsClient;
	
	@RequestMapping(value="getMessage")
	public String getMessage(){
		String message = "";
		message = jmsClient.getMessage();
		log.info("Message from webcontroller", message);
		return message;
		
	}
	@RequestMapping(value="sendMessage")
	public void sendMessage(@RequestParam("msg")String message){
		log.info("Message to broker:::",message);
		jmsClient.sendMessage(message);
	}

}
