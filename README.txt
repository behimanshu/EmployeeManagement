
Pre-requisites:
----------------
-----------------


MYSql installation:

 - Install MYSQL workbench 6.3
 - Run the given query to set up the database
 - Start the MYSQL Server


Installation of Apache Tomcat v7.0:

 - Install Apache Tomcat v7.0, or considering running the web service in Eclipse IDE, on Apache Tomcat server


Installation of Postman:

 - Consider installing Postman from Chrome webstore, to run the API Service calls.
(If any other browser is being used, consider any REST client for that browser)




Running the Deparment API Calls: 
--------------------------------
--------------------------------

This Employee management webservice is a Department wise management system, that keeps a track of employee on the basis of the 
department they belong to.


1) API call to get all the departments in the database:

 - Select GET as the API call from the dropdown in Postman, and run this call
	http://localhost:8080/EmployeeManagement/webapi/departments
-------------------------------------------------------------------------------
2) API call to get a department of a particular dept_id

 - Select GET as the API call from the dropdown in Postman, and run this call
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12
--------------------------------------------------------------------------------------
3) API call to insert a new department into the database

 - Select POST as the API call from the dropdown in Postman
 - Go to Headers section and write
	Key: Content-type
	Value: application/json
- Fill the body with JSON content of a new department
 	Eg: {
    "dept_expertise": "Analytics",
    "dept_id": 7,
    "dept_location": "Salisbury",
    "dept_name": "Social",
    "dept_size": 0
  }

- Run this below mentioned call and hit send
	http://localhost:8080/EmployeeManagement/webapi/departments
-----------------------------------------------------------------------------------------------------------------------------------------------------
4) API call to update any department details

 - Select PUT as the API call from the dropdown in Postman
 - Go to Headers section and write
	Key: Content-type
	Value: application/json
- Fill the body with JSON content of a new department
 	Eg: {
    "dept_expertise": "Analytics",
    "dept_id": 7,
    "dept_location": "Charlotte",
    "dept_name": "Social",
    "dept_size": 0
  }

- Run this below mentioned call and hit send
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12
------------------------------------------------------------------------------------------------------------------------------------------------------	
5) API call to remove a department of a particular dept_id

 - Select DELETE as the API call from the dropdown in Postman, and run this call
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12
--------------------------------------------------------------------------------------------------------------------------------------------------------





Running the Employee API Calls: 
--------------------------------
--------------------------------

1) API call to get all the employees of a particular department from the database:

 - Select GET as the API call from the dropdown in Postman, and run this call
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}/employees
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12/employees
------------------------------------------------------------------------------------------------
2) API call to get an employee of a particular emp_id

 - Select GET as the API call from the dropdown in Postman, and run this call
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}/employees/{emp_id}
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12/employees/5
-------------------------------------------------------------------------------------------------
3) API call to insert a new employee into a particular department

 - Select POST as the API call from the dropdown in Postman
 - Go to Headers section and write
	Key: Content-type
	Value: application/json
- Fill the body with JSON content of a new department
 	Eg: {
    "dept_id": 9,
    "emp_YOJ": 2016,
    "emp_age": 90,
    "emp_email": "h@gmail.com",
    "emp_fname": "Hima",
    "emp_gender": "M",
 
    "emp_lname": "Agarwal",
    "emp_phone": 89890
  }

- Run this below mentioned call and hit send
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}/employees
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12/employees
-----------------------------------------------------------------------------------------------------------------------------------------------------
4) API call to update any employee details

 - Select PUT as the API call from the dropdown in Postman
 - Go to Headers section and write
	Key: Content-type
	Value: application/json
- Fill the body with JSON content of a new department
 	Eg: {
    "dept_id": 9,
    "emp_YOJ": 2016,
    "emp_age": 90,
    "emp_email": "h@gmail.com",
    "emp_fname": "HimaTest",
    "emp_gender": "F",
     "emp_lname": "Agarwal",
    "emp_phone": 89890
  }

- Run this below mentioned call and hit send
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}/employees/{emp_id}
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12/employees/5
------------------------------------------------------------------------------------------------------------------------------------------------------	
5) API call to remove an employee of a particular emp_id, from a particular department

 - Select DELETE as the API call from the dropdown in Postman, and run this call
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}/employees/{emp_id}
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12/employees/5
--------------------------------------------------------------------------------------------------------------------------------------------------------
6) API call to fetch the employees on the basis of their Year of joining

- Select GET as the API call from the dropdown in Postman, and run this call
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}/employees?emp_YOJ=value
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12/employees?emp_YOJ=2015
---------------------------------------------------------------------------------------------------------------------------------------------------------
7) API call to fetch the employees on the basis of their Gender

- Select GET as the API call from the dropdown in Postman, and run this call
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}/employees?emp_gender="value"
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12/employees?emp_gender="M"
----------------------------------------------------------------------------------------------------------------------------------------------------------
8) API call to fetch the employees on the basis of their age

- Select GET as the API call from the dropdown in Postman, and run this call
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}/employees?age=value
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12/employees?emp_age=2015
----------------------------------------------------------------------------------------------------------------------------------------------------------
9) API call to paginate the employees on the basis of Start value and the size from the start value

- Select GET as the API call from the dropdown in Postman, and run this call
	Format: http://localhost:8080/EmployeeManagement/webapi/departments/{dept_id}/employees?start=value&size=value
	Sample: http://localhost:8080/EmployeeManagement/webapi/departments/12/employees?start=1&size=2