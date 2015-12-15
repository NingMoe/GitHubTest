package cn.edu.sdust.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sdust.register.Enterprise;

public class UpdateRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			
			String userName = (String)request.getSession().getAttribute("userName");
			Enterprise enterprise = new Enterprise();
			LoginInterface li = new LoginImpl();
			enterprise = li.getAllEncontactByUserName(userName);
			request.setAttribute("enterprise", enterprise);
			request.getRequestDispatcher("../Career/xiugaizhucexinxi.jsp").forward(request, response);
		}
		if(flag.equals("main1")){
			
			String userName = (String)request.getSession().getAttribute("userName");
			String enterpriseAttn = request.getParameter("cperson");
			String faxNum = request.getParameter("cfax");
			String enterprisePhone = request.getParameter("cphone");
			String enterpriseZip = request.getParameter("czip");
			String enterpriseEmail = request.getParameter("cemail");
			String postalAddress = request.getParameter("caddr2");
			String enterprisePost = request.getParameter("cposition");
			String phoneNum = request.getParameter("cmobile");
			String enterpriseIndex = request.getParameter("cwww");
			
			Enterprise enterprise = new Enterprise();
			enterprise.setEnterpriseAttn(enterpriseAttn);
			enterprise.setFaxNum(faxNum);
			enterprise.setEnterprisePhone(enterprisePhone);
			enterprise.setEnterpriseZip(enterpriseZip);
			enterprise.setEnterpriseEmail(enterpriseEmail);
			enterprise.setPostalAddress(postalAddress);
			enterprise.setEnterprisePost(enterprisePost);
			enterprise.setPhoneNum(phoneNum);
			enterprise.setEnterpriseIndex(enterpriseIndex);
			
			LoginInterface li = new LoginImpl();
			
			if(li.UpdateRegister(enterprise, userName)){
				String show = "<script language='javascript' type='text/javascript'>alert('ÐÞ¸Ä³É¹¦£¡ ')</script>";
				out.println(show);
				String show1 = "<script language='javascript' type='text/javascript'>location.href='../servlet/IndexServlet'</script>";
				out.println(show1);
			}
			
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
