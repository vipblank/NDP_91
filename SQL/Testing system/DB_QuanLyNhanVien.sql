/*============================== CREATE DATABASE ==========================================*/
DROP DATABASE IF EXISTS DB_QuanLyNhanVien;
CREATE DATABASE DB_QuanLyNhanVien;
USE DB_QuanLyNhanVien;

/*============================== CREATE TABLE ==========================================*/
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
	EmployeeID 		MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Fullname 		NVARCHAR(30) NOT NULL,
    Email			VARCHAR(30) NOT NULL UNIQUE KEY,
    `Password`		VARCHAR(12) NOT NULL,
    ProSkill		VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS Manager;
CREATE TABLE Manager(
	ManagerID 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Fullname 		NVARCHAR(50) NOT NULL,
    Email			VARCHAR(50) NOT NULL UNIQUE KEY,
    `Password`		VARCHAR(12) NOT NULL,
    ExplnYear		TINYINT UNSIGNED NOT NULL
);

DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin`(
	AdminID 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Fullname 		NVARCHAR(50) NOT NULL,
    Email			VARCHAR(50) NOT NULL UNIQUE KEY,
    `Password`		VARCHAR(12) NOT NULL
);

DROP TABLE IF EXISTS Project;
CREATE TABLE Project(
	ProjectID 			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProjectName 		VARCHAR(100) NOT NULL,
    ProjectManagerID	SMALLINT UNSIGNED NOT NULL,
    TeamSize			TINYINT	UNSIGNED NOT NULL,
    FOREIGN KEY(ProjectManagerID) REFERENCES Manager(ManagerID)
);

DROP TABLE IF EXISTS ProjectTeam;
CREATE TABLE ProjectTeam(
    ProjectID 		SMALLINT UNSIGNED NOT NULL,
    ManagerID		SMALLINT UNSIGNED NOT NULL,
    EmployeeID		MEDIUMINT UNSIGNED NOT NULL,
    FOREIGN KEY(ManagerID) REFERENCES Manager(ManagerID),
    FOREIGN KEY(EmployeeID) REFERENCES Employee(EmployeeID),
    FOREIGN KEY(ProjectID) REFERENCES Project(ProjectID)
);

/*============================== INSERT ADMIN ==========================================*/
INSERT INTO `db_quanlynhanvien`.`admin` (`Fullname`, `Email`, `Password`) VALUES ('Admin1', 'Admin1@gmail.com', '123456A');
INSERT INTO `db_quanlynhanvien`.`admin` (`Fullname`, `Email`, `Password`) VALUES ('Admin2', 'Admin2@gmail.com', '123456B');

INSERT INTO `db_quanlynhanvien`.`employee` (`Fullname`,   `Email`,      `Password`, `ProSkill`) 
VALUES									  ('employee1', 'employeeMail1', '123456A',   'DEV'),
										  ('employee2', 'employeeMail2', '123456A',   'TEST'),
										  ('employee3', 'employeeMail3', '123456A',   'SQL'),
										  ('employee4', 'employeeMail4', '123456A',   'JAVA'),
										  ('employee5', 'employeeMail5', '123456A',   'TEST'),
										  ('employee6', 'employeeMail6', '123456A',   'SQL'),
										  ('employee7', 'employeeMail7', '123456A',   'JAVA'),
										  ('employee8', 'employeeMail8', '123456A',   'TEST'),
										  ('employee9', 'employeeMail9', '123456A',   'JAVA'),
										  ('employee10', 'employeeMail10', '123456A',  'SQL');
                                          
INSERT INTO `db_quanlynhanvien`.`manager` (`Fullname`, 	 `Email`,     `Password`, `ExplnYear`)
VALUES 									  ('manager1', 'managerMail1', '123456B',    '1'),
										  ('manager2', 'managerMail2', '123456B',    '2'),
										  ('manager3', 'managerMail3', '123456B',    '1'),
                                          ('manager4', 'managerMail4', '123456B',    '2'),
                                          ('manager5', 'managerMail5', '123456B',    '1'),
                                          ('manager6', 'managerMail6', '123456B',    '2'),
                                          ('manager7', 'managerMail7', '123456B',    '1');
                                        
INSERT INTO `db_quanlynhanvien`.`project` (`ProjectName`, `ProjectManagerID`, `TeamSize`) 
VALUES 										('ProjectName1',	'6', 			'4'),
											('ProjectName2', 	'3', 			'5'),
											('ProjectName3', 	'4',			'4'),
											('ProjectName4', 	'5',			'5'),
											('ProjectName5', 	'1',			'4');
                                            
INSERT INTO `db_quanlynhanvien`.`projectteam` (`ProjectID`,`ManagerID`, `EmployeeID`) 
VALUES 											('1', 			'6', 		'1'),
												('1', 			'6',		'2'),
                                                ('1', 			'6', 		'3'),
                                                ('2', 			'3', 		'4'),
                                                ('2', 			'3', 		'5'),
                                                ('2', 			'3', 		'6'),
                                                ('2', 			'3', 		'7'),
                                                ('3', 			'4', 		'8'),
                                                ('3', 			'4', 		'9'),
                                                ('3', 			'4', 		'10'),
                                                ('4', 			'5', 		'1'),
                                                ('4', 			'5', 		'3'),
                                                ('4', 			'5', 		'5'),
                                                ('4', 			'5', 		'7'),
                                                ('5', 			'1', 		'9'),
                                                ('5', 			'1', 		'2'),
                                                ('5', 			'1', 		'4');
