package com.projectManager.service.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projectManager.service.constant.ServiceConstant;
import com.projectManager.service.entity.Project;
import com.projectManager.service.entity.Task;
import com.projectManager.service.repository.ProjectRepository;
import com.projectManager.service.view.BaseView;
import com.projectManager.service.view.ProjectView;
import com.projectManager.service.view.ProjectViews;

@Service
public class PrjManager {

	@Autowired
	private ProjectRepository projectRepository;

	public BaseView getProjects(String inSearchKey, String inSortKey) throws Exception {
		Iterable<Project> projectsModel = null;
		switch (inSortKey) {
		case "startdate":
			projectsModel = projectRepository.getProjectDetails(inSearchKey, new Sort("startDate"));
			break;
		case "enddate":
			projectsModel = projectRepository.getProjectDetails(inSearchKey, new Sort("endDate"));
			break;
		case "priority":
			projectsModel = projectRepository.getProjectDetails(inSearchKey, new Sort("priority"));
			break;
		case "completedStatus":
			projectsModel = projectRepository.getProjectDetailsOrderByStatus(inSearchKey);
			break;
		default:
			projectsModel = projectRepository.getProjectDetails(inSearchKey, new Sort("priority"));
			break;
		}
		List<ProjectView> projectViews = new ArrayList<>();
		if (projectsModel != null) {
			for (Project projectModel : projectsModel) {
				ProjectView projectView = new ProjectView();
				BeanUtils.copyProperties(projectModel, projectView);
				if (projectModel.getStartDate() != null) {
					projectView.setStartDateDisplay(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT)
							.format(projectModel.getStartDate()));

				}
				if (projectModel.getEndDate() != null) {
					projectView.setEndDateDisplay(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT)
							.format(projectModel.getEndDate()));
				}
				List<Task> tasks = projectModel.getTasks();
				if (tasks != null) {
					projectView.setTotalTaskNum(tasks.size());
					for (Task task : tasks) {
						if (StringUtils.equals(task.getStatus(), ServiceConstant.STATUS_COMPLETED)) {
							projectView.setCompletedTaskNum(projectView.getCompletedTaskNum() + 1);
						}
					}
				}
				projectViews.add(projectView);
			}
		}
		ProjectViews projectView = new ProjectViews();
		projectView.setProjectViews(projectViews);
		return projectView;
	}

	public ProjectView fetchProjectById(int inProjectId) throws Exception {
		try {
			Project projectModel = projectRepository.findOne(inProjectId);
			ProjectView projectView = new ProjectView();
			if (null != projectModel) {
				BeanUtils.copyProperties(projectModel, projectView);
				if (projectModel.getStartDate() != null) {
					projectView.setStartDateDisplay(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT)
							.format(projectModel.getStartDate()));
				}
				if (projectModel.getEndDate() != null) {
					projectView.setEndDateDisplay(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT)
							.format(projectModel.getEndDate()));
				}
			}
			List<Task> tasks = projectModel.getTasks();
			if (tasks != null) {
				projectView.setTotalTaskNum(tasks.size());
				for (Task task : tasks) {
					if (StringUtils.equals(task.getStatus(), ServiceConstant.STATUS_COMPLETED)) {
						projectView.setCompletedTaskNum(projectView.getCompletedTaskNum() + 1);
					}
				}
			}

			return projectView;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void addProject(ProjectView inProjectView) throws Exception {
		Project project = new Project();
		BeanUtils.copyProperties(inProjectView, project);
		try {
			project.setStartDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT)
					.parse(inProjectView.getStartDateDisplay()));
			project.setEndDate(
					new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).parse(inProjectView.getEndDateDisplay()));
		} catch (ParseException e) {
			// Consume Exception
			e.printStackTrace();
		}
		projectRepository.save(project);
	}

	public void editProject(ProjectView inProjectView) throws Exception {
		Project project = projectRepository.findOne(inProjectView.getProjectId());
		if (null != project) {
			BeanUtils.copyProperties(inProjectView, project);
			try {
				if (inProjectView.getStartDateDisplay() != null) {
					project.setStartDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT)
							.parse(inProjectView.getStartDateDisplay()));
				}
				if (inProjectView.getEndDateDisplay() != null) {
					project.setEndDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT)
							.parse(inProjectView.getEndDateDisplay()));
				}
			} catch (ParseException e) {
				// Consume Exception
				e.printStackTrace();
			}
			projectRepository.save(project);
		}
	}

	public void deleteProject(int inProjectId) throws Exception {
		projectRepository.delete(inProjectId);
	}

}
