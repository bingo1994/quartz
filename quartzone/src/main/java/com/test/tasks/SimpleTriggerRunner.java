package com.test.tasks;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

//通过SimpleTrigger对SimpleJob进行调度
public class SimpleTriggerRunner {

	public static void main(String []args){
		try {  
		//创建一个JobDetail实例，指定SimpleJob
		JobDetail jobDetail = new JobDetail("job1_1","jGroup1", SimpleJob.class); //指定关联的Job组名 ，指定关联的Job名称 
		//通过SimpleTrigger定义调度规则：马上启动，每2秒运行一次，共运行100次  
		SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1","tgroup1");  
		simpleTrigger.setStartTime(new Date());
		simpleTrigger.setRepeatInterval(2000);  
		simpleTrigger.setRepeatCount(100); 
		//通过SchedulerFactory获取一个调度器实例  
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();  
		  
		Scheduler scheduler = schedulerFactory.getScheduler();  
		  
		scheduler.scheduleJob(jobDetail, simpleTrigger);// 注册并进行调度   指定了关联JobDetail的Trigger
		  
		scheduler.start();//调度启动  
		} catch (Exception e) {  
			  
			e.printStackTrace();  
			  
			} 
	}
}
