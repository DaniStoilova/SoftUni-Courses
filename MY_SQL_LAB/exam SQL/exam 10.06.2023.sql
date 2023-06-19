CREATE DATABASE `universities_db`;

USE `universities_db`;

CREATE TABLE `countries`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name`VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `cities`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name`VARCHAR(40) NOT NULL UNIQUE,
`population`INT,
`country_id`INT NOT NULL,
CONSTRAINT fk_country_id
FOREIGN KEY (`country_id`)
REFERENCES `countries`(`id`)
);

CREATE TABLE`universities`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(60) NOT NULL UNIQUE,
`address` VARCHAR(80) NOT NULL UNIQUE,
`tuition_fee`DECIMAL(19,2) NOT NULL,
`number_of_staff` INT,
`city_id`INT ,
CONSTRAINT fk_city_id
FOREIGN KEY (`city_id`)
REFERENCES `cities`(`id`)
);

CREATE TABLE`students`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`first_name`VARCHAR(40) NOT NULL,
`last_name`VARCHAR(40) NOT NULL,
`age`INT,
`phone` VARCHAR(20) NOT NULL UNIQUE,
`email`  VARCHAR(255) NOT NULL UNIQUE,
`is_graduated`TINYINT(1) NOT NULL,
`city_id`INT ,
CONSTRAINT fk_city
FOREIGN KEY (`city_id`)
REFERENCES `cities`(`id`)
);

CREATE TABLE `courses`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
`duration_hours` DECIMAL(19,2),
`start_date` DATE,
`teacher_name` VARCHAR(60) NOT NULL UNIQUE,
`description` TEXT,
`university_id` INT,
CONSTRAINT fk_university_id
FOREIGN KEY (`university_id`)
REFERENCES `universities`(`id`)
);

CREATE TABLE `students_courses`(
`grade`DECIMAL(19,2) NOT NULL,
`student_id`INT NOT NULL,
CONSTRAINT fk_student_id
FOREIGN KEY (`student_id`)
REFERENCES `students`(`id`),
`course_id`INT NOT NULL,
CONSTRAINT fk_course_id
FOREIGN KEY (`course_id`)
REFERENCES `courses`(`id`)
);

-- 2 

INSERT INTO `courses`(`name`,`duration_hours`,`start_date`,`teacher_name`,`description`,`university_id`)
SELECT (CONCAT(c.`teacher_name`,' ','course')),(CHAR_LENGTH(c.`name`) / 10),(DATE(c.`start_date`) + 5),
(REVERSE(c.`teacher_name`)),(CONCAT('Course',' ',c.`teacher_name`,'',REVERSE(c.`description`))),
(DAY(c.`start_date`))
FROM `courses`AS c
WHERE c.`id` <= 5;

--- 3
UPDATE `universities`
SET `tuition_fee` = `tuition_fee`+ 300
WHERE `id` >= 5 AND `id` <= 12;

-- 4 

DELETE u 
FROM `universities` u
WHERE `number_of_staff` IS NULL;

-- 5 

SELECT `id`,`name`,`population`,`country_id`
FROM `cities`
ORDER BY `population` DESC;


-- 6 

SELECT `first_name`,`last_name`,`age`,`phone`,`email`
FROM `students`
WHERE `age`>= 21
ORDER BY `first_name` DESC,
`email`,`id`
LIMIT 10;

-- 7 

SELECT CONCAT(s.`first_name`,' ',s.`last_name`) AS 'full_name',
SUBSTRING(s.`email`,2,10) AS 'username',
REVERSE(s.`phone`) AS 'password'
FROM `students`s
LEFT JOIN `students_courses` sc On sc.`student_id` = s.`id`
WHERE sc.`course_id` IS NULL
ORDER BY `password` DESC;

-- 8 

SELECT COUNT(sc.`course_id`) AS 'students_count',
  (u.`name`) AS 'university_name'
FROM `students` s
JOIN `students_courses` sc ON sc.`student_id` = s.`id`
JOIN `courses` c ON c.`id`= sc.`course_id`
JOIN `universities` u ON u.`id` = c.`university_id`
WHERE sc.`course_id` IS NOT NULL
GROUP BY u.`id`
HAVING `students_count` >= 8
ORDER BY `students_count` DESC,  `university_name` DESC;

-- 9

SELECT u.`name` as 'university_name' , ci.`name` as 'city_name',
u.`address`,
CASE
WHEN (`tuition_fee` < 800) THEN 'cheap'
WHEN (`tuition_fee` >= 800 and `tuition_fee` < 1200) THEN 'normal'
WHEN (`tuition_fee` >= 1200 and `tuition_fee` < 2500) THEN 'high'
ELSE 'expensive'
END 
AS  'price_rank',
 u.`tuition_fee`
FROM `universities` u
JOIN `cities` ci ON ci.`id` = u.`city_id`
ORDER BY `tuition_fee`;

-- 10 

DELIMITER $$
CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN
RETURN (SELECT ROUND(AVG(`grade`),2)
FROM `students_courses` sc
JOIN `courses` c ON c.`id` = sc.`course_id`
JOIN `students` s ON s.`id` = sc.`student_id`
WHERE c.`name` = course_name AND `is_graduated` = 1);
END$$

-- 11

CREATE PROCEDURE udp_graduate_all_students_by_year(year_started INT)
BEGIN
UPDATE `courses` c
JOIN `students_courses` sc ON  sc.`course_id` = c.`id`
JOIN `students` s ON  s.`id` = sc.`student_id`
SET   s.`is_graduated` = TRUE
WHERE YEAR(`start_date`) = year_started;
END

-- SELECT s.`first_name`,s.`last_name`
-- FROM `courses` c
-- JOIN `students_courses` sc ON  sc.`course_id` = c.`id`
-- JOIN `students` s ON  s.`id` = sc.`student_id`
-- WHERE YEAR(`start_date`) = 2017 AND `is_graduated` = 0;

-- UPDATE `courses` c
-- SET `is_graduated` = TRUE
-- JOIN `students_courses` sc ON  sc.`course_id` = c.`id`
-- JOIN `students` s ON  s.`id` = sc.`student_id`
-- WHERE YEAR(`start_date`) = 2017;












