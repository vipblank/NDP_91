-- Q1
SELECT ac.*, de.DepartmentName as chucvu
FROM `account` as ac
JOIN `department` as de ON ac.DepartmentID = de.DepartmentID;
 
 -- Q2
 SELECT * 
 FROM `account` 
 WHERE CreateDate > '2019-01-29';
 
 -- Q3
SELECT AC.username, PO.PositionName
FROM `account` as AC
JOIN `position` as PO ON AC.PositionID = PO.PositionID
WHERE PO.PositionName LIKE 'dev';

-- Q4
SELECT de.departmentName as Ten, count(ac.username) as SoNV 
FROM `department`as de
JOIN `account` as ac ON de.DepartmentID = ac.DepartmentID
GROUP BY de.DepartmentID
HAVING count(ac.username) >3;

-- Q5
SELECT EX.questionID, QE.Content as CauHoi, count(Ex.examID) as SL FROM `examquestion` as EX 
JOIN `question` as QE ON QE.QuestionID = Ex.QuestionID
GROUP BY Ex.QuestionID
ORDER BY Count(Ex.examID) DESC;

-- Q6
SELECT C.CategoryName as tieude, count(Q.QuestionID) as sl FROM `categoryquestion` as C
JOIN `question` as Q ON Q.CategoryID = C.CategoryID
GROUP BY C.CategoryID
ORDER BY count(Q.QuestionID) ASC;

-- Q7
SELECT EX.questionID, QE.Content as noidung, count(Ex.examID) as SL FROM `examquestion` as EX 
JOIN `question` as QE ON QE.QuestionID = Ex.QuestionID
GROUP BY Ex.QuestionID

