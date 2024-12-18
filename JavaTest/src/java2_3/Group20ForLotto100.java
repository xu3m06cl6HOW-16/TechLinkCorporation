package java2_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

//第四題 產生20份100組大樂透檔案
public class Group20ForLotto100 {

	public static void main(String[] args){
		
		String userHome = System.getProperty("user.home");
		
		File output;
		LottoProduceTool lpt = new LottoProduceTool();
		
		//寫出次數
		for(int k=1;k<=20;k++) {
			
			if(k<10) {
				output = new File(userHome, "Desktop" + File.separator + "Lotto_0" + k + ".txt");
			}else {
				output = new File(userHome, "Desktop" + File.separator + "Lotto_" + k + ".txt");				
			}
			
			try(PrintWriter pw = new PrintWriter(new FileWriter(output,true))){	
				//大樂透產生組數
				for(int i=1;i<=100;i++) {
					pw.println(Arrays.toString(lpt.playLotto()));		
					pw.flush();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("已完成，請於桌面查收!");
		
	}

}
