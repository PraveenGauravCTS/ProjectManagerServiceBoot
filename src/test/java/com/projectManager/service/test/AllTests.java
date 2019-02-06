package com.projectManager.service.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.projectManager.service.test.exception.ServiceApplicationExceptionTest;
import com.projectManager.service.test.exception.ServiceGlobalExceptionHandlerTest;
import com.projectManager.service.test.manager.ParentTaskManagerTest;
import com.projectManager.service.test.manager.ProjectManagerTest;
import com.projectManager.service.test.manager.TaskManagerTest;
import com.projectManager.service.test.manager.UserManagerTest;
import com.projectManager.service.test.rest.ParentTaskServiceTest;
import com.projectManager.service.test.rest.ProjectServiceTest;
import com.projectManager.service.test.rest.TaskServiceTest;
import com.projectManager.service.test.rest.UserServiceTest;
import com.projectManager.service.test.util.ServiceResponseUtilityTest;

@SuiteClasses({ ParentTaskServiceTest.class, TaskServiceTest.class, ProjectServiceTest.class, UserServiceTest.class,
		ParentTaskManagerTest.class, ProjectManagerTest.class, TaskManagerTest.class, UserManagerTest.class,
		ServiceResponseUtilityTest.class, ServiceGlobalExceptionHandlerTest.class,
		ServiceApplicationExceptionTest.class })
@RunWith(Suite.class)
public class AllTests {
}
