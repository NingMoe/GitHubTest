package cn.edu.sdust.recruitment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecruitmentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public RecruitmentServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("main")){
			
			Recruitment recruitment = new Recruitment();
			recruitment.setRecruitEntName("");
			recruitment.setRecruitJob("");
			recruitment.setRecruitWorkplace("");
			recruitment.setRecruitReleaseTime("");
			recruitment.setRecruitReleaseTime1("");
			
			request.getSession().setAttribute("recruitEntName", "");
			request.getSession().setAttribute("recruitJob", "");
			request.getSession().setAttribute("recruitWorkplace", "");
			request.getSession().setAttribute("recruitReleaseTime", "");
			request.getSession().setAttribute("recruitReleaseTime1", "");
			
			RecruitmentInterface ri = new RecruitmentImpl();
			int countPage = RecruitmentImpl.getAllrecruitmentCountPage(recruitment);
			int count = RecruitmentImpl.getAllrecruitmentCountRecord(recruitment);
			request.getSession().setAttribute("countPage", countPage);
			request.getSession().setAttribute("count", count);
			request.getSession().setAttribute("countPageNow", 1);
			List<Recruitment> recruitments = new ArrayList<Recruitment>();
			recruitments = ri.getAllRecruitment(1, recruitment);
			request.setAttribute("recruitments", recruitments);
			request.getRequestDispatcher("../Career/zhaopinxinxi.jsp").forward(
					request, response);
		}else if(flag.equals("main1")){
			
			String recruitEntName = request.getParameter("enterprise");
			String recruitJob = request.getParameter("job");
			String recruitWorkplace = request.getParameter("address");
			String recruitReleaseTime = request.getParameter("time");
			String recruitReleaseTime1 = request.getParameter("time1");
			
			Recruitment recruitment = new Recruitment();
			recruitment.setRecruitEntName(recruitEntName);
			recruitment.setRecruitJob(recruitJob);
			recruitment.setRecruitWorkplace(recruitWorkplace);
			recruitment.setRecruitReleaseTime(recruitReleaseTime);
			recruitment.setRecruitReleaseTime1(recruitReleaseTime1);
			
			request.getSession().setAttribute("recruitEntName", recruitEntName);
			request.getSession().setAttribute("recruitJob", recruitJob);
			request.getSession().setAttribute("recruitWorkplace", recruitWorkplace);
			request.getSession().setAttribute("recruitReleaseTime", recruitReleaseTime);
			request.getSession().setAttribute("recruitReleaseTime1", recruitReleaseTime1);
			
			RecruitmentInterface ri = new RecruitmentImpl();
			int countPage = RecruitmentImpl.getAllrecruitmentCountPage(recruitment);
			int count = RecruitmentImpl.getAllrecruitmentCountRecord(recruitment);
			request.getSession().setAttribute("countPage", countPage);
			request.getSession().setAttribute("count", count);
			request.getSession().setAttribute("countPageNow", 1);
			List<Recruitment> recruitments = new ArrayList<Recruitment>();
			recruitments = ri.getAllRecruitment(1, recruitment);
			request.setAttribute("recruitments", recruitments);
			request.getRequestDispatcher("../Career/zhaopinxinxi.jsp").forward(
					request, response);
			
		}else if(flag.equals("content")){
			
			String recruitmentId = request.getParameter("ID");
			RecruitmentInterface ri = new RecruitmentImpl();
			Recruitment recruitment = new Recruitment();
			recruitment = ri.getAllRecruitmentByID(recruitmentId);
			request.setAttribute("recruitment",  recruitment);
			request.getRequestDispatcher("../Career/zhaopinxinxi2.jsp").forward(
				request, response);
		}else if(flag.equals("index")){
			
			Recruitment recruitment = new Recruitment();
			recruitment.setRecruitEntName((String)request.getSession().getAttribute("recruitEntName"));
			recruitment.setRecruitJob((String)request.getSession().getAttribute("recruitJob"));
			recruitment.setRecruitWorkplace((String)request.getSession().getAttribute("recruitWorkplace"));
			recruitment.setRecruitReleaseTime((String)request.getSession().getAttribute("recruitReleaseTime"));
			recruitment.setRecruitReleaseTime1((String)request.getSession().getAttribute("recruitReleaseTime1"));
			
			int countPageNow = Integer.parseInt(request.getParameter("countPageNow"));
			request.getSession().setAttribute("countPageNow", countPageNow);
			List<Recruitment> recruitments = new ArrayList<Recruitment>();
			RecruitmentInterface ri = new RecruitmentImpl();
			recruitments = ri.getAllRecruitment(countPageNow, recruitment);
			request.setAttribute("recruitments", recruitments);
			request.getRequestDispatcher("../Career/zhaopinxinxi.jsp").forward(
					request, response);
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
