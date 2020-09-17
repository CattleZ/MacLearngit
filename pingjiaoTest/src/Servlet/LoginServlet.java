package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.studentDao;
import Service.adminLoginImp;
import Service.stuLoginImp;
import Service.teaLoginImp;
import entity.admin;
import entity.student;
import entity.teacher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String method = request.getParameter("me");
		String username = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		String FLA =request.getParameter("code");
		if(FLA.equals("false")) {
			System.out.println("FLA:"+FLA);
			System.out.println(method +":"+FLA+"----");
			PrintWriter writer = response.getWriter();
			String urlSt =request.getContextPath()+"/adminLogin.jsp";
			System.out.println(urlSt);
			writer.write(urlSt);
			writer.flush();
			writer.close();
		}else {
	
		//管理员
		if("admin".equals(method)) {
			adminLoginImp imp = new adminLoginImp();
			System.out.println(method +":"+FLA+":"+username+":"+pwd);
			admin users = new admin();
			users.setAdmin_name(username);
			users.setAdmin_pwd(pwd);
			boolean flag = imp.getLogin(users);
			if(flag==true) {
				System.out.println(method +":"+FLA+"----");
				PrintWriter writer = response.getWriter();
				String urlSt =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/ForwardServlet?method=admin&login="+username+"&pwd="+pwd;
				System.out.println(urlSt);
				writer.write(urlSt);
				writer.flush();
				writer.close();
			}else {
				response.sendRedirect(request.getContextPath()+"/adminLogin.jsp");
			}
		}	
		
		
		//学生
				if("student".equals(method)) {
					stuLoginImp imp = new stuLoginImp();
					System.out.println(method +":"+FLA+":"+username+":"+pwd);
					student users = new student();
					users.setSid(Integer.parseInt(username));
					users.setSpwd(pwd);
					boolean flag = imp.getLogin(users);
					if(flag==true) {
						System.out.println(method +":"+FLA+"----");
						PrintWriter writer = response.getWriter();
						String urlSt =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/ForwardServlet?method=student&login="+username+"&pwd="+pwd;
						System.out.println(urlSt);
						writer.write(urlSt);
						writer.flush();
						writer.close();
					}else {
						response.sendRedirect(request.getContextPath()+"/studentLogin.jsp");
					}
				}	
		//教师
				if("teacher".equals(method)) {
					teaLoginImp imp = new teaLoginImp();
					System.out.println(method +":"+FLA+":"+username+":"+pwd);
					teacher users = new teacher();
					users.setTuser(username);
					users.setTpwd(pwd);
					boolean flag = imp.getLogin(users);
					if(flag==true) {
						System.out.println(method +":"+FLA+"----");
						PrintWriter writer = response.getWriter();
						String urlSt =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/ForwardServlet?method=teacher&login="+username+"&pwd="+pwd;
						System.out.println(urlSt);
						writer.write(urlSt);
						writer.flush();
						writer.close();
					}else {
						response.sendRedirect(request.getContextPath()+"/teacherLogin.jsp");
					}
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
