-- Q1 : Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
SELECT A.AccountID, A.Username, A.FullName, D.DepartmentName, A.Email FROM `account` A
JOIN department D ON D.DepartmentID = A.DepartmentID;

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
SELECT GA.GroupID, GR.GroupName, count(GA.AccountID) AS slAccount FROM groupaccount GA
JOIN `group` GR ON GR.groupID = GA.groupID
GROUP BY GA.GroupID 
HAVING count(GA.AccountID)

DROP PROCEDURE IF EXISTS SP_GetAccountInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetAccountInformation(IN in_GrpName VARCHAR(50))
BEGIN
	SELECT GA.GroupID, GR.GroupName, count(GA.AccountID) AS slAccount FROM groupaccount GA
	JOIN `group` GR ON GR.groupID = GA.groupID
	WHERE GR.GroupName = in_GrpName;
END$$
DELIMITER 
CALL SP_GetAccountInformation ('gamer');

-- Q3 : Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
SELECT TypeID, count(QuestionID), CreateDate FROM question
GROUP BY TypeID;



