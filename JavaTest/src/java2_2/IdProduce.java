package java2_2;

//身分證產生器
public class IdProduce {
	
	public static void main(String[] args) {
		
		IdProduce ipd = new IdProduce();
		System.out.println(ipd.idCardProduce());
		
	}
	
	public String idCardProduce() {
		
		char t=(char) ((int)(Math.random() * 26)+65);
		long randomNumber =(long) ((Math.random()* 200000000L)+100000000L);
		String k =String.valueOf(randomNumber);
		
		
		String num = t+k;
		
		return num;
	}

}
