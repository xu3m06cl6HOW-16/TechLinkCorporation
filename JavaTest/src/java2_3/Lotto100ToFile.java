package java2_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

//1.產生100組大樂透到檔案
public class Lotto100ToFile {

	
	public static void main(String[] args) throws IOException {
		
		String userHome = System.getProperty("user.home");
        String desktopPath = userHome + "\\Desktop\\Lotto.txt";
		
		FileWriter fw=new FileWriter(desktopPath,true);
		BufferedWriter bw=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(bw);
	
		
		LottoProduceTool lpt =new LottoProduceTool();
		
		for(int i=1;i<=100;i++) {
			pw.println(Arrays.toString(lpt.playLotto()));		
			pw.flush();
		}
		
		pw.close();
		bw.close();
		fw.close();
		
		System.out.println("完成...請於電腦桌面查收檔案。");
	}

}