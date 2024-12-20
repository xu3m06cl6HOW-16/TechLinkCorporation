package student.service;

import java.util.List;

import student.bean.Student;

public interface StudentService {
	
	Boolean insertStudent(Student student);
	
	List<Student> selectStudent();
	
	Integer updateStudent(Student student);
	
	Boolean deleteStudent(String sno);
	
	Integer insertStudentNumRandom(Integer studentnum);

}
