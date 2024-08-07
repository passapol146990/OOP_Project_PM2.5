CREATE TABLE DEPARTMENT(
	did		char(5),
	name	varchar(50),
	room	varchar(10),
CONSTRAINT dept_pk PRIMARY KEY (did))

CREATE TABLE EMPLOYEE(
	eid		char(5),
	name	varchar(50),
	idcard	varchar(13),
	gender	char,
	salary	float,
	birthday date,
	dept	 char(5),
CONSTRAINT emp_pk			 PRIMARY KEY(eid),
CONSTRAINT emp_uk_idcard	 UNIQUE(idcard),
CONSTRAINT emp_fk_dept		 FOREIGN KEY (dept) REFERENCES department(did) ON DELETE CASCADE,
CONSTRAINT emp_check_name	 CHECK(name IS NOT NULL),
CONSTRAINT emp_check_salary  CHECK(salary BETWEEN 10000 AND 200000),
CONSTRAINT emp_check_gender  CHECK(gender IN('M','F','N')))

CREATE TABLE PROJECT(
	pid			int identity(1,1),
	name		varchar(30),
	budget		float,
	start_date	date,
	end_date	date,
CONSTRAINT prj_pk				PRIMARY KEY (pid),
CONSTRAINT prj_check_enddate	CHECK(end_date > start_date))

CREATE TABLE WORKS_ON(
	workid		int identity(1,1),
	eid			char(5),
	pid			int,
	position	varchar(30),
CONSTRAINT workon_pk		PRIMARY KEY(workid),
CONSTRAINT workon_uk		UNIQUE (eid,pid),
CONSTRAINT workon_fk1_eid	FOREIGN KEY(eid) REFERENCES employee(eid) ON DELETE CASCADE,
CONSTRAINT workon_fk_pid	FOREIGN KEY(pid) REFERENCES project(pid) ON DELETE CASCADE)

select * from INFORMATION_SCHEMA.TABLES
where TABLE_SCHEMA like 'DB_66011212245%'

drop table EMPLOYEE
drop table DEPARTMENT
drop table WORKS_ON
drop table PROJECT

