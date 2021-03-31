-- Q1
SELECT ac.username, de.* 
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


