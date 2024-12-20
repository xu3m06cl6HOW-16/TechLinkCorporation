package tw.com.phctw.demo;

import java.util.Scanner;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentService;
import tw.com.phctw.service.StudentServiceImpl;

public class JdbcDemo {
	
	static StudentService stSer = new StudentServiceImpl();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
			
		Boolean fun = true;
		
		do {
			System.out.println("請選擇學生資料表的功能: 0.離開 1.查詢 2.新增 3.修改 4.刪除");
			int chooseNum = sc.nextInt();
			sc.nextLine();
			if(chooseNum!=0 && chooseNum <5) {
				
				JdbcDemo jdbcDemo =new JdbcDemo();
				switch(chooseNum){
				
					case 1:
						jdbcDemo.selectStudent();
						break;
					
					case 2:
						System.out.println("請輸入學生編號:");
						String sno = sc.nextLine();
						jdbcDemo.insertStudent(jdbcDemo.scan(sno));						
						break;
						
					case 3:
						System.out.println("請輸入要修改的學生編號:");
						String usno = sc.nextLine();
						jdbcDemo.updateStudent(jdbcDemo.scan(usno));
						break;
						
					case 4:
						System.out.println("請輸入要刪除的學生編號:");
						String dsno = sc.nextLine();
						jdbcDemo.deleteStudent(dsno);
						break;
				}
			}else {
				fun = false ;
			}
		}while(fun);
		
		System.out.println("已離開...");
		sc.close();
		
		
	}
	
	public void insertStudent(Student st) {
		
		Boolean inSuccess = stSer.insertStudent(st);
		if(inSuccess == true) {
			System.out.println("新增成功...");
		}else {
			System.out.println("新增失敗...");
		}
	}
	
	public void selectStudent() {
		
		for(Student st : stSer.selectStudent()) {
			System.out.println(st);
		}
	}
	
	public void updateStudent(Student st) {
		
		System.out.println("已更改" + stSer.updateStudent(st) + "筆資料成功...");
		
	}
	
	public void deleteStudent(String sno) {
		
		stSer.deleteStudent(sno);
		System.out.println("已成功刪除編號為:" + sno + "的學生...");
	}
	
	public Student scan(String sno) {
		
		System.out.println("請輸入學生姓名:");
		String sname = sc.nextLine();
		System.out.println("請輸入學生生日(yyyy-mm-dd):");
		String sbday = sc.next();
		System.out.println("請輸入學生性別(1/0):");
		Integer ssex = sc.nextInt();
		sc.nextLine(); // 清除換行符
		System.out.println("請輸入學生郵件:");
		String smail = sc.nextLine();
		System.out.println("請輸入學生密碼:");
		String spwd = sc.nextLine();
		
		Student st = new Student(sno,sname,java.sql.Date.valueOf(sbday),ssex,smail,spwd);
		
		return st;
		
	}

}
