package com.rmc.oss.werewolf;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;

@WebListener
public class QuartzListener extends QuartzInitializerListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    	System.out.println("............... SERVLET INITIALIZED ...............");
    	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        super.contextInitialized(sce);
        ServletContext ctx = sce.getServletContext();       
        System.out.println("ctx.getAttribute(QUARTZ_FACTORY_KEY: " + ctx.getAttribute(QUARTZ_FACTORY_KEY));
        StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QUARTZ_FACTORY_KEY);
        try {
            Scheduler scheduler = factory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(TestJob.class).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simple").withSchedule(
                    CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).startNow().build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            System.out.println("************ WEREWOLF HUNTING .... ******************");
            JobDetail job = JobBuilder.newJob(WerewolfSimpleJob.class).withIdentity("WerewolfHunting", "werewolfGroup01").build();
    		trigger = TriggerBuilder
    				.newTrigger()
    				.withIdentity("dummyTriggerName", "group1")
    				.withSchedule(
    					SimpleScheduleBuilder.simpleSchedule()
    						.withIntervalInSeconds(20).repeatForever())
    				.build();
    		scheduler.scheduleJob(job, trigger);
            
        } catch (Exception e) {
            ctx.log("There was an error scheduling the job.", e);
        }
    }
}