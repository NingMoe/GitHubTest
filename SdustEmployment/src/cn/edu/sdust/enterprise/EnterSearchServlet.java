package cn.edu.sdust.enterprise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sdust.register.Enterprise;

public class EnterSearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EnterSearchServlet() {
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
			
		String enterpriseName = request.getParameter("names");
		String enterpriseAddress = request.getParameter("suozai");
		String enterpriseProp = request.getParameter("xingzhi");
		String enterpriseRegCap = request.getParameter("zijin");
		String enterpriseEmpNum = request.getParameter("renshu");
		
		Enterprise enterprise = new Enterprise();
		enterprise.setEnterpriseAddress(enterpriseAddress);
		enterprise.setEnterpriseName(enterpriseName);
		enterprise.setEnterpriseProp(enterpriseProp);
		enterprise.setEnterpriseRegCap(enterpriseRegCap);
		enterprise.setEnterpriseEmpNum(enterpriseEmpNum);
		
		request.getSession().setAttribute("enterpriseName", enterpriseName);
		request.getSession().setAttribute("enterpriseAddress", enterpriseAddress);
		request.getSession().setAttribute("enterpriseProp", enterpriseProp);
		request.getSession().setAttribute("enterpriseRegCap", enterpriseRegCap);
		request.getSession().setAttribute("enterpriseEmpNum", enterpriseEmpNum);
		
		int countPage = EnterpriseSearchImpl.getAllEnterCountPage(enterprise);
		int count = EnterpriseSearchImpl.getAllEnterCountRecord(enterprise);
		request.getSession().setAttribute("countPage", countPage);
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("countPageNow", 1);
		EnterpriseSearchInterface esi = new EnterpriseSearchImpl();
		List<Enterprise> enterprises = new ArrayList<Enterprise>();
		enterprises = esi.EnterSearch(1,enterprise);
		request.setAttribute("enterprises", enterprises);
		request.getRequestDispatcher("../Career/qiyejiansuo2.jsp").forward(
				request, response);
		}else if(flag.equals("index")){
			
			int countPageNow = Integer.parseInt(request.getParameter("countPageNow"));
			Enterprise enterprise = new Enterprise();
			enterprise.setEnterpriseAddress((String)request.getSession().getAttribute("enterpriseAddress"));
			enterprise.setEnterpriseName((String)request.getSession().getAttribute("enterpriseName"));
			enterprise.setEnterpriseProp((String)request.getSession().getAttribute("enterpriseProp"));
			enterprise.setEnterpriseRegCap((String)request.getSession().getAttribute("enterpriseRegCap"));
			enterprise.setEnterpriseEmpNum((String)request.getSession().getAttribute("enterpriseEmpNum"));
			
			request.getSession().setAttribute("countPageNow", countPageNow);
			EnterpriseSearchInterface esi = new EnterpriseSearchImpl();
			List<Enterprise> enterprises = new ArrayList<Enterprise>();
			enterprises = esi.EnterSearch(countPageNow,enterprise);
			request.setAttribute("enterprises", enterprises);
			request.getRequestDispatcher("../Career/qiyejiansuo2.jsp").forward(
					request, response);
		}else if(flag.equals("content")){
			String enterpriseId = request.getParameter("enterpriseId");
			EnterpriseSearchInterface esi = new EnterpriseSearchImpl();
			Enterprise enterprise = new Enterprise();
			enterprise = esi.EnterSearchById(enterpriseId);
			request.setAttribute("enterprise", enterprise);
			request.getRequestDispatcher("../Career/qiyejiansuo3.jsp").forward(
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
