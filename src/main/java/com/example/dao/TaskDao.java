package com.example.dao;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {

	public Optional<Task> findById(int arg0);
	
	//public  <S extends Task> S save(Task agent);
	
	public boolean existsById(int arg0);
	
	@Query(value = "SELECT * FROM task t WHERE LOWER(t.task) = LOWER(:task)", nativeQuery = true)
	public Optional<Task> findByName(@Param("task") String task);
	
	@Modifying
    @Query(value = "UPDATE task t SET t.task = :task, t.parent_id = :parentId, start_date = :startDate , end_date = :endDate, priority =:priority  WHERE t.task_id = :id", nativeQuery = true)
    int updateAddress(@Param("task") String task, @Param("parentId") int  parentId, @Param("startDate") Date  startDate, @Param("endDate") Date endDate, @Param("priority") int  priority);
	
	
	
}
