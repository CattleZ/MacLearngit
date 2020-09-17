package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.totalService;
import entity.PingTerm;

/**
 * Servlet implementation class pingJiaoServlet
 */
@WebServlet("/pingJiaoServlet")
public class pingJiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pingJiaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//这里要判断一下 执行的什么操作   如果是pingjiao就执行评教
		String method = request.getParameter("me");
		String id = request.getParameter("sid");
		
		if("pingjiao".equals(method)) {
		//把查询到的评教项目 传到评教平台
		totalService toa = new totalService();
		PingTerm pt=toa.getAllTerms().get(0);
		//System.out.println("pingJiao:"+pt.getTerm1());
		request.setAttribute("toa", pt);
		request.setAttribute("sid", id);
		request.getRequestDispatcher("/pingjiao.jsp").forward(request, response);
		}
		
		//如果是修改个人信息 就要执行修改个人信息的操作。
		if("modify".equals(method)) {
			request.setAttribute("sid", id);
			request.getRequestDispatcher("/studentModify.jsp").forward(request, response);
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
