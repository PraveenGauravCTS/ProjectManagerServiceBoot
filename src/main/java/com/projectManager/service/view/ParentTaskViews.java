package com.projectManager.service.view;

import java.util.List;

public class ParentTaskViews extends BaseView {

	private List<ParentTaskView> parentTaskViews = null;

	public List<ParentTaskView> getParentTaskViews() {
		return parentTaskViews;
	}

	public void setParentTaskViews(List<ParentTaskView> inParentTaskViews) {
		parentTaskViews = inParentTaskViews;
	}

}
