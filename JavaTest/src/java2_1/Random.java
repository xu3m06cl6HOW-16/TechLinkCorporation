package java2_1;

import java.util.Arrays;

//亂數分類
public class Random {
	
	public static void main(String[] args) {
		
		int k;
		String f;
		String[] ranList = new String[20];
		
		for(int i=1;i<=20;i++) {
			k=(int)(Math.random()*100)+1;
			
			if(k>=90) {
				f="甲";
			}else if(k>=80 && k<90) {
				f="乙";
			}else if(k>=70 && k<80) {
				f="丙";
			}else {
				f="丁";
			}
			
			ranList[i-1]=f;
		}
		
		System.out.println(Arrays.toString(ranList));
	}

}
