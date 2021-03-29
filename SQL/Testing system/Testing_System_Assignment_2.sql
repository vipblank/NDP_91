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

INSERT INTO `Position` (PositionName ) values ('Dev');
INSERT INTO `Position` (PositionName ) values ('Test');
INSERT INTO `Position` (PositionName ) values ('Scrum Master');
INSERT INTO `Position` (PositionName ) values ('PM');

INSERT INTO `Account` (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('tapchicongsan123@gmail.com', 'phuong', 'nguyễn đức phương',  '1', '1', '2020-03-16');
INSERT INTO `Account` (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('bocongthuong123@gmail.com' , 'thanh' , 'phạm thị thanh',     '2', '2',	'2020-04-21');
INSERT INTO `Account` (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('botaichinh123@gmail.com'   , 'nam'  ,  'hoàng mạnh nam', 	  '3', '3', '2020-03-28');
INSERT INTO `Account` (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('bonongnghiep123@gmail.com',  'ngoc'  , 'vũ thị ngọc',		  '4', '4', '2020-07-02');
INSERT INTO `Account` (Email, Username, FullName, DepartmentID, PositionID, CreateDate) values ('bogiaothong123@gmail.com' ,  'hung'  , 'trần mạnh hùng', 	  '5', '1',	'2020-11-07');

INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('muahang', 	  '1', '2020-09-15');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('banhang'	, 	  '2', '2020-10-10');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('ketoan'	, 	  '3', '2020-10-20');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('xuatnhapkhau', '4', '2020-12-18');
INSERT INTO `Group` ( GroupName, CreatorID, CreateDate	) values ('thitruong', 	  '5', '2021-01-20');

INSERT INTO `GroupAccount` ( GroupID, AccountID, JoinDate ) values ('1' , '1', '2020-09-15');
INSERT INTO `GroupAccount` ( GroupID, AccountID, JoinDate ) values ('2' , '2', '2020-10-10');
INSERT INTO `GroupAccount` ( GroupID, AccountID, JoinDate ) values ('3' , '3', '2020-10-20');
INSERT INTO `GroupAccount` ( GroupID, AccountID, JoinDate ) values ('4' , '4', '2020-12-18');
INSERT INTO `GroupAccount` ( GroupID, AccountID, JoinDate ) values ('5' , '5', '2021-01-20');

INSERT INTO `TypeQuestion` ( TypeName ) values ('Essay');
INSERT INTO `TypeQuestion` ( TypeName ) values ('Multiple-Choice');

INSERT INTO `CategoryQuestion` ( CategoryName ) values ('Java');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('.NET');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('SQL');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('Postman');
INSERT INTO `CategoryQuestion` ( CategoryName ) values ('Ruby');

INSERT INTO `Question` ( Content, CategoryID, TypeID, CreatorID, CreateDate	) values ('JAVA là gì',    '1', '1',  '1', '2021-03-28');
INSERT INTO `Question` ( Content, CategoryID, TypeID, CreatorID, CreateDate	) values ('.NET là gì',	   '2', '2',  '2', '2021-03-28');
INSERT INTO `Question` ( Content, CategoryID, TypeID, CreatorID, CreateDate	) values ('SQL là gì',	   '3', '2',  '3', '2021-03-28');
INSERT INTO `Question` ( Content, CategoryID, TypeID, CreatorID, CreateDate	) values ('Postman là gì', '4', '1',  '4', '2021-03-28');
INSERT INTO `Question` ( Content, CategoryID, TypeID, CreatorID, CreateDate	) values ('Ruby là gì',	   '5', '1',  '5', '2021-03-28');

INSERT INTO `Answer` ( Content, QuestionID, isCorrect ) values ('là ngôn ngữ lập trình bậc cao', '1', 1);
INSERT INTO `Answer` ( Content, QuestionID, isCorrect ) values ('là một trang web',				 '2', 0);
INSERT INTO `Answer` ( Content, QuestionID, isCorrect ) values ('là một ngôn ngữ lập trình',	 '3', 1);
INSERT INTO `Answer` ( Content, QuestionID, isCorrect ) values ('là một ngôn ngữ bậc cao',		 '4', 0)	;
INSERT INTO `Answer` ( Content, QuestionID, isCorrect ) values ('là một loại đá quý',			 '5', 0);

INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (1, 'Đề thi Java',		'1',	'5',	'1',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (2, 'Đề thi .NET',		'2',	'5',	'2',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (3, 'Đề thi SQL',		'3',	'5',	'3',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (4, 'Đề thi Postman',	'4',	'5',	'4',	'2021-03-28');
INSERT INTO `Exam` ( `Code`, Title, CategoryID,	Duration, CreatorID, CreateDate	) values (5, 'Đề thi Ruby',		'5',	'5',	'5',	'2021-03-28');

INSERT INTO `ExamQuestion` ( ExamID, QuestionID	)  values ('1',	'1');
INSERT INTO `ExamQuestion` ( ExamID, QuestionID	)  values ('2',	'2');
INSERT INTO `ExamQuestion` ( ExamID, QuestionID	)  values ('3',	'3');
INSERT INTO `ExamQuestion` ( ExamID, QuestionID	)  values ('4',	'4');
INSERT INTO `ExamQuestion` ( ExamID, QuestionID	)  values ('5',	'5');