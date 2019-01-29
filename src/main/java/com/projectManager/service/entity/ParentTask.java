package com.projectManager.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PARENTTASK")
@Table(name = "PARENT_TASK")
public class ParentTask {

	@Id
	@GeneratedValue
	@Column(name = "PARENT_ID")
	private Integer parentId;

	@Column(name = "PARENT_TASK", length = 25)
	private String parentTask;
	
	@Column(name = "Project_ID")
	private Integer projectId;


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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer inProjectId) {
		projectId = inProjectId;
	}

}
