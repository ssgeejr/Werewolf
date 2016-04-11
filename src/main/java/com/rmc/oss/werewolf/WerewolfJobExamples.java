package com.rmc.oss.werewolf;

import javax.naming.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

import org.quartz.*;
import org.quartz.impl.matchers.*;

public class WerewolfJobExamples {

	public WerewolfJobExamples() {
		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();

			for (String group : scheduler.getJobGroupNames()) {
				for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(group))) {
					System.out.println("Found job identified by: " + jobKey);
				}
			}
			
            JobDataMap dataMap = new JobDataMap();
            dataMap.put("Message", "Some message data .... ");
            dataMap.put("recipient1", "you");
            dataMap.put("recipient2", "me");
            dataMap.put("recipient3", "us");
            dataMap.put("recipient4", "they");
            dataMap.put("recipient5", "them");

            JobDetail job = JobBuilder.newJob(WerewolfSimpleJob.class).usingJobData(dataMap).build();
	        Trigger trigger = TriggerBuilder
					.newTrigger()
//					.withIdentity("dummyTriggerName02", "group1")
					.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(10).repeatForever())
					.build();
			scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			System.out.println("There was an error scheduling the job.");
			e.printStackTrace();
		}
	}

}
