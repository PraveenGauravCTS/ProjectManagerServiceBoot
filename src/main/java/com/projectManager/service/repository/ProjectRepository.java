package com.projectManager.service.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.projectManager.service.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

	@Query(" SELECT P FROM PROJECT P where P.project LIKE %:prjName% ")
	Iterable<Project> getProjectDetails(@Param("prjName") String prjName, Sort sort);

	Iterable<Project> getProjectDetailsOrderByStatus(@Param("prjName") String prjName);

}
