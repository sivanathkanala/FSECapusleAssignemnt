package com.example.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentTaskDao extends CrudRepository<ParentTask, Integer> {

	public Optional<ParentTask> findById(int arg0);

	
	public boolean existsById(int arg0);
	
	@Query(value = "SELECT * FROM parenttask t WHERE LOWER(t.parent_task) = LOWER(:task)", nativeQuery = true)
	public Optional<ParentTask> findByName(@Param("task") String task);
	
}
