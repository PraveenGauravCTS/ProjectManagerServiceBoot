package com.projectManager.service.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentTaskView extends BaseView {

	@JsonProperty("Parent_ID")
	private Integer parentId;

	@JsonProperty("Parent_Task")
	private String parentTask = null;

	@JsonProperty("projectId")
	private Integer projectId = 0;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

}
