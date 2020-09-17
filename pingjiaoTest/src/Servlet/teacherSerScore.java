package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ScoreDao;
import Dao.studentDao;
import Service.teaLoginImp;
import entity.Score;
import entity.student;
import entity.teacher;

/**
 * Servlet implementation class teacherSerScore
 */
@WebServlet("/teacherSerScore")
public class teacherSerScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherSerScore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接收参数
		String method = request.getParameter("me");
		String tid = request.getParameter("tid");
		if("searScore1".equals(method)) {
			request.setAttribute("tid", tid);
			request.getRequestDispatcher("/ScoreList.jsp").forward(request, response);
		}
		//教师查询 评分
		if("searchSc2".equals(method)) {
			String scString  = request.getParameter("scice");
			ScoreDao sDao = new ScoreDao();
			List<Score> culs = sDao.seScorebyTeacher(Integer.parseInt(tid), scString);
			request.setAttribute("culs", culs);
			request.setAttribute("tid", tid);
			request.getRequestDispatcher("/ScoreList.jsp").forward(request, response);
		}
		//教师查询 自己学生的信息并操作
		if("searstu".equals(method)) {
			//获得教师的id
			int id = Integer.parseInt(request.getParameter("tid"));
			studentDao stu = new studentDao();
			List<student> ls = stu.searchOnlyEntity(id);
			request.setAttribute("culs", ls);
			request.getRequestDispatcher("/TeaAllstu.jsp").forward(request, response);
		}
		//教师 修改个人的信息页面跳转
		if("modify1".equals(method)) {
			request.setAttribute("tid", tid);
			request.getRequestDispatcher("/teaModify.jsp").forward(request, response);
		}
		//教师修改个人界面 功能执行
		if("modify".equals(method)) {
			//首先获得教师的信息 封装到对象中
			teacher te = new teacher();
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String username = request.getParameter("username");
			String tpwd = request.getParameter("passw");
			String tage = request.getParameter("age");
			String tgender = request.getParameter("gender");
			te.setTid(Integer.parseInt(id));
			te.setTname(name);
			te.setTuser(username);
			te.setTpwd(tpwd);
			te.setTgender(tgender);
			te.setTage(Integer.parseInt(tage));
			teaLoginImp imp = new teaLoginImp();
			boolean flag = imp.getUpdate(te);
			if(flag==true) {
				response.getWriter().write("修改成功");
			}else {
				response.getWriter().write("修改失败");
			}
		}
		//添加教师功能执行
		if("add".equals(method)) {
			//首先获得教师的信息 封装到对象中
			teacher te = new teacher();
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String username = request.getParameter("username");
			String tpwd = request.getParameter("passw");
			String tage = request.getParameter("age");
			String tgender = request.getParameter("gender");
			te.setTid(Integer.parseInt(id));
			te.setTname(name);
			te.setTuser(username);
			te.setTpwd(tpwd);
			te.setTgender(tgender);
			te.setTage(Integer.parseInt(tage));
			//执行添加操作
			teaLoginImp imp = new teaLoginImp();
			boolean flag = imp.getRegist(te);
			if(flag ==true) {
				response.getWriter().write("添加成功");
			}else {
				response.getWriter().write("添加失败");
			}
		}
		//删除教师 
		if("del".equals(method)) {
			int id =Integer.parseInt(request.getParameter("tid"));
			teaLoginImp imp = new teaLoginImp();
			boolean flag = imp.getDelTea(id);
			if(flag == true) {
				response.getWriter().write("删除成功");
			}else {
				response.getWriter().write("删除失败");
			}
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
