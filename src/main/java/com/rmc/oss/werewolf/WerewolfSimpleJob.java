package com.rmc.oss.werewolf;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class WerewolfSimpleJob implements Job{
	
	public void execute(JobExecutionContext context) throws JobExecutionException {				
		JobDataMap dataMap = context.getMergedJobDataMap();
		String message = "Hello Quartz!";
		String msg = dataMap.getString("Message");
		if (msg != null) message = msg; 
		
		System.out.println(message);
	}
}
