-- Q1 : Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS SP_GetAccountInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetAccountInformation(IN in_DepName VARCHAR(50))
BEGIN
	SELECT A.AccountID, A.Username, A.FullName, D.DepartmentName, A.Email FROM `account` A
	JOIN department D ON D.DepartmentID = A.DepartmentID
    WHERE D.DepartmentName = in_DepName;
END$$
DELIMITER 
CALL SP_GetAccountInformation ('sale');

-- Q2 : Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS SP_GetAccountInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetAccountInformation(IN in_GrpName VARCHAR(50))
BEGIN
	SELECT GA.GroupID, GR.GroupName, count(GA.AccountID) AS slAccount FROM groupaccount GA
	JOIN `group` GR ON GR.groupID = GA.groupID
	WHERE GR.GroupName = in_GrpName;
END$$
DELIMITER 
CALL SP_GetAccountInformation ('banhang');

-- Q3 : Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại

-- Q4 : Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS SP_GetTypeID;
DELIMITER $$
CREATE PROCEDURE SP_GetTypeID(OUT out_typeID TINYINT )
BEGIN
WITH CTE_GetID AS(
	SELECT TQ.typeID, count(Q.questionID) as SL FROM question Q
	JOIN typequestion TQ ON TQ.typeID = Q.typeID
	GROUP BY Q.typeID)
SELECT TQ.typeID INTO out_typeID  FROM question Q
JOIN typequestion TQ ON TQ.typeID = Q.typeID
GROUP BY Q.typeID
HAVING count(Q.questionID) = (SELECT MAX(SL) FROM CTE_GetID);
END$$
DELIMITER ;
SET @TypeID = '' ;
CALL SP_GetTypeID(@typeID) ;
SELECT @typeID;

-- Q5 : Sử dụng store ở question 4 để tìm ra tên của type question

-- Q6 : Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào

-- Q7 : 