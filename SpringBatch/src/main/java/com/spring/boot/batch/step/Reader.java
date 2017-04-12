/**
 * 
 */
package com.spring.boot.batch.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author subbu
 * Date 04/10/2017
 */
public class Reader implements ItemReader<String> {
    Logger logger = LoggerFactory.getLogger(Reader.class);
	private String[] messages = {"Hello world!!!","Welcome to spring batch"};
    private Integer count = 0;
    
	
	public String read() throws Exception, UnexpectedInputException, ParseException,
			NonTransientResourceException {
		logger.debug("No of messages:::",messages.length);
		if(count < messages.length){
			logger.info("#Message::::",messages[count++]);
			return messages[count++];
		}else{
			count = 0;
		}
		
		return null;
	}

}
