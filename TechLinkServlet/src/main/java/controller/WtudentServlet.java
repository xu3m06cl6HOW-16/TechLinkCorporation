package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.bean.Student;
import student.service.StudentService;
import student.service.serviceImpl.StudentServiceImpl;

@WebServlet("/student.do")
public class WtudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("insertStudent".equals(action)) {
			
			String url = "/student/inserStudent.jsp";
			
			Integer insertNum = Integer.valueOf(req.getParameter("studentNum"));
			System.out.println("正在新增" + insertNum + "筆學生資料.....");

			int auccessNum = studentService.insertStudentNumRandom(insertNum);
			System.out.println("共新增了:" + auccessNum + "筆資料");
			
			
			req.setAttribute("insertNum", insertNum);
			req.setAttribute("auccessNum", auccessNum);
			RequestDispatcher insertStudentView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			insertStudentView.forward(req, res);

		}
		else if("selectStudentList".equals(action)) {
			
			String url = "/student/showStudent.jsp";
			
			List<Student> studentList = studentService.selectStudent();
			
			for(Student st:studentList) {
				System.out.println(st.getSno());
				System.out.println(st.getSname());
				System.out.println(st.getSbday());
				System.out.println(st.getSsex());
				System.out.println(st.getSmail());
				System.out.println(st.getSpwd());
			}
			
			req.setAttribute("studentList", studentList);
			RequestDispatcher showStudentView = req.getRequestDispatcher(url);
			showStudentView.forward(req, res);
		}

	}

}
