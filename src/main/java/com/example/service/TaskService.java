package com.example.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ParentTask;
import com.example.dao.ParentTaskDao;
import com.example.dao.Task;
import com.example.dao.TaskDao;
import com.example.info.GetTaskInfo;

@Service
public class TaskService {

	@Autowired
	public TaskDao taskDao;
	
	@Autowired
	public ParentTaskDao parentTaskDao;
	
	private static  final Logger log =  LogManager.getLogger("TaskService");
	
	SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-DD");
	
	public Task getTaskDetails(String task) {
		
		return taskDao.findByName(task).get();
	}
	
	public Task getTaskDetailsById(int id) {
		
		return taskDao.findById(id).get();
	}

	public Iterable<Task> getAllTasks() {
		
		return taskDao.findAll();
	}
	
	public Task addTaskDetails( GetTaskInfo req) {
		if(!taskDao.existsById(req.getId()))
		{
			try {
				if(parentTaskDao.findByName(req.getParenttask()).isPresent())
				{
					return taskDao.save(new Task(parentTaskDao.findByName(req.getParenttask()), req.getTaskName(),sd.parse(req.getTaskStartDate()) ,
							sd.parse(req.getTaskEndDate()) , Integer.parseInt(req.getPriority()) ));
				}
				else
				{
					log.error("No Parent Task found by Id " + req.getParenttask());
					return new Task(0,new ParentTask(0, null), "No Task" ,null, null, 0);
				}
				
			} catch (NumberFormatException | ParseException e) {
				log.info("Failed to add Task.  Error while parsing the Task data for the Task " + req.getTaskName());
			}
		}
		else
		{
			return new Task(0,new ParentTask(0, null), "Task already present" ,null, null, 0);
		}
		return null;
	}
	
	public Task updateTaskDetails( GetTaskInfo req) {
		if(taskDao.existsById(req.getId()))
		{	
				try {		
					Optional<Task> temp = taskDao.findById(req.getId());
					Task loadedTask = temp.get();
					loadedTask.setTask(req.getTaskName());
					loadedTask.setParentTask(parentTaskDao.findByName(req.getParenttask()).get());
					loadedTask.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getTaskStartDate()));
					loadedTask.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(req.getTaskEndDate()));
					loadedTask.setPriority(new Integer(req.getPriority()));
					
					return taskDao.save(loadedTask);
					
				//taskDao.deleteById(Integer.parseInt(req.getTaskId()));
				/*
				 * return taskDao.save(new Task(parentTaskDao.findByName(req.getParenttask()),
				 * req.getTaskName(),sd.parse(req.getTaskStartDate()) ,
				 * sd.parse(req.getTaskEndDate()) , Integer.parseInt(req.getPriority()) ));
				 */
			} catch (NumberFormatException | ParseException e) {
				log.info("Failed to update Task.  Error while parsing the Task data for the Task " + req.getTaskName());
			}
		}
		else
		{
			return new Task(0,new ParentTask(0, null), "No Task" ,null, null, 0);
		}
		return null;
	}
	
	public Task deleteTaskById( int id) {
		if(taskDao.existsById(id))
		{
			try {		
				Optional<Task> temp = taskDao.findById(id);
				Task loadedTask = temp.get();
				loadedTask.setStatus("D");
				return taskDao.save(loadedTask);
			} catch (NumberFormatException e) {
				log.info("Failed to update Task.  Error while parsing the Task data for the Task id : " + id);
			}
		}
		else
		{
			return new Task(0,new ParentTask(0, null), "No Task" ,null, null, 0);
		}
		return null;
	}


}
