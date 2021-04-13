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

-- Q5 : Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com
	DROP TRIGGER IF EXISTS Trg_BfdeleteEmail;
DELIMITER $$
	CREATE TRIGGER Trg_BfdeleteEmail
    BEFORE DELETE ON `account`
    FOR EACH ROW
    BEGIN		
		DECLARE V_Email VARCHAR(50);
		SET V_Email = 'tranthanhhuyen@gmail.com';
        IF (OLD.Email = V_Email) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Khong the xoa';
            END IF;    
    END$$
DELIMITER ;
DELETE FROM `testingsystem`.`account` WHERE (`Email` = 'tranthanhhuyen@gmail.com');
	
-- Q6 : Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
DROP TRIGGER IF EXISTS Trg_BfinsertACC;
DELIMITER $$
	CREATE TRIGGER Trg_BfinsertACC
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN		
		DECLARE V_departmentID TINYINT;
		 SELECT D.departmentID INTO V_departmentID FROM `department` D
         JOIN `account` A ON A.DepartmentID = D.DepartmentID;
         IF (NEW.DepartmentID IS NULL) THEN 
		 SET D.DepartmentName = Waiting_Room;
         END IF;
    END$$
DELIMITER ;
INSERT INTO `testingsystem`.`account` (`Email`, `Username`, `FullName`, `PositionID`, `CreateDate`) 
VALUES						 ('ngoquangdao@gmail.com', 'dao88', 'nguyen quang dao', '2', '2018-01-18 00:00:00');

-- Q7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 3 answers cho mỗi question, trong đó có tối đa 1 đáp án đúng.
DROP TRIGGER IF EXISTS Trg_BfinsertAS;
DELIMITER $$
	CREATE TRIGGER Trg_BfinsertAS
    BEFORE INSERT ON `answer`
    FOR EACH ROW
    BEGIN		
		DECLARE V_countAS TINYINT;
        DECLARE V_countIS TINYINT;
        SELECT A.QuestionID, count(A.AnswerID) INTO V_countAS FROM answer A
        WHERE A.QuestionID = NEW.QuestionID;
        SELECT count(1) INTO V_countIS FROM answer A
        WHERE A.QuestionID = NEW.QuestionID AND A.isCorrect = NEW.isCorrect;
        IF (V_countAS >3) OR (V_countIS >1)THEN
        SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Xin Kiem Tra Lai';
        END IF;
    END$$
DELIMITER ;

-- Q8 : Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
DROP TRIGGER IF EXISTS Trg_GenderFromInput;
 DELIMITER $$ 
 CREATE TRIGGER Trg_GenderFromInput 
 BEFORE INSERT ON `Account` 
 FOR EACH ROW 
 BEGIN 
 IF NEW.Gender = 'Nam' THEN 
 SET NEW.Gender = 'M';
 ELSEIF NEW.Gender = 'Nu' THEN 
 SET NEW.Gender = 'F'; 
 ELSEIF NEW.Gender = 'Chưa xác định' THEN 
 SET NEW.Gender = 'U'; 
 END IF ; 
 END $$ 
 DELIMITER ;
 
 -- Q9 : Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
 DROP TRIGGER IF EXISTS Trg_CheckBefDelExam; 
 DELIMITER $$ 
 CREATE TRIGGER Trg_CheckBefDelExam 
 BEFORE DELETE ON `exam` 
 FOR EACH ROW 
 BEGIN 
 DECLARE v_CreateDate DATETIME;
 SET v_CreateDate = DATE_SUB(NOW(),INTERVAL 2 DAY);
 IF (OLD.CreateDate > v_CreateDate) THEN 
 SIGNAL SQLSTATE '12345' 
 SET MESSAGE_TEXT = 'Cant Delete This Exam!!'; 
 END IF ; 
 END $$ 
 DELIMITER ;
 
 -- Q10 : Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
 DROP TRIGGER IF EXISTS Trg_CheckBefUpdateQues; 
 DELIMITER $$ 
 CREATE TRIGGER Trg_CheckBefUpdateQues 
 BEFORE UPDATE ON `question` 
 FOR EACH ROW
 BEGIN 
 DECLARE v_CountQuesByID TINYINT;
 SET v_CountQuesByID = -1; 
 SELECT count(1) INTO v_CountQuesByID FROM examquestion ex 
 WHERE ex.QuestionID = NEW.QuestionID; 
 IF (v_CountQuesByID != -1) THEN 
 SIGNAL SQLSTATE '12345' 
 SET MESSAGE_TEXT = 'Cant Update This Question'; 
 END IF ; 
 END $$ 
 DELIMITER ;
 
 DROP TRIGGER IF EXISTS Trg_CheckBefDeleteQues; 
 DELIMITER $$ 
 CREATE TRIGGER Trg_CheckBefDeleteQues 
 BEFORE DELETE ON `question` 
 FOR EACH ROW 
 BEGIN 
 DECLARE v_CountQuesByID TINYINT;
 SET v_CountQuesByID = -1;
 SELECT count(1) INTO v_CountQuesByID FROM examquestion ex
 WHERE ex.QuestionID = OLD.QuestionID; 
 IF (v_CountQuesByID != -1) THEN 
 SIGNAL SQLSTATE '12345' 
 SET MESSAGE_TEXT = 'Cant Delete This Question';
 END IF ; 
 END $$ 
 DELIMITER ;

-- Q12 : Lấy ra thông tin exam trong đó: Duration <= 30 thì sẽ đổi thành giá trị "Short time" 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time" Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT * FROM exam;
 SELECT e.ExamID, e.Code, e.Title ,
 CASE WHEN Duration <= 30 THEN'Short time' 
		WHEN Duration <= 60 THEN 'Medium time' 
ELSE 'Longtime' END AS Duration, e.CreateDate, e.Duration FROM exam e;