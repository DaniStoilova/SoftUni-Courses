-- 1 Select Employee Information

SELECT id, first_name, last_name, job_title 
FROM employees
ORDER BY id;

-- 2 Select Employees with Filter

SELECT 
id AS id,
CONCAT(`first_name`, ' ', `last_name`) AS `full_name`,
job_title AS job_title,
salary AS salary
FROM employees
WHERE salary > 1000
ORDER BY id;

-- 3 Update Salary and Select

UPDATE employees
SET salary = salary + 100
WHERE job_title = 'Manager';
SELECT salary
FROM employees;

-- 4 Top Paid Employee

CREATE VIEW `v_top_paid_employee`
AS SELECT *
FROM employees
ORDER BY salary DESC LIMIT 1;

SELECT * FROM v_top_paid_employee;

-- 5 Select Employees by Multiple Filters

SELECT * FROM employees AS e
WHERE e.department_id = 4 AND e.salary >= 1000;

-- 6 Delete from Table

DELETE FROM employees
WHERE department_id = 1 OR department_id = 2;
SELECT * FROM employees
ORDER BY id;
