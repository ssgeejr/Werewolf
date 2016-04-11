package com.rmc.oss.werewolf;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerExample {

	public SimpleTriggerExample() {
		// TODO Auto-generated constructor stub
	}
	
	//Fire every 5 seconds
	public void exampleCode() throws Exception{
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("dummyTriggerName", "group1")
				.withSchedule(
				    SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(5).repeatForever())
				.build();
	}
		
	public static void main(String[] args) throws Exception {
		
		// Quartz 1.6.3
		// JobDetail job = new JobDetail();
		// job.setName("dummyJobName");
		// job.setJobClass(HelloJob.class);

		JobDetail job = JobBuilder.newJob(WerewolfSimpleJob.class).withIdentity("dummyJobName", "group1").build();

		// Trigger the job to run on the next round minute
		Trigger trigger = TriggerBuilder
			.newTrigger()
			.withIdentity("dummyTriggerName", "group1")
			.withSchedule(
				SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(20).repeatForever())
			.build();

		
		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

}
