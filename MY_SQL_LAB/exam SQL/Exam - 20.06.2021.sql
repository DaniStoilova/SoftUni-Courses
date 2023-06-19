CREATE DATABASE `SoftUni Taxi Company`;
USE `SoftUni Taxi Company`;

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE `clients`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`full_name`VARCHAR(50) NOT NULL,
`phone_number`VARCHAR(20) NOT NULL
);

CREATE TABLE`drivers`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`first_name`VARCHAR(30) NOT NULL,
`last_name`VARCHAR(30) NOT NULL,
`age`INT NOT NULL,
`rating` FLOAT
);

CREATE TABLE `cars`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`make`VARCHAR(20) NOT NULL,
`model`VARCHAR(20),
`year`INT NOT NULL,
`mileage`INT,
`condition` CHAR(1) NOT NULL,
`category_id` INT NOT NULL,
CONSTRAINT fk_category_id
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`)
);

CREATE TABLE `courses`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`from_address_id`INT NOT NULL,
CONSTRAINT fk_from_address_id
FOREIGN KEY (`from_address_id`)
REFERENCES `addresses`(`id`),
`start` DATETIME NOT NULL,
`bill` DECIMAL(10,2),
`car_id`INT NOT NULL,
CONSTRAINT fk_car_id
FOREIGN KEY (`car_id`)
REFERENCES `cars`(`id`),
`client_id` INT NOT NULL,
CONSTRAINT fk_client_id
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `cars_drivers`(
`car_id` INT NOT NULL,
`driver_id` INT NOT NULL,
CONSTRAINT fk_driver_id
FOREIGN KEY (`driver_id`)
REFERENCES `drivers`(`id`),
PRIMARY KEY(`car_id`,`driver_id`)
);

-- 2 

INSERT INTO `clients`(`full_name`,`phone_number`)
SELECT CONCAT(`first_name`,' ',`last_name`),CONCAT('(088) 9999',`id`*2)FROM `drivers`
WHERE `id` BETWEEN 10 AND 20 ;

-- 3

UPDATE `cars`
SET `condition` = 'C'
WHERE (`mileage` >= 800000 OR `mileage` IS NULL) AND (`year` <= 2010) AND (`make` != 'Mercedes-Benz');

-- 4 
DELETE c
FROM `clients`c 
LEFT JOIN `courses` co ON co.`client_id` = c.`id`
WHERE CHAR_LENGTH(`full_name`) > 3 AND `client_id` IS NULL;

-- 5

SELECT `make`, `model`,`condition`FROM `cars`
ORDER BY `id`;

-- 6 

SELECT `first_name`,`last_name`,`make`,`model`,`mileage` 
FROM `drivers`d
JOIN `cars_drivers` cd ON cd.`driver_id` = d.`id`
JOIN `cars` c ON c.`id`= cd.`car_id`
WHERE `mileage` IS NOT NULL
ORDER BY `mileage` DESC, `first_name`;

-- 7

SELECT c.`id` AS 'car_id', c.`make`, c.`mileage`,
COUNT(co.`client_id`) AS 'count_of_courses', 
ROUND(AVG(`bill`),2) AS 'avg_bill'
FROM `cars`c
JOIN `courses` co ON co.`car_id` = c.`id`
JOIN `clients` cl ON cl.`id` = `client_id`
WHERE co.`car_id` != 2
GROUP BY co.`car_id`
ORDER BY `count_of_courses` DESC, co.`car_id`;


-- SELECT c.`id` AS 'car_id',
--     COUNT(co.`client_id`) AS 'count_of_courses',
--     ROUND(AVG(`bill`), 2) AS 'avg_bill'
-- FROM
--     `clients` c
--         LEFT JOIN
--     `courses` co ON co.`client_id` = c.`id`
--    --  WHERE co.`car_id` != 2
-- GROUP BY c.`id`
-- ORDER BY `count_of_courses` DESC;

-- 8 

SELECT (c.`full_name`) as 'full_name', COUNT(co.`car_id`) AS 'count_of_cars',
SUM(`bill`) AS 'total_sum' 
FROM `clients` c
JOIN `courses` co ON co.`client_id` = c.`id`
JOIN `cars` ca ON ca.`id` = co.`car_id`
WHERE SUBSTR(c.`full_name`, 2, 1) = 'a' 
GROUP BY `full_name`
HAVING COUNT(co.`car_id`) > 1
ORDER BY `full_name`;

-- 9 

SELECT a.`name`,
IF(HOUR(co.`start`) BETWEEN 6 AND 20,'Day','Night')
as 'day_time'
,co.`bill`, cl.`full_name`,c.`make`,c.`model`,ca.`name` AS 'category_name'
FROM `addresses` AS  a
JOIN `courses` AS co ON co.`from_address_id` = a.`id`
JOIN `clients` AS cl ON cl.`id` = co.`client_id` 
JOIN `cars`AS c ON c.`id` = co.`car_id`
JOIN `categories` AS ca ON ca.`id` = c.`category_id`
ORDER BY co.`id`;

-- 11
DELIMITER $$
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INT
DETERMINISTIC
BEGIN
return (SELECT COUNT(co.`car_id`) AS 'count'
FROM `clients` cl
JOIN `courses` co ON co.`client_id` = cl.`id`
WHERE cl.`phone_number` = phone_num
GROUP BY `phone_number`);
END$$

-- 11

CREATE procedure udp_courses_by_address(address_name VARCHAR(100))
BEGIN
SELECT a.`name`, cl.`full_name`,
CASE
WHEN (co.`bill`<= 20) THEN  'Low'
WHEN (co.`bill`<= 30) THEN 'Medium '
ELSE 'High'
END 
AS 'level_of_bill',
c.`make`,c.`condition`,ca.`name` AS 'category_name'
FROM `addresses` AS  a
JOIN `courses` AS co ON co.`from_address_id` = a.`id`
JOIN `clients` AS cl ON cl.`id` = co.`client_id` 
JOIN `cars`AS c ON c.`id` = co.`car_id`
JOIN `categories` AS ca ON ca.`id` = c.`category_id`
WHERE a.`name` = address_name
ORDER BY c.`make`, cl.`full_name`;
END









