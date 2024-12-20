package student.dao.studentDaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student.bean.Student;
import student.dao.StudentDAO;
import student.util.Util;

public class StudentDAOImpl implements StudentDAO {

	public static final String INSERT_STUDENT = "INSERT INTO student VALUES (?,?,?,?,?,?)";
	public static final String SELECT_ALL = "SELECT s.SNO,s.SNAME,s.SBDAY,s.SSEX,s.SMAIL,s.SPWD FROM student s";
	public static final String UPDATE_STUDENT = "UPDATE student s SET s.SNAME = ? , s.SBDAY = ?, s.SSEX = ?, s.SMAIL= ?, s.SPWD = ? WHERE s.SNO = ?";
	public static final String DELETE_STUDENT_BY_SNO = "DELETE FROM student s WHERE s.SNO = ?";

	static {

		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Boolean insertStudent(Student student) {

		try (Connection con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(INSERT_STUDENT)) {

			pstmt.setString(1, student.getSno());
			pstmt.setString(2, student.getSname());
			pstmt.setDate(3, new java.sql.Date(student.getSbday().getTime()));
			pstmt.setInt(4, student.getSsex());
			pstmt.setString(5, student.getSmail());
			pstmt.setString(6, student.getSpwd());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public List<Student> selectStudent() {

		List<Student> stList = new ArrayList<Student>();

		try (Connection con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {

				Student st = new Student();
				st.setSno(rs.getString("SNO"));
				st.setSname(rs.getString("SNAME"));
				st.setSbday(rs.getDate("SBDAY"));
				st.setSsex(rs.getInt("SSEX"));
				st.setSmail(rs.getString("SMAIL"));
				st.setSpwd(rs.getString("SPWD"));

				stList.add(st);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stList;
	}

	@Override
	public Integer updateStudent(Student student) {

		Integer resultRow = null;

		try (Connection con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(UPDATE_STUDENT)) {

			pstmt.setString(1, student.getSname());
			pstmt.setDate(2, new java.sql.Date(student.getSbday().getTime()));
			pstmt.setInt(3, student.getSsex());
			pstmt.setString(4, student.getSmail());
			pstmt.setString(5, student.getSpwd());
			pstmt.setString(6, student.getSno());

			resultRow = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultRow;
	}

	@Override
	public Boolean deleteStudent(String sno) {

		try (Connection con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(DELETE_STUDENT_BY_SNO)) {

			pstmt.setString(1, sno);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public Integer insertStudentNumRandom(List<Student> studentList) {

		int[] results = null;
		int totalAffectedRows = 0;

		try (Connection con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(INSERT_STUDENT)) {

			con.setAutoCommit(false);//先不要自動提交
			for (Student student : studentList) {

				pstmt.setString(1, student.getSno());
				pstmt.setString(2, student.getSname());
				pstmt.setDate(3, new java.sql.Date(student.getSbday().getTime()));
				pstmt.setInt(4, student.getSsex());
				pstmt.setString(5, student.getSmail());
				pstmt.setString(6, student.getSpwd());
				pstmt.addBatch();
			}

			results = pstmt.executeBatch();
			con.commit();
			
			totalAffectedRows = 0;
			for (int result : results) {
				totalAffectedRows += result;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return totalAffectedRows;
	}

}
