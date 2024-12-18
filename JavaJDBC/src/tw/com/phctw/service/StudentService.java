package tw.com.phctw.service;

import java.util.List;

import tw.com.phctw.bean.Student;

public interface StudentService {
	
	Boolean insertStudent(Student student);
	
	List<Student> selectStudent();
	
	Integer updateStudent(Student student);
	
	Boolean deleteStudent(String sno);

}
