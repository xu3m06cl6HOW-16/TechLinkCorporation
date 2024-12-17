package java2_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//身分證驗證(1、5題合併)
public class IdVerify {
	
	static int idLength;
	static String idCard;
	
	public static void main(String[] args) {
		
		String successId = "^[A-Z][12]\\d{8}$";
		
		IdVerify idv=new IdVerify();
		
		Pattern pattern = Pattern.compile(successId);
		Matcher matcher = pattern.matcher(idv.idCardVerification());
		
		if(matcher.matches()) {
			System.out.println("身分證格式正確!");
		}else {
			System.out.println("身分證格式錯誤!");
		}
		
		System.out.println("=======以下為第五題=====");
	
		String[] idLengthArr= new String[idLength]; 
		for(int i=0;i<idLength;i++) {
			idLengthArr[i]=Character.toString(idCard.charAt(i));
		}
		ArrayList<String> list = idv.playLottoList(idLengthArr);
		for(String i:list) {
			System.out.print(i);
		}
	
	}
	
	//1.第一題
	public String idCardVerification() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("請輸入要驗證的身分證字號:");
		idCard=sc.nextLine();
		
		idLength=idCard.length();
		
		sc.close();
		
		return idCard;
	}
	
	//5.把第一題回傳字串放入此方法
	public ArrayList playLottoList(String[] lotto) {
		
		ArrayList<String> list=new ArrayList<String>();
			
		for(int i=0;i<lotto.length;i++) {
			list.add(lotto[i]);
		}		
		
		return list;
		
	}

}