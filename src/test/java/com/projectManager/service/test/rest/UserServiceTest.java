package com.projectManager.service.test.rest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.projectManager.service.manager.UserManager;
import com.projectManager.service.rest.UserService;
import com.projectManager.service.view.ProjectView;
import com.projectManager.service.view.UserView;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserManager userManager;

	@Test
	public final void testgetUserById() throws Exception {
		assertNotNull(userService.getUserById(3));
	}

	@Test
	public final void testgetUsers() throws Exception {
		assertNotNull(userService.getUsers("Sanjoy"));
	}

	@Test
	public final void testeditUser() throws Exception {
		UserView user = new UserView();
		assertNotNull(userService.editUser(user));
	}

	@Test
	public final void testaddUser() throws Exception {
		UserView user = new UserView();
		assertNotNull(userService.addUser(user));
	}

	@Test
	public final void testdeleteUser() throws Exception {
		assertNotNull(userService.deleteUser(3));
	}

}
