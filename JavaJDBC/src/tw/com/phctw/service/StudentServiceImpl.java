package tw.com.phctw.service;

import java.util.List;

import tw.com.phctw.bean.Student;
import tw.com.phctw.dao.StudentDAO;
import tw.com.phctw.dao.StudentDAOImpl;

public class StudentServiceImpl implements StudentService{
	
	StudentDAO stDao = new StudentDAOImpl();

	@Override
	public Boolean insertStudent(Student student) {

		return stDao.insertStudent(student);
	}

	@Override
	public List<Student> selectStudent() {
		
		return stDao.selectStudent();
	}

	@Override
	public Integer updateStudent(Student student) {
		
		return stDao.updateStudent(student);
	}

	@Override
	public Boolean deleteStudent(String sno) {
		// TODO Auto-generated method stub
		return stDao.deleteStudent(sno);
	}

}
