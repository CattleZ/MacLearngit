package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.stuLoginImp;
import entity.student;

/**
 * Servlet implementation class StumodifyServlet
 */
@WebServlet("/StumodifyServlet")
public class StumodifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StumodifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String method = request.getParameter("me");
		if("modify".equals(method)) {
			//获得所需要的信息
			String sid = request.getParameter("id");
			String sname = request.getParameter("name");
			String spwd = request.getParameter("passw");
			String sage = request.getParameter("age");
			String sgender = request.getParameter("gender");
			String saddress = request.getParameter("addr");
			student stu = new student();
			System.out.println(sid+" "+sname+" "+spwd+" "+sage+" "+sgender+" "+saddress+" ");
			stu.setSid(Integer.parseInt(sid));
			stu.setSname(sname);
			stu.setSpwd(spwd);
			stu.setSage(Integer.parseInt(sage));
			stu.setSgender(sgender);
			stu.setSaddress(saddress);
		stuLoginImp imp = new stuLoginImp();
		boolean flag = imp.getUpdate(stu);
		System.out.println("modify:"+flag);
		if(flag==true) {
		response.getWriter().write("修改成功");
		}else {
			response.getWriter().write("修改失败");
		}
		}
		if("add".equals(method)) {
			//获得所需要的信息
			String sid = request.getParameter("id");
			String sname = request.getParameter("name");
			String spwd = request.getParameter("passw");
			String sage = request.getParameter("age");
			String cls = request.getParameter("classid");
			String sgender = request.getParameter("gender");
			String saddress = request.getParameter("addr");
			student stu = new student();
			//System.out.println(sid+" "+sname+" "+spwd+" "+sage+" "+sgender+" "+saddress+" "+cls);
			stu.setSid(Integer.parseInt(sid));
			stu.setSname(sname);
			stu.setClassid(Integer.parseInt(cls));
			stu.setSpwd(spwd);
			stu.setSage(Integer.parseInt(sage));
			stu.setSgender(sgender);
			stu.setSaddress(saddress);
			stuLoginImp imp = new stuLoginImp();
			boolean flag = imp.getRegist(stu);
			if(flag==true) {
				response.getWriter().write("增加成功");
				}else {
					response.getWriter().write("增加失败");
				}
			
		}
		if("del".equals(method)) {
			stuLoginImp imp = new stuLoginImp();
			int sid = Integer.parseInt(request.getParameter("sid"));
			boolean flag = imp.deleStudent(sid);
			if(flag==true) {
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
