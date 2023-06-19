CREATE DATABASE ruk_database;
USE ruk_database;

CREATE TABLE`branches`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE `employees`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name`VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`started_on` DATE NOT NULL,
`branch_id`INT(11) NOT NULL,
CONSTRAINT fk_branch_id
FOREIGN KEY (`branch_id`)
REFERENCES `branches`(`id`)
);

CREATE TABLE `clients`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`full_name`VARCHAR(50) NOT NULL,
`age`INT(11) NOT NULL
);

CREATE TABLE `employees_clients`(
`employee_id`INT(11),
CONSTRAINT fk_employee_id
FOREIGN KEY (`employee_id`)
REFERENCES `employees`(`id`),
`client_id`INT(11),
CONSTRAINT fk_client_id
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE`bank_accounts`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`account_number` VARCHAR(10) NOT NULL,
`balance` DECIMAL(10,2) NOT NULL,
`client_id`INT(11) NOT NULL UNIQUE,
CONSTRAINT fk_client
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `cards`(
`id`INT(11) PRIMARY KEY AUTO_INCREMENT,
`card_number`VARCHAR(19) NOT NULL,
`card_status`VARCHAR(7) NOT NULL,
`bank_account_id`INT(11) NOT NULL,
CONSTRAINT fk_bank_account_id
FOREIGN KEY (`bank_account_id`)
REFERENCES `bank_accounts`(`id`)
);

-- 2  

INSERT INTO `cards`(`card_number`,`card_status`,`bank_account_id`)
SELECT REVERSE(`full_name`),'Active',c.`id` FROM `clients`c
WHERE c.`id` BETWEEN 191 AND 200;

-- 3 

UPDATE `employees_clients` ec
SET ec.`employee_id` = 
(SELECT ec1.`employee_id` FROM (SELECT * FROM `employees_clients`) AS ec1
 GROUP BY ec1.`employee_id`
 ORDER BY COUNT(ec1.`client_id`) ASC , ec1.`employee_id` ASC
 LIMIT 1)
WHERE ec.`employee_id` = ec.`client_id` ;

-- 4 

DELETE e 
FROM `employees` e 
LEFT JOIN `employees_clients` ec ON ec.`employee_id` = e.`id`
WHERE `client_id` IS NULL;


-- 5 

SELECT `id`,`full_name`
FROM `clients`
ORDER BY `id`;

-- 6 
SELECT `id`,CONCAT(`first_name`,' ',`last_name`) AS 'full_name',
CONCAT('$',`salary`) AS `salary`,`started_on`
FROM `employees`
WHERE `salary` >= 100000 and year(`started_on`) >= 2018
ORDER BY `salary` DESC,`id`;

-- 7 
SELECT c.`id`, 
CONCAT(c.`card_number`,' : ',cl.`full_name`) AS 'card_token' 
FROM `cards` c
JOIN `bank_accounts` ba ON ba.`id` = c.`bank_account_id`
JOIN `clients` cl ON cl.`id` = ba.`client_id`
ORDER BY c.`id`DESC;

-- 8

SELECT CONCAT(`first_name`,' ',`last_name`) AS 'name',
`started_on`,
COUNT(c.`id`) AS 'count_of_clients'
FROM `employees`e
JOIN `employees_clients`ec ON ec.`employee_id`= e.`id`
JOIN `clients`c ON c.`id` = ec.`client_id`
GROUP BY e.`id`
ORDER BY `count_of_clients` DESC, e.`id`
LIMIT 5;

-- 9

SELECT b.`name`,
COUNT(ca.`id`) AS 'count_of_cards'
FROM `branches` b
LEFT JOIN `employees` e ON e.`branch_id`= b.`id`
LEFT JOIN `employees_clients` ec ON ec.`employee_id`= e.`id`
LEFT JOIN `clients` c ON c.`id` = ec.`client_id`
LEFT JOIN `bank_accounts` bc ON bc.`client_id`= c.`id`
LEFT JOIN `cards` ca ON ca.`bank_account_id`= bc.`id`
GROUP BY b.`id`
ORDER BY `count_of_cards` DESC, b.`name` ASC;

-- 10 

DELIMITER %%
CREATE FUNCTION udf_client_cards_count(`name` VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(*)
FROM `clients` c
JOIN `bank_accounts` ba ON ba.`client_id` = c.`id`
JOIN `cards` ca ON ca.`bank_account_id`= ba.`id`
WHERE c.full_name = `name`);
END%%

-- SELECT COUNT(*)
-- FROM `clients` c
-- JOIN `bank_accounts` ba ON ba.`client_id` = c.`id`
-- JOIN `cards` ca ON ca.`bank_account_id`= ba.`id`
-- WHERE c.full_name = 'Baxy David';


-- 11

CREATE PROCEDURE udp_clientinfo(full_name VARCHAR(30)) 
BEGIN
SELECT c.`full_name`,c.`age`,ba.`account_number`,CONCAT('$',ba.`balance`) AS 'balance'
FROM `clients` c
JOIN `bank_accounts` ba ON ba.`client_id`= c.`id`
WHERE c.`full_name` = full_name;
END

































