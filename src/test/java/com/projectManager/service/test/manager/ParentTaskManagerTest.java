package com.projectManager.service.test.manager;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.projectManager.service.entity.ParentTask;
import com.projectManager.service.manager.ParentTaskManager;
import com.projectManager.service.repository.ParentTaskRepository;
import com.projectManager.service.view.ParentTaskView;

@RunWith(MockitoJUnitRunner.class)
public class ParentTaskManagerTest {

	@InjectMocks
	private ParentTaskManager parentTaskManager;

	@Mock
	private ParentTaskRepository parentTaskRepository;

	@Test
	public final void testgetParentTaskById() throws Exception {
		ParentTask parentTask = new ParentTask();
		Mockito.when(parentTaskRepository.findOne(3)).thenReturn(parentTask);
		assertNotNull(parentTaskManager.getParentTaskById(3));
	}

	@Test
	public final void testgetParentTasks() throws Exception {
		ParentTask parentTask = new ParentTask();
		ParentTask parentTask1 = new ParentTask();
		Iterable<ParentTask> parentTaskModels = Arrays.asList(parentTask, parentTask1);
		Mockito.when(parentTaskRepository.getParentTaskDetails("search")).thenReturn(parentTaskModels);
		assertNotNull(parentTaskManager.getParentTasks("search"));
	}

	@Test
	public final void testgetParentTasksBlankReturn() throws Exception {
		Mockito.when(parentTaskRepository.getParentTaskDetails("search")).thenReturn(null);
		assertNotNull(parentTaskManager.getParentTasks("search"));
	}

	@Test
	public final void testaddParentTask() throws Exception {
		ParentTaskView parentTask = new ParentTaskView();
		parentTaskManager.addParentTask(parentTask);
	}

	@Test
	public final void testdeleteParentTask() throws Exception {
		parentTaskManager.deleteParentTask(3);
	}

}
