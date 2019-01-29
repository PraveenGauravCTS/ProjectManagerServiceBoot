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

import com.projectManager.service.manager.PrjManager;
import com.projectManager.service.view.BaseView;
import com.projectManager.service.view.MessageView;
import com.projectManager.service.view.ProjectView;
import com.projectManager.service.view.ResponseWrapperView;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/projects")
public class PrjService extends BaseService {

	private PrjManager prjManager;

	@Autowired
	public PrjService(PrjManager prjManager) {
		this.prjManager = prjManager;
	}

	/**
	 * this method is used to fetch project by Id
	 * 
	 * @param inProjectId the project id
	 * @return
	 */
	@ApiOperation(nickname = "projectsFetchbyId", value = "This API is used to fetch project related operations by Id", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@GetMapping(value = "/id/{id}", produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> getProjectById(@PathVariable("id") final int inProjectId) {
		ResponseWrapperView ResponseWrapperView = new ResponseWrapperView();
		try {
			ResponseWrapperView.setResponse(prjManager.fetchProjectById(inProjectId)); 
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_getProjectById"));
		}
		return ResponseEntity.ok().body(ResponseWrapperView);
	}

	/**
	 * this method is used to fetch projects on searchkey and sortkey
	 * 
	 * @param inSearchKey
	 * @param inSortKey
	 * @return
	 */
	@ApiOperation(nickname = "projectsFetch", value = "This API is used to fetch project related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@GetMapping(produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> getProjects(
			@RequestParam(value = "searchkey", required = false) final String inSearchKey,
			@RequestParam(value = "sortkey", required = false) final String inSortKey) {
		ResponseWrapperView ResponseWrapperView = new ResponseWrapperView();
		try {
			if (inSearchKey == null || inSortKey == null) {
				ResponseWrapperView.setResponse(prjManager.getProjects("", ""));
			} else {
				ResponseWrapperView.setResponse(prjManager.getProjects(inSearchKey, inSortKey));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(getFailureMessage("msg.error_getProjects"));
		}
		return ResponseEntity.ok().body(ResponseWrapperView);
	}

	/**
	 * this method is used to add new project
	 * 
	 * @param inProjectView
	 * @return
	 */
	@ApiOperation(nickname = "projectsAdd", value = "This API is used to add project related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@PostMapping(produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<ResponseWrapperView<BaseView>> addProject(@RequestBody final ProjectView inProjectView) {
		try {
			prjManager.addProject(inProjectView);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_addProject"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("Project added successfully"));
	}

	/**
	 * this method is used to edit existing project
	 * 
	 * @param inProjectinProjectView
	 * @return
	 */
	@ApiOperation(nickname = "projectsUpdate", value = "This API is used to fetch update related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@PostMapping(value = "/edit", produces = { "application/json;charset=UTF-8" })
	public ResponseEntity<ResponseWrapperView<BaseView>> editProject(
			@RequestBody final ProjectView inProjectinProjectView) {
		try {
			prjManager.editProject(inProjectinProjectView);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_editProject"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("Project updated successfully"));
	}

	/**
	 * this method is used to delete an existing project
	 * 
	 * @param inProjectId
	 * @return
	 */
	@ApiOperation(nickname = "projectsDelete", value = "This API is used to delete project related operations", response = ResponseWrapperView.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class),
			@ApiResponse(code = 400, message = "Bad Request", response = MessageView.class),
			@ApiResponse(code = 404, message = "Not Found", response = MessageView.class),
			@ApiResponse(code = 500, message = "Internal Server Error (Server Error)", response = MessageView.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = MessageView.class) })
	@DeleteMapping(value = "/delete/id/{id}", produces = { "application/json;charset=UTF-8" })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<ResponseWrapperView> deleteProject(@PathVariable("id") final int inProjectId) {
		try {
			prjManager.deleteProject(inProjectId);
		} catch (Exception e) {
			return ResponseEntity.ok().body(getFailureMessage("msg.error_deleteProject"));
		}
		return ResponseEntity.ok().body(getSuccessMessage("Project deleted successfully"));
	}

}
