-- Q2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"
DROP TRIGGER IF EXISTS Trg_BfinsertDepartment;
DELIMITER $$
	CREATE TRIGGER Trg_BfinsertDepartment
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN		
		IF (New.departmentID = '1') THEN
        SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
		END IF;
    END$$
DELIMITER ;
INSERT INTO `testingsystem`.`account` (`Email`, `Username`, `FullName`, `DepartmentID`, `PositionID`, `CreateDate`) 
VALUES 							('nguyenquangdao@gmail.com', 'dao88', 'nguyen quang dao', '1', '2', '2018-01-18 00:00:00');

-- Q3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS Trg_BfinsertUS;
DELIMITER $$
	CREATE TRIGGER Trg_BfinsertUS
   BEFORE INSERT ON `groupaccount`
    FOR EACH ROW
    BEGIN		
		   DECLARE V_groupID TINYINT;
           SELECT count(GA.groupID) INTO V_groupID FROM `groupaccount` GA
           WHERE GA.groupID = NEW.groupID;
           IF (V_groupID >2) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Khong the nhap';
            END IF;
    END$$
DELIMITER ;
INSERT INTO `testingsystem`.`groupaccount` (`GroupID`, `AccountID`, `JoinDate`) VALUES ('5', '23', '2019-06-02 00:00:00');

-- Q4 : Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS Trg_BfinsertQS;
DELIMITER $$
	CREATE TRIGGER Trg_BfinsertQS
    BEFORE INSERT ON `examquestion`
    FOR EACH ROW
    BEGIN		
		   DECLARE V_QuesID TINYINT;
           SELECT count(EX.QuestionID) INTO V_QuesID FROM examquestion EX
           WHERE EX.ExamID = NEW.ExamID;
           IF (V_QuesID >5) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Khong the thay doi';
            END IF;    
    END$$
DELIMITER ;
INSERT INTO `testingsystem`.`examquestion` (`ExamID`, `QuestionID`) VALUES ('1', '32');

-- Q6 : Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
DROP TRIGGER IF EXISTS Trg_BfinsertDP;
DELIMITER $$
	CREATE TRIGGER Trg_BfinsertDP
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN		
		 DECLARE Waiting_RoomID TINYINT;
		 SELECT D.departmentID INTO Waiting_RoomID FROM `department` D
         WHERE D.departmentName = 'Waiting_Room';
         IF (NEW.DepartmentID IS NULL) THEN 
		 SET NEW.DepartmentID = Waiting_RoomID;
         END IF;
    END$$
DELIMITER ;
INSERT INTO `testingsystem`.`account` (`Email`, `Username`, `FullName`, `PositionID`, `CreateDate`) 
VALUES						 ('ngoquangdao@gmail.com', 'dao88', 'nguyen quang dao', '2', '2018-01-18 00:00:00');

-- Q7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.


