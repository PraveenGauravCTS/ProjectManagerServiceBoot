package com.projectManager.service.view;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserView extends BaseView{

	@JsonProperty("User_ID")
	private Integer userId = null;
	@JsonProperty("EmployeeId")
	private Integer employeeId = null;
	@JsonProperty("FirstName")
	private String firstName = null;
	@JsonProperty("LastName")
	private String lastName = null;
	@JsonProperty("fullName")
	private String fullName = null;
	@JsonProperty("Project_ID")
	private Integer projectId = 0;
	@JsonProperty("Task_ID")
	private Integer taskId = 0;

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

	public String getFullName() {
		return StringUtils.trimToEmpty(this.firstName) + StringUtils.trimToEmpty(this.lastName);
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
