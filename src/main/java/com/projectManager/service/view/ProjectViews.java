package com.projectManager.service.view;

import java.util.List;

public class ProjectViews extends BaseView {

	List<ProjectView> projectViews = null;

	public List<ProjectView> getProjectViews() {
		return projectViews;
	}

	public void setProjectViews(List<ProjectView> inProjectViews) {
		projectViews = inProjectViews;
	}
}
