/**
 * 
 */
package com.spring.boot.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.batch.step.Processor;
import com.spring.boot.batch.step.Reader;
import com.spring.boot.batch.step.Writter;

/**
 * @author subbu
 *
 */
@Configuration
public class BatchConfig {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job job(){
		return jobBuilderFactory.get("job")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end().build();
	}
	
	@Bean
	public Step step1(){
		logger.info("#Step:::");
		return stepBuilderFactory.get("step1")
				.<String,String>chunk(1)
				.reader(new Reader())
				.processor(new Processor())
				.writer(new Writter())
				.build();
	}
	
	

}
