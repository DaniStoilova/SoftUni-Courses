CREATE DATABASE `fsd`;
USE `fsd`;

CREATE TABLE `countries`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE `towns`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`name`VARCHAR(45)  NOT NULL,
`country_id` INT(11) NOT NULL,
CONSTRAINT fk_country_id
FOREIGN KEY (`country_id`)
REFERENCES `countries`(`id`)
);

CREATE TABLE `stadiums`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)  NOT NULL,
`capacity` INT(11) NOT NULL,
`town_id` INT(11) NOT NULL,
CONSTRAINT fk_town_id
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`)
);

CREATE TABLE `teams`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)  NOT NULL,
`established` DATE NOT NULL,
`fan_base` BIGINT(20) NOT NULL,
`stadium_id` INT(11) NOT NULL,
CONSTRAINT fk_stadium_id
FOREIGN KEY (`stadium_id`)
REFERENCES `stadiums`(`id`)
);

CREATE TABLE `skills_data`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`dribbling`INT(11),
`pace`INT(11),
`passing`INT(11),
`shooting`INT(11),
`speed`INT(11),
`strength`INT(11)
);

CREATE TABLE `players`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name`VARCHAR(20) NOT NULL,
`age` INT(11) NOT NULL,
`position` CHAR(1) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`hire_date` DATETIME,
`skills_data_id`INT(11) NOT NULL,
CONSTRAINT fk_skills_data_id
FOREIGN KEY (`skills_data_id`)
REFERENCES `skills_data`(`id`),
`team_id` INT(11),
CONSTRAINT fk_team_id
FOREIGN KEY (`team_id`)
REFERENCES `teams`(`id`));

CREATE TABLE `coaches`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`first_name`VARCHAR(10) NOT NULL,
`last_name`VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL default(0),
`coach_level` INT(11) NOT NULL DEFAULT(0)
);

CREATE TABLE`players_coaches`(
`player_id` INT(11),
CONSTRAINT fk_player_id
FOREIGN KEY (`player_id`)
REFERENCES `players`(`id`),
`coach_id` INT(11),
CONSTRAINT fk_coach_id
FOREIGN KEY (`coach_id`)
REFERENCES `coaches`(`id`)
);


-- 2

INSERT INTO `coaches`(`first_name`,`last_name`,`salary`,`coach_level`)
SELECT p.`first_name`,p.`last_name`,`salary`* 2,CHAR_LENGTH(p.`first_name`)
FROM `players`AS p
WHERE p.`age` >= 45;


-- 3 

UPDATE `coaches` AS c
JOIN `players_coaches` AS pc ON pc.`coach_id` = c.`id`
JOIN `players` AS p ON p.`id` = pc.`player_id`
SET `coach_level`= `coach_level` + 1
WHERE c.`first_name` LIKE 'A%' AND 
c.`id` IN (SELECT `coach_id` FROM `players_coaches`);

-- 4

DELETE p 
FROM `players` p
left JOIN `players_coaches` pc ON pc.`player_id` = p.`id`
left JOIN `coaches`c ON c.`id` = pc.`coach_id`
WHERE p.`age` >= 45;


-- 5 

SELECT `first_name`,`age`,`salary`
FROM `players`
ORDER BY `salary` DESC;

-- 6

SELECT p.`id`,CONCAT(p.`first_name`,' ',p.`last_name`) AS 'full_name',
p.`age`,p.`position`,p.`hire_date`
FROM `players`p
JOIN `skills_data` sd ON sd.`id`= p.`skills_data_id`
WHERE p.`age` < 23 AND p.`hire_date` IS NULL AND sd.`strength` > 50
ORDER BY `salary`,`age`;

-- 7

SELECT t.`name` AS 'team_name',t.`established`,t.`fan_base`,
COUNT(p.`id`) AS 'players_count'
FROM `teams`t
left JOIN `players` p ON p.`team_id` = t.`id`
GROUP BY t.`id`
ORDER BY `players_count` DESC, `fan_base` DESC ;

-- 8

SELECT MAX(sk.`speed`) AS 'max_speed',
ts.`name` AS 'town_name'
FROM `skills_data`sk
RIGHT JOIN `players`p ON p.`skills_data_id` = sk.`id`
RIGHT JOIN `teams`t ON t.`id` = p.`team_id`
JOIN `stadiums`s ON s.`id` = t.`stadium_id`
RIGHT JOIN `towns` ts ON ts.`id` = s.`town_id`
WHERE t.`name` != 'Devify'
GROUP BY ts.`id`
ORDER BY `max_speed` DESC,`town_name`;

-- 9

SELECT c.`name` ,
COUNT(p.`id`) AS 'total_count_of_players',
SUM(p.`salary`) AS 'total_sum_of_salaries'
FROM `countries` c
LEFT JOIN `towns`t ON t.`country_id` = c.`id`
LEFT JOIN `stadiums` s ON s.`town_id`= t.`id`
LEFT JOIN `teams` te ON te.`stadium_id` = s.`id`
LEFT JOIN `players` p ON p.`team_id` = te.`id`
GROUP BY c.`id`
ORDER BY `total_count_of_players` DESC, c.`name`;

-- 10

DELIMITER %%
CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC 
BEGIN 
 return (SELECT COUNT(*)
FROM `players` p
JOIN `teams` t ON t.`id`= p.`team_id`
JOIN `stadiums`s ON s.`id` = t.`stadium_id`
WHERE s.`name` = stadium_name);
END%%

-- 11 

CREATE PROCEDURE udp_find_playmaker(min_dribble_points INT, team_name VARCHAR(45))
BEGIN 
SELECT CONCAT(p.`first_name`,' ',p.`last_name`) AS 'full_name',
p.`age`,
p.`salary`,
sk.`dribbling`,
sk.`speed`,
t.`name`
FROM `skills_data` sk
JOIN `players`p ON p.`skills_data_id`= sk.`id`
JOIN `teams`t On t.`id`= p.`team_id`
WHERE `dribbling` > min_dribble_points AND t.`name` = team_name
ORDER BY `speed` DESC LIMIT 1;
END




































