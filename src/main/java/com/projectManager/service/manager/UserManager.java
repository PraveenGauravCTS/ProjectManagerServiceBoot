package com.projectManager.service.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projectManager.service.entity.User;
import com.projectManager.service.repository.UserRepository;
import com.projectManager.service.view.BaseView;
import com.projectManager.service.view.UserView;
import com.projectManager.service.view.UserViews;

@Service
public class UserManager {

	@Autowired
	private UserRepository userRepository;

	public BaseView getUserById(int inUserId) throws Exception{
		User user = userRepository.findOne(inUserId);
		UserView userView = new UserView();
		if (null != user) {
			BeanUtils.copyProperties(user, userView);
		}
		return userView;
	}

	public BaseView getUsers(String inSearchKey) throws Exception{
		Iterable<User> userModels = null;
		if (inSearchKey == null) {
			userModels = userRepository.findAll();
		} else {
			userModels = userRepository.getUserDetails(inSearchKey, new Sort("firstName"));
		}
		List<UserView> userViews = new ArrayList<>();
		if (userModels != null) {
			for (User userModel : userModels) {
				UserView userView = new UserView();
				BeanUtils.copyProperties(userModel, userView);
				userViews.add(userView);
			}
		}
		UserViews userView = new UserViews();
		userView.setUserViews(userViews);
		return userView;
	}

	public void addUser(UserView inUserView) throws Exception{
		User user = new User();
		BeanUtils.copyProperties(inUserView, user);
		userRepository.save(user);
	}

	public void editUser(UserView inUserView) throws Exception{
		User user = userRepository.findOne(inUserView.getEmployeeId());
		if (null != user) {
			BeanUtils.copyProperties(inUserView, user);
			userRepository.save(user);
		}
	}

	public void deleteUser(int inUserId) throws Exception{
		userRepository.delete(inUserId);
	}

}
