package steamEngine;

public class Tool {
	
	
	public Float produceWidgets(int internalQuan,int steanQuan) {
		
		engineTool engineTool = new productionEngine();
		Float internalMon =0F;
		Float steamMon = 0F;
		
		for(int i=1;i<=internalQuan;i++) {
			int ran = (int)(Math.random()*9);
			internalMon += internalQuan*engineTool.internalCombustionEngine(ran,(8-ran));
			
		}
		for(int j=1;j<=steanQuan;j++) {
			int ran = (int)(Math.random()*3);
			steamMon += steanQuan*engineTool.steamEngine(ran, (2-ran));			
		}
		
		return internalMon + steamMon;
	}

}
