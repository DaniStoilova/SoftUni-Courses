CREATE DATABASE colonial_journey_management_system_db;
USE colonial_journey_management_system_db;

CREATE TABLE `planets`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE `spaceports`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`planet_id` INT(11),
CONSTRAINT fk_planet_id
FOREIGN KEY (`planet_id`)
REFERENCES `planets`(`id`)
);

CREATE TABLE `spaceships`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`manufacturer`VARCHAR(30) NOT NULL,
`light_speed_rate`INT(11) DEFAULT(0)
);

CREATE TABLE `colonists`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`first_name`VARCHAR(20) NOT NULL,
`last_name`VARCHAR(20) NOT NULL,
`ucn` CHAR(10) NOT NULL UNIQUE,
`birth_date`DATE NOT NULL
);

CREATE TABLE `journeys`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`journey_start`DATETIME NOT NULL,
`journey_end`DATETIME NOT NULL,
`purpose` ENUM('Medical', 'Technical', 'Educational', 'Military'),
`destination_spaceport_id`INT(11),
CONSTRAINT fk_destination_spaceport_id
FOREIGN KEY (`destination_spaceport_id`)
REFERENCES `spaceports`(`id`),
`spaceship_id`INT(11),
CONSTRAINT fk_spaceship_id
FOREIGN KEY (`spaceship_id`)
REFERENCES `spaceships`(`id`)
);

CREATE TABLE`travel_cards`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`card_number`CHAR(10) NOT NULL UNIQUE,
`job_during_journey` ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook'),
`colonist_id` INT(11),
CONSTRAINT fk_colonist_id
FOREIGN KEY (`colonist_id`)
REFERENCES `colonists`(`id`),
`journey_id`INT(11),
CONSTRAINT fk_journey_id
FOREIGN KEY (`journey_id`)
REFERENCES `journeys`(`id`)
);

-- 1 

INSERT INTO `travel_cards`(`card_number`,`job_during_journey`, `colonist_id`, `journey_id`)
SELECT
(CASE
WHEN c.`birth_date` > '1980-01-01' 
THEN concat_ws('', year(c.`birth_date`), DAY(c.`birth_date`), substr(c.`ucn`, 1, 4))
ELSE concat_ws('', year(c.`birth_date`), MONTH(c.`birth_date`), substr(c.`ucn`, 7, 10))
END) AS 'card_number',
(CASE
WHEN c.`id` % 2 = 0 THEN 'Pilot'
WHEN c.`id` % 3 = 0 THEN 'Cook'
ELSE 'Engineer'
END) AS 'job_during_journey',
      c.`id`,(SUBSTRING(c.`ucn`, 1,1)) AS 'journey_id'
FROM `colonists` c 
WHERE `id` BETWEEN 96 AND 100;

-- 2

UPDATE `journeys`
SET `purpose`= (
CASE
WHEN `id` % 2 = 0 THEN 'Medical'
WHEN `id` % 3 = 0 THEN 'Technical'
WHEN `id` % 5 = 0 THEN 'Educational'
WHEN `id` % 7 = 0 THEN 'Military'
ELSE `purpose`
END);

-- 3 
DELETE c
FROM `colonists` c
WHERE c.`id` NOT IN(SELECT tc.`colonist_id` FROM `travel_cards` tc);

-- 4 

SELECT `card_number`,`job_during_journey` FROM `travel_cards`
ORDER BY `card_number`;

-- 5 

SELECT `id`, CONCAT(`first_name`,' ',`last_name`)AS 'full_name',
`ucn`
FROM `colonists`
ORDER BY `first_name`,`last_name`,`id`;

-- 6 

SELECT `id`,`journey_start`,`journey_end`
FROM `journeys`
WHERE `purpose` ='Military'
ORDER BY `journey_start`;

-- 7 

