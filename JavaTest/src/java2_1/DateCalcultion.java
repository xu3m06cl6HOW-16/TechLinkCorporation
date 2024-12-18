package java2_1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DateCalcultion {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		System.out.print("請輸入日期 (yyyy-MM-dd): ");
        String inputDate = sc.nextLine();
        
		System.out.println("請輸入要計算的天數:");
		int adysToAdd = sc.nextInt();
		
		DateCalcultion dcl=new DateCalcultion();
		Date result=dcl.ComputationDate(inputDate, adysToAdd);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    String formattedDate = sdf.format(result);
	    System.out.println(formattedDate);
	    
	    sc.close();
		
	}
	
	public Date ComputationDate(String date, int dateNum) {
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate originalDate = LocalDate.parse(date, formatter);
        LocalDate newDate = originalDate.plusDays(dateNum);

        // 將 LocalDateTime 轉換為 Instant
        Date resultDate = Date.from(newDate.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant());

        
        return resultDate;
	}

}
