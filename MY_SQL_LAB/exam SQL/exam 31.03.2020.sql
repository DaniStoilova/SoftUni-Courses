CREATE DATABASE `instd`;
USE `instd`;

CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username`VARCHAR(30) NOT NULL UNIQUE,
`password`VARCHAR(30) NOT NULL,
`email`VARCHAR(50) NOT NULL,
`gender` CHAR(1) NOT NULL,
`age` INT NOT NULL,
`job_title` VARCHAR(40) NOT NULL,
`ip` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`address`VARCHAR(30) NOT NULL,
`town`VARCHAR(30) NOT NULL,
`country`VARCHAR(30) NOT NULL,
`user_id` INT NOT NULL,
CONSTRAINT fk_user_id
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`)
);

CREATE TABLE `photos`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`description` TEXT NOT NULL,
`date`DATETIME NOT NULL,
`views`INT NOT NULL
);

CREATE TABLE `comments`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`comment`VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
`photo_id` INT NOT NULL,
CONSTRAINT fk_photo_id
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)
);

CREATE TABLE `users_photos`(
`user_id` INT NOT NULL,
CONSTRAINT fk_user
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),
`photo_id` INT NOT NULL,
CONSTRAINT fk_photo
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)
);

CREATE TABLE `likes`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`photo_id`INT,
CONSTRAINT fk_ph
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`),
`user_id` INT,
CONSTRAINT fk_us
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`)
);

-- 2

INSERT INTO `addresses`(`address`,`town`,`country`,`user_id`)
SELECT `username`,`password`,`ip`,`age` FROM `users`
WHERE `gender` = 'M';

-- 3 

UPDATE `addresses`
SET `country` = (
CASE
WHEN `country` LIKE 'B%' THEN 'Blocked'
WHEN `country` LIKE 'T%' THEN  'Test' 
WHEN `country` LIKE 'P%' THEN  'In Progress'
ELSE `country`
END);


-- 4

DELETE a
FROM `addresses` a
WHERE `id` / 3;

-- 5

SELECT `username`,`gender`,`age`
FROM `users`
ORDER BY `age` DESC, `username` ASC;

-- 6

SELECT p.`id`,
p.`date` AS 'date_and_time',
p.`description`,
COUNT(c.`comment`) AS 'commentsCount'
FROM `photos` p
JOIN `comments` c ON c.`photo_id` = p.`id`
GROUP BY p.`id`
ORDER BY `commentsCount` DESC, `id` ASC
LIMIT 5;

-- 7 

SELECT CONCAT(u.`id`,' ', u.`username`) AS 'id_username', u.`email`
FROM `users` u 
JOIN `users_photos` up ON up.`user_id` = u.`id`
JOIN `photos` p On p.`id` = `photo_id`
WHERE u.`id` = p.`id`
ORDER BY u.`id`;

-- 8
SELECT p.`id` AS 'photo_id',
COUNT(DISTINCT l.`id`) AS 'likes_count',
COUNT(DISTINCT c.`id`) AS 'comments_count'
FROM `photos`p
LEFT JOIN `likes` l ON l.`photo_id` = p.`id`
LEFT JOIN `comments` c ON c.`photo_id` = p.`id` 
GROUP BY p.`id`
ORDER BY `likes_count` DESC, `comments_count` DESC, `photo_id` ASC;


-- 9 

SELECT CONCAT(SUBSTRING(`description`,1,30),'...') AS 'summary',`date`
FROM `photos`
WHERE DAY(`date`) = 10
ORDER BY `date` DESC;

-- 10 

DELIMITER $$
CREATE FUNCTION udf_users_photos_count(username VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(*)
FROM `users`u
JOIN `users_photos`up ON up.`user_id`= u.`id`
WHERE u.`username` = username
);
END$$

-- 11

CREATE PROCEDURE udp_modify_user (address VARCHAR(30), town VARCHAR(30)) 
BEGIN
UPDATE `users`u
JOIN `addresses` a ON a.`user_id` = u.`id`
SET u.`age` = u.`age`+ 10
WHERE a.`address` = address AND a.`town` = town;
END



UPDATE `users`u
JOIN `addresses` a ON a.`user_id` = u.`id`
SET u.`age` = u.`age`+ 10
WHERE a.`address` = '97 Valley Edge Parkway' AND a.`town` = 'Divinópolis';





