
use `soft_uni`;

-- 1 Employee Address
SELECT `employee_id`,`job_title`, a.`address_id`,`address_text` 
FROM `employees` AS e JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
ORDER BY `address_id` ASC LIMIT 5;

-- 2 Addresses with Towns

SELECT `first_name`, `last_name`,`name`,`address_text`
FROM `employees` AS e 
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t
ON t.`town_id` =  a.`town_id`
ORDER BY `first_name`,`last_name` LIMIT 5;

-- 3 Sales Employee
SELECT `employee_id`, `first_name`,`last_name`,`name` AS 'department_name'
FROM `employees` AS e JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE `name` = 'Sales'
ORDER BY `employee_id` DESC;

-- 4 Employee Departments

SELECT `employee_id`, `first_name`,`salary`,`name` AS 'department_name'
FROM `employees` AS e JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE `salary` > 15000
ORDER BY d.`department_id` DESC LIMIT 5;

-- 5 Employees Without Project
SELECT e.`employee_id`, `first_name`
FROM `employees` AS e 
LEFT JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
WHERE `project_id` IS NULL
ORDER BY e.`employee_id` DESC LIMIT 3;

-- 6 Employees Hired After
SELECT `first_name`,`last_name`,`hire_date`,`name` AS `dept_name`
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE `hire_date` > '1999/1/1'  AND `name` in ('Sales','Finance')
ORDER BY `hire_date`;

-- 7 Employees with Project

SELECT e.`employee_id`, e.`first_name`,p.`name` AS 'project_name'
FROM `employees` AS e
JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE DATE(p.`start_date`) > '2002/08/13' AND p.`end_date` IS NULL
ORDER BY e.`first_name`, p.`name` 
LIMIT 5;

-- 8 Employee 24

SELECT e.`employee_id`, e.`first_name`,
IF(YEAR(p.`start_date`) >= '2005',NULL, p.`name`) AS 'project_name'
FROM `employees` AS e
JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE e.`employee_id` = 24 
ORDER BY `name`;

-- 9 Employee Manager
SELECT e1.`employee_id`, e1.`first_name`, e1.`manager_id`, e2.`first_name`
FROM `employees` AS e1, `employees` AS e2 
WHERE e1.`manager_id` = e2.`employee_id`AND e1.`manager_id` IN (3,7)
ORDER BY e1.`first_name`;

-- 10 Employee Summary
SELECT e1.`employee_id`, CONCAT( e1.`first_name`,' ',e1.`last_name`) AS 'employee_name'
,CONCAT( e2.`first_name`,' ',e2.`last_name`) AS 'manager_name', d.`name` AS 'department_name'
FROM `employees` AS e1 
JOIN `employees` AS e2 
ON e1.`manager_id` = e2.`employee_id`
JOIN `departments` AS d
ON e1.`department_id` = d.`department_id`
ORDER BY e1.`employee_id`
LIMIT 5;

-- 11 Min Average Salary

SELECT AVG(`salary`) AS 'min_average_salary' 
FROM `employees`
GROUP BY `department_id`
ORDER BY `min_average_salary`
LIMIT 1;

-- 12 Highest Peaks in Bulgaria

USE `geography`;

SELECT c.`country_code`, mo.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `countries` AS c
JOIN `mountains_countries` AS m ON c.`country_code` = m.`country_code`
JOIN `mountains` AS mo ON mo.`id` = m.`mountain_id`
RIGHT JOIN `peaks` AS p ON p.`mountain_id` = m.`mountain_id`
WHERE p.`elevation` > 2835 AND `country_name` = 'Bulgaria'
ORDER BY p.`elevation`DESC;
 
-- 13 Count Mountain Ranges
SELECT `country_code`, COUNT(`mountain_range`) AS 'mountain_range'
FROM `mountains_countries` AS mc 
JOIN `mountains` AS m
ON m.`id` = mc.`mountain_id`
WHERE `country_code` IN ('BG','RU','US')
GROUP BY `country_code`
ORDER BY `mountain_range` DESC;

-- 14 Countries with Rivers

SELECT c.`country_name`, r.`river_name`
FROM `countries` c 
LEFT JOIN `countries_rivers` cr ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` r ON cr.`river_id` = r.`id`
WHERE c.`continent_code` = 'AF' 
ORDER BY c.`country_name`
LIMIT 5;

-- 16 Countries Without Any Mountains

SELECT COUNT(c.`country_code`) - COUNT(mc.`country_code`) AS 'country_count'
FROM `countries`c
LEFT JOIN `mountains_countries` mc
ON c.`country_code` = mc.`country_code`;

-- 17 Highest Peak and Longest River by Country
SELECT c.`country_name`, MAX(p.`elevation`) 'highest_peak_elevation', MAX(r.`length`) 'longest_river_length'
FROM `countries` c 
LEFT JOIN `mountains_countries` mc ON c.`country_code` = mc.`country_code`
LEFT JOIN `peaks` p ON p.`mountain_id` = mc.`mountain_id`
LEFT JOIN `countries_rivers` cr ON cr.`country_code` = c.`country_code`
LEFT JOIN `rivers` r ON r.`id` = cr.`river_id`
GROUP BY `country_name` 
ORDER BY `highest_peak_elevation` DESC,`longest_river_length` DESC,`country_name`
LIMIT 5;

-- 15 *Continents and Currencies

SELECT c.`continent_code`, cu.`currency_code`, (COUNT(cu.`currency_code`)) AS 'currency_usage'
FROM `continents` AS c
LEFT JOIN `countries` co ON c.`continent_code` = co.`continent_code`
LEFT JOIN `currencies` cu ON cu.`currency_code` = co.`currency_code`
GROUP BY  c.`continent_code`,`currency_code`
HAVING `currency_usage` > 1 
AND `currency_usage`= 
(SELECT COUNT(*) as 'count'
FROM `countries` c2
WHERE c2.`continent_code` = c.`continent_code`
GROUP BY c2.`currency_code`
ORDER BY `count` DESC
LIMIT 1)	
ORDER BY `continent_code`,`currency_code`;






















