package com.projectManager.service.exception;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.projectManager.service.constant.ServiceConstant;
import com.projectManager.service.util.ServiceResponseUtility;
import com.projectManager.service.view.BaseView;
import com.projectManager.service.view.MessageView;
import com.projectManager.service.view.ResponseWrapperView;

/**
 * Global Exception Handler It takes care of all exceptions of the applications.
 */
@ControllerAdvice
public class ServiceGlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceGlobalExceptionHandler.class);

	@Autowired
	private Environment itsProperties;

	/**
	 * It does BusinessException exception handling
	 *
	 * @param inRequest   the http servlet request
	 * @param inException the actual exception occurred
	 * @return ResponseWrapperBO the error message build based on exception
	 */
	@ExceptionHandler(ServiceApplicationException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseWrapperView<BaseView> handleBusinessException(final HttpServletRequest inRequest,
			final ServiceApplicationException inException) {
		LOGGER.error("Below business exception occured while processing request: " + inRequest.getRequestURL());
		LOGGER.error("Business Exception : ", inException);
		if (StringUtils.isNotEmpty(inException.getMessage())) {
			return getErrorResponse(inException.getMessage());
		}
		return getErrorResponse(ServiceConstant.PROP_ERROR_GLOBAL_EXCEPTION);
	}

	/**
	 * It does common exception handling
	 *
	 * @param inRequest   the http servlet request
	 * @param inException the actual exception occurred
	 * @return ResponseWrapperBO the error message build based on exception
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseWrapperView<BaseView> handleException(final HttpServletRequest inRequest,
			final Exception inException) {
		LOGGER.error("Below exception occured while processing request: " + inRequest.getRequestURL());
		LOGGER.error("Exception : ", inException);
		return getErrorResponse(ServiceConstant.PROP_ERROR_GLOBAL_EXCEPTION);
	}

	/**
	 * Prepare Error Response
	 *
	 * @param inMessageKeys the keys of the message property
	 * @return ResponseWrapperBO the error message build based on exception
	 */
	private ResponseWrapperView<BaseView> getErrorResponse(final String inMessageKey) {
		final ResponseWrapperView<BaseView> theResponse = new ResponseWrapperView<>();
		theResponse.setStatus(ServiceConstant.STATUS_FAILURE);
		final MessageView theMessageBO = new MessageView();
		final String theMessageId = itsProperties.getProperty(inMessageKey);
		theMessageBO.setMessageID(theMessageId);
		theMessageBO.setMessageType(ServiceResponseUtility.getMessageType(theMessageId));
		theMessageBO.setMessageDetail(itsProperties.getProperty(inMessageKey + ServiceConstant.PROP_DETAILS_SUFFIX));
		theResponse.setMessages(Arrays.asList(theMessageBO));
		return theResponse;
	}

}
