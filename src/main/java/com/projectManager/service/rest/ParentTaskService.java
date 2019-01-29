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

import com.projectManager.service.manager.ParentTaskManager;
import com.projectManager.service.view.BaseView;
import com.projectManager.service.view.MessageView;
import com.projectManager.service.view.ParentTaskView;
import com.projectManager.service.view.ResponseWrapperView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/parenttasks")
public class ParentTaskService extends BaseService {

	private ParentTaskManager parentTaskManager;

	@Autowired
	public ParentTaskService(ParentTaskManager parentTaskManager) {
		this.parentTaskManager = parentTaskManager;
	}

	@ApiOperation(nickname = "parentTasksFetchById", value = "This API is used to fetch parent task related operations by Id", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@GetMapping(value = "/id/{id}", produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> getParentTaskById(@PathVariable("id") final int inParentId) {
		ResponseWrapperView ResponseWrapperView = new ResponseWrapperView();
		try {
			ResponseWrapperView.setResponse(parentTaskManager.getParentTaskById(inParentId));
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_parentTasksFetchById"));
		}
		return ResponseEntity.ok().body(ResponseWrapperView);
	}

	@ApiOperation(nickname = "parentTasksFetch", value = "This API is used to fetch parent task related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@GetMapping(produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> getParentTasks(
			@RequestParam(value = "searchkey", required = false) final String inSearchKey) {
		ResponseWrapperView ResponseWrapperView = new ResponseWrapperView();
		try {
			if (inSearchKey == null || inSearchKey == "") {
				ResponseWrapperView.setResponse(parentTaskManager.getParentTasks(null));
			} else {
				ResponseWrapperView.setResponse(parentTaskManager.getParentTasks(inSearchKey));
			}
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_getParentTasks"));
		}
		return ResponseEntity.ok().body(ResponseWrapperView);
	}

	@ApiOperation(nickname = "parentTasksAdd", value = "This API is used to add parent task related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@PostMapping(produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<ResponseWrapperView<BaseView>> addParentTask(@RequestBody final ParentTaskView inParentTask) {
		try {
			parentTaskManager.addParentTask(inParentTask);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_addParentTask"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("Task added successfully"));
	}

	@ApiOperation(nickname = "parentTasksDelete", value = "This API is used to delete parent task related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@DeleteMapping(value = "/delete/id/{id}", produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> deleteParentTask(@PathVariable("id") final int inParentId) {
		try {
			parentTaskManager.deleteParentTask(inParentId);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_deleteParentTask"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("Task deleted successfully"));
	}

}
