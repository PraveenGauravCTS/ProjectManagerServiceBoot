package com.projectManager.service.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProjectView extends BaseView {


	@JsonProperty("Project_ID")
	private Integer projectId;
	@JsonProperty("Project")
	private String project = null;
	@JsonProperty("Priority")
	private String priority = null;
	@JsonProperty("StartDate")
	private String startDateDisplay = null;
	@JsonProperty("EndDate")
	private String endDateDisplay = null;
	@JsonProperty("CompletedTasks")
	private Integer completedTaskNum = 0;
	@JsonProperty("TaskCount")
	private Integer totalTaskNum = 0;
	@JsonProperty("UserId")
	private Integer managerId = 0;


	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getCompletedTaskNum() {
		return completedTaskNum;
	}

	public void setCompletedTaskNum(Integer completedTaskNum) {
		this.completedTaskNum = completedTaskNum;
	}

	public Integer getTotalTaskNum() {
		return totalTaskNum;
	}

	public void setTotalTaskNum(Integer totalTaskNum) {
		this.totalTaskNum = totalTaskNum;
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

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer inManagerId) {
		managerId = inManagerId;
	}

}
