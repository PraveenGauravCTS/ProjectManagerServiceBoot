
CREATE DATABASE ProjectManagerDB
GO

CREATE TABLE parent_task ( 
    PARENT_ID  	int(11) AUTO_INCREMENT NOT NULL,
    PARENT_TASK	varchar(25) NULL,
    PROJECT_ID 	int(11) NULL,
    PRIMARY KEY(PARENT_ID)
)
GO

CREATE TABLE project ( 
    PROJECT_ID  	int(11) AUTO_INCREMENT NOT NULL,
    PROJECT			varchar(25) NULL,
    START_DATE  	date NULL,
    END_DATE    	date NULL,
    PRIORITY    	varchar(25) NULL,
    MANAGER_ID  	int(11) NULL,
    PRIMARY KEY(PROJECT_ID)
)
GO


CREATE TABLE task ( 
    TASK_ID   	int(11) AUTO_INCREMENT NOT NULL,
    PARENT_ID 	int(11) NULL,
    PROJECT_ID	int(11) NULL,
    TASK 	varchar(25) NULL,
    START_DATE	date NULL,
    END_DATE  	date NULL,
    PRIORITY  	varchar(25) NULL,
    STATUS    	varchar(25) NULL,
    PRIMARY KEY(TASK_ID)
)
GO

CREATE TABLE users ( 
	USER_ID int(11) AUTO_INCREMENT NOT NULL,
    FIRST_NAME 	varchar(25) NULL,
    LAST_NAME  	varchar(25) NULL,
    EMPLOYEE_ID	int(11) NOT NULL,
    PROJECT_ID 	int(11) NULL,
    TASK_ID    	int(11) NULL,
    PRIMARY KEY(USER_ID)
)
GO


INSERT INTO parent_task(PARENT_ID, PARENT_TASK, Project_ID) 
    VALUES(1, 'Parent 1', 1)
GO

INSERT INTO project(PROJECT_ID, PROJECT, START_DATE, END_DATE, PRIORITY, MANAGER_ID) 
    VALUES(1, 'Project 1', '2019-02-08', '2019-02-08', '1', 1)
GO

INSERT INTO task(TASK_ID, PARENT_ID, PROJECT_ID, TASK, START_DATE, END_DATE, PRIORITY, STATUS) 
    VALUES(1, 1, 1, '', '2019-02-08', '2019-02-08', '2', '0')
GO

INSERT INTO users(FIRST_NAME, LAST_NAME, EMPLOYEE_ID, PROJECT_ID, TASK_ID) 
    VALUES('Praveen', 'Gaurav', 253226, 1, 1)
GO

