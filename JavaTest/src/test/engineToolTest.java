package test;

import steamEngine.Tool;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;

public class engineToolTest {
	

	
	@Test
	public void produceWidgetsTest() {

		Tool pw = new Tool();
		Float totalMoney = pw.produceWidgets(3, 5);
		
		
		assertNotNull(totalMoney);
		System.out.println("共花費" + totalMoney + "元");
	}
	
	@Test
	public void test() {
		System.out.println("test1");
	}

}
