-- Q2 : lấy ra tất cả các phòng ban
SELECT * 
FROM `department`;

-- Q3 : lấy ra ID phòng ban 'sale'
SELECT departmentID 
FROM `department`
WHERE DepartmentName LIKE 'sale';

-- Q4 : lấy ra thông tin account có fullname dài nhất
SELECT * FROM `account` a 
WHERE length(a.fullname) = (
SELECT MAX(length(a.FullName))FROM `account` a
);

WITH CTE_GetMaxLeng AS (
	SELECT MAX(length(Fullname)) FROM `Account`
)
SELECT 	* FROM 	`Account` 
WHERE 	length(Fullname) = (SELECT * FROM CTE_GetMaxLeng) 
ORDER BY Fullname DESC;

WITH CTE_GetMaxLeng AS (
	SELECT (length(Fullname)) as ABC FROM `Account` 
)
SELECT 	* FROM 	`Account` 
WHERE 	length(Fullname) = (SELECT Max(ABC) FROM CTE_GetMaxLeng) ;

-- Q5 : lấy ra thông tin account có fullname dài nhất và thuộc phòng ban có ID = 3
SELECT * FROM `account` a 
WHERE length(a.fullname) = (
SELECT MAX(length(a.FullName))FROM `account` a ) AND DepartmentID = 1;

-- Q6 : lấy ra tên group đã tham gia trước ngày 28/3/2020
SELECT GroupName 
FROM `group` 
WHERE CreateDate <'2020-3-28';

-- Q7 : lấy ra ID của câu hỏi có >= 2 câu trả lời
SELECT * FROM `answer`;
SELECT questionID AS ID, count(QuestionID) AS SL FROM `answer`
GROUP BY QuestionID 
HAVING count(QuestionID) >= '2';

-- Q8 : lấy ra các mã đề thi có thời gian thi >=15p và tạo trước ngày 30/03/2021
SELECT `code` 
FROM `exam` 
WHERE Duration >= '15' AND CreateDate <'2021-03-30';

-- Q9 : lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `group`;
SELECT GroupName, CreateDate FROM `group`
ORDER BY CreateDate ASC
LIMIT 5;

-- Q10 : đếm số nhân viên thuộc department có ID = 2
SELECT count(AccountID) as SNV FROM `account` WHERE DepartmentID =2;

-- Q11 lấy ra thông tin nhân viên có tên bắt đầu = L và kết thúc = N 
SELECT * 
FROM `account` 
WHERE FullName LIKE 'l%n';

-- Q12 : Xóa tất cả exak được tạo trước ngày 20/12/2019
DELETE FROM `exam` WHERE CreateDate < '2019-12-20' ;

-- Q13 : Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM `question` WHERE content LIKE 'câuhỏi&';

-- Q14 : Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `account` SET fullname = 'Nguyễn Bá Lộc', email = 'loc.nguyenba@bti.com.vn' 
WHERE accountID = 5;

-- Q15 : update account có id = 5 sẽ thuộc group có id = 4
UPDATE `account` SET groupID = 4
WHERE accountID = 5;

-- VD





