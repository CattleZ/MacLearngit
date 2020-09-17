package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;

import Dao.ScoreDao;
import entity.Score;

/**
 * Servlet implementation class adminOperaScore
 */
@WebServlet("/adminOperaScore")
public class adminOperaScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminOperaScore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("htlm/text;charset=utf-8");
		String method = request.getParameter("me");
		//不分学科查询所有评教数据
		if("searAll".equals(method)) {
			//获得所有的评教数据 存储 并转发
			ScoreDao sDao = new ScoreDao();
			List<Score> culs =sDao.seAllScore();
			request.setAttribute("culs", culs);
			request.getRequestDispatcher("/adminScoreList.jsp").forward(request, response);			
		}
		
		//一根据学科查询
		if("searAll2".equals(method)) {
			String scient = request.getParameter("scice");
			
			ScoreDao sDao = new ScoreDao();
			List<Score> culs =sDao.seAllScoreBySci(scient);
			request.setAttribute("culs", culs);
			List<Integer> ls = new ArrayList<Integer>();
			//计算每个项目的平均分
			System.out.println(scient);
				int x1=0,x2=0,x3=0,x4=0,x5=0,x6=0,x7=0,x8=0,x9=0,x10=0;
			   for (Score score : culs) {
				  x1+= score.getTerm1();
				  x2+=score.getTerm2();
				  x3+=score.getTerm3();
				  x4+=score.getTerm4();
				  x5+=score.getTerm5();
				  x6+=score.getTerm6();
				  x7+=score.getTerm7();
				  x8+=score.getTerm8();
				  x9+=score.getTerm9();
				  x10+=score.getTerm10();
			   }
			   int size = culs.size();
			  if(size!=0) {
			   ls.add(x1/size);
			   ls.add(x2/size);
			   ls.add(x3/size);
			   ls.add(x4/size);
			   ls.add(x5/size);
			   ls.add(x6/size);
			   ls.add(x7/size);
			   ls.add(x8/size);
			   ls.add(x9/size);
			   ls.add(x10/size);
			  }
			   request.setAttribute("ls", ls);
			request.getRequestDispatcher("/adminScoreScien.jsp").forward(request, response);
		}
		//统计教师的综合得分 并排名
		if("tedao".equals(method)) {
			//首先要获得教师的信息
			// 然后根据教师的id 查找到 教师所在的班级 
			// 在根据班级id 查找到学生
			//request.getRequestDispatcher("/adminTeaTong.jsp").forward(request, response);
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
