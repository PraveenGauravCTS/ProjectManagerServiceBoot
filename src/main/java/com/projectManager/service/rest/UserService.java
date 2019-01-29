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

import com.projectManager.service.manager.UserManager;
import com.projectManager.service.view.MessageView;
import com.projectManager.service.view.ResponseWrapperView;
import com.projectManager.service.view.UserView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserService extends BaseService {

	private UserManager userManager;

	@Autowired
	public UserService(UserManager userManager) {
		this.userManager = userManager;
	}

	@ApiOperation(nickname = "usersFetchById", value = "This API is used to do fetch user operations by Id", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@GetMapping(value = "/id/{id}", produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> getUserById(@PathVariable("id") final int inUserId) {
		ResponseWrapperView ResponseWrapperView = new ResponseWrapperView();
		try {
			ResponseWrapperView.setResponse(userManager.getUserById(inUserId));
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_getUserById"));
		}
		return ResponseEntity.ok().body(ResponseWrapperView);
	}

	@ApiOperation(nickname = "usersFetch", value = "This API is used to do fetch user operations ", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@GetMapping(produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> getUsers(
			@RequestParam(value = "searchkey", required = false) final String inSearchKey) {
		ResponseWrapperView ResponseWrapperView = new ResponseWrapperView();
		try {
			ResponseWrapperView.setResponse(userManager.getUsers(inSearchKey));
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_getUsers"));
		}
		return ResponseEntity.ok().body(ResponseWrapperView);
	}

	@ApiOperation(nickname = "usersAdd", value = "This API is used to do add user operations ", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@PostMapping(produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> addUser(@RequestBody final UserView inUserView) {
		try {
			userManager.addUser(inUserView);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_addUser"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("User added successfully"));
	}

	@ApiOperation(nickname = "usersUpdate", value = "This API is used to do update user operations ", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@PostMapping(value = "/edit", produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> editUser(@RequestBody final UserView inUserView) {
		try {
			userManager.editUser(inUserView);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_editUser"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("User updated successfully"));
	}

	@ApiOperation(nickname = "usersDelete", value = "This API is used to do delete user operations ", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@DeleteMapping(value = "/delete/id/{id}", produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> deleteUser(@PathVariable("id") final int inUserId) {
		try {
			userManager.deleteUser(inUserId);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_deleteUser"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("User deleted successfully"));
	}

}
