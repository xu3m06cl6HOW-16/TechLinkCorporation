package java2_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//使用者選取要抓的行數
public class LottoLineCatch {

	public static void main(String[] args) throws IOException {
		
		int count=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("請輸入要抓第幾筆的資料:");
		int userLine = sc.nextInt();

		String userHome = System.getProperty("user.home");
		String desktopPath = userHome + "\\Desktop\\Lotto.txt";
		
		String str;
		// 讀取
		File dir = new File(desktopPath);
		FileReader fr = new FileReader(dir);
		BufferedReader br = new BufferedReader(fr);
		
		//寫出
		String newDesktopPath = userHome + "\\Desktop\\Lotto_new.txt";
		FileWriter fw = new FileWriter(newDesktopPath,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		while((str=br.readLine())!=null) {
			count++;
			if(count==userLine) {
				System.out.println(str);
				pw.println("第"+userLine+"筆樂透");
				
				String[] fruits = str.split(",");
				for(int i=0;i<fruits.length;i++) {	
					pw.println(fruits[i]);
				}
			}
		}
		
		br.close();
		fr.close();
		pw.close();
		bw.close();
		fw.close();
		sc.close();

	}

}
