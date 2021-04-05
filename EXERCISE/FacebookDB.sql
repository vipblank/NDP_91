DROP DATABASE IF EXISTS Facebook_DB;
CREATE DATABASE Facebook_DB;
USE Facebook_DB;

DROP TABLE IF EXISTS `National`;
CREATE TABLE `National` (
	NationalID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    NationalName	VARCHAR(30) NOT NULL UNIQUE KEY,
    LanguageMain	VARCHAR(30) NOT NULL 
);

DROP TABLE IF EXISTS `Office`;
CREATE TABLE `Office` (
	OfficeID	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Address		VARCHAR(50) NOT NULL UNIQUE KEY,
    NationalID	TINYINT UNSIGNED,
    FOREIGN KEY ( NationalID ) REFERENCES `National`( NationalID )
);

DROP TABLE IF EXISTS `Staff`;
CREATE TABLE `Staff` (
	StaffID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FirstName	VARCHAR(50) NOT NULL,
    LastName	VARCHAR(50) NOT NULL,
    Email		VARCHAR(50) NOT NULL UNIQUE KEY,
    OfficeID	TINYINT UNSIGNED,
    FOREIGN KEY ( OfficeID ) REFERENCES `Office`( OfficeID )
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
VALUES								('VN1',		 	'1'),
									('My2',			 '2'),
                                    ('Phap3',		 '3'),
                                    ('Nga4',		 '4'),
                                    ('TrungQuoc5',	 '5'),
                                    ('NhatBan6',	 '6'),
                                    ( 'Anh7',		 '7'),
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
                                ('vuvan',	 	'trong', 	'vuvantrong@gmail.com', 		'10');
                                
-- ===================================================

-- Q3 : lấy dữ liệu tất cả nhân viên làm việc tại Việt Nam
SELECT S.*, O.Address FROM `staff` S 
INNER JOIN `office` O ON S.OfficeID = O.OfficeID
GROUP BY O.Address
HAVING Address LIKE "VN1";

-- Q4
SELECT S.StaffID, S.FirstName, S.LastName, S.Email, O.NationalID FROM staff S
JOIN `office` O ON S.OfficeID = O.OfficeID
GROUP BY O.OfficeID