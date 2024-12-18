package java2_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//使用者選取要抓的行數
public class LottoLineCatch {

	public static void main(String[] args) {

		int count = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入要抓第幾筆的資料:");
		int userLine = sc.nextInt();

		String userHome = System.getProperty("user.home");
		String desktopPath = userHome + "\\Desktop\\Lotto.txt";

		String str;
		// 讀取
		File dir = new File(desktopPath);
		String newDesktopPath = userHome + "\\Desktop\\Lotto_new.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(dir))) {
			// 寫出
			try (PrintWriter pw = new PrintWriter(new FileWriter(newDesktopPath, true))) {
				while ((str = br.readLine()) != null) {
					count++;
					if (count == userLine) {
						System.out.println(str);
						pw.println("第" + userLine + "筆樂透");

						String[] fruits = str.split(",");
						for (int i = 0; i < fruits.length; i++) {
							pw.println(fruits[i]);
						}
					}
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
