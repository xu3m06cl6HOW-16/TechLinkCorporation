package student.service.serviceImpl;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import student.bean.Student;
import student.dao.StudentDAO;
import student.dao.studentDaoImpl.StudentDAOImpl;
import student.service.StudentService;

public class StudentServiceImpl implements StudentService {

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

	@Override
	public Integer insertStudentNumRandom(Integer studentnum) {

		StudentServiceImpl si = new StudentServiceImpl();
		return stDao.insertStudentNumRandom(si.randomProduce(studentnum));
	}

	// 隨機產生學生方法(傳入需要數量)
	public List<Student> randomProduce(Integer studentnum) {

		ArrayList<Student> studentList = new ArrayList<Student>();

		// 中文名字
		Random random = new Random();
		int unicodeStart = 0x4e00; // \u4e00
		int unicodeEnd = 0x9fff; // \u9fff
		int studentAllNum = stDao.selectStudent().size();// 目前資料筆數
		for (int j = studentAllNum + 1; j <= studentnum + studentAllNum; j++) {
			StringBuilder randomName = new StringBuilder();
			for (int i = 0; i < 3; i++) {
				char ch = (char) (unicodeStart + random.nextInt(unicodeEnd - unicodeStart + 1));
				randomName.append(ch);
			}

			// 生日
			Instant instant = Instant.now();
			String timeString = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.of("UTC")) // 指定 UTC 時區
					.format(instant);

			// 郵件加密碼
			String[] randomStr = UUID.randomUUID().toString().split("-");

			String sno = "A" + (j);
			String sname = randomName.toString();
			String sbday = timeString;
			int ssex = (int) (Math.random() * 2) + 1;
			String smail = randomStr[4] + "@GMAIL.COM";
			String spwd = randomStr[0];

			Student student = new Student();
			student.setSno(sno);
			student.setSname(sname);
			student.setSbday(java.sql.Date.valueOf(sbday));
			student.setSsex(ssex);
			student.setSmail(smail);
			student.setSpwd(spwd);

			studentList.add(student);
		}

		return studentList;

	}

}
