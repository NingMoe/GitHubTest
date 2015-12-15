package cn.edu.sdust.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public StudentRegisterServlet() {
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
		
		String stuUserName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String studentNum = request.getParameter("studentNum");
		String tName = request.getParameter("tName");
		
		Student student = new Student();
		student.setUserName(stuUserName);
		student.setPassWord(passWord);
		student.setStudentNum(studentNum);
		student.settName(tName);
		
		RegisterInterface ri = new RegisterImpl();
		if(ri.CheckStudentUserName(stuUserName)){
			String show = "<script language='javascript' type='text/javascript'>alert('用户名存在！请更换用户名！ ')</script>";
			out.println(show);
			String show1 = "<script language='javascript' type='text/javascript'>location.href='../Career/xueshengzhuce2.jsp'</script>";
			out.println(show1);
		}else if(ri.StuRegister(student)){
			 String show = "<script language='javascript' type='text/javascript'>alert('恭喜您，您已经注册成功！')</script>";
			 out.println(show);
			 String show1 = "<script language='javascript' type='text/javascript'>location.href='../servlet/IndexServlet'</script>";
			 out.println(show1);
		}else{
			 String show = "<script language='javascript' type='text/javascript'>alert('对不起，不是本校学生不能注册！')</script>";
			 out.println(show);
			 String show1 = "<script language='javascript' type='text/javascript'>location.href='../Career/xueshengzhuce2.jsp'</script>";
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
