package com.projectManager.service.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.projectManager.service.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(" SELECT U FROM USERS U where FIRST_NAME=(:userName) OR LAST_NAME=(:userName) ")
	Iterable<User> getUserDetails(@Param("userName") String userName, Sort sort);

}
