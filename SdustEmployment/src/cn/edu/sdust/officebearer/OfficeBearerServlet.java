package cn.edu.sdust.officebearer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sdust.tool.DbUtils;
import cn.edu.sdust.tool.StuQuery;

public class OfficeBearerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public OfficeBearerServlet() {
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
		
		if (flag.equals("main")) {
			int countPage = DbUtils.getCountPage("OfficeBearer");
			int count = DbUtils.getCountRecord("OfficeBearer");
			request.getSession().setAttribute("countPage", countPage);
			request.getSession().setAttribute("count", count);
			request.getSession().setAttribute("countPageNow", 1);
			OfficeBearerInterface obi = new OfficeBearerImpl();
			List<StuQuery> stuQuerys = new ArrayList<StuQuery>();
			stuQuerys = obi.getAllOfficeBearer(1);
			request.setAttribute("stuQuerys", stuQuerys);
			request.getRequestDispatcher("../Career/gongwuyuan.jsp").forward(
					request, response);
		} else if (flag.equals("index")) {
			int countPageNow = Integer.parseInt(request
					.getParameter("countPageNow"));
			request.getSession().setAttribute("countPageNow", countPageNow);
			OfficeBearerInterface obi = new OfficeBearerImpl();
			List<StuQuery> stuQuerys = new ArrayList<StuQuery>();
			stuQuerys = obi.getAllOfficeBearer(countPageNow);
			request.setAttribute("stuQuerys", stuQuerys);
			request.getRequestDispatcher("../Career/gongwuyuan.jsp").forward(
					request, response);
		} else if (flag.equals("content")) {
			String ID = request.getParameter("ID");
			OfficeBearerInterface obi = new OfficeBearerImpl();
			StuQuery stuQuery = obi.getAllOfficeBearerByID(ID);
			request.setAttribute("stuQuery", stuQuery);
			request.getRequestDispatcher("../Career/gongwuyuan2.jsp").forward(
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
