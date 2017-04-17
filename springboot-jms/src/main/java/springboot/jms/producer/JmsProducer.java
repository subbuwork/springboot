package springboot.jms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
	Logger log = LoggerFactory.getLogger(JmsProducer.class);
	@Autowired
	JmsTemplate jmsTemplate;
	@Value("${outbount.endpoint}")
	String destination;
	public void sendMessage(String message){
		log.info("Inside JmsProducer",message);
		jmsTemplate.convertAndSend(destination, message);
	}

}
