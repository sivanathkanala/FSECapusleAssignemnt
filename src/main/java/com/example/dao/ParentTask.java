package com.example.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="parenttask")
public class ParentTask {
	
	public ParentTask()
	{
		
	}
	
	@Id
	@Column(name = "Parent_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	//@OneToMany(mappedBy = "parentTask" )
	@Column(name = "Parent_Task", unique = false)	
	@NotNull
	private String parenttask;
	
	
	public ParentTask(int id)
	{
		this.id = id;	
	}
	
	public ParentTask(int id,  String parenttask)
	{
		this.id = id;		
		this.parenttask = parenttask;		
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getTask() {
		return parenttask;
	}




	public void setTask(String parenttask) {
		this.parenttask = parenttask;
	}



	


}
