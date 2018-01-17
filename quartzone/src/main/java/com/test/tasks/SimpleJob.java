package com.test.tasks;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

// Quartz 任务的一个示例
//通过实现 org.quartz..Job 接口，可以使 Java 类化身为可调度的任务。
public class SimpleJob implements Job{

	//实例Job接口方法
	public void execute(JobExecutionContext jobCtx) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(jobCtx.getTrigger().getClass().getName()+ " triggered. time is:" + (new Date())); 
	}

}
