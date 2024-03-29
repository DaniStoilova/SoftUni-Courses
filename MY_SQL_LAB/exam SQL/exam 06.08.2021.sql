CREATE DATABASE `SoftUni Game Dev Branch`;

USE `SoftUni Game Dev Branch`;

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name`VARCHAR(50) NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name`VARCHAR(10) NOT NULL
);

CREATE TABLE `offices`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`workspace_capacity`INT NOT NULL,
`website` VARCHAR(50),
`address_id` INT NOT NULL,
CONSTRAINT fk_address_id
FOREIGN KEY (`address_id`)
REFERENCES `addresses`(`id`)
);

CREATE TABLE `employees`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`age` INT NOT NULL,
`salary` DECIMAL(10,2),
`job_title`VARCHAR(20) NOT NULL,
`happiness_level` CHAR(1) NOT NULL 
);

CREATE TABLE `teams`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`office_id` INT NOT NULL,
CONSTRAINT fk_office_id
FOREIGN KEY (`office_id`)
REFERENCES `offices`(`id`),
`leader_id` INT NOT NULL UNIQUE,
CONSTRAINT fk_leader_id
FOREIGN KEY (`leader_id`)
REFERENCES `employees`(`id`)
);

CREATE TABLE `games`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
`description` TEXT,
`rating` FLOAT NOT NULL,
`budget`DECIMAL(10,2) NOT NULL,
`release_date`DATE,
`team_id` INT NOT NULL,
CONSTRAINT fk_team_id
FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`)
);

CREATE TABLE `games_categories`(
`game_id` INT,
CONSTRAINT fk_game_id
FOREIGN KEY (`game_id`)
REFERENCES `games`(`id`),
`category_id`INT ,
CONSTRAINT fk_category_id
FOREIGN KEY (`category_id`)
REFERENCES `categories`(`id`),
PRIMARY KEY(`game_id`,`category_id`)
);

-- 2 

INSERT INTO `games`(`name`,`rating`,`budget`,`team_id`)
SELECT REVERSE(LOWER(SUBSTRING(`name`,2))),`id`,`leader_id`*1000,`id` FROM `teams`
WHERE `id`  BETWEEN 1 AND 9;

-- 3 

UPDATE `employees` e 
JOIN `teams` t ON e.`id` = t.`leader_id`
SET `salary` = `salary` + 1000
WHERE `age` < 40 AND `salary` < 5000;

-- 4 

DELETE g
FROM `games`g
LEFT JOIN `games_categories` gc ON gc.`game_id` = g.`id`
WHERE `release_date` IS NULL AND `category_id` IS NULL;

-- 5

SELECT `first_name`,`last_name`,`age`,`salary`,`happiness_level`
FROM `employees`
ORDER BY `salary`,`id`; 

-- 6 

SELECT t.`name` AS 'team_name', a.`name` AS 'address_name',
CHAR_LENGTH(a.`name`) AS 'count_of_characters'
FROM `teams` t
JOIN `offices` o ON o.`id` = t.`office_id`
JOIN `addresses` a ON a.`id` = o.`address_id`
WHERE `website` IS NOT NULL
ORDER BY t.`name`, `address_name`;

-- 7

SELECT c.`name`, COUNT(c.`id`) AS 'games_count',
ROUND(AVG(`budget`),2) AS 'avg_budget', MAX(`rating`) AS 'max_rating'
FROM `categories`c
JOIN `games_categories` gc ON gc.`category_id`= c.`id`
JOIN `games` g ON g.`id` = gc.`game_id`
GROUP BY c.`id`
HAVING MAX(`rating`) >= 9.5 
ORDER BY `games_count` DESC, c.`name`;

-- 8 

SELECT g.`name`,`release_date`, CONCAT(SUBSTRING(`description`,1,10),'...') AS 'summary',
CASE
WHEN MONTH(`release_date`) IN (01,02,03) THEN 'Q1'
WHEN MONTH(`release_date`) IN (04,05,06) THEN 'Q2'
WHEN MONTH(`release_date`) IN (07,08,09) THEN 'Q3'
ELSE 'Q4'
END
AS 'quarter',
t.`name` AS 'team_name'
FROM `games` g
JOIN `teams` t ON t.`id` = g.`team_id`
WHERE g.`name` LIKE '%2' AND MOD(MONTH(`release_date`),2) = 0 AND YEAR(`release_date`) = 2022
ORDER BY `quarter`;


-- 9

SELECT 
g.`name`,
IF(`budget`< 50000,'Normal budget','Insufficient budget') AS 'budget_level',
t.`name` AS 'team_name' ,
a.`name` AS 'address_name'
FROM `games` g
LEFT JOIN `games_categories` gc ON gc.`game_id` = g.`id`
JOIN `teams` t ON t.`id` = g.`team_id`
JOIN `offices` o ON o.`id` = t.`office_id`
JOIN `addresses` a ON a.`id` = o.`address_id`
WHERE  `release_date` IS NULL AND `category_id` IS NULL
ORDER BY g.`name`;

-- 10
DELIMITER $$
CREATE FUNCTION udf_game_info_by_name (`game_name` VARCHAR (20)) 
RETURNS TEXT
DETERMINISTIC
BEGIN
RETURN (SELECT CONCAT('The ',g.`name`,' is developed by a '
,t.`name`,' in an office with an address ',a.`name`)
FROM `games` g 
JOIN `teams`t ON t.`id` =  g.`team_id`
JOIN `offices` o ON o.`id` = t.`office_id`
JOIN `addresses` a ON a.`id` = o.`address_id`
WHERE g.`name` = `game_name`);
END$$

-- 11

CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)
BEGIN
UPDATE `games` g
JOIN `games_categories` gc ON gc.`game_id` = g.`id`
SET `budget` = `budget`+ 100000 AND YEAR(`release_date`) = YEAR(`release_date`) + 1
WHERE `category_id` IS NULL AND `rating` > min_game_rating AND `release_date` IS NOT NULL;
END
































