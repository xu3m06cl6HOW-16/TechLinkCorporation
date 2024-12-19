package tw.com.phctw.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/techlinkdb?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "123456";

//	public static void main(String[] args) {
//
//		try {
//
//			Class.forName(DRIVER);
//			
//
//			try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
//					PreparedStatement stmt = con.prepareStatement("SELECT * FROM student ORDER BY SNO");
//					ResultSet rs = stmt.executeQuery()) {
//
//				while(rs.next()) {
//					
//					String sno = rs.getString(1);
//					String sname = rs.getString(2);
//					Date sbday = rs.getDate(3);
//					int ssex = rs.getInt(4);
//					String smail = rs.getString(5);
//					String spwd = rs.getString(6);
//					
//					System.out.print("SNO=" + sno + "\t");
//					System.out.print("SNAME=" + sname + "\t");
//					System.out.print("SBDAY=" + sbday + "\t");
//					System.out.print("SSEX=" + ssex + "\t");
//					System.out.print("SMAIL=" + smail + "\t");
//					System.out.println("SPED=" + spwd + "\t");
//
//					
//				}
//
//			}
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException se) {
//			se.printStackTrace();
//		}
//	}

}
