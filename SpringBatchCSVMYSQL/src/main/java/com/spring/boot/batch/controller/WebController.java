/**
 * Author : Subbu
 *SpringBatchCSVMYSQL
 *WebController.java
 *Apr 12, 2017
 */
package com.spring.boot.batch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@RequestMapping("/reunjob")
	public String handle(){
		logger.info("Inside handle()..");
		try {
			JobParameters jobParameters = new JobParametersBuilder().
					addLong("time",System.currentTimeMillis()).
					toJobParameters();
			        jobLauncher.run(job,jobParameters);
		} catch (Exception e) {
            logger.info(e.getMessage());
		}
		logger.info("Done! Check Console Window for more details");
		return "Done! Check Console Window for more details";
	}
	

}
