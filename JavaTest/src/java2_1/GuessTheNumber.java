package java2_1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//猜數字
public class GuessTheNumber {
	
	
	static boolean answer=true;
	static String num;
	
	public static void main(String[] args) {
		
		
		String checkNum="^(?!.*(.).*\\1)[0-9]{4}$";
		Matcher matcher;
		
		do{
			num=String.valueOf((int)(Math.random()*10000));//隨機產生
			Pattern pattern = Pattern.compile(checkNum);
			matcher = pattern.matcher(num);
		}while
			(!matcher.matches());
		
		String iNum;
		Scanner sc=new Scanner(System.in);

		while(answer) {
			
			
			do{
				System.out.println("請輸入四位不重複數字:");	
				iNum=sc.nextLine();
				Pattern pattern = Pattern.compile(checkNum);
				matcher = pattern.matcher(iNum);
			}while(!matcher.matches());
			
			
			GuessTheNumber gtn=new GuessTheNumber();
			gtn.myNumber(iNum);
		}
		System.out.println("恭喜答對了!答案為:"+num);
		sc.close();
	}
	
	
	public boolean myNumber(String inum) {
		
		int x=0,z=0;
		
		for(int i=0;i<num.length();i++) {
			for(int j=0;j<inum.length();j++) {
				if((num.charAt(i)==inum.charAt(j)) && (i==j)) {
					x+=1;
					break;
				}else if(num.charAt(i)==inum.charAt(j)) {
					z+=1;
					break;
				}
			}
		}
		
		String FinNum=x+"A"+z+"B";
		System.out.println(FinNum);
		if("4A0B".equals(FinNum)) {
			answer=false;
			return answer;	
		}else {
			return answer;
		}
		
	}

}
