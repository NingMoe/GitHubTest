package cn.edu.sdust.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePassServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpdatePassServlet() {
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
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		
		Login login = new Login();
		login.setUserName((String)request.getSession().getAttribute("userName"));
		login.setPassWord(oldPass);
		login.setLoginbtn((String)request.getSession().getAttribute("loginbtn"));
		
		LoginInterface li = new LoginImpl();
		
		if(li.Update(login, newPass)){
			String show = "<script language='javascript' type='text/javascript'>alert('密码修改成功，请重新登陆！')</script>";
			out.println(show);
			String show1 = "<script language='javascript' type='text/javascript'>location.href='../servlet/ExitServlet'</script>";
			out.println(show1);
		}else{
			String show = "<script language='javascript' type='text/javascript'>alert('密码修改失败，请检查密码是否正确！')</script>";
			out.println(show);
			String show1 = "<script language='javascript' type='text/javascript'>location.href='../Career/xiugaimima.jsp'</script>";
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
