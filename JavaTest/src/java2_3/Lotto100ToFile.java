package java2_3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

//1.產生100組大樂透到檔案
public class Lotto100ToFile {

	
	public static void main(String[] args){
		
		String userHome = System.getProperty("user.home");
        String desktopPath = userHome + "\\Desktop\\Lotto.txt";
		
		
        try(PrintWriter pw = new PrintWriter(new FileWriter(desktopPath,true))){
        	
        	LottoProduceTool lpt =new LottoProduceTool();
        	for(int i=1;i<=100;i++) {
        		pw.println(Arrays.toString(lpt.playLotto()));		
        		pw.flush();
        	}
        } catch (IOException e) {
			e.printStackTrace();
		}
		

		
		System.out.println("完成...請於電腦桌面查收檔案。");
	}

}
