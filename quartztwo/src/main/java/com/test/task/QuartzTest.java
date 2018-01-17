package com.test.task;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

//Quartz的API的风格在2.x以后，采用的是DSL风格（通常意味着fluent interface风格），
//就是示例中newTrigger()那一段东西。它是通过Builder实现的，就是以下几个
//DSL风格写起来会更加连贯，畅快，而且由于不是使用setter的风格，语义上会更容易理解一些。
public class QuartzTest {

	public static void main(String args[]) {
		try {
			// 创建scheduler
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			// 定义一个Trigger
			Trigger trigger = newTrigger().withIdentity("trigger1", "group1") // 定义name/group
					.startNow()// 一旦加入scheduler，立即生效
					.withSchedule(simpleSchedule() // 使用SimpleTrigger
							.withIntervalInSeconds(1) // 每隔一秒执行一次
							.repeatForever()) // 一直执行，奔腾到老不停歇
					.build();

			/*setter的风格
			SimpleTriggerImpl trigger=new SimpleTriggerImpl("trigger1","group1");
			trigger.setStartTime(new Date());
			trigger.setRepeatInterval(1);
			trigger.setRepeatCount(-1);*/
			// 定义一个JobDetail
			JobDetail job = newJob(SimpleJob.class) // 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
					.withIdentity("job1", "group1") // 定义name/group
					.usingJobData("name", "quartz") // 定义属性
					.build();

			// 加入这个调度
			scheduler.scheduleJob(job, trigger);

			// 启动之
			scheduler.start();

			// 运行一段时间后关闭
			Thread.sleep(10000);
			scheduler.shutdown(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
