package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.adminDao;
import Dao.teaDao;
import Service.adminLoginImp;
import Service.stuLoginImp;
import Service.teaLoginImp;
import entity.Tclass;
import entity.admin;
import entity.student;
import entity.teacher;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/ForwardServlet")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获得用户名 密码 以及登陆对象
		String method = request.getParameter("method");
		String username = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		//管理员
		if("admin".equals(method)) {
			adminLoginImp imp = new adminLoginImp();
			admin users = new admin();
			users.setAdmin_name(username);
			users.setAdmin_pwd(pwd);
			adminDao dao = new adminDao();
			if(dao.searchEntity(users)!=null) {
				admin dA = dao.searchEntity(users).get(0);
				request.setAttribute("admin", dA);
			}
			request.getRequestDispatcher("/adminIndex.jsp").forward(request, response);
			
		}	
		
		
		//学生
				if("student".equals(method)) {
					stuLoginImp imp = new stuLoginImp();
					student users = new student();
					users.setSid(Integer.parseInt(username));
					users.setSpwd(pwd);
					//转发学生信息
					student student =imp.getStudent(users);
					
					request.setAttribute("stu", student);
					int id = student.getClassid();
					Tclass c = imp.getcName(id);
					String classname=c.getClassname();
					request.setAttribute("clas", classname);
					//学院信息
					String dname = imp.getDname(c.getDid());
					request.setAttribute("dname", dname);
					
					
					request.getRequestDispatcher("/studentIndex.jsp").forward(request, response);
				}	
		//教师
				if("teacher".equals(method)) {
					teaLoginImp imp = new teaLoginImp();
					teacher users = new teacher();
					users.setTuser(username);
					users.setTpwd(pwd);
					//先根据用户名密码查询到  教师的信息
					teaDao dao = new teaDao();
					List<teacher>  ls =dao.searchEntity(users);
					System.out.println(ls.get(0).getTid()+":"+ls.get(0).getTname());
					//将所需要的信息放到域对象中 转发
					request.setAttribute("tea", ls.get(0));
					request.getRequestDispatcher("/teacherIndex.jsp").forward(request, response);
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
