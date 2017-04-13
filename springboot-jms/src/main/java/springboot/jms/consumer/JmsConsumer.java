package springboot.jms.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
	Logger log = LoggerFactory.getLogger(JmsConsumer.class);
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${inbound.endpoint}")
	String destination;
	
	public String getMessage(){
		String retMessage = "";
		retMessage= (String)jmsTemplate.receiveAndConvert(destination);
		log.info("Message from jmsConsumer:::",retMessage);
		return retMessage;
	}

}
