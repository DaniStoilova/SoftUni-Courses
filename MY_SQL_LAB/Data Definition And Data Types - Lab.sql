CREATE DATABASE `gamebar`;

-- 1 Create Tables

CREATE TABLE `gamebar`.`employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(100) NOT NULL,
`last name` VARCHAR(100) NOT NULL
);
CREATE TABLE `gamebar`.`categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);
CREATE TABLE `gamebar`.`products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
`category_id` INT NOT NULL
);
USE `gamebar`;

-- 2 Insert Data in Tables

INSERT INTO  `gamebar`.`employees` (`first_name`,`last name`) VALUES ("Pesho", "Peshev");
INSERT INTO  `gamebar`.`employees` (`first_name`,`last name`) VALUES ("Pesho", "Peshev"),
("Alexander", "Alexandrov");

-- 3  Alter Tables

ALTER TABLE `gamebar`.`employees`
ADD COLUMN `middle_name` VARCHAR(100);

-- 5 Modifying Columns

ALTER TABLE `gamebar`.`employees`
MODIFY COLUMN `middle_name` VARCHAR(100);

-- 4 Adding Constraints

ALTER TABLE `gamebar`.`products`
ADD CONSTRAINT `id_products`
FOREIGN KEY (`category_id`) REFERENCES `gamebar`.`categories`(`id`);

