/**
 * 
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

/**
 * @author subbu
 *
 */
@RestController
public class JobLauncherController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@RequestMapping("launchjob")
	public String handle(){
		try {
			JobParameters jobParameter = new JobParametersBuilder().
					                          addLong("time",System.currentTimeMillis()).toJobParameters();
			jobLauncher.run(job,jobParameter);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "Job done";
		
	}
	
	

}
