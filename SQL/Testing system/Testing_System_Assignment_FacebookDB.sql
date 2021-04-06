DROP DATABASE IF EXISTS Facebook_DB;
CREATE DATABASE Facebook_DB;
USE Facebook_DB;

DROP TABLE IF EXISTS `National`;
CREATE TABLE `National` (
	NationalID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    NationalName	VARCHAR(30),
    LanguageMain	VARCHAR(30)
);

DROP TABLE IF EXISTS `Office`;
CREATE TABLE `Office` (
	OfficeID	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Address		VARCHAR(50),
    NationalID	TINYINT UNSIGNED,
    FOREIGN KEY ( NationalID ) REFERENCES `National`( NationalID ) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Staff`;
CREATE TABLE `Staff` (
	StaffID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FirstName	VARCHAR(50),
    LastName	VARCHAR(50),
    Email		VARCHAR(50) UNIQUE KEY,
    OfficeID	TINYINT UNSIGNED,
    FOREIGN KEY ( OfficeID ) REFERENCES `Office`( OfficeID ) ON DELETE CASCADE
);

-- ===================================================

INSERT INTO `facebook_db`.`national` (`NationalName`, `LanguageMain`) 
VALUES 									('VietNam', 	'T.Viet'),
										('My', 			'T.Anh'),
                                        ('Phap', 		'T.Phap'),
                                        ('Nga', 		'T.Nga'),
                                        ('TrungQuoc', 	'T.TrungQuoc'),
                                        ('NhatBan', 	'T.Nhat'),
                                        ('Anh', 		'T.Anh'),
                                        ('India', 		'T.Anh'),
                                        ('HanQuoc', 	'T.han'),
                                        ('ThaiLan', 	'T.THai');
                                        
INSERT INTO `facebook_db`.`office` ( `Address`, `NationalID`) 
VALUES								('VN1',	 		 '1'),
									('My2',	 		 '2'),
                                    ('Phap3',	 	 '3'),
                                    ('Nga4',		 '4'),
                                    ('TrungQuoc5',	 '5'),
                                    ('NhatBan6',	 '6'),
                                    ( 'Anh7',	 	 '7'),
                                    ('India8',		 '8'),
                                    ( 'HanQuoc9',	 '9'),
                                    ('ThaiLan10',	 '10');
                                    
INSERT INTO `facebook_db`.`staff` (`FirstName`,  `LastName`, 	`Email`, 				`OfficeID`) 
VALUES 							('nguyenduc',	 'phuong', 'nguyenducphuong@gmail.com', 	'1'),
								('vucam',	 	 'nhung',  'vucamnhung@gmail.com', 			'2'),
                                ('lehai',	 	 'yen',		'lehaiyen@gmail.com', 			'3'),
                                ('phamvan',	 	'truong', 	'phamvantruong@gmail.com', 		'4'),
                                ('dangthanh',	 'lam', 	'dangthanhlam@gmail.com', 		'5'),
                                ('levan',		 'nam', 	'levannam@gmail.com', 			'6'),
                                ('nguyenhuong',	 'ly', 		'nguyenhuongly@gmail.com', 		'7'),
                                ('lethi',	 	 'tuyet', 	'lethituyet@gmail.com', 		'8'),
                                ('trantrung',	 'kien', 	'trantrungkien@gmail.com', 		'9'),
                                ('vuvan',	 	'trong', 	'vuvantrong@gmail.com', 		'1');
                                
-- ===================================================

-- Q3 : lấy dữ liệu tất cả nhân viên làm việc tại Việt Nam
SELECT S.*, O.Address FROM `staff` S 
INNER JOIN `office` O ON S.OfficeID = O.OfficeID
GROUP BY O.Address
HAVING Address LIKE "VN1";

-- Q4 : Lấy ra ID, FullName, Email, National của mỗi nhân viên.
CREATE OR REPLACE VIEW nhanvien AS 
	SELECT S.StaffID, S.FirstName, S.LastName, O.nationalID, S.Email FROM Staff S 
	INNER JOIN Office O ON O.OfficeID = S.OfficeID;
    SELECT NV.StaffID, NV.FirstName, NV.LastName, NV.Email, N.NationalName  FROM nhanvien NV
    JOIN `National` N ON N.NationalID = NV.NationalID ;
    
-- Q5 : Lấy ra tên nước mà nhân viên có Email: "daonq@viettel.com.vn" đang làm việc"
SELECT N.NationalName, NV.Email FROM nhanvien NV
JOIN `National` N ON N.NationalID = NV.NationalID
WHERE NV.email LIKE 'daonq@viettel.com.vn';

-- Q6 : Bạn hãy tìm xem trên hệ thống có quốc gia nào có thông tin trên hệ thống nhưng không có nhân viên nào đang làm việc.  
SELECT S.StaffID, S.FirstName, S.LastName, O.Address  FROM office O
RIGHT JOIN staff S ON S.OfficeID = O.OfficeID
GROUP BY O.OfficeID
HAVING S.FirstName IS NULL;

-- Q7 : Thống kê xem trên thế giới có bao nhiêu quốc gia mà FB đang hoạt động sử dụng tiếng Anh làm ngôn ngữ chính.
SELECT N.*, count(N.LanguageMain) FROM `national` N
WHERE N.LanguageMain LIKE 'T.Anh';

-- Q8 : Viết lệnh để lấy ra thông tin nhân viên có tên (First_Name) có 8 ký tự, bắt đầu bằng chữ N và kết thúc bằng chữ C.
SELECT * FROM Staff
WHERE FirstName LIKE 'N%C';

-- Q9 : Bạn hãy tìm trên hệ thống xem có nhân viên nào đang làm việc nhưng do nhập khi nhập liệu bị lỗi mà nhân viên đó vẫn chưa cho thông tin về trụ sở làm việc(Office).
SELECT S.* FROM office O
RIGHT JOIN staff S ON O.OfficeID = S.OfficeID
GRoup BY S.OfficeID
HAVING S.OfficeID IS NULL ;

-- Q10 : Nhân viên có mã ID =9 hiện tại đã nghỉ việc, bạn hãy xóa thông tin của nhân viên này trên hệ thống.
DELETE FROM staff WHERE staffID = '9';

-- Q11 : Hãy tạo 1 Procedure có đầu vào là tên quốc gia cần xóa thông tin để xóa tất cả các thông tin trên hệ thống liên quan đến quốc gia này và gửi lại cho anh ấy.
DROP PROCEDURE IF EXISTS SP_GetnationalInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetnationalInformation(IN in_NationalName VARCHAR(50))
BEGIN
	DELETE FROM `national` 
    WHERE NationalName = in_NationalName;
END$$
DELIMITER 
CALL SP_GetnationalInformation ('VietNam');

-- Q12 : viết cho anh ấy 1 Function để a ấy có thể lấy dữ liệu này 1 cách nhanh chóng.

-- Q13 : Bạn hãy tạo trigger cho table Staff chỉ cho phép insert mỗi quốc gia có tối đa 10.000 nhân viên giúp anh ấy (có thể cấu hình số lượng nhân viên nhỏ hơn vd 11 nhân viên để Test).

-- Q14 : Bạn hãy viết 1 Procedure để lấy ra tên trụ sở mà có số lượng nhân viên đang làm việc nhiều nhất.
DROP PROCEDURE IF EXISTS SP_GetAddressInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetAddressInformation(IN in_Address VARCHAR(50))
BEGIN
	WITH CTE_GetAddress AS (
	SELECT O.Address AS Diachi, count(S.staffID) AS SoNV FROM Office O
	JOIN Staff S ON S.officeID = O.officeID
	GROUP BY O.OfficeID
    )
SELECT O.Address, count(S.staffID) FROM Office O
JOIN Staff S ON S.officeID = O.officeID
GROUP BY O.OfficeID
HAVING count(S.staffID) = (SELECT MAX(SoNV) FROM CTE_GetAddress);
END$$
DELIMITER 
CALL SP_GetAddressInformation ('1');

-- Q15 : Bạn hãy viết 1 Function để khi nhập vào thông tin Email của nhân viên thì sẽ trả ra thông tin đầy đủ của nhân viên đó.

-- Q16 : Bạn hãy viết 1 Trigger để khi thực hiện cập nhật thông tin về trụ sở làm việc của nhân viên đó thì hệ thống sẽ tự động lưu lại trụ sở cũ của nhân viên vào 1 bảng khác có tên Log_Office để Mark có thể xem lại khi cần thiết.

-- Q17 : hãy tạo Trigger để ngăn người nhập liệu nhập vào quốc gia thứ 101

-- Q18 : Thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân viên đang làm việc.
SELECT O.nationalID, N.nationalName, count(S.staffID) FROM `office` O
JOIN staff S ON S.officeID = O.officeID
JOIN `national` N ON N.nationalID = O.nationalID
Group BY O.nationalID;

-- Q19 : Viết Procedure để thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân viên đang làm việc, với đầu vào là tên nước.
SELECT A.AccountID, A.Username, A.FullName, D.DepartmentName, A.Email FROM `account` A
JOIN department D ON D.DepartmentID = A.DepartmentID;

DROP PROCEDURE IF EXISTS SP_GetStaffInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetStaffInformation(IN in_nationalName VARCHAR(50))
BEGIN
	SELECT O.nationalID, N.nationalName AS tennuoc, count(S.staffID) as SoNV FROM `office` O
	JOIN staff S ON S.officeID = O.officeID
	JOIN `national` N ON N.nationalID = O.nationalID
	Group BY N.nationalName
    HAVING N.nationalName LIKE 'in_nationalName';
END$$
DELIMITER 
CALL SP_GetStaffInformation ('My');

-- Q20 : Thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu employee đang làm việc.
select O.OfficeID, O.Address, count(S.staffID) from office O
JOIN staff S ON S.officeID = O.OfficeID
Group BY O.officeID;

-- Q21 : Viết Procedure để thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu employee đang làm việc đầu vào là ID của trụ sở.
DROP PROCEDURE IF EXISTS SP_GetStaffInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetEmployee(IN in_OfficeID TINYINT)
BEGIN
	select O.OfficeID, O.Address, count(S.staffID) from office O
	JOIN staff S ON S.officeID = O.OfficeID
	Group BY O.officeID
    HAVING O.OfficeID = in_OfficeID;
END$$
DELIMITER 
CALL SP_GetEmployee ('3');

-- Q22 : Viết Procedure để lấy ra tên quốc gia đang có nhiều nhân viên nhất
DROP PROCEDURE IF EXISTS SP_GetStaffInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetNV(IN in_nationalName VARCHAR(50))
BEGIN
	WITH CTE_GetStaff AS (
	SELECT O.nationalID, N.nationalName AS tennuoc, count(S.staffID) as SoNV FROM `office` O
	JOIN staff S ON S.officeID = O.officeID
	JOIN `national` N ON N.nationalID = O.nationalID
	Group BY N.nationalName)
SELECT O.nationalID, N.nationalName AS tennuoc,O.Address AS diachi, count(S.staffID) as SoNV FROM `office` O
JOIN staff S ON S.officeID = O.officeID
JOIN `national` N ON N.nationalID = O.nationalID
Group BY N.nationalName 
HAVING count(S.staffID) = (SELECT MAX(SoNV) FROM CTE_GetStaff);
END$$
DELIMITER 
CALL SP_GetNV ('1');

-- Q24 : Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ chuyển về Null
 FOREIGN KEY ( OfficeID ) REFERENCES `Office`( OfficeID ) ON DELETE SET NULL;

-- Q25 : Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ bị xóa hết.
 FOREIGN KEY ( OfficeID ) REFERENCES `Office`( OfficeID ) ON DELETE CASCADE;


