package java2_2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//Set產生大樂透(4、6題合併)
public class ArraysLotteryTicket {
	
	static TreeSet loSet = new TreeSet();

	public static void main(String[] args) {
		
		ArraysLotteryTicket alt = new ArraysLotteryTicket();
		System.out.println("大樂透號碼為:"+alt.playLottoSet());
		
		System.out.println("=======以下為第六題=======");
		
		HashMap<Integer,String> map=alt.playLottoMap(loSet);
		
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

	}
	
	//第四題
	public TreeSet playLottoSet() {
		
		while(loSet.size()<6) {
			int j =(int)((Math.random()*48)+1);
			if(j<10) {
				loSet.add(String.valueOf("0"+j));
			}else {
				loSet.add(String.valueOf(j));
			}
		}
		
		return loSet;
	}
	
	//第六題
	public HashMap playLottoMap(TreeSet lotto) {
		
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		int i=1;
		
		for(Object id:lotto) {
			map.put(i,(String) id);
			i++;
		}
		
		
		return map;
	}

}