package com.VTI.frontend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import com.VTI.ultis.ScannerUltis;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class Main_code {
	public static void main(String[] args) throws IOException {

// 		Hàm này chú ý phải xử lý thêm năm và tháng thì mới ra kết quả chính xác.
		System.out.println("In theo định dạng việt Nam với 2 ngày bất kỳ date1 và date2:");
		Date date1 = new Date(2019 - 1900, 05 - 1, 12);
		Date date2 = new Date();
		System.out.println("In không có định dạng:");
		System.out.println("Date1: " + date1.toString());
		System.out.println("Date2: " + date2.toString());
		System.out.println("In theo định dạng:");
		Locale locale = new Locale("vn", "VN");
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		System.out.println("Date1: " + dateformat.format(date1));
		System.out.println("Date2: " + dateformat.format(date2));
//		In theo định dạng Pháp
		System.out.println("In theo định dạng 1 nước khác:");
//		Locale locale1 = new Locale("fr", "FR");
//		Locale locale1 = new Locale("en", "EN");
		Locale locale1 = new Locale("de", "DE");
		DateFormat dateformat1 = DateFormat.getDateInstance(DateFormat.DEFAULT, locale1);
		System.out.println("Date1: " + dateformat1.format(date1));
		System.out.println("Date2: " + dateformat1.format(date2));

//		Định dạng theo thời gian
		System.out.println("Định dạng theo thời gian: ");
		DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale1);
		System.out.println("Date2: " + timeFormat.format(date2));
//		DateFormat.FULL: trả về 0
//		DateFormat.LONG: trả về 1
		System.out.println("In theo định dạng FULL LONG MEDIUM SHORT");
		DateFormat dateformat2 = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("Date2, DateFormat.FULL: " + dateformat2.format(date2));
		DateFormat dateformat3 = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println("Date2, DateFormat.LONG: " + dateformat3.format(date2));
		DateFormat dateformat4 = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("Date2, DateFormat.MEDIUM: " + dateformat4.format(date2));
		DateFormat dateformat5 = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("Date2, DateFormat.SHORT: " + dateformat5.format(date2));
//		Sử dụng với LocalDate
		System.out.println("Sử dụng khai báo với LocalDate: ");
		LocalDate localDate1 = LocalDate.now();
		LocalDate localDate2 = LocalDate.of(2000, Month.JANUARY, 25);
		System.out.println("In không có định dạng:");
		System.out.println("localDate1: " + localDate1.toString());
		System.out.println("localDate2: " + localDate2.toString());
		System.out.println("In theo định dạng:");
//		System.out.println("localDate1: " + dateformat.format(Date.parse(localDate2.toString())));
//		Chuyển đổi từ LocalDate về Date
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date5 = Date.from(localDate1.atStartOfDay(defaultZoneId).toInstant());
		System.out.println("localDate1: " + dateformat.format(date5));
		System.out.println(
				"localDate2: " + dateformat.format(Date.from(localDate2.atStartOfDay(defaultZoneId).toInstant())));
	}

}
