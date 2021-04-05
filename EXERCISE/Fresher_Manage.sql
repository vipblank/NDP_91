DROP DATABASE IF EXISTS fresher_manage;
CREATE DATABASE fresher_manage;
USE fresher_manage;

DROP TABLE IF EXISTS `Trainee`;
CREATE TABLE `Trainee`(
	TraineeID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name			VARCHAR(50) NOT NULL UNIQUE KEY,
    BirthDate			DATE NOT NULL,
    Gender				ENUM ('MALE', 'FEMALE', 'UNKNOWN'),
    ETIQ				TINYINT UNSIGNED NOT NULL ,
    ETGmath				TINYINT	UNSIGNED NOT NULL,
    ETEnglish			TINYINT	UNSIGNED NOT NULL,
    TrainingClass		CHAR(10) NOT NULL,
    EvaluationNotes		VARCHAR(30) NOT NULL
);

-- ===================================================
INSERT INTO `fresher_manage`.`trainee` (`Full_Name`, 			`BirthDate`, `Gender`, `ETIQ`, `ETGmath`, `ETEnglish`, `TrainingClass`, `EvaluationNotes`) 
VALUES 									('nguyen duc phuong', 	'1998-03-20', 'MALE', 	'15',	'17', 		'15', 		'VTI002', 		'DHKHTN'),
										('tran thi mai', 		'1999-10-20', 'FEMALE', '16', 	'12', 		'11', 		'VTI001', 		'DHKHTN'),
                                        ('doan phuong ha', 		'1999-03-15', 'FEMALE', '17', 	'14', 		'12', 		'VTI003', 		'DHKTQD'),
                                        ('tran thanh lam',		'2001-08-20', 'MALE', 	'18', 	'15',		'19', 		'VTI002', 		'DHKTQD'),
                                        ('doan van ngoc', 		'1997-03-30', 'MALE', 	'19', 	'16',		'18', 		'VTI001', 		'DHBKHN'),
                                        ('nguyen huong ly', 	'2000-04-10', 'FEMALE', '20', 	'16', 		'14', 		'VTI003', 		'DHBKHN'),
                                        ('nguyen thi bich diep','1999-11-10', 'FEMALE', '14',	'17', 		'14', 		'VTI003', 		'DHGTVT'),
                                        ('tran quang tung', 	'1999-05-29', 'MALE', 	 '12',	'12', 		'14', 		'VTI001', 		'DHGTVT'),
                                        ('tran thi yen', 		'1997-08-27', 'FEMALE',  '13',	'18', 		'14', 		'VTI002', 		'DHKHXH'),
                                        ('lai thi uyen', 		'1998-02-13', 'FEMALE',  '15',	'16', 		'14', 		'VTI001', 		'DHKHXH');
                                        
-- ===================================================

-- Q4
SELECT * FROM `Trainee` WHERE ETIQ >=12 AND ETGmath>=12 AND ETEnglish>=30 ;

-- Q5
SELECT Full_name FROM `Trainee` WHERE full_name LIKE 'D%C';

-- Q6
SELECT * FROM `Trainee` WHERE full_name LIKE "_R%";

-- Q7
SELECT * FROM `trainee`
WHERE length(full_name) = 12 AND full_name LIKE '%N';
	

-- Q8
SELECT DISTINCT Full_name FROM `Trainee`;

-- Q9
SELECT Full_name FROM `Trainee`
ORDER BY full_name ASC;

-- Q10
SELECT * FROM `trainee` tr
WHERE length(tr.full_name) = (
	SELECT MAX(length(tr.full_name)) FROM `trainee` tr
);

-- Q11
SELECT TraineeID, Full_Name, BirthDate FROM `trainee` tr
WHERE length(tr.full_name) = (
	SELECT MAX(length(tr.full_name)) FROM `trainee` tr
    );

-- Q12
SELECT Full_Name, ETIQ, ETGmath, ETEnglish FROM `trainee` tr
WHERE length(tr.full_name) = (SELECT MAX(length(tr.full_name)) FROM `trainee` tr);
    
-- Q13
SELECT *
FROM trainee ORDER BY BirthDate DESC LIMIT 5;

-- Q14
SELECT * FROM `trainee` WHERE (ETIQ + ETGmath) >=30 AND ETIQ>=15 AND ETGmath>=15 AND ETEnglish>=25;

-- Q15
DELETE FROM trainee WHERE TraineeID = 15;

-- Q16
DELETE FROM trainee WHERE (ETIQ + ETGmath) <= 15;

-- Q17
DELETE FROM trainee WHERE (YEAR(CURRENT_TIMESTAMP) - YEAR(BirthDate)) > 30;

-- Q18
UPDATE trainee SET TrainingClass = '3'
WHERE TraineeID = 15;

-- Q19
UPDATE trainee SET Full_Name = 'le van A'AND ETIQ = 10 AND ETGmath = 15 AND ETEnglish = 30
WHERE TraineeID = 15;

-- Q20
SELECT full_name, TrainingClass FROM trainee 
WHERE TrainingClass LIKE 'VTI001';

-- Q21
SELECT full_name, TrainingClass FROM trainee 
WHERE TrainingClass LIKE 'VTI001';

-- Q22
SELECT full_name, TrainingClass FROM trainee 
WHERE TrainingClass LIKE 'VTI001'
UNION
SELECT full_name, TrainingClass FROM trainee 
WHERE TrainingClass LIKE 'VTI003';

-- Q23
SELECT TraineeID, gender FROM trainee WHERE gender LIKE 'male'
union
SELECT TraineeID, gender FROM trainee WHERE gender LIKE 'female'
union
SELECT TraineeID, gender FROM trainee WHERE gender LIKE 'unknown' ;

-- Q24
SELECT TrainingClass, count(traineeID) as HocVien 
FROM trainee 
GROUP BY TrainingClass
HAVING count(traineeID) >2; 

-- Q25
SELECT TrainingClass, count(traineeID) as HocVien 
FROM trainee 
GROUP BY TrainingClass
HAVING count(traineeID) >2; 

-- Q26
SELECT EvaluationNotes as truong, count(traineeID) as SoHV
FROM trainee
GROUP BY EvaluationNotes
HAVING count(traineeID) <2;

-- Q27
SELECT traineeID, Full_name,TrainingClass, EvaluationNotes FROM trainee WHERE TrainingClass LIKE 'VTI001'
UNION
SELECT traineeID, Full_name,TrainingClass, EvaluationNotes FROM trainee WHERE TrainingClass LIKE 'VTI002';



