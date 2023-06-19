CREATE DATABASE `softuni_stores_system`;
USE `softuni_stores_system`;

CREATE TABLE `pictures`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`url` VARCHAR(100) NOT NULL,
`added_on` DATETIME NOT NULL
);

CREATE TABLE `categories`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `products`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`name`VARCHAR(40) NOT NULL UNIQUE,
`best_before` DATE,
`price` DECIMAL(10,2) NOT NULL,
`description` TEXT,
`category_id` INT NOT NULL,
CONSTRAINT fk_category_id
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`),
`picture_id`INT NOT NULL,
CONSTRAINT fk_picture_id
FOREIGN KEY (`picture_id`)
REFERENCES `pictures`(`id`)
);

CREATE TABLE `towns`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL
);

CREATE TABLE `addresses`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
`town_id` INT NOT NULL,
CONSTRAINT fk_town_id
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`)
);

CREATE TABLE `stores`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`rating` FLOAT NOT NULL,
`has_parking` TINYINT(1),
`address_id` INT NOT NULL,
CONSTRAINT fk_address_id
FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`)
);

CREATE TABLE `products_stores`(
`product_id` INT NOT NULL,
CONSTRAINT fk_product_id
FOREIGN KEY (`product_id`)
REFERENCES `products`(`id`),
`store_id` INT NOT NULL,
CONSTRAINT fk_store_id
FOREIGN KEY (`store_id`)
REFERENCES `stores`(`id`),
PRIMARY KEY(`product_id`,`store_id`)
);

CREATE TABLE `employees`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(15) NOT NULL,
`middle_name` CHAR(1),
`last_name`VARCHAR(20) NOT NULL,
`salary` DECIMAL(19,2) NOT NULL,
`hire_date` DATE NOT NULL,
`manager_id` INT,
CONSTRAINT fk_manager_id
FOREIGN KEY (`manager_id`)
REFERENCES `employees`(`id`),
`store_id`INT NOT NULL,
CONSTRAINT fk_store
FOREIGN KEY (`store_id`)
REFERENCES `stores`(`id`)
);

-- 2 

INSERT INTO `products_stores`(`product_id`,`store_id`)
SELECT p.`id`, 1 
FROM `products` p
WHERE p.`id` NOT IN (SELECT `product_id` FROM `products_stores` AS ps);

-- 3

UPDATE `employees` e
JOIN `stores` s ON s.`id` = e.`store_id`
SET e.`salary` = e.`salary` - 500, e.`manager_id` = 3
WHERE YEAR(`hire_date`) > 2003 AND 
`store_id` NOT IN(
SELECT s.`id`
FROM `stores` AS s 
WHERE s.`name` NOT IN ('Cardguard','Veribet'));

-- 4
DELETE e
FROM `employees` e
WHERE `salary` >= 6000 AND `manager_id` IS NOT NULL;

-- 5 

SELECT `first_name`,`middle_name`,`last_name`,`salary`,`hire_date`
FROM `employees`
ORDER BY `hire_date` DESC;

-- 6

SELECT 
`name`AS 'product_name',
`price`,
`best_before`,CONCAT(SUBSTRING(`description`,1,10),'...') AS 'short_description',
`url`
FROM `products` p
JOIN `pictures` pi ON pi.`id` = p.`picture_id`
WHERE CHAR_LENGTH(`description`) > 100 AND (YEAR(`added_on`) < 2019) 
AND `price` > 20
ORDER BY `price` DESC;

-- 7

SELECT s.`name`, COUNT(p.`id`) AS 'product_count', ROUND(AVG(p.`price`),2) AS 'avg'
FROM `stores` AS s
LEFT JOIN `products_stores` AS ps ON ps.`store_id` = s.`id`
LEFT JOIN `products` AS p ON p.`id` = ps.`product_id`
GROUP BY (s.`id`)
ORDER BY `product_count` DESC,`avg` DESC, s.`id`;

-- 8

SELECT CONCAT(`first_name`,' ',`last_name`) AS 'Full_name',
s.`name` AS 'Store_name',
a.`name` AS 'address',
`salary`
FROM `employees` e
JOIN `stores` s ON s.`id` = e.`store_id`
JOIN `addresses` a ON a.`id` = s.`address_id`
WHERE `salary` < 4000 AND LOCATE(5,a.`name`)
AND CHAR_LENGTH(s.`name`) > 8 
AND `last_name` like '%n';

-- 9 

SELECT REVERSE(s.`name`) AS 'reversed_name',
CONCAT(UPPER(t.`name`),'-',(a.`name`)) AS 'full_address',
COUNT(e.`id`) AS 'employees_count'
FROM `stores` s
JOIN `addresses` AS a ON a.`id` = s.`address_id`
JOIN `towns`AS t ON t.`id` = a.`town_id`
JOIN `employees` AS e ON e.`store_id`= s.`id`
GROUP BY s.`id`
ORDER BY `full_address` ASC;

-- 10

DELIMITER $$
CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50)) 
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
RETURN (SELECT CONCAT(e.`first_name`,' ',e.`middle_name`,'. ',e.`last_name`,' works in store for ',
(YEAR('2020-10-18')-YEAR(e.`hire_date`)) ,' years')
FROM `employees` as e
JOIN `stores` as s on s.`id`= e.`store_id`
WHERE s.`name` = store_name
ORDER BY e.`salary` DESC LIMIT 1);
END$$

CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))
BEGIN
UPDATE `products` p
JOIN `products_stores` ps ON ps.`product_id` = p.`id`
JOIN `stores` s ON s.`id` = ps.`store_id`
JOIN `addresses` a ON a.`id` =  s.`address_id`
SET p.`price` = p.`price` + (IF(`address_name` LIKE '0%',100,200))
WHERE a.`name` = address_name;
END















































