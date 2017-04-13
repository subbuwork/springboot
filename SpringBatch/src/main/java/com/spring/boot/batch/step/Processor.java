package com.spring.boot.batch.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {
    Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public String process(String content) throws Exception {
		log.info("Processing message is::",content.toString());
		return content.toUpperCase();
	}

}
