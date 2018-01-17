package com.test.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleJobListener implements JobListener{
	
	private static Logger logger = LoggerFactory.getLogger(SimpleJobListener.class);


	//用于获取该JobListener的名称
	public String getName() {
		String name = getClass().getSimpleName();
        logger.info(" listener name is:"+name);
		return name;
	}

	//Scheduler在JobDetail将要被执行时调用这个方法
	public void jobToBeExecuted(JobExecutionContext context) {
		String jobName = context.getJobDetail().getKey().getName();
        logger.info(jobName + " is going to be executed");
	}

	//Scheduler在JobDetail即将被执行，但又被TriggerListerner否决时会调用该方法
	public void jobExecutionVetoed(JobExecutionContext context) {
		String jobName = context.getJobDetail().getKey().getName();
        logger.info(jobName + " was vetoed and not executed");
	}

	//Scheduler在JobDetail被执行之后调用这个方法
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		String jobName = context.getJobDetail().getKey().getName();
        logger.info(jobName + " was executed");
	}

}
