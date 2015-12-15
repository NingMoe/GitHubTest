package cn.edu.sdust.verify;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sdust.resume.StudentInfo;

public class VerifyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public VerifyServlet() {
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
		
		String studentName = request.getParameter("studentName");
		String gender = request.getParameter("gender");
		String eduBg = request.getParameter("eduBg");
		String major = request.getParameter("major");
		String los = request.getParameter("los");
		String nativePlace = request.getParameter("nativePlace");
		
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setEduBg(eduBg);
		studentInfo.setGender(gender);
		studentInfo.setLos(los);
		studentInfo.setMajor(major);
		studentInfo.setNativePlace(nativePlace);
		studentInfo.setStudentName(studentName);
		
		VerifyInterface vi = new VerifyImpl();
		if(studentName.equals("")||studentName.length()==0||gender.equals("")||gender.length()==0||eduBg.equals("")||eduBg.length()==0||
				major.equals("")||major.length()==0||los.equals("")||los.length()==0||nativePlace.equals("")||nativePlace.length()==0){
			String show = "<script language='javascript' type='text/javascript'>alert('带*的不能为空！ ')</script>";
			out.println(show);
			String show1 = "<script language='javascript' type='text/javascript'>location.href='../Career/xueshengsousuo.jsp'</script>";
			out.println(show1);
		}else if(vi.StuVerify(studentInfo)){
			String show = "<script language='javascript' type='text/javascript'>alert('该学生是本校学生！ ')</script>";
			out.println(show);
			String show1 = "<script language='javascript' type='text/javascript'>location.href='../Career/xueshengsousuo.jsp'</script>";
			out.println(show1);
		}
		else{
			String show = "<script language='javascript' type='text/javascript'>alert('该学生不是本校学生或你输入的信息不正确！！ ')</script>";
			out.println(show);
			String show1 = "<script language='javascript' type='text/javascript'>location.href='../Career/xueshengsousuo.jsp'</script>";
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
