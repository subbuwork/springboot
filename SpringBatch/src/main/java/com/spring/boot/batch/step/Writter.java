/**
 * 
 */
package com.spring.boot.batch.step;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

/**
 * @author subbu
 *
 */
public class Writter implements ItemWriter<String> {
  Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void write(List<? extends String> messages) throws Exception {
        for(String msg: messages){
        	logger.info("#Writing message is:::",msg);
        }
		
		
	}

}
