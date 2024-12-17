package java2_1;


//星星圖
public class DrawStars {
	
	public static void main(String[] args) {
		DrawStars ds = new DrawStars();
		ds.question6();
	}
	
	//(1)
	public void question1() {
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//(2)
	public void question2() {
		for(int i=1;i<=5;i++) {
			String spaces=String.format("%" + (6 - i) + "s", " ");
			System.out.print(spaces);
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	//(3)
	public void question3() {
		
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//(4)
	public void question4() {
		
		for(int i=5;i>=1;i--) {
			if(5-i!=0) {
			String spaces=String.format("%" + (5-i) + "s", " ");
			System.out.print(spaces);	
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//(5)
	public void question5() {
		
		for(int i=1;i<6;i++) {
			String spaces = String.format("%"+(6-i)+"s","");
			System.out.print(spaces);
			for(int j=1;j<=i;j++) {
				System.out.print("*"+" ");
			}
			System.out.println();
		}
	}
	
	//(6)
	public void question6() {
		
		for(int i=1;i<6;i++) {
			String spaces = String.format("%"+(6-i)+"s","");
			System.out.print(spaces);
			for(int j=1;j<=i;j++) {
				System.out.print("*"+" ");
			}
			System.out.println();
		}
		for(int i=1;i<=4;i++) {
			String spaces =String.format("%"+(i+1)+"s","");
			System.out.print(spaces);
			for(int j=4;j>=i;j--) {
				System.out.print("*"+" ");
			}
			System.out.println();
		}
	}

}
