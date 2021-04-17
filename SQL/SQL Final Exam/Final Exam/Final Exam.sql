DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;

DROP TABLE IF EXISTS `GiangVien`;
CREATE TABLE `GiangVien` (
	MaGV		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    HoTen		VARCHAR(30) NOT NULL,
    Luong		INT UNSIGNED NOT NULL
);

DROP TABLE IF EXISTS `SinhVien`;
CREATE TABLE `SinhVien` (
	MaSV		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    HoTen		VARCHAR(50) NOT NULL,
    NamSinh		DATE NOT NULL,
    QueQuan		VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS `DeTai`;
CREATE TABLE `DeTai` (
	MaDT		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TenDT		VARCHAR(50) NOT NULL,
    KinhPhi		INT UNSIGNED NOT NULL,
    NoiThucTap	VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS `HuongDan`;
CREATE TABLE `HuongDan` (
	ID			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    MaSV		SMALLINT UNSIGNED NOT NULL,
    MaDT		TINYINT UNSIGNED NOT NULL,
    MaGV		SMALLINT UNSIGNED NOT NULL,
    KetQua		TINYINT UNSIGNED NOT NULL,
   CONSTRAINT fk_HuongDan_GiangVien FOREIGN KEY ( MaGV ) REFERENCES `GiangVien`( MaGV ) ,
   CONSTRAINT fk_HuongDan_SinhVien FOREIGN KEY ( MaSV ) REFERENCES `SinhVien`( MaSV ) ,
   CONSTRAINT fk_HuongDan_DeTai FOREIGN KEY ( MaDT ) REFERENCES `DeTai`( MaDT ) 
);

-- Nhập Dữ Liệu

INSERT INTO `thuctap`.`giangvien` (`HoTen`, `Luong`) 
VALUES 						  	  ('GV1', '10000000'),
								  ('GV2', '15000000'),
								  ('GV3', '10000000'),
                                  ('GV4', '15000000'),
                                  ('GV5', '10000000');
 
 INSERT INTO `thuctap`.`sinhvien` (`HoTen`, `NamSinh`, `QueQuan`) 
 VALUES						 ('SinhVien1', '2000-02-03', 'QueQuan1'),
							('SinhVien2', '2000-03-13', 'QueQuan2'),
                            ('SinhVien3', '2000-04-06', 'QueQuan3'),
                            ('SinhVien4', '2000-05-09', 'QueQuan1'),
                            ('SinhVien5', '2000-06-23', 'QueQuan2'),
                            ('SinhVien6', '2000-07-15', 'QueQuan3'),
                            ('SinhVien7', '2000-08-20', 'QueQuan1');
  
INSERT INTO `thuctap`.`detai` (`TenDT`, `KinhPhi`, `NoiThucTap`) 
VALUES						 ('Detai1', '1000000', 'NoiThucTap1'),
							 ('Detai2', '2000000', 'NoiThucTap2'),
							 ('Detai3', '1000000', 'NoiThucTap3'),
						 	 ('Detai4', '3000000', 'NoiThucTap4'),
							 ('Detai5', '2000000', 'NoiThucTap5');
                             
INSERT INTO `thuctap`.`huongdan` (`MaSV`, `MaDT`, `MaGV`, `KetQua`) 
VALUES 								('1',  '1', 	'2', 	'60'),
									('1',  '2', 	'1', 	'70'),
                                    ('2',  '3', 	'3', 	'80'),
                                    ('2',  '4', 	'4', 	'90'),
                                    ('3',  '5', 	'5', 	'60'),
                                    ('3',  '1', 	'1', 	'70'),
                                    ('4',  '2', 	'2', 	'80'),
                                    ('4',  '3', 	'3', 	'90'),
                                    ('5',  '4', 	'4', 	'75'),
                                    ('5',  '5', 	'5', 	'85');
                                    
-- Questions 2 : Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT SV.MaSV, SV.HoTen, HD.MaDT FROM huongdan HD
RIGHT JOIN SinhVien SV ON SV.MaSV = HD.MaSV
WHERE HD.MaSV IS NULL;


-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’ thay tên bằng Detai2
SELECT D.TenDT, count(HD.MaSV) AS SoSV FROM huongdan HD
JOIN detai D ON HD.MaDT = D.MaDT
WHERE TenDT LIKE 'Detai2';

-- Questions 3 : Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: mã số, họ tên và tên đề tài . (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS 
	SELECT SV.MaSV, SV.HoTen, HD.MaDT, 'ChuaCo' AS TenDeTai FROM huongdan HD
	RIGHT JOIN sinhvien SV ON SV.MaSV = HD.MaSV
    WHERE HD.MaDT IS NULL
    UNION
     SELECT SV.MaSV, SV.HoTen, HD.MaDT, DT.TenDT AS TenDeTai FROM huongdan HD
	JOIN sinhvien SV ON SV.MaSV = HD.MaSV
    JOIN detai DT ON DT.MaDT = HD.MaDT;
SELECT * FROM SinhVienInfo;

-- Questions 4 : Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900 thì hiện ra thông báo "năm sinh phải > 1900"
 DROP TRIGGER IF EXISTS Trg_BfinsertSV;
DELIMITER $$
	CREATE TRIGGER Trg_BfinsertSV
    BEFORE INSERT ON `SinhVien`
    FOR EACH ROW
    BEGIN		
		IF (New.NamSinh <= '1900-01-01') THEN
        SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'năm sinh phải > 1900';
		END IF;
    END$$
DELIMITER ;
 INSERT INTO `thuctap`.`sinhvien` (`HoTen`, `NamSinh`, `QueQuan`) VALUES ('SinhVien8', '1899-08-20', 'QueQuan1');  
 
-- Questions 5 : Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
ALTER TABLE huongdan DROP FOREIGN KEY fk_HuongDan_SinhVien;
ALTER TABLE huongdan ADD CONSTRAINT fk_HuongDan_SinhVien FOREIGN KEY (MaSV) REFERENCES SinhVien(MaSV) ON DELETE CASCADE;
