DROP DATABASE IF EXISTS Testingsystem;
CREATE DATABASE Testingsystem;
USE Testingsystem;

DROP TABLE IF EXISTS `Department`;
CREATE TABLE `Department`(
	DepartmentID 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 	VARCHAR(30) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName	ENUM ('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email	 		VARCHAR(50) NOT NULL UNIQUE KEY,
    Username		VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName		NVARCHAR(50) NOT NULL,
    DepartmentID	TINYINT UNSIGNED NOT NULL,
    PositionID		TINYINT UNSIGNED NOT NULL,
    CreateDate		DATETIME DEFAULT NOW(),
    FOREIGN KEY ( PositionID ) REFERENCES `Position`( PositionID ),
    FOREIGN KEY ( DepartmentID ) REFERENCES `Department`( DepartmentID )
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName	VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID	TINYINT UNSIGNED ,
    CreateDate	DATETIME DEFAULT NOW(),
    FOREIGN KEY ( CreatorID ) REFERENCES `Account`( AccountID )
);

DROP TABLE IF EXISTS `GroupAccount`;
CREATE TABLE `GroupAccount`(
	GroupID		TINYINT UNSIGNED NOT NULL,
    AccountID	TINYINT UNSIGNED NOT NULL ,
    JoinDate 	DATETIME DEFAULT NOW(),
    PRIMARY KEY ( GroupID, AccountID ),
    FOREIGN KEY ( GroupID ) REFERENCES `Group`( GroupID ),
    FOREIGN KEY ( AccountID ) REFERENCES `Account`( AccountID )
);

DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE `TypeQuestion`(
	TypeID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 	ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE `CategoryQuestion`(
	CategoryID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName 	NVARCHAR(50) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question`(
	QuestionID	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content		NVARCHAR(100) NOT NULL,
    CategoryID 	TINYINT UNSIGNED NOT NULL ,
    TypeID		TINYINT UNSIGNED NOT NULL,
    CreatorID 	TINYINT UNSIGNED NOT NULL,
    CreateDate 	DATETIME DEFAULT NOW(),
    FOREIGN KEY ( CategoryID ) REFERENCES `CategoryQuestion`( CategoryID ),
    FOREIGN KEY ( TypeID ) REFERENCES `TypeQuestion`( TypeID ),
    FOREIGN KEY ( CreatorID ) REFERENCES `Account`( AccountID )
);

DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer`(
	AnswerID 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content	 	NVARCHAR(100) NOT NULL,
    QuestionID	TINYINT UNSIGNED NOT NULL,
    isCorrect	BIT DEFAULT 1,
    FOREIGN KEY ( QuestionID ) REFERENCES `Question`( QuestionID )
);

DROP TABLE IF EXISTS `Exam`;
CREATE TABLE `Exam`(
	ExamID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` 		CHAR(10) NOT NULL,
    Title 		NVARCHAR(50) NOT NULL,
    CategoryID 	TINYINT UNSIGNED NOT NULl,
    Duration 	TINYINT UNSIGNED NOT NULL,
    CreatorID 	TINYINT UNSIGNED NOT NULL,
    CreateDate	DATETIME DEFAULT NOW(),
    FOREIGN KEY ( CategoryID ) REFERENCES `CategoryQuestion`( CategoryID ),
    FOREIGN KEY ( CreatorID ) REFERENCES `Account`( AccountID )
);

DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE `ExamQuestion`(
	ExamID 		TINYINT UNSIGNED NOT NULL,
    QuestionID 	TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY ( ExamID, QuestionID ),
    FOREIGN KEY ( ExamID ) REFERENCES `Exam`( ExamID ),
    FOREIGN KEY ( QuestionID ) REFERENCES `Question`( QuestionID )
);
-- ===================================================

INSERT INTO `Department` (DepartmentName) values ('sale');
INSERT INTO `Department` (DepartmentName) values ('marketing');
INSERT INTO `Department` (DepartmentName) values ('filenance');
INSERT INTO `Department` (DepartmentName) values ('store');
INSERT INTO `Department` (DepartmentName) values ('logistic');
INSERT INTO `Department` (DepartmentName) values ('Support');
INSERT INTO `Department` (DepartmentName) values ('Services');
INSERT INTO `Department` (DepartmentName) values ('Training');
INSERT INTO `Department` (DepartmentName) values ('Human Resources');
INSERT INTO `Department` (DepartmentName) values ('Engineering');

INSERT INTO `Position` (PositionName ) values ('Dev');
INSERT INTO `Position` (PositionName ) values ('Test');
INSERT INTO `Position` (PositionName ) values ('Scrum Master');
INSERT INTO `Position` (PositionName ) values ('PM');

INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('vucamnhung@gmail.com', 		'nhung83',  'vu cam nhung', 		1, 3, '2017-04-09');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('lehaiyen@gmail.com', 		'yen90', 	'le hai yen', 			3, 2, '2020-09-13');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('phamvantruong@gmail.com', 	'truong85', 'pham van tr', 			9, 2, '2018-01-23');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('dangthanhlam@gmail.com', 	'lam78',	 'dang thanh lam', 		7, 2, '2018-11-30');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('levannam@gmail.com',			'nam88', 	'le van nam', 			3, 4, '2019-06-16');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('nguyenhuongly@gmail.com', 	'ly93',		 'nguyen huong ly',		6, 2, '2019-12-26');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('lethituyet@gmail.com', 		'tuyet92',	 'le thi tuyet', 		5, 2, '2017-08-27');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('trantrungkien@gmail.com',    'kien88', 	'tran trung kien', 		9, 3, '2017-08-08');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('nguyennhungoc@gmail.com', 	'ngoc91', 	'nguyen nhu ngoc',  	9, 4, '2017-09-23');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('vuvantrong@gmail.com',		'trong95',	 'vu van trong', 		10, 4, '2018-10-08');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('dinhvanmanh@gmail.com',		'manh85',	 'dinh van manh',	 	7, 3, '2021-01-02');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('nguyenhuongngoc@gmail.com',	'ngoc84', 	'nguyen huong ngoc', 	3, 4, '2018-08-13');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('lethihuyentrang@gmail.com', 	'trang91', 	'le thi huyen trang', 	1, 4, '2017-09-21');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('leminhdung@gmail.com', 		'dung82', 	'le minh dung', 	 	3, 3, '2017-08-12');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('caovansang@gmail.com', 		'sang89', 	'cao van sang',			2, 3, '2020-11-08');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('dinhvannghia@gmail.com',		'nghia85',  'dinh van nghia', 	 	3, 1, '2020-04-30');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('vuhoainam@gmail.com',		 'nam91', 	'vu hoai nam', 		 	3, 3, '2019-08-28');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('tranminhduc@gmail.com', 		'duc89', 	'tran minh duc', 	 	2, 4, '2017-10-25');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('tranvanchau@gmail.com', 		'chau86',   'tran van chau', 	 	3, 4, '2020-03-19');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('vumanhtung.gmail.com', 		'tung85', 	'vu manh tung', 	 	6, 1, '2020-10-17');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('ngobakha@gmail.com', 		'kha92',	 'ngo ba kha', 		 	8, 1, '2018-03-21');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('nguyenhaichau@gmail.com', 	'chau94',	 'nguyen hai chau',  	10, 2, '2017-12-22');
INSERT INTO account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('tranthanhhuyen@gmail.com', 'huyen85', 'tran thanh huyen', 		10, 4, '2018-01-18');


INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('muahang', 	  '1', '2020-09-15');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('banhang'	, 	  '2', '2020-10-10');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('ketoan'	, 	  '3', '2020-10-20');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('xuatnhapkhau', '4', '2020-12-18');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('thitruong', 	  '5', '2021-01-20');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('designer' , 	  '6' ,'2020-04-06');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('development' , '1' ,'2020-03-07');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('management' ,  '8' ,'2020-04-08');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('gamer', 	  	  '5', '2021-01-20');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('photoshop', 	  '5', '2021-01-20');

INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (1 , 1, '2020-09-15');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (2 , 2, '2020-10-10');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (3 , 3, '2020-10-20');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (4 , 4, '2020-12-18');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (5 , 5, '2021-01-20');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (7, 15 , '2020-10-08');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (8, 11 , '2019-01-27');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (6, 19 , '2019-05-07');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (7, 22 , '2020-06-29');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (5, 14 , '2019-12-26');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (2, 13 , '2019-10-10');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (10, 16 , '2019-12-09');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (5, 10 , '2019-09-26');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (10, 7 , '2020-07-26');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (10, 22 , '2019-06-02');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (4, 18 , '2019-06-07');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (6, 14 , '2020-12-11');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (6, 20 , '2019-03-28');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (8, 21 , '2019-10-06');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (9, 23 , '2018-12-14');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (3, 2 , '2019-12-12');
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) values (8, 4 , '2021-01-20');


INSERT INTO `TypeQuestion` ( TypeName ) values ('Essay');
INSERT INTO `TypeQuestion` ( TypeName ) values ('Multiple-Choice');

INSERT INTO `CategoryQuestion` ( CategoryName ) values ('Java');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('.NET');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('SQL');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('Postman');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('Python');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('C++');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('PHP');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('ASP.NET');

insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 3642 eJD', 5, 1, 11, '2020-03-12');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 3019 iSY', 1, 2, 8, '2020-09-20');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 4860 k6T', 2, 2, 12, '2020-10-01');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 6896 rPU', 6, 2, 10, '2020-10-29');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 8823 cwX', 8, 2, 5, '2020-01-19');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 8430 bD5', 7, 1, 2, '2020-09-15');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 9538 sjU', 2, 1, 14, '2020-06-15');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 8934 oJL', 3, 2, 17, '2020-11-18');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 3505 ppI', 4, 1, 16, '2020-07-11');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 7641 zR2', 2, 2, 15, '2020-07-15');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 3328 sMB', 4, 2, 17, '2020-08-01');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 7404 kV6', 6, 2, 23, '2020-10-23');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 6939 sdF', 3, 1, 17, '2020-03-17');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 3233 fnX', 4, 2, 14, '2020-11-11');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 3830 iG2', 8, 2, 19, '2020-02-21');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 4997 vDW', 2, 1, 8, '2020-12-26');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 7836 yVR', 8, 1, 11, '2020-05-25');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 8287 tiW', 7, 1, 20, '2020-06-18');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 9420 eg2', 5, 1, 22, '2020-01-07');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 5208 yi6', 5, 2, 22, '2020-12-15');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 3565 z66', 1, 2, 7, '2020-09-10');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 0804 blJ', 6, 2, 21, '2020-10-05');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 6741 sPN', 7, 1, 19, '2020-06-24');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 5280 kX8', 2, 1, 15, '2020-06-20');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 2803 yaS', 7, 2, 10, '2020-08-19');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 1329 kON', 3, 1, 16, '2020-02-11');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 0133 np5', 2, 2, 12, '2020-12-13');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 2812 uE1', 5, 2, 12, '2020-06-02');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 5574 ndU', 4, 1, 3, '2020-03-25');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 8625 oGT', 4, 2, 21, '2020-09-05');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 2818 kJZ', 4, 2, 14, '2020-02-03');
insert into Question (Content, CategoryID, TypeID, CreatorID, CreateDate) values ('Question VTI 4138 jp1', 8, 1, 6, '2020-07-28');


INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1689', 1, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1027', 1, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4825', 2, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5115', 2, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 9582', 3, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8527', 3, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 6529', 4, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 9137', 4, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3510', 5, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4111', 5, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1323', 6, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 6141', 6, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8454', 7, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 9932', 7, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7723', 8, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1167', 8, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 9553', 9, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5702', 9, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 2261', 10, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 9918', 10, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8863', 11, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8005', 11, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4603', 12, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8584', 12, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 0371', 13, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7259', 13, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4285', 14, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7590', 14, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 6891', 15, 1);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4590', 15, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 6183', 16, 0);
INSERT INTO `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 9747', 16, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3983', 17, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 9652', 17, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 0967', 18, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 2724', 18, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5692', 19, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4594', 19, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5394', 20, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7462', 20, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7208', 21, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 9156', 21, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3823', 22, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5701', 23, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4470', 23, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 6822', 24, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4587', 24, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8288', 25, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5489', 25, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3292', 26, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3552', 26, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 0366', 27, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8035', 27, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4394', 28, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1309', 28, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5933', 29, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3965', 29, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5903', 30, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5308', 30, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1739', 31, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1363', 31, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5311', 32, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3304', 32, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7026', 1, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8459', 2, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3884', 3, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 0726', 4, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3786', 5, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 6614', 6, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1093', 7, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7742', 8, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1955', 9, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1186', 10, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 9951', 11, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4832', 12, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4416', 13, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 2841', 14, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 6639', 15, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7437', 16, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4428', 17, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 2747', 18, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8022', 19, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7479', 20, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 7828', 21, 0);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 0755', 22, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 4141', 23, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5704', 24, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 3209', 25, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 8146', 26, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 6359', 27, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 0988', 28, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5992', 29, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 6113', 30, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 5098', 31, 1);
insert into `Answer` (Content, QuestionID, isCorrect) values ('Answers VTI 1898', 32, 0);

INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (1, 'Đề thi Java',		'1',	'30',	'1',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (2, 'Đề thi .NET',		'2',	'15',	'2',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (3, 'Đề thi SQL',		'3',	'15',	'3',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (4, 'Đề thi Postman',	'4',	'15',	'4',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (5, 'Đề thi Python',	'5',	'30',	'6',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (6, 'Đề thi C++',		'6',	'30',	'7',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (7, 'Đề thi PHP',		'7',	'30',	'8',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (8, 'Đề thi ASP.NET',	'8',	'15',	'9',	'2021-03-28');


insert into ExamQuestion (ExamID, QuestionID) values (1, 1);
insert into ExamQuestion (ExamID, QuestionID) values (1, 2);
insert into ExamQuestion (ExamID, QuestionID) values (1, 3);
insert into ExamQuestion (ExamID, QuestionID) values (1, 4);
insert into ExamQuestion (ExamID, QuestionID) values (1, 5);
insert into ExamQuestion (ExamID, QuestionID) values (1, 6);
insert into ExamQuestion (ExamID, QuestionID) values (1, 7);
insert into ExamQuestion (ExamID, QuestionID) values (1, 8);
insert into ExamQuestion (ExamID, QuestionID) values (1, 9);
insert into ExamQuestion (ExamID, QuestionID) values (1, 10);
insert into ExamQuestion (ExamID, QuestionID) values (2, 2);
insert into ExamQuestion (ExamID, QuestionID) values (2, 3);
insert into ExamQuestion (ExamID, QuestionID) values (2, 4);
insert into ExamQuestion (ExamID, QuestionID) values (2, 5);
insert into ExamQuestion (ExamID, QuestionID) values (2, 6);
insert into ExamQuestion (ExamID, QuestionID) values (2, 7);
insert into ExamQuestion (ExamID, QuestionID) values (2, 8);
insert into ExamQuestion (ExamID, QuestionID) values (2, 9);
insert into ExamQuestion (ExamID, QuestionID) values (2, 10);
insert into ExamQuestion (ExamID, QuestionID) values (2, 11);
insert into ExamQuestion (ExamID, QuestionID) values (3, 12);
insert into ExamQuestion (ExamID, QuestionID) values (3, 13);
insert into ExamQuestion (ExamID, QuestionID) values (3, 14);
insert into ExamQuestion (ExamID, QuestionID) values (3, 15);
insert into ExamQuestion (ExamID, QuestionID) values (3, 16);
insert into ExamQuestion (ExamID, QuestionID) values (3, 17);
insert into ExamQuestion (ExamID, QuestionID) values (3, 18);
insert into ExamQuestion (ExamID, QuestionID) values (3, 19);
insert into ExamQuestion (ExamID, QuestionID) values (3, 20);
insert into ExamQuestion (ExamID, QuestionID) values (3, 21);
insert into ExamQuestion (ExamID, QuestionID) values (4, 22);
insert into ExamQuestion (ExamID, QuestionID) values (4, 23);
insert into ExamQuestion (ExamID, QuestionID) values (4, 24);
insert into ExamQuestion (ExamID, QuestionID) values (4, 25);
insert into ExamQuestion (ExamID, QuestionID) values (4, 26);
insert into ExamQuestion (ExamID, QuestionID) values (4, 27);
insert into ExamQuestion (ExamID, QuestionID) values (4, 28);
insert into ExamQuestion (ExamID, QuestionID) values (4, 29);
insert into ExamQuestion (ExamID, QuestionID) values (4, 30);
insert into ExamQuestion (ExamID, QuestionID) values (4, 31);
insert into ExamQuestion (ExamID, QuestionID) values (5, 32);
insert into ExamQuestion (ExamID, QuestionID) values (5, 2);
insert into ExamQuestion (ExamID, QuestionID) values (5, 1);
insert into ExamQuestion (ExamID, QuestionID) values (5, 3);
insert into ExamQuestion (ExamID, QuestionID) values (5, 4);
insert into ExamQuestion (ExamID, QuestionID) values (5, 5);
insert into ExamQuestion (ExamID, QuestionID) values (5, 7);
insert into ExamQuestion (ExamID, QuestionID) values (5, 6);
insert into ExamQuestion (ExamID, QuestionID) values (5, 8);
insert into ExamQuestion (ExamID, QuestionID) values (5, 9);
insert into ExamQuestion (ExamID, QuestionID) values (6, 10);
insert into ExamQuestion (ExamID, QuestionID) values (6, 11);
insert into ExamQuestion (ExamID, QuestionID) values (6, 12);
insert into ExamQuestion (ExamID, QuestionID) values (6, 13);
insert into ExamQuestion (ExamID, QuestionID) values (6, 14);
insert into ExamQuestion (ExamID, QuestionID) values (6, 15);
insert into ExamQuestion (ExamID, QuestionID) values (6, 16);
insert into ExamQuestion (ExamID, QuestionID) values (6, 17);
insert into ExamQuestion (ExamID, QuestionID) values (6, 18);
insert into ExamQuestion (ExamID, QuestionID) values (6, 19);
insert into ExamQuestion (ExamID, QuestionID) values (7, 20);
insert into ExamQuestion (ExamID, QuestionID) values (7, 21);
insert into ExamQuestion (ExamID, QuestionID) values (7, 22);
insert into ExamQuestion (ExamID, QuestionID) values (7, 23);
insert into ExamQuestion (ExamID, QuestionID) values (7, 24);
insert into ExamQuestion (ExamID, QuestionID) values (7, 25);
insert into ExamQuestion (ExamID, QuestionID) values (7, 26);
insert into ExamQuestion (ExamID, QuestionID) values (7, 27);
insert into ExamQuestion (ExamID, QuestionID) values (7, 28);
insert into ExamQuestion (ExamID, QuestionID) values (7, 29);
insert into ExamQuestion (ExamID, QuestionID) values (8, 30);
insert into ExamQuestion (ExamID, QuestionID) values (8, 31);
insert into ExamQuestion (ExamID, QuestionID) values (8, 32);
insert into ExamQuestion (ExamID, QuestionID) values (8, 1);
insert into ExamQuestion (ExamID, QuestionID) values (8, 2);
insert into ExamQuestion (ExamID, QuestionID) values (8, 3);
insert into ExamQuestion (ExamID, QuestionID) values (8, 4);
insert into ExamQuestion (ExamID, QuestionID) values (8, 5);
insert into ExamQuestion (ExamID, QuestionID) values (8, 6);
insert into ExamQuestion (ExamID, QuestionID) values (8, 7);
