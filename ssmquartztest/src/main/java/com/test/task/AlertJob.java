package com.test.task;




import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import com.test.controller.JobController;

public class AlertJob implements Job{

	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		String msg=context.getJobDetail().getJobDataMap().getString("message");
		System.out.println("msg--------third-------->"+msg+"--------->");
		
		//测试scheduler.getCurrentlyExecutingJobs()
		/*for(long i=0;i<90000000000l;i++){
			System.out.println(i);
		}*/
		try {
			JobController jobController=(JobController)context.getScheduler().getContext().get("com.test.controller.JobController");
			jobController.test(msg);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
