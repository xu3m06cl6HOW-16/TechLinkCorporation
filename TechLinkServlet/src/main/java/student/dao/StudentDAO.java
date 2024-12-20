package student.dao;

import java.util.List;

import student.bean.Student;


public interface StudentDAO {
	
	Boolean insertStudent(Student student);
	
	List<Student> selectStudent();
	
	Integer updateStudent(Student student);
	
	Boolean deleteStudent(String sno);

	Integer insertStudentNumRandom(List<Student> studentList);

}
