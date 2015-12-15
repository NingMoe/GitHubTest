package cn.edu.sdust.careerfair;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CareerFairServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CareerFairServlet() {
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
			
			CareerFair careerFair_c = new CareerFair();
			careerFair_c.setcFClassfy("");
			careerFair_c.setcFStartTime("");
			careerFair_c.setcFStartTime1("");
			careerFair_c.setCfStartPlace("");
			
			request.getSession().setAttribute("cFClassfy", "");
			request.getSession().setAttribute("cFStartTime", "");
			request.getSession().setAttribute("cFStartTime1", "");
			request.getSession().setAttribute("CfStartPlace", "");
			
			int count = CareerFairImpl.getAllCFCountRecord(careerFair_c);
			int countPage = CareerFairImpl.getAllCFCountPage(careerFair_c);
			request.getSession().setAttribute("countPage", countPage);
			request.getSession().setAttribute("count", count);
			request.getSession().setAttribute("countPageNow", 1);
			CareerFairInterface cfi = new CareerFairImpl();
			List<CareerFair> careerFairs = new ArrayList<CareerFair>();
			careerFairs = cfi.getAllCareerFair(1, careerFair_c);
			request.setAttribute("careerFairs",careerFairs);
			request.getRequestDispatcher("../Career/zhaopinhuixinxi.jsp").forward(
					request, response);
			
		}else if (flag.equals("main1")) {
			
			String cFClassfy = request.getParameter("cFClassfy");
			String cFStartTime = request.getParameter("cFStartTime");
			String cFStartTime1 = request.getParameter("cFStartTime1");
			String CfStartPlace = request.getParameter("CfStartPlace");
			CareerFair careerFair_c = new CareerFair();
			careerFair_c.setcFClassfy(cFClassfy);
			careerFair_c.setcFStartTime(cFStartTime);
			careerFair_c.setcFStartTime1(cFStartTime1);
			careerFair_c.setCfStartPlace(CfStartPlace);
			
			request.getSession().setAttribute("cFClassfy", cFClassfy);
			request.getSession().setAttribute("cFStartTime", cFStartTime);
			request.getSession().setAttribute("cFStartTime1", cFStartTime1);
			request.getSession().setAttribute("CfStartPlace", CfStartPlace);
			
			int countPage = CareerFairImpl.getAllCFCountPage(careerFair_c);
			int count = CareerFairImpl.getAllCFCountRecord(careerFair_c);
			request.getSession().setAttribute("countPage", countPage);
			request.getSession().setAttribute("count", count);
			request.getSession().setAttribute("countPageNow", 1);
			CareerFairInterface cfi = new CareerFairImpl();
			List<CareerFair> careerFairs = new ArrayList<CareerFair>();
			careerFairs = cfi.getAllCareerFair(1, careerFair_c);
			request.setAttribute("careerFairs",careerFairs);
			request.getRequestDispatcher("../Career/zhaopinhuixinxi.jsp").forward(
					request, response);
		} else if (flag.equals("index")) {
			
			CareerFair careerFair_c = new CareerFair();
			careerFair_c.setcFClassfy((String)request.getSession().getAttribute("cFClassfy"));
			careerFair_c.setcFStartTime((String)request.getSession().getAttribute("cFStartTime"));
			careerFair_c.setcFStartTime1((String)request.getSession().getAttribute("cFStartTime1"));
			careerFair_c.setCfStartPlace((String)request.getSession().getAttribute("CfStartPlace"));
			
			int countPageNow = Integer.parseInt(request.getParameter("countPageNow"));
			request.getSession().setAttribute("countPageNow", countPageNow);
			CareerFairInterface cfi = new CareerFairImpl();
			List<CareerFair> careerFairs = new ArrayList<CareerFair>();
			careerFairs = cfi.getAllCareerFair(countPageNow, careerFair_c);
			request.setAttribute("careerFairs",careerFairs);
			request.getRequestDispatcher("../Career/zhaopinhuixinxi.jsp").forward(
					request, response);
		} else if (flag.equals("content")) {
			
			String CFID = request.getParameter("CFID");
			CareerFairInterface cfi = new CareerFairImpl();
			CareerFair careerFair = new CareerFair();
			careerFair = cfi.getAllCareerFairByID(CFID);
			request.setAttribute("careerFair",  careerFair);
			request.getRequestDispatcher("../Career/zhaopinhuixinxi2.jsp").forward(
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
