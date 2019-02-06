package com.projectManager.service.test.rest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import com.projectManager.service.manager.ParentTaskManager;
import com.projectManager.service.rest.ParentTaskService;
import com.projectManager.service.view.ParentTaskView;

@RunWith(MockitoJUnitRunner.class)
public class ParentTaskServiceTest {

	@InjectMocks
	private ParentTaskService parentTaskService;

	@Mock
	private ParentTaskManager parentTaskManager;
	
	@Mock
	protected Environment itsProperties;

	@Test
	public final void testgetParentTaskById() throws Exception {
		assertNotNull(parentTaskService.getParentTaskById(3));
	}

	@Test
	public final void testgetParentTasks() throws Exception {
		assertNotNull(parentTaskService.getParentTasks("search"));
	}

	@Test
	public final void testgetParentTasksNullSearch() throws Exception {
		assertNotNull(parentTaskService.getParentTasks(null));
	}

	@Test
	public final void testaddParentTask() throws Exception {
		ParentTaskView parentTask = new ParentTaskView();
		assertNotNull(parentTaskService.addParentTask(parentTask));
	}

	@Test
	public final void testdeleteParentTask() throws Exception {
		assertNotNull(parentTaskService.deleteParentTask(3));
	}

}
