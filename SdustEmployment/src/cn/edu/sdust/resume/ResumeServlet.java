package cn.edu.sdust.resume;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResumeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ResumeServlet() {
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
			
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setStudentName("");
			studentInfo.setGender("");
			studentInfo.setEduBg("");
			studentInfo.setLos("");
			studentInfo.setMajor("");
			studentInfo.setNativePlace("");
			
			request.getSession().setAttribute("studentName", "");
			request.getSession().setAttribute("gender", "");
			request.getSession().setAttribute("eduBg","");
			request.getSession().setAttribute("los", "");
			request.getSession().setAttribute("major", "");
			request.getSession().setAttribute("nativePlace", "");
			
			int countPage = ResumeImpl.getAllResumeCountPage(studentInfo);
			int count = ResumeImpl.getAllResumeCountRecord(studentInfo);
			request.getSession().setAttribute("countPage", countPage);
			request.getSession().setAttribute("count", count);
			request.getSession().setAttribute("countPageNow", 1);
			ResumeInterface ri = new ResumeImpl();
			List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
			studentInfos = ri.getAllStudentInfoByCondition(1, studentInfo);
			request.setAttribute("studentInfos",studentInfos);
			request.getRequestDispatcher("../Career/jianli.jsp").forward(
					request, response);
			
		}
		else if (flag.equals("main1")) {
			
			String studentName = request.getParameter("name");
			String gender = request.getParameter("sex");
			String eduBg = request.getParameter("level");
			String los = request.getParameter("years");
			String major = request.getParameter("Specialized");
			String nativePlace = request.getParameter("native");
			
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setStudentName(studentName);
			studentInfo.setGender(gender);
			studentInfo.setEduBg(eduBg);
			studentInfo.setLos(los);
			studentInfo.setMajor(major);
			studentInfo.setNativePlace(nativePlace);
			
			request.getSession().setAttribute("studentName", studentName);
			request.getSession().setAttribute("gender", gender);
			request.getSession().setAttribute("eduBg", eduBg);
			request.getSession().setAttribute("los", los);
			request.getSession().setAttribute("major", major);
			request.getSession().setAttribute("nativePlace", nativePlace);
			
			int countPage = ResumeImpl.getAllResumeCountPage(studentInfo);
			int count = ResumeImpl.getAllResumeCountRecord(studentInfo);
			request.getSession().setAttribute("countPage", countPage);
			request.getSession().setAttribute("count", count);
			request.getSession().setAttribute("countPageNow", 1);
			ResumeInterface ri = new ResumeImpl();
			List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
			studentInfos = ri.getAllStudentInfoByCondition(1, studentInfo);
			request.setAttribute("studentInfos",studentInfos);
			request.getRequestDispatcher("../Career/jianli.jsp").forward(
					request, response);
		} else if (flag.equals("index")) {
			
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setStudentName((String)request.getSession().getAttribute("studentName"));
			studentInfo.setGender((String)request.getSession().getAttribute("gender"));
			studentInfo.setEduBg((String)request.getSession().getAttribute("eduBg"));
			studentInfo.setLos((String)request.getSession().getAttribute("los"));
			studentInfo.setMajor((String)request.getSession().getAttribute("major"));
			studentInfo.setNativePlace((String)request.getSession().getAttribute("nativePlace"));
			
			int countPageNow = Integer.parseInt(request.getParameter("countPageNow"));
			request.getSession().setAttribute("countPageNow", countPageNow);
			ResumeInterface ri = new ResumeImpl();
			List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
			studentInfos = ri.getAllStudentInfoByCondition(countPageNow, studentInfo);
			request.setAttribute("studentInfos",studentInfos);
			request.getRequestDispatcher("../Career/jianli.jsp").forward(
					request, response);
		} else if (flag.equals("content")) {
			
			String StuNum = request.getParameter("StuNum");
			ResumeInterface ri = new ResumeImpl();
			StuResume stuResume = ri.getAllResumeByStuNum(StuNum);
			StuContact stuContact = ri.getAllStuContactByNum(StuNum);
			StudentInfo studentInfo_r = ri.getAllStudentInfoByStuNum(StuNum);
			request.setAttribute("stuResume", stuResume);
			request.setAttribute("stuContact", stuContact);
			request.setAttribute("studentInfo_r", studentInfo_r);
			request.getRequestDispatcher("../Career/jianli2.jsp").forward(
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
