USE `soft_uni`;

-- 1 Managers

SELECT `employee_id`, CONCAT(`first_name`,' ', `last_name`) AS 'full_name',
 d.`department_id`, `name` AS 'department_name' FROM 	`employees` AS e
 JOIN `departments` AS d
 ON d.`manager_id` = e.`employee_id`
 ORDER BY `employee_id` LIMIT 5;
 
 -- 2 Towns and Addresses

 SELECT t.`town_id`,`name` AS 'town_name',`address_text` 
 FROM
 `towns` AS t 
 JOIN `addresses` AS a
 ON t.`town_id` = a.`town_id`
 WHERE `name` in ('San Francisco', 'Sofia', 
'Carnation')
 ORDER BY `town_id`, `address_id`;
 
 -- 3 Employees Without Managers

 SELECT `employee_id`,`first_name`,`last_name`, `department_id`, `salary`
 FROM `employees`
 WHERE `manager_id` IS NULL;
 

 
 -- 4 High Salary

 SELECT  COUNT(*) AS 'count' 
 FROM `employees`
 WHERE `salary` > (SELECT AVG(`salary`) FROM `employees`);

 
 
 
 