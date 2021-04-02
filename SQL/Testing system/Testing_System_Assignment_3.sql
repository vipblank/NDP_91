-- Q2
SELECT * 
FROM `department`;

-- Q3
SELECT departmentID 
FROM `department`
WHERE DepartmentName LIKE 'sale';

-- Q4
SELECT * FROM `account` a 
WHERE length(a.fullname) = (
SELECT MAX(length(a.FullName))FROM `account` a
);

-- Q5
SELECT * FROM `account` a 
WHERE length(a.fullname) = (
SELECT MAX(length(a.FullName))FROM `account` a ) AND DepartmentID = 1;

-- Q6
SELECT GroupName 
FROM `group` 
WHERE CreateDate <'2020-3-28';

-- Q7
SELECT * FROM `answer`;
SELECT questionID AS ID, count(QuestionID) AS SL FROM `answer`
GROUP BY QuestionID 
HAVING count(QuestionID) >= '2';

-- Q8
SELECT `code` 
FROM `exam` 
WHERE Duration >= '15' AND CreateDate <'2021-03-30';

-- Q9
SELECT * FROM `group`;
SELECT GroupName, CreateDate FROM `group`
ORDER BY CreateDate ASC
LIMIT 5;

-- Q10
SELECT count(AccountID) as SNV FROM `account` WHERE DepartmentID =2;

-- Q11
SELECT * 
FROM `account` 
WHERE FullName LIKE 'l%n';

-- Q12
DELETE FROM `exam` WHERE CreateDate < '2019-12-20' ;

-- Q13
DELETE FROM `question` WHERE content LIKE 'câuhỏi&';

-- Q14
UPDATE `account` SET fullname = 'Nguyễn Bá Lộc', email = 'loc.nguyenba@bti.com.vn' 
WHERE accountID = 5;


