-- Q1 : Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW VW_nhanviensale AS
SELECT A.AccountID, A.Email, A.Username, D.DepartmentName FROM `account` A
JOIN department D ON A.DepartmentID = D.DepartmentID
WHERE D.DepartmentName LIKE 'sale';
SELECT * FROM VW_nhanviensale;

-- Q2 : Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW accountMAXgroup AS 
WITH CTE_grTG AS (
	SELECT GA.accountID, count(GA.AccountID) AS SL FROM groupaccount GA
	GROUP BY GA.AccountID
)
SELECT GA.AccountID, Email, Username, count(GA.AccountID) AS SoGroupThamGia FROM groupaccount GA
INNER JOIN `account` A ON A.AccountID = GA.AccountID
GROUP BY GA.AccountID
HAVING count(GA.AccountID) = (SELECT MAX(SL) FROM CTE_grTG);
SELECT * FROM accountMAXgroup;

-- Q3 : Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi)
CREATE VIEW cauhoiquadai AS
SELECT Q.QuestionID, length(Q.Content) FROM question Q
WHERE length(Q.Content) >22;
DROP VIEW cauhoiquadai;

-- Q4 : Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW DSpban AS
WITH CTE_Getdep AS(
	SELECT AC.DepartmentID, count(AC.AccountID) AS SoNV FROM `account` AC
	GROUP BY AC.DepartmentID)
SELECT AC.DepartmentID, DepartmentName AS TenPban, count(AC.AccountID) FROM `account` AC
JOIN department D ON D.DepartmentID = AC.DepartmentID
GROUP BY AC.DepartmentID
HAVING count(AC.AccountID) = (SELECT MAX(SoNV) FROM CTE_Getdep);

-- Q5 : Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW DScauhoi AS
SELECT Q.QuestionID, Q.CreatorID, AC.FullName FROM question Q
JOIN `account` AC ON AC.AccountID = Q.CreatorID
GROUP BY Q.QuestionID
HAVING AC.FullName LIKE 'nguyen%';


