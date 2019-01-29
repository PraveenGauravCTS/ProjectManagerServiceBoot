package com.projectManager.service.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "PROJECT")
@Table(name = "PROJECT")
@NamedQueries({
@NamedQuery(name = "Project.getProjectDetailsOrderByStatus", query = "SELECT P FROM PROJECT P , TASK T where P.projectId=T.project.projectId and P.project=(:prjName) order by T.status")
})
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "PROJECT_ID") 
	private Integer projectId;

	@Column(name = "PROJECT", length = 25)
	private String project;

	@Column(name = "PRIORITY", length = 25)
	private String priority;

	@Column(name = "START_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@Column(name = "END_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@Column(name = "MANAGER_ID")
	private Integer managerId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "project", orphanRemoval = true, targetEntity = Task.class)
	@JsonManagedReference
	private List<Task> tasks;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
