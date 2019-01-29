package com.projectManager.service.view;

import java.util.List;

public class UserViews extends BaseView {
	List<UserView> userViews = null;

	public List<UserView> getUserViews() {
		return userViews;
	}

	public void setUserViews(List<UserView> inUserViews) {
		userViews = inUserViews;
	}

}
