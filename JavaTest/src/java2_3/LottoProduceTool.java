package java2_3;

import java.util.Arrays;
import java.util.TreeSet;

//此類別為大樂透產生工具
public class LottoProduceTool {
	
	public static void main(String[] args) {
		
		LottoProduceTool lpt=new LottoProduceTool();
		
			System.out.println(Arrays.toString(lpt.playLotto()));	
		
		
	}
	

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

}
