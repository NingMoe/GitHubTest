package cn.edu.sdust.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sdust.resume.ResumeImpl;
import cn.edu.sdust.resume.ResumeInterface;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
		
		String userName = request.getParameter("c_name");
		String passWord = request.getParameter("c_pass");
		String verify = request.getParameter("yanzheng");
		String loginbtn = request.getParameter("loginbtn");
		
		request.getSession().setAttribute("loginbtn", loginbtn);
		request.getSession().setAttribute("Resume", "否");
		
		Login login = new Login();
		login.setUserName(userName);
		login.setPassWord(passWord);
		login.setLoginbtn(loginbtn);
		
		LoginInterface li = new LoginImpl();
		if (verify.equals(request.getSession().getAttribute("captcha"))) {
			if (li.Login(login)) {
				if (loginbtn.equals("student")) {
					ResumeInterface ri = new ResumeImpl();
					String studentNum = ri.getStudentNumByStuName(userName);
					if (li.ifResume(studentNum)) {
						request.getSession().setAttribute("Resume", "是");
					}
				}
				request.getSession().setAttribute("userName", userName);
				request.getSession().setAttribute("loginbtn", loginbtn);
				response.sendRedirect("../servlet/IndexServlet");
			} else {
				String show = "<script language='javascript' type='text/javascript'>alert('登陆信息有误，请重新登陆！')</script>";
				out.println(show);
				String show1 = "<script language='javascript' type='text/javascript'>location.href='../servlet/IndexServlet'</script>";
				out.println(show1);
			}
		} else {
			String show = "<script language='javascript' type='text/javascript'>alert('验证码错误，请重新登陆！')</script>";
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
