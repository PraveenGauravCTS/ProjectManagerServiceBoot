package com.cognizant.internal.prjmgmt.service.test.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.projectManager.service.util.ServiceResponseUtility;

@RunWith(MockitoJUnitRunner.class)
public class ServiceResponseUtilityTest {

	@InjectMocks
	private ServiceResponseUtility serviceResponseUtility;

	@Test
	public final void testgetMessageTypeBlank() throws Exception {
		serviceResponseUtility.getMessageType("");
	}
	
	@Test
	public final void testgetMessageTypeInfo() throws Exception {
		serviceResponseUtility.getMessageType("PRJI");
	}
	
	@Test
	public final void testgetMessageTypeWarn() throws Exception {
		serviceResponseUtility.getMessageType("PRJW");
	}
	
	@Test
	public final void testgetMessageTypeError() throws Exception {
		serviceResponseUtility.getMessageType("PRJE");
	}
	
	@Test
	public final void testgetMessageTypeDefault() throws Exception {
		serviceResponseUtility.getMessageType("PRJD");
	}

}
