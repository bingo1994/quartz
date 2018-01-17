package com.test.listener;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

public class SimpleSchedulerListener implements SchedulerListener {

	//用于部署JobDetail时调用
	public void jobScheduled(Trigger trigger) {
		// TODO Auto-generated method stub

	}

	//用于卸载JobDetail时调用
	public void jobUnscheduled(TriggerKey triggerKey) {
		// TODO Auto-generated method stub

	}

	//当一个 Trigger 来到了再也不会触发的状态时调用这个方法。除非这个 Job 已设置成了持久性，否则它就会从 Scheduler 中移除。
	public void triggerFinalized(Trigger trigger) {
		// TODO Auto-generated method stub

	}

	//Scheduler 调用这个方法是发生在一个 Trigger 或 Trigger 组被暂停时。假如是 Trigger 组的话，triggerName 参数将为 null。
	public void triggerPaused(TriggerKey triggerKey) {
		// TODO Auto-generated method stub

	}

	
	public void triggersPaused(String triggerGroup) {
		// TODO Auto-generated method stub

	}

	//Scheduler 调用这个方法是发生成一个 Trigger 或 Trigger 组从暂停中恢复时。假如是 Trigger 组的话，假如是 Trigger 组的话，triggerName 参数将为 null。参数将为 null。
	public void triggerResumed(TriggerKey triggerKey) {
		// TODO Auto-generated method stub

	}

	public void triggersResumed(String triggerGroup) {
		// TODO Auto-generated method stub

	}

	public void jobAdded(JobDetail jobDetail) {
		// TODO Auto-generated method stub

	}

	public void jobDeleted(JobKey jobKey) {
		// TODO Auto-generated method stub

	}

	//当一个或一组 JobDetail 暂停时调用这个方法。
	public void jobPaused(JobKey jobKey) {
		// TODO Auto-generated method stub

	}

	public void jobsPaused(String jobGroup) {
		// TODO Auto-generated method stub

	}

	//当一个或一组 Job 从暂停上恢复时调用这个方法。假如是一个 Job 组，jobName 参数将为 null。
	public void jobResumed(JobKey jobKey) {
		// TODO Auto-generated method stub

	}

	public void jobsResumed(String jobGroup) {
		// TODO Auto-generated method stub

	}

	//在 Scheduler 的正常运行期间产生一个严重错误时调用这个方法。
	public void schedulerError(String msg, SchedulerException cause) {
		// TODO Auto-generated method stub

	}

	//当Scheduler处于StandBy模式时，调用该方法
	public void schedulerInStandbyMode() {
		// TODO Auto-generated method stub

	}

	//当Scheduler 开启时，调用该方法
	public void schedulerStarted() {
		// TODO Auto-generated method stub

	}

	public void schedulerStarting() {
		// TODO Auto-generated method stub

	}

	//当Scheduler停止时，调用该方法
	public void schedulerShutdown() {
		// TODO Auto-generated method stub

	}

	public void schedulerShuttingdown() {
		// TODO Auto-generated method stub

	}

	//当Scheduler中的数据被清除时，调用该方法。
	public void schedulingDataCleared() {
		// TODO Auto-generated method stub

	}

}
