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
import com.projectManager.service.manager.TaskManager;
import com.projectManager.service.repository.TaskRepository;
import com.projectManager.service.view.TaskView;

@RunWith(MockitoJUnitRunner.class)
public class TaskManagerTest {

	@InjectMocks
	private TaskManager taskManager;

	@Mock
	private TaskRepository taskRepository;

	@Test
	public final void testgetTaskById() throws Exception {
		Task task = new Task();
		task.setEndDate(new Date());
		task.setStartDate(new Date());
		task.setStatus(ServiceConstant.STATUS_COMPLETED);
		Mockito.when(taskRepository.findOne(3)).thenReturn(task);
		assertNotNull(taskManager.getTaskById(3));
	}

	@Test
	public final void testgetTasksForPrioritySort() throws Exception {
		assertNotNull(taskManager.getTasks("search", "priority"));
	}

	@Test
	public final void testgetTasksForStartdateSort() throws Exception {
		assertNotNull(taskManager.getTasks("search", "startdate"));
	}

	@Test
	public final void testgetTasksForEnddateSort() throws Exception {
		assertNotNull(taskManager.getTasks("search", "enddate"));
	}

	@Test
	public final void testgetTasksForDefaultSort() throws Exception {
		assertNotNull(taskManager.getTasks("search", "default"));
	}

	@Test
	public final void testgetTasks() throws Exception {
		Task task = new Task();
		task.setEndDate(new Date());
		task.setStartDate(new Date());
		task.setStatus(ServiceConstant.STATUS_COMPLETED);
		ArrayList<Task> tasks = new ArrayList<>();
		tasks.add(task);
		Mockito.when(taskRepository.getTaskDetails("search", new Sort("priority"))).thenReturn(tasks);
		assertNotNull(taskManager.getTasks("search", "priority"));
	}

	@Test
	public final void testaddTask() throws Exception {
		TaskView task = new TaskView();
		task.setStartDateDisplay("26Dec18");
		task.setEndDateDisplay("26Dec18");
		taskManager.addTask(task);
	}

	@Test
	public final void testeditTask() throws Exception {
		TaskView taskView = new TaskView();
		taskView.setEndDateDisplay("26Dec18");
		taskView.setStartDateDisplay("26Dec18");
		Task task = new Task();
		Mockito.when(taskRepository.findOne(taskView.getTaskId())).thenReturn(task);
		taskManager.editTask(taskView);
	}

	@Test
	public final void testdeleteTask() throws Exception {
		taskManager.deleteTask(3);
	}

}
