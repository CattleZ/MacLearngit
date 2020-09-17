package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.model.core.ID;

import Service.classService;
import entity.Tclass;

/**
 * Servlet implementation class classModifyServlet
 */
@WebServlet("/classModifyServlet")
public class classModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("me");
		if("del".equals(method)) {
			//执行删除功能
			int id = Integer.parseInt(request.getParameter("classid"));
			classService cs = new classService();
			boolean flag = cs.deleCLASS(id);
			if(flag == true) {
				response.getWriter().write("删除成功");
			}else {
				response.getWriter().write("删除失败");
			}
		}
		if("modify".equals(method)) {
			int cid = Integer.parseInt(request.getParameter("id"));
			String cname = request.getParameter("name");
			int techer = Integer.parseInt(request.getParameter("tacher"));
			int math = Integer.parseInt(request.getParameter("math"));
			int china = Integer.parseInt(request.getParameter("china"));
			int english = Integer.parseInt(request.getParameter("english"));
			int total = Integer.parseInt(request.getParameter("total"));
		    Tclass ct = new Tclass(cid, cname, techer, math, china, english, total,501);
		    //执行更新操作
		    classService cs = new classService();
			boolean flag = cs.updateClass(ct);
			if(flag == true) {
				response.getWriter().write("更新成功");
			}else {
				response.getWriter().write("更新失败");
			}
		    
		}
		if("add".equals(method)) {
			int cid = Integer.parseInt(request.getParameter("id"));
			String cname = request.getParameter("name");
			int techer = Integer.parseInt(request.getParameter("tacher"));
			int math = Integer.parseInt(request.getParameter("math"));
			int china = Integer.parseInt(request.getParameter("china"));
			int english = Integer.parseInt(request.getParameter("english"));
			int total = Integer.parseInt(request.getParameter("total"));
		    Tclass ct = new Tclass(cid, cname, techer, math, china, english, total,501);
		    //执行增加操作
		    classService cs = new classService();
			boolean flag = cs.addClass(ct);
			if(flag == true) {
				response.getWriter().write("增加成功");
			}else {
				response.getWriter().write("增加失败");
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
