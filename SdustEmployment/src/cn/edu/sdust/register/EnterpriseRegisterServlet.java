package cn.edu.sdust.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnterpriseRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EnterpriseRegisterServlet() {
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
		
		String enUserName = request.getParameter("username");
		String enPassWord = request.getParameter("password");
		String enterpriseName = request.getParameter("cname");
		String enterpriseRegtime = request.getParameter("cdate");
		String enterpriseIndus = request.getParameter("changye");
		String enterpriseProp = request.getParameter("ctype");
		String enterpriseEmpNum = request.getParameter("cnum");
		String enterpriseRegCap = request.getParameter("cmoney");
		String enterpriseAddress = request.getParameter("caddr");
		String enterpriseBrief = request.getParameter("cmore");
		String enterpriseAttn = request.getParameter("cperson");
		String faxNum = request.getParameter("cfax");
		String enterprisePhone = request.getParameter("cphone");
		String enterpriseZip = request.getParameter("czip");
		String enterpriseEmail = request.getParameter("cemail");
		String postalAddress = request.getParameter("caddr2");
		String enterprisePost = request.getParameter("cposition");
		String phoneNum = request.getParameter("cmobile");
		String enterpriseIndex = request.getParameter("cwww");
		
		Enterprise enterReg = new Enterprise();
		enterReg.setEnUserName(enUserName);
		enterReg.setEnPassWord(enPassWord);
		enterReg.setEnterpriseName(enterpriseName);
		enterReg.setEnterpriseRegtime(enterpriseRegtime);
		enterReg.setEnterpriseIndus(enterpriseIndus);
		enterReg.setEnterpriseProp(enterpriseProp);
		enterReg.setEnterpriseEmpNum(enterpriseEmpNum);
		enterReg.setEnterpriseRegCap(enterpriseRegCap);
		enterReg.setEnterpriseAddress(enterpriseAddress);
		enterReg.setEnterpriseBrief(enterpriseBrief);
		enterReg.setEnterpriseAttn(enterpriseAttn);
		enterReg.setFaxNum(faxNum);
		enterReg.setEnterprisePhone(enterprisePhone);
		enterReg.setEnterpriseZip(enterpriseZip);
		enterReg.setEnterpriseEmail(enterpriseEmail);
		enterReg.setPostalAddress(postalAddress);
		enterReg.setEnterprisePost(enterprisePost);
		enterReg.setPhoneNum(phoneNum);
		enterReg.setEnterpriseIndex(enterpriseIndex);
		
		RegisterInterface ri = new RegisterImpl();
		if(ri.CheckEnUserName(enUserName)){
			String show = "<script language='javascript' type='text/javascript'>alert('用户名存在！请更换用户名！ ')</script>";
			out.println(show);
			String show1 = "<script language='javascript' type='text/javascript'>location.href='../Career/qiyezhuce2.jsp'</script>";
			out.println(show1);
		}else if(ri.EnRegister(enterReg)){
			 String show = "<script language='javascript' type='text/javascript'>alert('恭喜您，您已经注册成功！')</script>";
			 out.println(show);
			 String show1 = "<script language='javascript' type='text/javascript'>location.href='../servlet/IndexServlet'</script>";
			 out.println(show1);
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
