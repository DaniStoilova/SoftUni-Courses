CREATE DATABASE `softuni_imdb’s`;
USE `softuni_imdb’s`;


-- 1
CREATE TABLE `countries`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE,
`continent` VARCHAR(30) NOT NULL,
`currency` VARCHAR(5) NOT NULL
);

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE `actors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name`VARCHAR(50) NOT NULL,
`last_name`VARCHAR(50) NOT NULL,
`birthdate` DATE NOT NULL,
`height` INT,
`awards` INT,
`country_id` INT NOT NULL,
CONSTRAINT fk
FOREIGN KEY (`country_id`)
REFERENCES `countries`(`id`)
);

CREATE TABLE `movies_additional_info`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`rating` DECIMAL(10,2),
`runtime` INT NOT NULL,
`picture_url` VARCHAR(80) NOT NULL,
`budget` DECIMAL(10,2),
`release_date`DATE NOT NULL,
`has_subtitles` TINYINT(1),
`description` TEXT
);

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(70) NOT NULL UNIQUE,
`country_id` INT NOT NULL,
CONSTRAINT fk_movies
FOREIGN KEY (`country_id`)
REFERENCES `countries`(`id`),
`movie_info_id` INT NOT NULL UNIQUE,
CONSTRAINT fk_movies_info
FOREIGN KEY (`movie_info_id`)
REFERENCES `movies_additional_info`(`id`)
);

CREATE TABLE `movies_actors`(
`movie_id` INT,
CONSTRAINT fk_movies_id
FOREIGN KEY (`movie_id`)
REFERENCES `movies`(`id`),
`actor_id`INT,
CONSTRAINT fk_actor_id
FOREIGN KEY (`actor_id`)
REFERENCES `actors`(`id`)
);

CREATE TABLE `genres_movies`(
`genre_id`INT,
CONSTRAINT fk_genre_id
FOREIGN KEY (`genre_id`)
REFERENCES `genres`(`id`),
`movie_id`INT,
CONSTRAINT fk_movie_id
FOREIGN KEY (`movie_id`)
REFERENCES `movies`(`id`)
);

-- 2 

INSERT INTO `actors` (`first_name`,`last_name`,`birthdate`,`height`,`awards`,`country_id`)
SELECT REVERSE(`first_name`),REVERSE(`last_name`),DATE(`birthdate` - 2),(`height` + 10),
(`country_id`),(3)
FROM `actors`
WHERE `id` <=10;

INSERT INTO actors(first_name, last_name, birthdate, height, awards, country_id)
SELECT (REVERSE(a.first_name)),(REVERSE(a.last_name)),(DATE (a.birthdate - 2)),(a.height + 10),(a.country_id),(3) FROM actors a
WHERE a.id <= 10;

-- 3

UPDATE `movies_additional_info`
SET `runtime` = `runtime` - 10
WHERE `id` BETWEEN 15 AND 25;

-- 4

DELETE c 
FROM `countries` c
LEFT JOIN `movies`m on c.id = m.country_id
WHERE m.country_id IS NULL;


DELETE m
 FROM countries m
          LEFT JOIN movies m2 on m.id = m2.country_id
WHERE m2.country_id IS NULL;
 

-- 5

SELECT `id`,`name`,`continent`,`currency`
FROM `countries`
ORDER BY `currency` DESC,`id`;

-- 6 

SELECT m.`id`, m.`title`,mai.`runtime`,mai.`budget`,mai.`release_date`
FROM `movies` AS m 
JOIN `movies_additional_info` mai ON mai.`id` = m.`id`
WHERE YEAR(mai.`release_date`) BETWEEN 1996 AND 1999
ORDER BY mai.`runtime`, mai.`id` 
LIMIT 20;

-- 7

SELECT CONCAT(`first_name`,' ',`last_name`) AS 'full_name',
CONCAT(REVERSE(`last_name`), CHAR_LENGTH(`last_name`),'@cast.com') AS 'email',
(2022 - YEAR(`birthdate`)) AS 'age', `height`
FROM `actors`AS a
LEFT JOIN `movies_actors` ma on a.`id` = ma.`actor_id`
WHERE ma.`movie_id` IS NULL
ORDER BY `height`;

-- 8 

SELECT `name`, COUNT(m.`country_id`) AS 'movies_count' FROM `countries` AS c
JOIN `movies` AS m ON c.`id` = m.`country_id`
GROUP BY m.`country_id`
HAVING COUNT(m.`country_id`) >= 7
ORDER BY `name` DESC;

-- 9 


SELECT m.`title`,
CASE
WHEN (`rating` <= 4) THEN 'poor'
WHEN (`rating` <= 7) THEN 'good'
ELSE 'excellent'
END AS 
'rating',
IF (`has_subtitles` = 1,'english','-') AS 'subtitles',
mai.`budget` FROM `movies` AS m
JOIN `movies_additional_info` AS mai ON m.`movie_info_id` = mai.`id`
ORDER BY `budget` DESC;

-- 10
DELIMITER $$
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(g.`name`) AS 'history_movies'
FROM `actors` AS a 
JOIN `movies_actors`AS ma ON a.`id`= ma.`actor_id`
JOIN `genres_movies` AS gm ON  gm.`movie_id` = ma.`movie_id`
JOIN `genres` AS g ON g.`id` = gm.`genre_id`
WHERE CONCAT(a.`first_name`,' ',a.`last_name`) = full_name AND g.`name` = 'History'
GROUP BY g.`name`);
END$$

-- 11
CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))
BEGIN
UPDATE `actors` a
        JOIN `movies_actors` ma on a.`id` = ma.`actor_id`
        JOIN `movies` m on m.`id` = ma.`movie_id`
    SET  a.`awards` = a.`awards` + 1
    WHERE m.`title` = movie_title;
END
