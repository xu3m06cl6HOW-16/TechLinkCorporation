package tw.com.phctw.dao;

import java.util.List;

import tw.com.phctw.bean.Student;

public interface StudentDAO {
	
	Boolean insertStudent(Student student);
	
	List<Student> selectStudent();
	
	Integer updateStudent(Student student);
	
	Boolean deleteStudent(String sno);

}
