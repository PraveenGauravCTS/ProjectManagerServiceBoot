package com.cognizant.internal.prjmgmt.service.test.exception;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import com.projectManager.service.constant.ServiceConstant;
import com.projectManager.service.exception.ServiceApplicationException;
import com.projectManager.service.exception.ServiceGlobalExceptionHandler;
import com.projectManager.service.view.BaseView;
import com.projectManager.service.view.MessageView;
import com.projectManager.service.view.ResponseWrapperView;

@RunWith(MockitoJUnitRunner.class)
public class ServiceGlobalExceptionHandlerTest {

	@Mock
	private Environment itsProperties;

	@InjectMocks
	ServiceGlobalExceptionHandler itsServiceGlobalExceptionHandler;

	/**
	 * Test for Business Exception
	 */
	@Test
	public void testHandleBusinessException() {
		// Initialization Block
		final HttpServletRequest theHttpServletRequest = Mockito.mock(HttpServletRequest.class);
		final ServiceApplicationException theBusinessException = Mockito.mock(ServiceApplicationException.class);
		final ResponseWrapperView<BaseView> theResponse = new ResponseWrapperView<>();
		theResponse.setStatus(ServiceConstant.STATUS_FAILURE);
		final MessageView theMessageView = new MessageView();
		theMessageView.setMessageID("");
		theMessageView.setMessageType("INFO");

		// Mocking Block
		Mockito.when(theBusinessException.getMessage()).thenReturn("Business Exception");

		// Execution Block
		itsServiceGlobalExceptionHandler.handleBusinessException(theHttpServletRequest, theBusinessException);
	}

	/**
	 * Test for Business Exception
	 */
	@Test
	public void testHandleBusinessExceptionWithoutMsg() {
		// Initialization Block
		final HttpServletRequest theHttpServletRequest = Mockito.mock(HttpServletRequest.class);
		final ServiceApplicationException theBusinessException = Mockito.mock(ServiceApplicationException.class);
		final ResponseWrapperView<BaseView> theResponse = new ResponseWrapperView<>();
		theResponse.setStatus(ServiceConstant.STATUS_FAILURE);
		final MessageView theMessageView = new MessageView();
		theMessageView.setMessageID("");
		theMessageView.setMessageType("INFO");
		// Mocking Block
		Mockito.when(theBusinessException.getMessage()).thenReturn("");

		// Execution Block
		itsServiceGlobalExceptionHandler.handleBusinessException(theHttpServletRequest, theBusinessException);
	}

	/**
	 * Test For Handle Exception
	 */
	@Test
	public void testhandleException() {
		// Initialization Block
		final HttpServletRequest theHttpServletRequest = Mockito.mock(HttpServletRequest.class);
		final ServiceApplicationException theBusinessException = Mockito.mock(ServiceApplicationException.class);
		final ResponseWrapperView<BaseView> theResponse = new ResponseWrapperView<>();
		theResponse.setStatus(ServiceConstant.STATUS_FAILURE);
		final MessageView theMessageView = new MessageView();
		theMessageView.setMessageID("MsgId");
		theMessageView.setMessageType("INFO");
		theMessageView.setMessageDetail("MsgDetails");
		theResponse.setMessages(Arrays.asList(theMessageView));

		// Execution Block
		itsServiceGlobalExceptionHandler.handleException(theHttpServletRequest, theBusinessException);
	}
}
