package cn.edu.sdust.resume;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetResumeInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public GetResumeInfoServlet() {
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
		
		String studentUserName = (String)request.getSession().getAttribute("userName");
		String loginbtn = (String)request.getSession().getAttribute("loginbtn");
		
		StuResume stuResume = new StuResume();
		StuContact stuContact = new StuContact();
		StudentInfo studentInfo = new StudentInfo();
		
		if(loginbtn.equals("student")){
			
			ResumeInterface ri = new ResumeImpl();
			String studentNum = ri.getStudentNumByStuName(studentUserName);
			stuResume = ri.getAllResumeByStuNum(studentNum);
			stuContact = ri.getAllStuContactByNum(studentNum);
			studentInfo = ri.getAllStudentInfoByStuNum(studentNum);
			request.setAttribute("studentInfo", studentInfo);
			request.setAttribute("stuResume", stuResume);
			request.setAttribute("stuContact", stuContact);
			request.getRequestDispatcher("../Career/xiugaijianli.jsp").forward(request, response);
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
