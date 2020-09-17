package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.classDao;
import Dao.studentDao;
import Dao.teaDao;
import entity.Tclass;
import entity.student;
import entity.teacher;

/**
 * Servlet implementation class adminToolFunc
 */
@WebServlet("/adminToolFunc")
public class adminToolFunc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminToolFunc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("html/text;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("me");
		//学生管理功能
		if("searstu".equals(method)) {
			studentDao stu = new studentDao();
			List<student> ls = stu.searchAllEntity();
			request.setAttribute("culs", ls);
			request.getRequestDispatcher("/TeaAllstu.jsp").forward(request, response);
		}
		//教师管理功能
		if("seartea".equals(method)) {
			teaDao dao = new teaDao();
			List<teacher> culs = dao.searchAllEntity();
			request.setAttribute("culs",culs);
			request.getRequestDispatcher("/teacherList.jsp").forward(request, response);
		}
		
		//班级管理
		if("mangClass".equals(method)) {
			//执行操作
			classDao cdao = new classDao();
			List<Tclass> ls = cdao.searchAllEntity();
			request.setAttribute("culs", ls);
			request.getRequestDispatcher("/managerClass.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
