# Expense Reimbursement System 2021
  The Expense Reimbursement System (ERS) manages the process of reimbursing employees for expenses incurred while on company time. All employees can log in and submit requests for reimbursement and view their past tickets and pending requests. Managers can then log in and view all reimbursement requests and past history for all employees. These managers are authorized to approve and deny requests for expense reimbursements.

## Contributors
* Hon Pan Loi (solo)

## Roles / Responsibilities 
* Database design and construct 
* Version control 
* Front end design and implementation
* Back end implementation
* Database connectivity
* Test case writing
* QA
* Debug
* Project presentation

## Technologies Used / Environment
* Maven - 2.22.1
* Log4j - 1.2.17
* PostgreSQL - 42.2.5
* Junit - 5.4.2
* Mokito - 3.7.7
* Java - 8
* Spring Tool Suite - 4.8.1.Release
* Dbeaver - 7.3.4
* Git Bash - 2.25.1
* Javax-servlet-api - 3.1.0
* Jackson databind - 2.21.1
* Hibernate - 5.4.28.Final
* AWS-java-sdk - 1.11.327
* AWS EC2 - Linux
* AWS RDS
* AJAX
* Tomcat 8.5
* Language used - Java 8, SQL, XML, Javascript, HTML, CSS

## User Stroies / Features
-An Employee can login 
-An Employee can view the Employee Homepage
-An Employee can logout
-An Employee can submit a reimbursement request
-An Employee can upload an image of his/her receipt as part of the reimbursement request
-An Employee can view their pending reimbursement requests
-An Employee can view their resolved reimbursement requests
-An Employee can view their information
-An Employee can update their information
-A Manager can login
-A Manager can view the Manager Homepage
-A Manager can logout
-A Manager can approve/deny pending reimbursement requests from the employees they manage
-A Manager can view all pending requests from the employees they manage
-A Manager can view all resolved requests from all employees and see which manager resolved it
-A Manager can view all Employees and their managers
-A Manager can view reimbursement requests from a single Employee whom they manage

## Getting Started
1. Download and install development tools. (Spring Tool Suite, Dbeaver, Gitbash, Tomcat 8.5)
2. Open Git bash on the location that you want your project folder to be.
3. In the Git bash CLI, enter the command 'git clone https://github.com/honpanloi/ExpenseReimbrusmentSystem2021.git'.
4. You should see the project folder is created on your computer.
5. Open Dbeaver.
6. Create a new connection with local client PostgreSQL 12.
7. Create a new schema called 'ers_2021'
8. Right Click on the 'ers_2021' schema. -> Tools -> Restore.
9. Select the backup file at ExpenseReimbrusmentSystem2021/dump-postgres-202103261906.sql .
10. Click on local client and select PostgreSQL 12.
11. Click 'start'.
12. The tables with some dummy data should be created
13. Open Spring Tool Suite with the workspace of your choice.
14. File -> Import -> Maven -> Existing Maven Projects.
15. Navigate to the folder ExpenseReimbrusmentSystem2021 where the pom.xml is located and click finish.
16. You should see a project named 'ExpenseReimbrusmentSystem' get imported.
17. Right click on the project -> Run as -> Run on server.
18. You can now use the app with a browser of your choice.
19. The defaut url of the web application should be: http://localhost:8080/ExpenseReimbursementSystem/
 
## Usage
* After you successfully have the project running on your browser, it should be very intuitive on how to use the app. You can login as an employee to file reimbursement requests. You can also login as a manager to manager requests that were filed by the employees you manage.


## License Information
* Open-source. For demo purposes. Not for commercial use.
