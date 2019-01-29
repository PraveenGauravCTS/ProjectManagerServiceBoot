package com.cognizant.internal.prjmgmt.service.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cognizant.internal.prjmgmt.service.test.exception.ServiceApplicationExceptionTest;
import com.cognizant.internal.prjmgmt.service.test.exception.ServiceGlobalExceptionHandlerTest;
import com.cognizant.internal.prjmgmt.service.test.manager.ParentTaskManagerTest;
import com.cognizant.internal.prjmgmt.service.test.manager.ProjectManagerTest;
import com.cognizant.internal.prjmgmt.service.test.manager.TaskManagerTest;
import com.cognizant.internal.prjmgmt.service.test.manager.UserManagerTest;
import com.cognizant.internal.prjmgmt.service.test.rest.ParentTaskServiceTest;
import com.cognizant.internal.prjmgmt.service.test.rest.ProjectServiceTest;
import com.cognizant.internal.prjmgmt.service.test.rest.TaskServiceTest;
import com.cognizant.internal.prjmgmt.service.test.rest.UserServiceTest;
import com.cognizant.internal.prjmgmt.service.test.util.ServiceResponseUtilityTest;

@SuiteClasses({ ParentTaskServiceTest.class, TaskServiceTest.class, ProjectServiceTest.class, UserServiceTest.class,
		ParentTaskManagerTest.class, ProjectManagerTest.class, TaskManagerTest.class, UserManagerTest.class,
		ServiceResponseUtilityTest.class, ServiceGlobalExceptionHandlerTest.class,
		ServiceApplicationExceptionTest.class })
@RunWith(Suite.class)
public class AllTests {
}
