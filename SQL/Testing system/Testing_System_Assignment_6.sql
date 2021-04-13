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
CALL SP_GetAccountInformation ('logistic');

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
DROP PROCEDURE IF EXISTS sp_GetCountTypeInMonth;
 DELIMITER $$ 
 CREATE PROCEDURE sp_GetCountTypeInMonth() 
 BEGIN 
 SELECT tq.TypeName, count(q.TypeID) AS KieuCauHoi FROM question q 
 INNER JOIN typequestion tq ON q.TypeID = tq.TypeID 
 WHERE MONTH(q.CreateDate) = MONTH(now()) AND YEAR(q.CreateDate) = YEAR(now()) 
 GROUP BY q.TypeID; 
 END$$ 
 DELIMITER ;
 Call sp_GetCountTypeInMonth();
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
SELECT * FROM typequestion
WHERE typeID = @typeID;

-- Q6 : Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào

-- Q7 ; 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
DROP PROCEDURE IF EXISTS sp_insertAccount; 
DELIMITER $$ 
CREATE PROCEDURE sp_insertAccount ( IN var_Email VARCHAR(50), IN var_Fullname VARCHAR(50))
 BEGIN 
 DECLARE v_Username VARCHAR(50) DEFAULT SUBSTRING_INDEX(var_Email, '@', 1); 
 DECLARE v_DepartmentID TINYINT UNSIGNED DEFAULT 11; 
 DECLARE v_PositionID TINYINT UNSIGNED DEFAULT 1; 
 DECLARE v_CreateDate DATETIME DEFAULT now();
INSERT INTO `account` (`Email`, `Username`, `FullName`, `DepartmentID`, `PositionID`, `CreateDate`)
 VALUES 			(var_Email, v_Username, var_Fullname, v_DepartmentID, v_PositionID, v_CreateDate);
END$$ 
DELIMITER ;

-- Q8 : Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS sp_getMaxNameQuesFormNameType; 
DELIMITER $$ 
CREATE PROCEDURE sp_getMaxNameQuesFormNameType ( IN var_Choice VARCHAR(50) ) 
BEGIN 
DECLARE v_TypeID TINYINT UNSIGNED; 
SELECT tq.TypeID INTO v_TypeID FROM typequestion tq
 WHERE tq.TypeName = var_Choice; 
 IF var_Choice = 'Essay' THEN 
	WITH CTE_LengContent AS( SELECT length(q.Content) AS leng FROM question q WHERE TypeID = v_TypeID) 
    SELECT * FROM question q WHERE TypeID = v_TypeID AND length(q.Content) = (SELECT MAX(leng) FROM CTE_LengContent) ; 
    ELSEIF var_Choice = 'Multiple-Choice' THEN 
    WITH CTE_LengContent AS( SELECT length(q.Content) AS leng FROM question q WHERE TypeID = v_TypeID) 
    SELECT * FROM question q WHERE TypeID = v_TypeID AND length(q.Content) = (SELECT MAX(leng) FROM CTE_LengContent) ;
END IF;
 END$$ 
 DELIMITER ;
 CALL sp_getMaxNameQuesFormNameType('essay');
 
 -- Q9 : Viết 1 store cho phép người dùng xóa exam dựa vào ID
 DROP PROCEDURE IF EXISTS sp_DeleteExamWithID;
 DELIMITER $$
 CREATE PROCEDURE sp_DeleteExamWithID (IN in_ExamID TINYINT UNSIGNED) 
 BEGIN
 DELETE FROM examquestion WHERE ExamID = in_ExamID;
 DELETE FROM Exam WHERE ExamID = in_ExamID;
 END$$
 DELIMITER ;
 
 -- Q10 : Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa), Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
 DROP PROCEDURE IF EXISTS SP_DeleteExamFrom3Year; 
 DELIMITER $$
 CREATE PROCEDURE SP_DeleteExamFrom3Year() 
 BEGIN
 DECLARE v_ExamID TINYINT UNSIGNED; 
 SELECT e.ExamID INTO v_ExamID FROM exam e 
 WHERE (year(now()) - year(e.CreateDate)) >2;
 CALL sp_DeleteExamWithID(v_ExamID); 
 END$$ 
 DELIMITER ;
 
 -- Q11 : Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc
 DROP PROCEDURE IF EXISTS SP_DelDepFromName; 
 DELIMITER $$ 
 CREATE PROCEDURE SP_DelDepFromName(IN var_DepartmentName VARCHAR(30))
 BEGIN 
 DECLARE v_DepartmentID VARCHAR(30) ;
 SELECT D1.DepartmentID INTO v_DepartmentID FROM department D1 WHERE D1.DepartmentName = var_DepartmentName; 
 UPDATE `account` A SET A.DepartmentID = '11' WHERE A.DepartmentID = v_DepartmentID;
DELETE FROM department d WHERE d.DepartmentName = var_DepartmentName;
 END$$ 
 DELIMITER ;
 
 -- Q12 : Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
 DROP PROCEDURE IF EXISTS sp_CountQuesInMonth; 
 DELIMITER $$ 
 CREATE PROCEDURE sp_CountQuesInMonth() 
 BEGIN
SELECT EachMonthInYear.MONTH, COUNT(QuestionID) AS COUNT
	FROM ( SELECT 1 AS MONTH 
		UNION 
        SELECT 2 AS MONTH 
        UNION 
        SELECT 3 AS MONTH 
        UNION 
        SELECT 4 AS MONTH
        UNION
        SELECT 5 AS MONTH
        UNION
        SELECT 6 AS MONTH 
        UNION
        SELECT 7 AS MONTH 
        UNION
        SELECT 8 AS MONTH
        UNION 
        SELECT 9 AS MONTH 
        UNION
        SELECT 10 AS MONTH
        UNION 
        SELECT 11 AS MONTH 
        UNION 
        SELECT 12 AS MONTH ) AS EachMonthInYear 
 LEFT JOIN Question ON EachMonthInYear.MONTH = MONTH(CreateDate) GROUP BY EachMonthInYear.MONTH ORDER BY EachMonthInYear.MONTH ASC;
 END$$ 
 DELIMITER ;