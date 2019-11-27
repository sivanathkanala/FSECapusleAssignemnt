package com.example.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetTaskInfo {

	@JsonProperty("id")
	public int id;
	
	@JsonProperty("taskName")
	public String taskName;
	
	@JsonProperty("parenttask")
	public String parenttask;	
	
	@JsonProperty("taskStartDate")
	public String taskStartDate;
	
	@JsonProperty("taskEndDate")
	public String taskEndDate;
	
	@JsonProperty("priority")
	public String priority;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParenttask() {
		return parenttask;
	}

	public void setParenttask(String parenttask) {
		this.parenttask = parenttask;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(String taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public String getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(String taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	

}
