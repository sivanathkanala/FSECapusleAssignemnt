package com.example.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="task")
public class Task {
	
	public Task()
	{
		
	}
	
	@Id
	@Column(name = "Task_ID", updatable = false, nullable = false)	
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)	
	@JoinColumn(name = "Parent_ID")	
	private ParentTask parentTask;
	

	@Column(name = "Task", unique=false)
	@NotNull	
	private String task;
	
	@Column(name = "Start_date")	
	private Date startDate;
	
	@Column(name = "End_Date")	
	private Date endDate;
	
	@Column(name = "Priority")	
	private int priority;
	
	@Column(name = "Status")	
	private String status = "A";
	


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public ParentTask getParentTask() {
		return parentTask;
	}



	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}



	public Task(Optional<ParentTask> parentTask, String task, Date startDate, Date endDate, int priority)
	{		
		this.parentTask = parentTask.get();
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
	}

	public Task(int id, ParentTask parentTask, String task, Date startDate, Date endDate, int priority)
	{		
		this.parentTask = parentTask;
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
	}
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getTask() {
		return task;
	}



	public void setTask(String task) {
		this.task = task;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public int getPriority() {
		return priority;
	}



	public void setPriority(int priority) {
		this.priority = priority;
	}



}
