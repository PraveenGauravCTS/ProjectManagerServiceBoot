package com.projectManager.service.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.projectManager.service.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

	@Query(" SELECT T FROM TASK T INNER JOIN T.project P where P.project LIKE %:projectName% ")
	Iterable<Task> getTaskDetails(@Param("projectName") String projectName, Sort sort);

}
