package java2_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//檔名加上日期做複製
public class TodayLotto {

	public static void main(String[] args) throws IOException {

		String userHome = System.getProperty("user.home");
        String desktopPath = userHome + "\\Desktop\\Lotto.txt";
        
        //今日日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date now =new Date();
        String formattedDate = sdf.format(now);
        String todayDesktopPath = userHome + "\\Desktop\\Lotto"+formattedDate+".txt";
        
        File inPut = new File(desktopPath);
        File outPut = new File(todayDesktopPath);
        
        
        TodayLotto tl = new TodayLotto();
        tl.copyFile(inPut, outPut);
		
	}
	
	
	public void copyFile(File inPut,File outPut) throws IOException {
		
		FileReader fr = new FileReader(inPut);
		FileWriter fw = new FileWriter(outPut);
		int c;
		while((c=fr.read())!=-1) {
			fw.write(c);
			fw.flush();
		}
		
		fw.close();
		fr.close();
		System.out.println("本日期大樂透已複製於桌面!");
	}

}
