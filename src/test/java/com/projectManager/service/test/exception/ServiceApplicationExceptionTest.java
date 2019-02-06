package com.projectManager.service.test.exception;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.projectManager.service.exception.ServiceApplicationException;

@RunWith(MockitoJUnitRunner.class)
public class ServiceApplicationExceptionTest {

	@InjectMocks
	ServiceApplicationException serviceApplicationException;

	/**
	 * Test for Business Exception
	 */
	@Test
	public void testserviceApplicationExceptionWithMessage() {
		assertThat(new ServiceApplicationException("123").getMessageKey(), equalTo("123"));
	}

	/**
	 * Test for Business Exception
	 */
	@Test
	public void testserviceApplicationExceptionWithErrors() {
		List<String> errors = new ArrayList<>();
		errors.add("SEARCH");
		assertThat(new ServiceApplicationException("123", errors).getMessageKey(), equalTo("123"));

	}
	
	/**
	 * Test for Business Exception
	 */
	@Test
	public void testserviceApplicationExceptionWithException() {
		List<String> errors = new ArrayList<>();
		errors.add("SEARCH");
		assertThat(new ServiceApplicationException("123", errors).getMessageKey(), equalTo("123"));

	}

	/**
	 * Test for Business Exception
	 */
	@Test
	public void testserviceApplicationExceptionWithThrowable() {
		assertNotNull(new ServiceApplicationException(new Throwable()));
	}

}
