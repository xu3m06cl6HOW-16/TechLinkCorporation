package tw.com.phctw.service;

import java.util.List;

import tw.com.phctw.bean.Student;

public interface StudentService {
	
	List<Student> selectStudent();
	
	Boolean insertStudent(Student student);
	
	Integer updateStudent(Student student);
	
	Boolean deleteStudent(String sno);

}
