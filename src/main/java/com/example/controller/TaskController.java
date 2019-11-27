package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ParentTask;
import com.example.dao.Task;
import com.example.info.GetTaskInfo;
import com.example.service.TaskService;
import com.example.utilities.ResponseBuilder;
import com.example.utilities.ResponseBuilder.GetResponseInfo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ComponentScan("com.example")
public class TaskController {

	@Autowired
	public TaskService taskService;
	
	@RequestMapping(value="/getTaskByName",  method=RequestMethod.GET)
	public @ResponseBody GetResponseInfo getTask(@RequestParam(name = "task") String taskName)
	{	
		return new ResponseBuilder()._build(taskService.getTaskDetails(taskName));
	}
	
	@RequestMapping(value="/getTaskById",  method=RequestMethod.GET)
	public @ResponseBody GetResponseInfo getTaskById(@RequestParam(name = "id") int id)
	{	
		return new ResponseBuilder()._build(taskService.getTaskDetailsById(id));
	}
	
	@RequestMapping(value="/getAllTasks",  method=RequestMethod.GET)
	public @ResponseBody List<GetResponseInfo> getAllTasks()
	{	
		return new ResponseBuilder()._build(taskService.getAllTasks());
	}
	
	@RequestMapping(value="/addTask",  method=RequestMethod.POST)
	public @ResponseBody String addTask(@RequestBody GetTaskInfo reqInfo)
	{	
		return new ResponseBuilder()._buildAddTaskResponse(taskService.addTaskDetails(reqInfo));
	}
	
	@RequestMapping(value="/updateTask",  method=RequestMethod.POST)
	public @ResponseBody String updateTask(@RequestBody GetTaskInfo reqInfo)
	{	
		return new ResponseBuilder()._buildUpdateTaskResponse(taskService.updateTaskDetails(reqInfo));
	}
	
	@RequestMapping(value="/deleteTaskById",  method=RequestMethod.POST)
	public @ResponseBody String deleteTaskById(@RequestParam(name = "id") int id)
	{	
		return new ResponseBuilder()._buildUpdateTaskResponse(taskService.deleteTaskById(id));
	}
	
}
