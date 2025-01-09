package tw.com.phctw.util;

import java.util.HashMap;
import java.util.Map;



public class Practise {

	public static void main(String[] args) {
		
		Practise pt = new Practise();
		pt.method();
		
	}
	
	
	public void method() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("food", "馬鈴薯");
		map.put("number", 33);
		map.put("bigdecimal", 5.00);
		
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("KEY:" + entry.getKey() + "\tValue:" + entry.getValue());
		}
	}

}
