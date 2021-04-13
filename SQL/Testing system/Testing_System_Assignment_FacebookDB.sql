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
   CONSTRAINT fk_Office_National FOREIGN KEY ( NationalID ) REFERENCES `National`( NationalID ) 
);

DROP TABLE IF EXISTS `Staff`;
CREATE TABLE `Staff` (
	StaffID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FirstName	VARCHAR(50),
    LastName	VARCHAR(50),
    Email		VARCHAR(50) UNIQUE KEY,
    OfficeID	TINYINT UNSIGNED,
  CONSTRAINT fk_Staff_Office  FOREIGN KEY ( OfficeID ) REFERENCES `Office`( OfficeID ) 
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
                                    ('Anh7',	 	 '7'),
                                    ('India8',		 '8'),
                                    ('HanQuoc9',	 '9'),
                                    ('ThaiLan10',	 '10');
                                    
INSERT INTO `facebook_db`.`staff` (`FirstName`,  `LastName`, 	      `Email`, 					`OfficeID`) 
VALUES 							('FirstName1',	 'LastName1',	'FirstName1LastName1@gmail.com', 	'1'),
								('FirstName2',	 'LastName2',   'FirstName2LastName2@gmail.com', 	'2'),
                                ('FirstName3',	 'LastName3',	'FirstName3LastName3@gmail.com', 	'3'),
                                ('FirstName4',	 'LastName4', 	'FirstName4LastName4@gmail.com', 	'4'),
                                ('FirstName5',	 'LastName5', 	'FirstName5LastName5@gmail.com', 	'5'),
                                ('FirstName6',	 'LastName6', 	'FirstName6LastName6@gmail.com', 	'6'),
                                ('FirstName7',	 'LastName7', 	'FirstName7LastName7@gmail.com',	'7'),
                                ('FirstName8',	 'LastName8', 	'FirstName8LastName8@gmail.com', 	'1');
                                
INSERT INTO `facebook_db`.`staff` (`FirstName`, `LastName`, `Email`, `OfficeID`) VALUES ('FirstName10', 'LastName10', 'FirstName10LastName10@gmail.com',	'1'	);
INSERT INTO `facebook_db`.`staff` (`FirstName`, `LastName`, `Email`, `OfficeID`) VALUES ('FirstName11', 'LastName11', 'FirstName11LastName11@gmail.com',	'1' );
INSERT INTO `facebook_db`.`staff` (`FirstName`, `LastName`, `Email`, `OfficeID`) VALUES ('FirstName12', 'LastName12', 'FirstName12LastName12@gmail.com',	'1'	);
INSERT INTO `facebook_db`.`staff` (`FirstName`, `LastName`, `Email`, `OfficeID`) VALUES ('FirstName13', 'LastName13', 'FirstName13LastName13@gmail.com',	'1'	);
INSERT INTO `facebook_db`.`staff` (`FirstName`, `LastName`, `Email`, `OfficeID`) VALUES ('FirstName14', 'LastName14', 'FirstName14LastName14@gmail.com',	'1'	);
INSERT INTO `facebook_db`.`staff` (`FirstName`, `LastName`, `Email`, `OfficeID`) VALUES ('FirstName15', 'LastName15', 'FirstName15LastName15@gmail.com',	'1'	);
INSERT INTO `facebook_db`.`staff` (`FirstName`, `LastName`, `Email`, `OfficeID`) VALUES ('FirstName16', 'LastName16', 'FirstName16LastName16@gmail.com',	'1'	);
INSERT INTO `facebook_db`.`staff` (`FirstName`, `LastName`, `Email`, `OfficeID`) VALUES ('FirstName17', 'LastName17', 'FirstName17LastName17@gmail.com',	'1'	);
-- ===================================================

-- Q3 : lấy dữ liệu tất cả nhân viên làm việc tại Việt Nam
SELECT S.*, N.NationalName FROM `staff` S 
INNER JOIN `office` O ON S.OfficeID = O.OfficeID
INNER JOIN `national` N ON N.NationalID = O.NationalID
WHERE N.NationalName LIKE "VietNam";

-- Q4 : Lấy ra ID, FullName, Email, National của mỗi nhân viên.
	SELECT S.StaffID, CONCAT(S.FirstName, S.LastName) AS FullName, S.Email, N.nationalName AS QuocGia FROM office O 
	INNER JOIN staff S ON S.OfficeID = O.OfficeID
	INNER JOIN `national` N ON N.nationalID = O.nationalID;
    
-- Q5 : Lấy ra tên nước mà nhân viên có Email: "FirstName1LastName1@gmail.com" đang làm việc"
SELECT S.StaffID, S.Email, N.nationalName AS d FROM office O 
	INNER JOIN staff S ON S.OfficeID = O.OfficeID
	INNER JOIN `national` N ON N.nationalID = O.nationalID
    WHERE S.email LIKE 'FirstName1LastName1@gmail.com';

-- Q6 : Bạn hãy tìm xem trên hệ thống có quốc gia nào có thông tin trên hệ thống nhưng không có nhân viên nào đang làm việc.  
SELECT S.StaffID, N.NationalName FROM `staff` S 
RIGHT JOIN `office` O ON S.OfficeID = O.OfficeID
RIGHT JOIN `national` N ON O.NationalID = N.NationalID
WHERE S.StaffID IS NULL;

-- Q7 : Thống kê xem trên thế giới có bao nhiêu quốc gia mà FB đang hoạt động sử dụng tiếng Anh làm ngôn ngữ chính.
SELECT LanguageMain, count(NationalName) AS SoNuoc FROM `national` 
WHERE LanguageMain LIKE 'T.Anh';

-- Q8 : Viết lệnh để lấy ra thông tin nhân viên có tên (First_Name) có 9 ký tự, bắt đầu bằng chữ F và kết thúc bằng số 1.
SELECT * FROM Staff
WHERE FirstName LIKE 'F________1';

-- Q9 : Bạn hãy tìm trên hệ thống xem có nhân viên nào đang làm việc nhưng do nhập khi nhập liệu bị lỗi mà nhân viên đó vẫn chưa cho thông tin về trụ sở làm việc(Office).
UPDATE `facebook_db`.`staff` SET `OfficeID` = NULL WHERE (`StaffID` = '7');
UPDATE `facebook_db`.`staff` SET `OfficeID` = NULL WHERE (`StaffID` = '6');
SELECT S.* FROM office O
RIGHT JOIN staff S ON O.OfficeID = S.OfficeID
WHERE S.OfficeID IS NULL ;

-- Q10 : Nhân viên có mã ID =9 hiện tại đã nghỉ việc, bạn hãy xóa thông tin của nhân viên này trên hệ thống.
DELETE FROM staff WHERE staffID = '9';

-- Q11 : Hãy tạo 1 Procedure có đầu vào là tên quốc gia cần xóa thông tin để xóa tất cả các thông tin trên hệ thống liên quan đến quốc gia này và gửi lại cho anh ấy.
DROP PROCEDURE IF EXISTS SP_GetnationalInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetnationalInformation(IN in_NationalName VARCHAR(50))
BEGIN
	DECLARE V_nationalID VARCHAR(50);
	SELECT N.nationalID INTO V_nationalID FROM `national`N WHERE N.nationalName = in_NationalName;
    DELETE FROM staff S WHERE S.OfficeID IN (SELECT o.OfficeID FROM office O WHERE o.NationalID = V_nationalID);
    DELETE FROM office O WHERE o.NationalID = V_nationalID;
	DELETE FROM `national` N
    WHERE N.NationalID = V_nationalID;
END$$
DELIMITER 
CALL SP_GetnationalInformation ('VietNam');

-- Q12 : viết cho anh ấy 1 Function để a ấy có thể lấy dữ liệu này 1 cách nhanh chóng.
	
-- Q13 : Bạn hãy tạo trigger cho table Staff chỉ cho phép insert mỗi quốc gia có tối đa 10.000 nhân viên giúp anh ấy (có thể cấu hình số lượng nhân viên nhỏ hơn vd 10 nhân viên để Test).
DROP TRIGGER IF EXISTS Trg_BfinsertStf;
DELIMITER $$
	CREATE TRIGGER Trg_BfinsertStf
    BEFORE INSERT ON `staff`
    FOR EACH ROW
    BEGIN		
			DECLARE V_countStaffID TINYINT;
            DECLARE V_nationalID TINYINT;
            SELECT O.NationalID INTO V_nationalID FROM `office`O 
			WHERE NEW.OfficeID = O.OfficeID;
			SELECT count(S.staffID) INTO V_countStaffID FROM `staff` S
			JOIN office O ON O.OfficeID = S.OfficeID
            JOIN `national` N ON N.NationalID = O.NationalID
            WHERE V_nationalID = N.nationalID;
            IF (V_countStaffID >'5') THEN
            SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Khong the nhap';
            END IF;
    END$$
DELIMITER ;
INSERT INTO `staff` (`FirstName`, `LastName`, `Email`, `OfficeID`) 
VALUES 		('FirstName17', 'LastName17', 'FirstName17LastName17@gmail.com', '1');

-- Q14 : Bạn hãy viết 1 Procedure để lấy ra tên trụ sở mà có số lượng nhân viên đang làm việc nhiều nhất.
DROP PROCEDURE IF EXISTS SP_GetAddressInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetAddressInformation()
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
CALL SP_GetAddressInformation ();

-- Q15 : Bạn hãy viết 1 Function để khi nhập vào thông tin Email của nhân viên thì sẽ trả ra thông tin đầy đủ của nhân viên đó.
	
-- Q16 : Bạn hãy viết 1 Trigger để khi thực hiện cập nhật thông tin về trụ sở làm việc của nhân viên đó thì hệ thống sẽ tự động lưu lại trụ sở cũ của nhân viên vào 1 bảng khác có tên Log_Office để Mark có thể xem lại khi cần thiết.
	DROP TABLE IF EXISTS `log_office`;
	CREATE TABLE `facebook_db`.`log_office` (
	  `Id` TINYINT AUTO_INCREMENT,
	  `Email` VARCHAR(45) NOT NULL,
	  `OldOfficeName` VARCHAR(50) NOT NULL,
	  `ChageDate` DATETIME NOT NULL,
	  PRIMARY KEY (`Id`));
      
DROP TRIGGER IF EXISTS Trg_BfupdateStf;
DELIMITER $$
	CREATE TRIGGER Trg_BfupdateStf
    AFTER UPDATE ON `staff`
    FOR EACH ROW
    BEGIN		
		DECLARE Address_OLD VARCHAR(50); 
        SELECT O.address INTO Address_OLD FROM office O WHERE O.OfficeID = OLD.OfficeID;
		INSERT INTO `log_office` (`Email`, `OldOfficeName`, `ChageDate`) 
        VALUES 						(OLD.email, Address_OLD, now()); 
    END$$
DELIMITER ;
UPDATE `facebook_db`.`staff` SET `OfficeID` = '5' WHERE (`StaffID` = '14');

-- Q17 : hãy tạo Trigger để ngăn người nhập liệu nhập vào quốc gia thứ 10
DROP TRIGGER IF EXISTS Trg_BfinsertNational;
DELIMITER $$
	CREATE TRIGGER Trg_BfinsertNational
    BEFORE INSERT ON `national`
    FOR EACH ROW
    BEGIN
		DECLARE V_nationalID TINYINT;
		SELECT count(N.nationalID) INTO V_nationalID FROM `national`N;
        IF (V_nationalID >9) THEN
           SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Khong the nhap';
		END IF;
    END$$
DELIMITER ;
INSERT INTO `facebook_db`.`national` (`NationalName`, `LanguageMain`) VALUES ('TayBanNha', 'T.TayBanNha');

-- Q18 : Thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân viên đang làm việc.
SELECT O.nationalID, N.nationalName, count(S.staffID) FROM `office` O
JOIN staff S ON S.officeID = O.officeID
JOIN `national` N ON N.nationalID = O.nationalID
Group BY O.nationalID;

-- Q19 : Viết Procedure để thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân viên đang làm việc, với đầu vào là tên nước.
DROP PROCEDURE IF EXISTS SP_GetStaffInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetStaffInformation(IN in_nationalName VARCHAR(50))
BEGIN
	SELECT N.nationalID, N.nationalName AS tennuoc, count(S.staffID) as SoNV FROM `office` O
	JOIN staff S ON S.officeID = O.officeID
	JOIN `national` N ON N.nationalID = O.nationalID
    WHERE N.nationalName = in_nationalName;
END$$
DELIMITER 
CALL SP_GetStaffInformation ('VietNam');

-- Q20 : Thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu employee đang làm việc.
SELECT O.OfficeID, O.Address, count(S.staffID) FROM office O
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
CALL SP_GetEmployee ('1');

-- Q22 : Viết Procedure để lấy ra tên quốc gia đang có nhiều nhân viên nhất
DROP PROCEDURE IF EXISTS SP_GetStaffInformation;
DELIMITER $$
CREATE PROCEDURE SP_GetNV()
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
CALL SP_GetNV ();

-- Q24 : Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ chuyển về Null
ALTER TABLE Staff DROP FOREIGN KEY fk_Staff_Office;
ALTER TABLE Staff MODIFY COLUMN OfficeID SMALLINT UNSIGNED;
ALTER TABLE Staff ADD CONSTRAINT fk_Staff_Office FOREIGN KEY (OfficeID) REFERENCES Office(OfficeID) ON DELETE SET NULL;
ALTER TABLE Office DROP FOREIGN KEY fk_Office_National;
ALTER TABLE Staff MODIFY COLUMN OfficeID SMALLINT UNSIGNED;
ALTER TABLE Office ADD CONSTRAINT fk_Office_National FOREIGN KEY (NationalID) REFERENCES `National`(NationalID) ON DELETE SET NULL;

-- Q25 : Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ bị xóa hết.
ALTER TABLE Staff DROP FOREIGN KEY fk_Staff_Office;
ALTER TABLE Staff ADD CONSTRAINT fk_Staff_Office FOREIGN KEY (OfficeID) REFERENCES office(OfficeID) ON DELETE CASCADE;
ALTER TABLE Office DROP FOREIGN KEY fk_Office_National;
ALTER TABLE Office ADD CONSTRAINT fk_Office_National FOREIGN KEY (NationalID) REFERENCES `National`(NationalID) ON DELETE CASCADE;

DELETE FROM `facebook_db`.`office` WHERE (`OfficeID` = '3');
DELETE FROM `facebook_db`.`national` WHERE (`NationalID` = '1');

SELECT S.StaffID, CASE 
					WHEN S.Gender = 1 THEN 'Nam'
					WHEN S.Gender = 0 THEN 'Nu'
					WHEN S.Gender IS NULL THEN 'Unknown'
                    END AS Gender
FROM Staff S;