package java2_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

//3大樂透隨機號碼(3、5題合併)
public class LotteryTicket {

	public static void main(String[] args) {
		
		LotteryTicket lt =new LotteryTicket();
		
		System.out.println("大樂透號碼為:"+Arrays.toString(lt.playLotto()));
		
		System.out.println("=====以下為第五題======");
		
		for(String i:lt.playLottoList(lt.playLotto())) {
			System.out.print(i+" ");
		}

	}
	//3
	public String[] playLotto() {
		
		int i=0;
		String[] lotto =new String[6];
		
		TreeSet<Integer> loSet= new TreeSet<Integer>();
		
		while(loSet.size()<6) {
			int j =(int)((Math.random()*48)+1);
			loSet.add(j);
		}
				
		for(int a :loSet) {
			if(a<10) {
				lotto[i]=String.valueOf("0"+a);
			}else {
				lotto[i]=String.valueOf(a);
			}
			i++;
		}
		
		return lotto;
	}
	
	//(5)
	public ArrayList<String> playLottoList(String[] lotto) {
		
		ArrayList<String> list=new ArrayList<String>();
			
		for(int i=0;i<lotto.length;i++) {
			list.add(lotto[i]);
		}		
		
		return list;
		
	}

}
