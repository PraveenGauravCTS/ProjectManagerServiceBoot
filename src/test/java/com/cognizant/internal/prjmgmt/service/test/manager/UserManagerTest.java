package com.cognizant.internal.prjmgmt.service.test.manager;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

import com.projectManager.service.constant.ServiceConstant;
import com.projectManager.service.entity.Task;
import com.projectManager.service.entity.User;
import com.projectManager.service.manager.UserManager;
import com.projectManager.service.repository.UserRepository;
import com.projectManager.service.view.TaskView;
import com.projectManager.service.view.UserView;

@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {

	@InjectMocks
	private UserManager userManager;

	@Mock
	private UserRepository userRepository;

	@Test
	public final void testgetUserById() throws Exception {
		User user = new User();
		Mockito.when(userRepository.findOne(3)).thenReturn(user);
		assertNotNull(userManager.getUserById(3));
	}

	@Test
	public final void testgetUsersForNullSearch() throws Exception {
		userManager.getUsers(null);
	}
	
	@Test
	public final void testgetUsersForSearch() throws Exception {
		userManager.getUsers("search");
	}
	
	@Test
	public final void testgetUsers() throws Exception {
		User user = new User();
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
		Mockito.when(userRepository.findAll()).thenReturn(users);
		assertNotNull(userManager.getUsers(null));
	}

	@Test
	public final void testaddUser() throws Exception {
		UserView userView = new UserView();
		userManager.addUser(userView);
	}

	@Test
	public final void testeditUser() throws Exception {
		UserView userView = new UserView();
		User user = new User();
		Mockito.when(userRepository.findOne(userView.getEmployeeId())).thenReturn(user);
		userManager.editUser(userView);
	}

	@Test
	public final void testdeleteUser() throws Exception {
		userManager.deleteUser(3);
	}

}
