/*
- find the highest salary from employee table
*/

select * from employee order by desc sal limit 1;

SELECT MAX(Salary) FROM Employee;
/*
- Retrieve distinct records
*/

SELECT DISTINCT salary, dept_id FROM Employee;
/* 
- Given a table Employee, write an SQL query to find the names of employees who earn more than a specific salary 1000.
*/

select name from Employee where sal > 1000;

/* 
- Given two tables Customers and Orders, write an SQL query to find all customers who never placed an order.
*/

select customerName from customers where customerId not in (select customerId from orders);

select customerName from customers as c left join orders as o on o.customerId = c.id where o.customerId is null;

select customerName from customers where not exists (select 1 from orders where orders.customerId = customers.customerId);

/*
- Given a table Employee, write an SQL query to find the second-highest salary.
*/

select max(salary) from employee where employee < (select max(salary) from employee);

select distinct salary from employee order by salary desc limit 1, 1;

select salary from (select salary, dense_rank() over (order by salary desc) as rank from employee) as rankedSal where rank = 2;

/*
- Given two tables Employee and Department, write an SQL query to find the department with the highest average salary.
*/
select * from employee e join department d on e.departmentId = d.departmentId group by d.department_name having AVG(e.salary)
=(select max(avg_salary) from (select Avg(e.salary) as avg_salary from employee e join Department d on e.departmentId = 
d.departmentId group by d.department_name) as subquery);

select d.department_name, Avg(e.salary) as avg_salary from employee e join department d on e.departmentId = d.departmentId
group by d.department_name order by avg(e.salary) desc limit 1;

/*
- Given a table Person, write an SQL query to find all duplicate emails.
*/

select email, count(email) as count from person group by email having count(email) > 1;

/*
- Given a table Employee, write an SQL query to rank the salaries of all employees.

Explanation:
RANK(): Assigns a rank to each row based on the Salary column in descending order. If two employees have the same salary, they receive the same rank, and the next rank is skipped.

DENSE_RANK(): Similar to RANK(), but if two employees have the same salary, they receive the same rank, and the next rank is not skipped.

ROW_NUMBER(): Assigns a unique rank to each row based on the Salary column in descending order. There are no ties; each employee gets a distinct rank.
*/

select employeeId, name, salaries, Rank() over (order by salary desc) as salaryRank from employee;
select employeeId, name, salaries, row_number() over (order by salary desc) as salaryRank from employee;
select employeeId, name, salaries, DENSE_RANK() over (order by salary desc) as salaryRank from employee;


/*
- Given a table Employee, write an SQL query to find the employees who earn more than their managers.
*/
select e.employee_name, e.salary from employee e join employee m on e.managersId = m.employeeId where e.salary > m.salary; 
select e.* from Employee e where e.salary > (select m.salary from employee m where e.managers_Id = m.employeeId);


/*
- Given a table Employee, write an SQL query to find the median salary.
PERCENTILE_CONT: Calculates the median as an interpolated value between the two middle values if there is an even number of rows.
*/

SELECT PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY Salary) AS MedianSalary FROM Employee;

/*
- Write a query to retrieve all records from a employee where the date is '2024-01-01'.
*/

select * from employee where date_time >= '2025-05-01' and date_time < '2025-05-02';
select * from employee where CAST (date_time as Date) = '2025-05-01';
select * from employee where Date(date_time) = '2025-05-01'; 

/*

*/


/*

*/




