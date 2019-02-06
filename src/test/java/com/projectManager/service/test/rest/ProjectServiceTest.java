package com.projectManager.service.test.rest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import com.projectManager.service.manager.PrjManager;
import com.projectManager.service.rest.PrjService;
import com.projectManager.service.view.ProjectView;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTest {

	@InjectMocks
	private PrjService projectService;

	@Mock
	private PrjManager projectManager;
	
	@Mock
	protected Environment itsProperties;
	
	@Test
	public final void testgetProjectById() throws Exception {
		assertNotNull(projectService.getProjectById(3));
	}

	@Test
	public final void testgetProjects() throws Exception {
		assertNotNull(projectService.getProjects("search", "priority"));
	}

	@Test
	public final void testgetProjectsForNullSearch() throws Exception {
		assertNotNull(projectService.getProjects(null, "priority"));
	}

	@Test
	public final void testeditProject() throws Exception {
		ProjectView task = new ProjectView();
		assertNotNull(projectService.editProject(task));
	}

	@Test
	public final void testaddProject() throws Exception {
		ProjectView task = new ProjectView();
		assertNotNull(projectService.addProject(task));
	}

	@Test
	public final void testdeleteProject() throws Exception {
		assertNotNull(projectService.deleteProject(3));
	}

}
