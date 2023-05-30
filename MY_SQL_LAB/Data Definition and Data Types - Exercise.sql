USE minions;

-- 1 Create Tables

CREATE TABLE `minions` (
`id` INT PRIMARY KEY AUTO_INCREMENT ,
`name` VARCHAR(100) ,
`age` INT 
);

CREATE TABLE `towns` (
 `town_id` INT PRIMARY KEY AUTO_INCREMENT ,
 `name` VARCHAR(100) NOT NULL
 );

-- 2 Alter Minions Table

ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`);

SELECT * FROM minions;

-- 3 Insert Records in Both Tables

INSERT INTO `towns` (`id`,`name`) VALUES 
(1,"Sofia"),
(2,"Plovdiv"),
(3,"Varna");


INSERT INTO `minions` (`id`,`name`,`age`,`town_id`) VALUES 
(1,"Kevin",22,1),
(2,"Bob",15,3),
(3,"Steward",NULL,2);

SELECT * FROM `minions`;
SELECT * FROM `towns`;

-- 4 Truncate Table Minions

TRUNCATE TABLE `minions`;

-- 5 Drop All Tables

DROP TABLE `minions`;
DROP TABLE `towns`;

-- 6 Create Table People

CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE (10,2),
`weight`  DOUBLE (10,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL ,
`biography` TEXT 
);

INSERT INTO `people`(`name`,`gender`,`birthdate`) 
VALUES ("George","m", DATE(NOW())),
("Peter","m",DATE(NOW())),
("Mitko","m",DATE(NOW())),
("Dari","f",DATE(NOW())),
("Alex","f",DATE(NOW()));

SELECT * FROM `people`;
USE `exercise`;

-- 7 Create Table Users

CREATE TABLE `users`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password`VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users`(`username`,`password`)
VALUES ("test","123"),
("test1","321"),
("test2","456"),
("test3","654"),
("test4","789"); 

-- 8 Change Primary Key

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD PRIMARY KEY `pk_users` (`id`,`username`) ;

-- 9 Set Default Value of a Field

ALTER TABLE `users`
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME DEFAULT NOW();

INSERT INTO `users`(`username`,`password`)
VALUES ("desi","111");


-- 10 Set Unique Field

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY `users` (`id`),
MODIFY COLUMN `username` VARCHAR(30) UNIQUE;

-- 11 Movies Database

CREATE DATABASE `movies`;

CREATE TABLE `directors` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(30) NOT NULL,
`notes` VARCHAR(30)
);

INSERT INTO `directors` (`director_name`) 
VALUES("test"),
("test1"),
("test2"),
("test3"),
("test4");

CREATE TABLE `genres` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` VARCHAR(30)
);

INSERT INTO `genres` (`genre_name`) 
VALUES("test5"),
("test6"),
("test7"),
("test8"),
("test9");

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(30) NOT NULL,
`notes` VARCHAR(30)
);

INSERT INTO `categories` (`category_name`) 
VALUES("test5"),
("test6"),
("test7"),
("test8"),
("test9");

CREATE TABLE `movies` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(30) NOT NULL,
`director_id` INT,
`copyright_year` DATE,
`length` DOUBLE(3,2),
`genre_id` INT,
`category_id`INT,
`rating` INT,
`notes` VARCHAR(30)
);

INSERT INTO `movies` (`title`) 
VALUES("info"),
("info1"),
("info2"),
("info3"),
("info4");

-- 12 Car Rental Database

CREATE DATABASE `car_rental`;

USE `car_rental`;

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(30) NOT NULL,
`daily_rate` INT,
`weekly_rate` INT,
`monthly_rate` INT,
`weekend_rate` INT
);
INSERT INTO `categories` (`category`)
 VALUES ("test"),
 ("test1"),
 ("test2");
 
--  s (id, plate_number, make, model, car_year, category_id, doors, picture, car_condition, 
-- available)

CREATE TABLE `cars`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` INT NOT NULL,
`make` INT,
`model` VARCHAR(30) NOT NULL,
`car_year` DATE,
`category_id` INT,
`doors` INT,
`picture` BLOB,
`car_condition` VARCHAR(30),
`available` BOOLEAN
);
INSERT INTO `cars` (`plate_number`,`model`)
 VALUES (123,"info"),
 (455,"info1"),
 (666,"info2");
 
 CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name`  VARCHAR(30) NOT NULL,
