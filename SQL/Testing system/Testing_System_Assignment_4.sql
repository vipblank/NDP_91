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
HAVING count(Ex.examID);

-- Q8
SELECT A.questionID, A.Content as CauHoi, count(A.answerID) as SL FROM `answer`as a 
JOIN `question` as Q ON a.QuestionID = Q.QuestionID
GROUP BY A.QuestionID
ORDER BY Count(A.answerID) DESC
LIMIT 1;

-- Q9
SELECT GR.groupID, count(GR.accountID) as SL FROM `groupaccount` as GR 
JOIN `account` as AC ON AC.AccountID = GR.AccountID
GROUP BY AC.AccountID
HAVING count(GR.accountID)
ORDER BY groupID ASC;

-- Q10
SELECT PositionName, count(a.AccountID) as SNV FROM `position`as p 
JOIN `account` as a ON a.PositionID = p.PositionID
GROUP BY p.PositionID
ORDER BY count(a.AccountID) ASC
LIMIT 1;



