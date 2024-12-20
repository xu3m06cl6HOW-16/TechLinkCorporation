package java2_1;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class DemoTest {

	public static void main(String[] args) {

		String[] randomStr = UUID.randomUUID().toString().split("-");
		System.out.println("郵件:" + randomStr[4] + "\t密碼:" +randomStr[0]);
		
		Instant instant = Instant.now();
		String timeString = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.of("UTC"))  // 指定 UTC 時區
                .format(instant);
		System.out.println("生日:" + timeString);
		
		Random random = new Random();
		int unicodeStart = 0x4e00;  // \u4e00
        int unicodeEnd = 0x9fff;    // \u9fff
		StringBuilder randomName = new StringBuilder();
		for(int i=0;i<3;i++) {
			char ch = (char) (unicodeStart + random.nextInt(unicodeEnd - unicodeStart + 1));
			randomName.append(ch);
		}
		System.out.println("姓名:" + randomName);
		
		System.out.println((int)(Math.random()*2)+1);
	}

}
