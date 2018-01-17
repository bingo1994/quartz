package com.test.service;

import javax.servlet.http.HttpServletResponse;

import com.test.controller.JobController;
import com.test.model.JobEntity;

public interface QuartzService {

	public void addJob(JobEntity job, HttpServletResponse response,JobController jobController);
}