SELECT c.`id`,CONCAT(c.`first_name`,' ',c.`last_name`)AS 'full_name'
FROM `colonists`c
JOIN `travel_cards`t ON t.`colonist_id` = c.`id`
WHERE `job_during_journey` = 'Pilot'
ORDER BY `id`;


-- 8 

SELECT COUNT(c.`id`) AS 'count'
FROM `colonists` c
JOIN `travel_cards` t ON t.`colonist_id` = c.`id`
JOIN `journeys` j ON j.`id` = t.`journey_id`
WHERE j.`purpose` = 'Technical';

-- 9 
SELECT sh.`name` AS 'spaceship_name',
sp.`name` AS 'spaceport_name' 
FROM `spaceships`sh
JOIN `journeys`j ON j.`spaceship_id` = sh.`id`
JOIN `spaceports` sp ON sp.`id` = j.`destination_spaceport_id`
ORDER BY sh.`light_speed_rate` DESC LIMIT 1;

-- 10

SELECT `name`,`manufacturer`
FROM `spaceships` s
JOIN `journeys`j ON j.`spaceship_id`= s.`id`
JOIN `travel_cards`t ON t.`journey_id`= j.`id`
JOIN `colonists` c ON c.`id` = t.`colonist_id`
WHERE YEAR(c.birth_date) > YEAR(DATE_SUB('2019-01-01', INTERVAL 30 YEAR))
AND t.`job_during_journey` = 'Pilot'
ORDER BY s.`name`; 

-- 11

SELECT p.`name` AS 'planet_name', s.`name` AS 'spaceport_name'
FROM `planets` p
JOIN `spaceports` s ON s.`planet_id`= p.`id`
JOIN `journeys` j ON j.`destination_spaceport_id`= s.`id`
WHERE j.`purpose`= 'Educational'
ORDER BY `spaceport_name` DESC;

-- 12
SELECT p.`name` AS 'planet_name', COUNT(j.`id`) AS 'journeys_count'
FROM `planets` p
JOIN `spaceports` s ON s.`planet_id`= p.`id`
JOIN `journeys` j ON j.`destination_spaceport_id`= s.`id`
GROUP BY p.`id`
ORDER BY `journeys_count` DESC,`planet_name`;

-- 13

SELECT j.`id`, p.`name` as 'planet_name',
s.`name` as 'spaceport_name',
j.`purpose` as 'journey_purpose'
FROM `planets`p
JOIN `spaceports` s ON s.`planet_id`= p.`id`
JOIN `journeys` j ON j.`destination_spaceport_id`= s.`id`
ORDER BY DATEDIFF(j.`journey_end`, j.`journey_start`)
LIMIT 1;

-- 14 
SELECT tc.`job_during_journey`
FROM`travel_cards` tc
WHERE tc.`journey_id` =  (
  SELECT j.`id`
  FROM `journeys` j
  ORDER BY DATEDIFF(j.`journey_end`, j.`journey_start`) DESC
  LIMIT 1
)
GROUP BY tc.`job_during_journey`
ORDER BY COUNT(tc.`job_during_journey`)
LIMIT 1;


-- 15 

DELIMITER %%
CREATE FUNCTION udf_count_colonists_by_destination_planet (planet_name VARCHAR (30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(*)
FROM `colonists` c
	  JOIN `travel_cards` tc on c.`id` = tc.`colonist_id`
      JOIN `journeys` j on tc.`journey_id` = j.`id`
      JOIN `spaceports` s on j.`destination_spaceport_id` = s.`id`
      JOIN `planets` p on s.`planet_id` = p.`id`
      WHERE p.`name` = planet_name);
END%%

-- 16 

CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50),
light_speed_rate_increse INT(11)) 
BEGIN
if (SELECT COUNT(ss.name) FROM spaceships ss WHERE ss.name = spaceship_name > 0) THEN
      UPDATE spaceships ss
        SET ss.light_speed_rate = ss.light_speed_rate + light_speed_rate_increse
        WHERE name = spaceship_name;
    ELSE
      SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
      ROLLBACK;
    END IF;
END





