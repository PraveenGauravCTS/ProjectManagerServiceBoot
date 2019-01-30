package com.projectManager.service.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.projectManager.service.constant.ServiceConstant;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TaskView extends BaseView {

	@JsonProperty("Task_ID")
	private Integer taskId;
	@JsonProperty("Parent_ID")
	private Integer parentId = 0;
	@JsonProperty("ParentTask")
	private String parentTask=null;
	@JsonProperty("Project_ID")
	private Integer projectId = 0;
	@JsonProperty("Project")
	private String project = null;
	@JsonProperty("Task")
	private String task = null;
	@JsonProperty("status")
	private String status = null;
	@JsonProperty("Priority")
	private String priority = null;
	@JsonProperty("StartDate")
	private String startDateDisplay = null;
	@JsonProperty("EndDate")
	private String endDateDisplay = null;

	
	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (ServiceConstant.STATUS_OPEN.equals(status)) {
			this.status = "OPEN";
		} else if (ServiceConstant.STATUS_COMPLETED.equals(status)) {
			this.status = "COMPLETED";
		} else {
			this.status = status;
		}
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStartDateDisplay() {
		return startDateDisplay;
	}

	public void setStartDateDisplay(String inStartDateDisplay) {
		startDateDisplay = inStartDateDisplay;
	}

	public String getEndDateDisplay() {
		return endDateDisplay;
	}

	public void setEndDateDisplay(String inEndDateDisplay) {
		endDateDisplay = inEndDateDisplay;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String inParentTask) {
		parentTask = inParentTask;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

}