`title` VARCHAR(30) NOT NULL,
`notes` TEXT
);
INSERT INTO `employees` (`first_name`,`last_name`,`title`)
 VALUES ("Ivan","Ivanov",".NET Developer"),
("Petar","Petrov","Senior Engineer"),
("Maria","Petrova","Intern");

-- customers (id, driver_licence_number, full_name, address, city, zip_code, notes)

CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` INT NOT NULL,
`full_name`  VARCHAR(30) NOT NULL,
`address` VARCHAR(30) NOT NULL,
`city`VARCHAR(30),
`zip_code`INT ,
`notes` TEXT
);
INSERT INTO `customers` (`driver_licence_number`,`full_name`,`address`)
 VALUES (123,"Ivanov","address1"),
(456,"Petrov","address1"),
(789,"Petrova","address1");

-- rental_orders (id, employee_id, customer_id, car_id, car_condition, tank_level, 
-- kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, 
-- total_days, rate_applied, tax_rate, order_status, notes
 
 CREATE TABLE `rental_orders`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`customer_id`  INT NOT NULL,
`car_id` INT NOT NULL,
`car_condition` VARCHAR(30),
`tank_level`INT ,
`kilometrage_start` INT,
`kilometrage_end` INT,
`total_kilometrage` INT,
`start_date` DATE,
`end_date` DATE,
`total_days` INT,
`rate_applied`INT,
`tax_rate` DOUBLE(5,2),
`order_status` VARCHAR(30),
`notes` TEXT
);

INSERT INTO `rental_orders` (`employee_id`,`customer_id`,`car_id`)
 VALUES (1,5,6),
(1,5,6),
(1,5,6);

-- 13 Basic Insert

CREATE DATABASE `soft_uni`;

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);
CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` VARCHAR(30) NOT NULL,
`town_id` INT NOT NULL
);
CREATE TABLE `departments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);
CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(255) NOT NULL,
`middle_name`  VARCHAR(255) NOT NULL,
`last_name`  VARCHAR(255) NOT NULL,
`job_title`  VARCHAR(255) NOT NULL,
`department_id` INT NOT NULL,
`hire_date` DATE,
`salary` DECIMAL NOT NULL,
`address_id`INT NOT NULL
);

-- 13 

INSERT INTO `towns` (`name`) VALUES("Sofia"),
("Plovdiv"),("Varna"),("Burgas");

INSERT INTO `departments` (`name`) VALUES("Engineering"),
("Sales"),("Marketing"),("Software Development"),("Quality Assurance");

ALTER TABLE `employees`
MODIFY COLUMN `address_id` INT ;

ALTER TABLE `employees`
MODIFY COLUMN `salary` DECIMAL(10,2) NOT NULL ;


INSERT INTO `employees` (`first_name`,`middle_name`,`last_name`,`job_title`,
`department_id`,`hire_date`,`salary`) 
VALUES("Ivan","Ivanov","Ivanov",".NET Developer",4,'2013-02-01', 3500.00),
("Petar","Petrov","Petrov","Senior Engineer",1,'2004-03-02', 4000.00),
("Maria","Petrova","Ivanova","Intern",5,'2016-08-28', 525.25),
("Georgi","Terziev","Ivanov","CEO",2,'2007-12-09', 3000.00),
("Peter","Pan","Pan","Intern",3,'2016-08-28', 599.88);

-- 14 Basic Select All Fields

SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;

-- 15 Basic Select All Fields and Order Them

SELECT * FROM `towns`
ORDER BY `name`;

SELECT * FROM `departments`
ORDER BY `name`;

SELECT * FROM `employees`
ORDER BY `salary` DESC;

-- 16 Basic Select Some Fields

SELECT `name` FROM `towns`
ORDER BY `name`;

SELECT `name` FROM `departments`
ORDER BY `name`;

SELECT `first_name`,`last_name`,`job_title`,`salary` FROM `employees`
ORDER BY `salary` DESC;

-- 17 Increase Employees Salary

UPDATE `employees`
SET `salary` = `salary` * 1.10;
SELECT `salary` FROM `employees`;


-------------------------------



