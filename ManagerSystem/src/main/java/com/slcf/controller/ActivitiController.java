package com.slcf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/activiti")
public class ActivitiController {

	
	@RequestMapping("/goQuest.action")
	public String goQuest(){
		return "quest";
	}
	
	@RequestMapping("/goTask.action")
	public String goTask(){
		return "task";
	}
	
	@RequestMapping("/goProcess.action")
	public String goProcess(){
		return "process";
	}
}
