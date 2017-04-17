package springboot.jms.clt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.jms.consumer.JmsConsumer;
import springboot.jms.producer.JmsProducer;


@Service
public class JmsClientImpl implements JmsClient {
    Logger log = LoggerFactory.getLogger(JmsClientImpl.class);
    @Autowired
    JmsProducer jmsProducer;
    
    @Autowired
    JmsConsumer jmsConsumer;
    
    
    
    public String getMessage() {
		log.info("Jms client impl.....");
		return jmsConsumer.getMessage();
	}

	public void sendMessage(String message) {
		log.info(message);
		jmsProducer.sendMessage(message);
		
	}
	

}
