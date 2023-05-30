-- 1 Find Book Titles

SELECT `title`FROM `books`
WHERE SUBSTRING(`title`,1,3) = 'The'
ORDER BY `id`;

-- 2 Replace Titles

SELECT REPLACE(`title`,'The','***')
FROM `books`
WHERE SUBSTRING(`title`,1,3) = 'The'
ORDER BY `id`;

-- 4 Days Lived

SELECT CONCAT_wS(' ',`first_name`,`last_name`) AS 'Full Name',
TIMESTAMPDIFF(DAY,born,died) AS 'Days Lived'
FROM `authors`;

-- 5 Harry Potter Books

SELECT `title`  
FROM `books`
WHERE `title` LIKE 'Harry Potter%';

-- 3 Sum Cost of All Books

SELECT `cost` FROM `books`;
SELECT SUM(`cost`) FROM `books`;

