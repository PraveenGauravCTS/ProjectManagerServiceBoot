package com.projectManager.service.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projectManager.service.constant.ServiceConstant;
import com.projectManager.service.entity.ParentTask;
import com.projectManager.service.entity.Project;
import com.projectManager.service.entity.Task;
import com.projectManager.service.repository.TaskRepository;
import com.projectManager.service.view.BaseView;
import com.projectManager.service.view.TaskView;
import com.projectManager.service.view.TaskViews;

@Service
public class TaskManager {
	@Autowired
	private TaskRepository taskRepository;

	public BaseView getTaskById(int inTaskId) throws Exception {
		Task taskModel = taskRepository.findOne(inTaskId);
		TaskView taskView = new TaskView();
		if (null != taskModel) {
			BeanUtils.copyProperties(taskModel, taskView);
			taskView.setStartDateDisplay(
					new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).format(taskModel.getStartDate()));
			taskView.setEndDateDisplay(
					new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).format(taskModel.getEndDate()));
		}
		if(taskModel.getParentTask()!=null) {
			taskView.setParentId(taskModel.getParentTask().getParentId());
			taskView.setParentTask(taskModel.getParentTask().getParentTask());
		}else {
			taskView.setParentId(0);
			taskView.setParentTask("N/A");
		}
		if(taskModel.getProject()!=null) {
			taskView.setProjectId(taskModel.getProject().getProjectId());
			taskView.setProject(taskModel.getProject().getProject());
		}else {
			taskView.setProjectId(0);
			taskView.setProject("N/A");
		}
		return taskView;
	}

	public BaseView getTasks(String inProjectName, String inSortKey) throws Exception {
		Iterable<Task> tasksModel = null;
		switch (inSortKey) {
		case "startdate":
			tasksModel = taskRepository.getTaskDetails(inProjectName, new Sort("startDate"));
			break;
		case "enddate":
			tasksModel = taskRepository.getTaskDetails(inProjectName, new Sort("endDate"));
			break;
		case "priority":
			tasksModel = taskRepository.getTaskDetails(inProjectName, new Sort("priority"));
			break;
		default:
			tasksModel = taskRepository.getTaskDetails(inProjectName, new Sort("priority"));
			break;
		}
		List<TaskView> taskViews = new ArrayList<>();
		if (tasksModel != null) {
			for (Task taskModel : tasksModel) {
				TaskView taskView = new TaskView();
				BeanUtils.copyProperties(taskModel, taskView);
				if (taskModel.getStartDate() != null) {
					taskView.setStartDateDisplay(
							new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).format(taskModel.getStartDate()));
				}
				if (taskModel.getEndDate() != null) {
					taskView.setEndDateDisplay(
							new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).format(taskModel.getEndDate()));
				}
				if(taskModel.getParentTask()!=null) {
					taskView.setParentId(taskModel.getParentTask().getParentId());
					taskView.setParentTask(taskModel.getParentTask().getParentTask());
				}else {
					taskView.setParentId(0);
					taskView.setParentTask("N/A");
				}
				taskViews.add(taskView);
			}
		}
		TaskViews taskView = new TaskViews();
		taskView.setTaskViews(taskViews);
		return taskView;
	}

	public void addTask(TaskView inTaskView) throws Exception {
		Task task = new Task();
		BeanUtils.copyProperties(inTaskView, task);
		//setting parent task
		ParentTask parentTask=new ParentTask();
		parentTask.setParentId(inTaskView.getParentId());
		task.setParentTask(parentTask);
		//setting project
		Project project=new Project();
		project.setProjectId(inTaskView.getProjectId());
		task.setProject(project);
		try {
			task.setStartDate(
					new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).parse(inTaskView.getStartDateDisplay()));
			task.setEndDate(
					new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT).parse(inTaskView.getEndDateDisplay()));
		} catch (ParseException e) {
			// Consume exception
		}
		taskRepository.save(task); 
	}

	public void editTask(TaskView inTaskView) throws Exception {
		Task task = taskRepository.findOne(inTaskView.getTaskId());
		if (null != task) {
			BeanUtils.copyProperties(inTaskView, task);
			//setting parent task
			ParentTask parentTask=new ParentTask();
			parentTask.setParentId(inTaskView.getParentId());
			task.setParentTask(parentTask);
			//setting project
			Project project=new Project();
			project.setProjectId(inTaskView.getProjectId());
			task.setProject(project);
			try {
				task.setStartDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT)
						.parse(inTaskView.getStartDateDisplay()));
				task.setEndDate(new SimpleDateFormat(ServiceConstant.DISPLAY_DATE_FORMAT)
						.parse(inTaskView.getEndDateDisplay()));
			} catch (ParseException e) {
				// Consume exception
			}
			taskRepository.save(task);
		}
	}

	public void deleteTask(int inTaskId) throws Exception {
		taskRepository.delete(inTaskId);
	}

}
