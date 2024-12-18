package java2_3;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//檔名加上日期做複製
public class TodayLotto {

	public static void main(String[] args){

		String userHome = System.getProperty("user.home");
        String desktopPath = userHome + "\\Desktop\\Lotto.txt";
        
        //今日日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date now =new Date();
        String formattedDate = sdf.format(now);
        String todayDesktopPath = userHome + "\\Lotto" + formattedDate + ".txt";
        
        File inPut = new File(desktopPath);
        File outPut = new File(todayDesktopPath);
        
        
        TodayLotto tl = new TodayLotto();
        tl.copyFile(inPut, outPut);
		
	}
	
	
	public void copyFile(File inPut,File outPut){
		
		
		try (FileReader fr = new FileReader(inPut)){
			
			try(FileWriter fw = new FileWriter(outPut)){
				int c;
				while((c=fr.read())!=-1) {
					fw.write(c);
					fw.flush();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("本日期大樂透已複製於您C槽使用者名稱的資料夾內!");
	}

}
