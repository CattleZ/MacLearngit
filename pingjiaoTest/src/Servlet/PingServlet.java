package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ScoreService;
import Service.totalService;
import entity.PingTerm;
import entity.Score;
import sun.net.www.content.image.png;

/**
 * Servlet implementation class PingServlet
 */
@WebServlet("/PingServlet")
public class PingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PingServlet() {
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
		String method = request.getParameter("me");
		if("sping".equals(method)) {
		String sid=request.getParameter("sid");
		String scice = request.getParameter("scice");
		String sc1 = request.getParameter("term1");
		String sc2 =request.getParameter("term2");
		String sc3 =request.getParameter("term3");
		String sc4 =request.getParameter("term4");
		String sc5 =request.getParameter("term5");
		String sc6 =request.getParameter("term6");
		String sc7 =request.getParameter("term7");
		String sc8 =request.getParameter("term8");
		String sc9 =request.getParameter("term9");
		String sc10 =request.getParameter("term10");
		String sc11 =request.getParameter("term11");
		//System.out.println(sid+" "+scice+" "+sc1+" "+sc11);
		Score sc = 
	new Score(Integer.parseInt(sid), scice, Integer.parseInt(sc1), Integer.parseInt(sc2),
		Integer.parseInt(sc3), Integer.parseInt(sc4), Integer.parseInt(sc5), Integer.parseInt(sc6),Integer.parseInt(sc7),Integer.parseInt(sc8), Integer.parseInt(sc9), Integer.parseInt(sc10), sc11);
	   //将评教信息插入到数据库中去
	   ScoreService ss = new ScoreService();
	   
	   boolean flag =  ss.insertScore(sc);
	   if(flag==true) {
		   response.getWriter().write("提交成功");
	   }else {
		   response.getWriter().write("提交失败");
	   }
		}
		
		if("mangPing".equals(method)) {
			//首先查找 原来的项目填充到评教项目设计中
			//把查询到的评教项目 传到评教平台
			totalService toa = new totalService();
			PingTerm pt=toa.getAllTerms().get(0);
			//System.out.println("pingJiao:"+pt.getTerm1());
			request.setAttribute("toa", pt);
			request.getRequestDispatcher("/adminManagerPingList.jsp").forward(request, response);
			
		}
		
		if("aping".equals(method)) {
			//然后再次提交修改 执行更新操作
			String sc1 = request.getParameter("term1");
			String sc2 =request.getParameter("term2");
			String sc3 =request.getParameter("term3");
			String sc4 =request.getParameter("term4");
			String sc5 =request.getParameter("term5");
			String sc6 =request.getParameter("term6");
			String sc7 =request.getParameter("term7");
			String sc8 =request.getParameter("term8");
			String sc9 =request.getParameter("term9");
			String sc10 =request.getParameter("term10");
			PingTerm pt = new PingTerm(sc1, sc2, sc3, sc4, sc5, sc6, sc7, sc8, sc9, sc10);
			totalService tol = new totalService();
			boolean flag = tol.updateTerm(pt);
			if(flag == true) {
				response.getWriter().write("更改成功");
			}else {
				response.getWriter().write("更改失败");
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
