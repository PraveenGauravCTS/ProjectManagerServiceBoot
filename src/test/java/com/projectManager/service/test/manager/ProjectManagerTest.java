package com.projectManager.service.test.manager;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

import com.projectManager.service.constant.ServiceConstant;
import com.projectManager.service.entity.Project;
import com.projectManager.service.entity.Task;
import com.projectManager.service.manager.PrjManager;
import com.projectManager.service.repository.ProjectRepository;
import com.projectManager.service.view.ProjectView;

@RunWith(MockitoJUnitRunner.class)
public class ProjectManagerTest {

	@InjectMocks
	private PrjManager projectManager;

	@Mock
	private ProjectRepository projectRepository;

	@Test
	public final void testfetchProjectById() throws Exception {
		Project project = new Project();
		project.setEndDate(new Date());
		project.setStartDate(new Date());
		Task task = new Task();
		task.setStatus(ServiceConstant.STATUS_COMPLETED);
		ArrayList<Task> tasks = new ArrayList<>();
		tasks.add(task);
		project.setTasks(tasks);
		Mockito.when(projectRepository.findOne(3)).thenReturn(project);
		assertNotNull(projectManager.fetchProjectById(3));
	}

	@Test
	public final void testfetchProjectByIdResult() throws Exception {
		Project project = new Project();
		project.setEndDate(new Date());
		project.setStartDate(new Date());
		project.setTasks(new ArrayList<>());
		Mockito.when(projectRepository.findOne(3)).thenReturn(project);
		assertNotNull(projectManager.fetchProjectById(3));
	}

	@Test
	public final void testgetProjectsForPrioritySort() throws Exception {
		assertNotNull(projectManager.getProjects("search", "priority"));
	}

	@Test
	public final void testgetProjectsForStartdateSort() throws Exception {
		assertNotNull(projectManager.getProjects("search", "startdate"));
	}

	@Test
	public final void testgetProjectsForEnddateSort() throws Exception {
		assertNotNull(projectManager.getProjects("search", "enddate"));
	}

	@Test
	public final void testgetProjectsForDefaultSort() throws Exception {
		assertNotNull(projectManager.getProjects("search", "default"));
	}

	@Test
	public final void testgetProjectsForCompletedSort() throws Exception {
		assertNotNull(projectManager.getProjects("search", "completedStatus"));
	}
	
	@Test
	public final void testgetProjects() throws Exception {
		Project project = new Project();
		project.setEndDate(new Date());
		project.setStartDate(new Date());
		project.setTasks(new ArrayList<>());
		List<Project> projectsModels = new ArrayList<>();
		projectsModels.add(project);
		project = new Project();
		project.setEndDate(new Date());
		project.setStartDate(new Date());
		Task task = new Task();
		task.setStatus(ServiceConstant.STATUS_COMPLETED);
		ArrayList<Task> tasks = new ArrayList<>();
		tasks.add(task);
		project.setTasks(tasks);
		projectsModels.add(project);
		Iterable<Project> projectsModel = projectsModels;
		Mockito.when(projectRepository.getProjectDetails("search", new Sort("priority"))).thenReturn(projectsModel);
		assertNotNull(projectManager.getProjects("search", "priority"));
	}

	@Test
	public final void testaddProject() throws Exception {
		ProjectView project = new ProjectView();
		project.setStartDateDisplay("2018-02-02");
		project.setEndDateDisplay("2018-02-02");
		projectManager.addProject(project);
	}

	@Test
	public final void testeditProject() throws Exception {
		ProjectView project = new ProjectView();
		projectManager.editProject(project);
	}
	
	@Test
	public final void testeditProjectNull() throws Exception {
		ProjectView project = new ProjectView();
		Project projectModel = new Project();
		Mockito.when(projectRepository.findOne(project.getProjectId())).thenReturn(projectModel);
		projectManager.editProject(project);
	}

	@Test
	public final void testdeleteProject() throws Exception {
		projectManager.deleteProject(3);
	}

}
