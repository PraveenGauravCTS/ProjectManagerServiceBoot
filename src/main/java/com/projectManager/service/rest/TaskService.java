package com.projectManager.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectManager.service.manager.TaskManager;
import com.projectManager.service.view.BaseView;
import com.projectManager.service.view.MessageView;
import com.projectManager.service.view.ResponseWrapperView;
import com.projectManager.service.view.TaskView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tasks")
public class TaskService extends BaseService {

	private TaskManager taskManager;

	@Autowired
	public TaskService(TaskManager taskManager) {
		this.taskManager = taskManager;
	}

	@ApiOperation(nickname = "tasksFetchById", value = "This API is used to do fetch task related operations by Id", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@GetMapping(value = "/id/{id}", produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> getTaskById(@PathVariable("id") final int inProjectId) {
		ResponseWrapperView ResponseWrapperView = new ResponseWrapperView();
		try {
			ResponseWrapperView.setResponse(taskManager.getTaskById(inProjectId));
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_getTaskById"));
		}
		return ResponseEntity.ok().body(ResponseWrapperView);
	}

	@ApiOperation(nickname = "tasksFetch", value = "This API is used to do fetch task related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@GetMapping(produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> getTasks(
			@RequestParam(value = "searchkey", required = false) final String inSearchKey,
			@RequestParam(value = "sortkey", required = false) final String inSortKey) {
		ResponseWrapperView ResponseWrapperView = new ResponseWrapperView();
		try {
			if (inSearchKey == null || inSortKey == null) {
				ResponseWrapperView.setResponse(taskManager.getTasks("", ""));
			} else {
				ResponseWrapperView.setResponse(taskManager.getTasks(inSearchKey, inSortKey));
			}
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_getTasks"));
		}
		return ResponseEntity.ok().body(ResponseWrapperView);
	}

	@ApiOperation(nickname = "tasksAdd", value = "This API is used to do add task related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@PostMapping(produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<ResponseWrapperView<BaseView>> addTask(@RequestBody final TaskView inTaskView) {
		try {
			taskManager.addTask(inTaskView);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_addTask"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("Task added successfully"));
	}

	@ApiOperation(nickname = "tasksUpdate", value = "This API is used to do update task related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@PostMapping(value = "/edit", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<ResponseWrapperView<BaseView>> editTask(@RequestBody final TaskView inTaskView) {
		try {
			taskManager.editTask(inTaskView);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_editTask"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("Task updated successfully"));
	}

	@ApiOperation(nickname = "tasksDelete", value = "This API is used to do delete task related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@DeleteMapping(value = "/delete/id/{id}", produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> deleteTask(@PathVariable("id") final int inTaskId) {
		try {
			taskManager.deleteTask(inTaskId);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_deleteTask"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("Task deleted successfully"));
	}

}
