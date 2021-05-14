package com.VTI.frontend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import com.VTI.ultis.ScannerUltis;

public class Main_code {
	public static void main(String[] args) throws IOException {
			File file = new File("C:\\Users\\onii-chan\\Desktop\\");
			System.out.println(file.getFreeSpace());
//			if (file.exists()) {
//				System.out.println("file đã tồn tại");
//			}else {
//				System.out.println("file chưa tồn tại");		
//			}
//			if (file.isDirectory()) {
//				System.out.println("đường dẫn là 1 thư mục");
//		}else {
//			System.out.println("đường dẫn là file");
//		}
//			System.out.println(file.createNewFile());
//			System.out.println(file.delete());
//			for (File filename : file.listFiles()) {
//				System.out.println(filename);
//			}		
	
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\onii-chan\\Desktop\\text1.txt");
			byte[] b = new byte[1024];
			int length = fileInputStream.read(b);
			while (length > -1) {
				String content = new String(b,0,length);
				System.out.println(content);			
				length = fileInputStream.read(b);
			}
//			String content = "Sáng hôm đó, núi Phú Sĩ phủ một màu đen. Cho tới hôm qua, vẫn còn là một núi Phú Sĩ trắng xóa,như được bao phủ bởi bê tông, vậy mà chỉ qua một đêm đã bị nhuộm thành những bậc thang cuốn màu đen. Có lẽ đó là dấu hiệu bắt đầu mùa mưa, mùa hè đã tới.\r\n" + 
//					"“ Độ dốc đã gây ra ảnh hưởng này “. Ngồi trên bờ biển, vị giáo sư vừa nhìn về hướng núi Phú Sĩ vừa nói. “ thế giới cấu trúc gien di truyền “ được mô tả là hình thành với hình dáng của chiếc thang cuốn nằm ở nơi có độ dốc nhất định. Tuy nhiên, nếu những cơn mưa kéo dài nó sẽ thành hình dáng như một mái nhà bê tông. Ở núi Phú Sĩ, thời tiết giữa đỉnh núi và chân núi khác nhau, những tầng thang cuốn và bê tông đó lại đan xen vào nhau, trở thành một cấu trúc hỗn hợp như là bột bánh vậy. Đó chính là nguyên lý của núi Phú Sĩ trắng và núi Phú Sĩ đen.\r\n" + 
//					"“ Ra vậy “. Mitsushima Hiroto bày tỏ sự đồng tình. Anh chàng vốn cũng chẳng hiểu lắm những gì mà vị giáo sư vừa nói, nhưng đây lại là một trong những công việc của anh – làm bạn với ông giáo sư già cô độc này. Việc lão nhân được gọi là “ giáo sư “ bị chứng suy giảm trí nhớ này xuất hiện ở địa tầng thứ 99 là việc xảy ra từ 20 năm về trước.  Người đã phát hiện ra vị giáo sư ngã quay ra dưới chân cầu thang cuốn như một tấm giẻ lau chính là anh chàng Hiroto lúc còn bé, tuy nhiên trong kí ức của anh ấy lại không hề có chuyện này. Hồi đó, tóc của vị giáo sư này vẫn còn màu đen, đầu óc vẫn còn minh mẫn, nhưng ngôn từ của ông ấy thì lại chẳng thể nào hiểu nổi. Dù là thời điểm ở ‘ phía trong nhà ga ‘ thì vẫn có cảm giác như là ông ấy sống ở một nơi rất là xa mũi đất này vậy. Điều duy nhất hiểu được là ông ấy từng là giáo sư cho một phòng thí nghiệm ở ‘ phía trong nhà ga ‘. Việc ông ấy bị đuổi ra khỏi nhà ga YOKOHAMA, e là có liên quan đến vụ việc bất chánh với  “ Suika “ .  Ở mũi đất này, như là thứ phế thải bỏ đi từ nhà ga vậy,’ những kẻ sử dụng bất chánh ‘\r\n" + 
//					"";
//			FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\onii-chan\\Desktop\\text1.txt", false);
//			fileOutputStream.write(content.getBytes());
//			System.out.println("Viết file thành công");
			
	}			
}
