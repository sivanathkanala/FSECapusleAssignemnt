package com.example.utilities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.example.dao.Task;




public class ResponseBuilder {

	public ResponseBuilder() {

	}

	SimpleDateFormat simpleDtFormat = new SimpleDateFormat("yyyy-MM-dd");  
	
	public List<GetResponseInfo> _build(Iterable<Task> tasks) {
		List<GetResponseInfo> responses = new ArrayList<GetResponseInfo>();
		java.util.Iterator<Task> iter = tasks.iterator();
		while(iter.hasNext())
		{
			Task task = iter.next();
			responses.add(new GetResponseInfo()._setId(task.getId())._setParenttask(task.getParentTask().getTask())
				._setTaskName(task.getTask())._setTaskStartDate(simpleDtFormat.format(task.getStartDate()))._setTaskEndDate(simpleDtFormat.format(task.getEndDate()))._setPriority(task.getPriority())._setStatus(task.getStatus()));
		}
		return responses;
	}
	
	public GetResponseInfo _build(Task task) {
		return new GetResponseInfo()._setId(task.getId())._setParenttask(task.getParentTask().getTask())
				._setTaskName(task.getTask())._setTaskStartDate(simpleDtFormat.format(task.getStartDate()))._setTaskEndDate(simpleDtFormat.format(task.getEndDate()))._setPriority(task.getPriority())._setStatus(task.getStatus());
	}
	
	public String _buildAddTaskResponse(Task task) {
		return task.getId() != 0 ? "success" : "Failure. Probably  Task exists already or No Parent Task";
	}

	public String _buildUpdateTaskResponse(Task task) {
		return task.getId() != 0 ? "success" : "Update failed. Probably Task does not exist or No Parent Task";
	}
	
	
	public class GetResponseInfo {
		public int id;		
		public String parenttask;
		public String taskName;
		public String taskStartDate;
		public String taskEndDate;
		public int priority;
		public String status;
		public String getStatus() {
			return status;
		}
		public GetResponseInfo _setStatus(String status) {
			this.status = status;
			return this;
		}
		public int getId() {
			return id;
		}
		public GetResponseInfo _setId(int id) {
			this.id = id;
			return this;
		}
		public String getParenttask() {
			return parenttask;
		}
		public GetResponseInfo _setParenttask(String parenttask) {
			this.parenttask = parenttask;
			return this;
		}
		public String getTaskName() {
			return taskName;
		}
		public GetResponseInfo _setTaskName(String taskName) {
			this.taskName = taskName;
			return this;
		}
		public String getTaskStartDate() {
			return taskStartDate;
		}
		public GetResponseInfo _setTaskStartDate(String taskStartDate) {
			this.taskStartDate = taskStartDate;
			return this;
		}
		public String getTaskEndDate() {
			return taskEndDate;
		}
		public GetResponseInfo _setTaskEndDate(String taskEndDate) {
			this.taskEndDate = taskEndDate;
			return this;
		}
		public int getPriority() {
			return priority;
		}
		public GetResponseInfo _setPriority(int priority) {
			this.priority = priority;
			return this;
		}

		

	}
}
