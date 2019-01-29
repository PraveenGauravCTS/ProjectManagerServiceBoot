package com.projectManager.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "USERS")
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;

	@Column(name = "FIRST_NAME", length = 25)
	private String firstName;

	@Column(name = "LAST_NAME", length = 25)
	private String lastName;

	@Column(name = "PROJECT_ID")
	private Integer projectId;

	@Column(name = "TASK_ID")
	private Integer taskId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

}
