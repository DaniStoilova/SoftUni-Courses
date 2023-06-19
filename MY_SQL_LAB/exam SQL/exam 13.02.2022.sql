 CREATE DATABASE `online_stores’s`; 
 
 USE `online_stores’s`;
 
 CREATE TABLE `brands`(
 `id`INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(40) NOT NULL UNIQUE
 );

 
 CREATE TABLE `categories`(
 `id` INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(40) NOT NULL UNIQUE
 );
 
 CREATE TABLE `reviews`(
 `id`INT PRIMARY KEY AUTO_INCREMENT,
 `content`TEXT,
 `rating` DECIMAL(10,2) NOT NULL,
 `picture_url` VARCHAR(80) NOT NULL,
 `published_at` DATETIME
 );
 
 CREATE TABLE`products`(
 `id` INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(40) NOT NULL,
 `price` DECIMAL(19,2) NOT NULL,
 `quantity_in_stock` INT,
 `description` TEXT,
 `brand_id` INT NOT NULL,
 CONSTRAINT fk_brand_id
 FOREIGN KEY (`brand_id`)
 REFERENCES `brands`(`id`),
 `category_id`INT NOT NULL,
 CONSTRAINT fk_category_id
 FOREIGN KEY (`category_id`)
 REFERENCES `categories`(`id`),
 `review_id`INT,
 CONSTRAINT fk_review_id
 FOREIGN KEY (`review_id`)
 REFERENCES `reviews`(`id`)
 );
 
 CREATE TABLE `customers`(
 `id`INT PRIMARY KEY AUTO_INCREMENT,
 `first_name` VARCHAR(20) NOT NULL,
 `last_name`VARCHAR(20) NOT NULL,
 `phone` VARCHAR(30) NOT NULL UNIQUE,
 `address` VARCHAR(60),
 `discount_card` BIT(1)
 );
 
 CREATE TABLE `orders`(
 `id`INT PRIMARY KEY AUTO_INCREMENT,
 `order_datetime` DATETIME NOT NULL,
 `customer_id`INT NOT NULL,
 CONSTRAINT fk_customer_id
 FOREIGN KEY (`customer_id`)
 REFERENCES `customers`(`id`)
 );
 
 CREATE TABLE `orders_products`(
 `order_id` INT,
 CONSTRAINT fk_order_id
 FOREIGN KEY (`order_id`)
 REFERENCES `orders`(`id`),
 `product_id` INT,
 CONSTRAINT fk_product_id
 FOREIGN KEY (`product_id`)
 REFERENCES `products`(`id`)
 );
 
 -- 2
 
 INSERT INTO `reviews`(`content`,`picture_url`,`published_at`,`rating`)
 SELECT 
 SUBSTRING(p.`description`,1,15),
 REVERSE(p.`name`),
 DATE('2010/10/10'),
 p.`price`/8
 FROM `products` AS p
 WHERE p.`id` >= 5;
 
-- 3 

UPDATE `products`
SET `quantity_in_stock`= `quantity_in_stock` - 5
WHERE `quantity_in_stock` BETWEEN 60 AND 70;

-- 4

DELETE c FROM `customers` AS c
LEFT JOIN `orders` AS o On o.`customer_id` = c.`id`
WHERE o.`customer_id` IS NULL;

-- 5 

SELECT `id`, `name` FROM
`categories`
ORDER BY `name` DESC;

-- 6

SELECT `id`,`brand_id`,`name`,`quantity_in_stock`
FROM `products`
WHERE `price` > 1000 AND `quantity_in_stock` < 30
ORDER BY `quantity_in_stock`,`id`;

-- 7 
SELECT `id`,`content`,`rating`,`picture_url`,`published_at`
FROM `reviews`
WHERE `content` LIKE 'MY%' AND char_length(`content`) > 61
ORDER BY `rating` DESC;

SELECT *
FROM `reviews`
WHERE `content` LIKE 'MY%' AND char_length(`content`) > 61
ORDER BY `rating` DESC;

-- 8 

SELECT CONCAT(`first_name`,' ',`last_name`) AS 'full_name', `address`,`order_datetime` AS 'order_date'
FROM `customers` AS c
JOIN `orders` AS o ON o.`customer_id` = c.`id`
WHERE YEAR(`order_datetime`) <= 2018
ORDER BY `full_name`DESC;

-- 9 

SELECT COUNT(c.`id`) AS 'items_count', c.`name`, SUM(`quantity_in_stock`) AS 'total_quantity'
FROM `categories` c
JOIN `products` p ON p.`category_id` = c.`id`
GROUP BY c.`id`
ORDER BY `items_count` DESC, `total_quantity`
LIMIT 5;

-- 10 

DELIMITER %%
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(p.`id`) AS 'total_products' FROM `customers`c
JOIN `orders` o ON o.`customer_id` = c.`id`
JOIN `orders_products` op ON op.`order_id` = o.`id`
JOIN `products` p ON p.`id` = op.`product_id`
WHERE `first_name` = name
GROUP BY `first_name`);
END%%

CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(p.`id`) AS 'total_products' FROM `customers`c
JOIN `orders` o ON o.`customer_id` = c.`id`
JOIN `orders_products` op ON op.`order_id` = o.`id`
WHERE `first_name` = name);
END

-- 11
DELIMITER %%
CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
UPDATE `products` p
JOIN `categories` c ON c.`id` = p.`category_id`
JOIN `reviews` r ON r.`id` = p.`review_id`
SET `price` = `price`*0.7 
WHERE r.`rating` < 4 AND c.`name` = category_name;
END%%

UPDATE `products` p
JOIN `categories` c ON c.`id` = p.`category_id`
JOIN `reviews` r ON r.`id` = p.`review_id`
SET `price` = `price`*0.7 
WHERE r.`rating` < 4 AND c.`name` = 'Phones and tablets';










 


