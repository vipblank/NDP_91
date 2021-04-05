-- Q1 : Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT ac.*, de.DepartmentName as chucvu
FROM `account` as ac
JOIN `department` as de ON ac.DepartmentID = de.DepartmentID;
 
 -- Q2 : Viết lệnh để lấy ra thông tin các account được tạo sau ngày 29/01/2019
 SELECT * 
 FROM `account` 
 WHERE CreateDate > '2019-01-29';
 
 -- Q3 : Viết lệnh để lấy ra tất cả các developer
SELECT AC.username, PO.PositionName
FROM `account` as AC
JOIN `position` as PO ON AC.PositionID = PO.PositionID
WHERE PO.PositionName LIKE 'dev';

-- Q4 : Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT de.departmentName as Ten, count(ac.username) as SoNV 
FROM `department`as de
JOIN `account` as ac ON de.DepartmentID = ac.DepartmentID
GROUP BY de.DepartmentID
HAVING count(ac.username) >3;

-- Q5 : Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
WITH CTE_Getexam AS(
	SELECT EX.QuestionID as cauhoi, count(EX.ExamID) as SoLan FROM examquestion EX
	GROUP BY EX.QuestionID)
SELECT Ex.QuestionID as cauhoi, Q.content, count(Ex.ExamID) as SL FROM examquestion Ex 
JOIN question Q ON Q.QuestionID = Ex.QuestionID
GROUP BY Ex.QuestionID
HAVING count(Ex.ExamID) = (SELECT MAX(SoLan) FROM CTE_Getexam); 

-- Q6 : Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
WITH CTE_GetQuestion AS (
	SELECT Q.CategoryID AS cauhoi, count(Q.QuestionID) as socau FROM question Q
	GROUP BY Q.CategoryID)
SELECT Q.CategoryID as loaicauhoi,CA.CategoryName, count(Q.QuestionID) as solandung FROM question Q
INNER JOIN categoryquestion CA ON CA.CategoryID = Q.CategoryID
GROUP BY Q.CategoryID
HAVING count(Q.QuestionID) = (SELECT MAX(socau) FROM CTE_GetQuestion);

-- Q7 : Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT QuestionID as cauhoi, count(examID) AS solan FROM examquestion
GROUP BY QuestionID;

-- Q8 : Lấy ra Question có nhiều câu trả lời nhất
WITH CTE_GET AS (
	SELECT A.QuestionID, count(A.QuestionID) AS SL FROM answer A
	GROUP BY A.QuestionID)
SELECT A.QuestionID, count(A.QuestionID) AS Socautraloi FROM answer A
GROUP BY A.QuestionID
HAVING count(A.QuestionID) = (SELECT MAX(SL) FROM CTE_GET);
	
-- Q9 : Thống kê số lượng account trong mỗi group
SELECT GR.groupID, GA.GroupName, count(GR.accountID) as SL FROM `groupaccount` as GR 
JOIN `account` as AC ON AC.AccountID = GR.AccountID
JOIN `group` AS GA ON GA.GroupID = GR.GroupID
GROUP BY GR.GroupID
HAVING count(GR.accountID);

-- Q10 : Tìm chức vụ có ít người nhất
WITH CTE_GET AS(
	SELECT A.PositionID, count(A.accountID) AS soNV FROM `account` A
	GROUP BY A.PositionID)
SELECT A.PositionID, P.PositionName as Chucvu, count(A.accountID) as SoNV FROM `account` A
INNER JOIN position P ON P.positionID = A.PositionID
GROUP BY A.PositionID
HAVING count(A.accountID) = (SELECT MIN(soNV) FROM CTE_GET);

-- Q11 : Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
CREATE OR REPLACE VIEW VW_thongke AS
SELECT A.AccountID,A.Username,D.departmentName, P.positionName  FROM `account` A
JOIN department D ON D.departmentID = A.departmentID
JOIN position P ON P.positionID = A.positionID;

SELECT TK.positionName, TK.departmentName, count(TK.AccountID) FROM VW_thongke TK
WHERE TK.departmentName LIKE 'Engineering' AND TK.positionName LIKE 'Dev'
UNION
SELECT TK.positionName, TK.departmentName, count(TK.AccountID) FROM VW_thongke TK
WHERE TK.departmentName LIKE 'Engineering' AND TK.positionName LIKE 'Test'
UNION
SELECT TK.positionName, TK.departmentName, count(TK.AccountID) FROM VW_thongke TK
WHERE TK.departmentName LIKE 'Engineering' AND TK.positionName LIKE 'Scrum Master'
UNION
SELECT TK.positionName, TK.departmentName, count(TK.AccountID) FROM VW_thongke TK
WHERE TK.departmentName LIKE 'Engineering' AND TK.positionName LIKE 'PM';

-- Q12 Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT Q.QuestionID,Q.content AS cauhoi,TQ.TypeName AS dangcauhoi, Q.CreatorID AS nguoitao, A.Content AS cautraloi
FROM Question AS Q
JOIN TypeQuestion AS TQ ON Q.TypeID = TQ.TypeID
JOIN Answer AS A ON Q.QuestionID = A.QuestionID;

-- Q13 : Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT Q.TypeID, TP.TypeName AS Loaicauhoi, count(QuestionID) as Socauhoi FROM question Q
INNER JOIN typequestion TP ON TP.TypeID = Q.TypeID
GROUP BY TypeID;

-- Q14 : Lấy ra group không có account nào
SELECT GroupID, count(AccountID) AS `member` FROM groupaccount
GROUP BY GroupID
HAVING count(AccountID) IS NULL;

-- Q16 : Lấy ra question không có answer nào
SELECT * FROM answer A
RIGHT JOIN question Q ON A.QuestionID = Q.QuestionID
GROUP BY A.QuestionID
HAVING answerID IS NULL;

-- Q17 : a) Lấy các account thuộc nhóm thứ 1 - b) Lấy các account thuộc nhóm thứ 2 - c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT accountID FROM groupaccount
WHERE groupID = '1'
UNION
SELECT accountID FROM groupaccount
WHERE groupID = '2';

-- Q18 : a) Lấy các group có lớn hơn 5 thành viên - b) Lấy các group có nhỏ hơn 7 thành viên - c) Ghép 2 kết quả từ câu a) và câu b)
SELECT GroupID, count(AccountID) FROM `groupaccount`
GROUP BY GroupID
HAVING count(AccountID) >'2'
UNION
SELECT GroupID, count(AccountID) FROM `groupaccount`
GROUP BY GroupID
HAVING count(AccountID) <'4'














