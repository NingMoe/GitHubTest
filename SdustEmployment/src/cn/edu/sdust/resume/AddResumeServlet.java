package cn.edu.sdust.resume;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResumeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddResumeServlet() {
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
		
		String birthday = request.getParameter("birthday");
		String nation = request.getParameter("nation");
		String graduateSchool = request.getParameter("school");
		String studentTel = request.getParameter("tel");
		String studentEmail = request.getParameter("email");
		String studentQQ = request.getParameter("qq");
		String studentZip = request.getParameter("zip");
		String studentAddress = request.getParameter("address");
		String politicsStatus = request.getParameter("ps");
		String language = request.getParameter("language");
		String expertise= request.getParameter("expertise");
		String hobby = request.getParameter("hobby");
		String awards = request.getParameter("award");
		String projectAcademic = request.getParameter("projectAcademic");
		String practiceWork = request.getParameter("practiceWork");
		String jobIntension = request.getParameter("jobIntension");
		String selfAssessment = request.getParameter("selfAssessment");
		
		StuResume stuResume = new StuResume();
		StuContact stuContact = new StuContact();
		stuResume.setAwards(awards);
		stuResume.setBirthday(birthday);
		stuResume.setExpertise(expertise);
		stuResume.setGraduateSchool(graduateSchool);
		stuResume.setHobby(hobby);
		stuResume.setJobIntension(jobIntension);
		stuResume.setLanguage(language);
		stuResume.setNation(nation);
		stuResume.setPoliticsStatus(politicsStatus);
		stuResume.setPracticeWork(practiceWork);
		stuResume.setProjectAcademic(projectAcademic);
		stuResume.setSelfAssessment(selfAssessment);
		
		stuContact.setStudentAddress(studentAddress);
		stuContact.setStudentEmail(studentEmail);
		stuContact.setStudentQQ(studentQQ);
		stuContact.setStudentTel(studentTel);
		stuContact.setStudentZip(studentZip);
	
		String studentUserName = (String)request.getSession().getAttribute("userName");
		ResumeInterface ri = new ResumeImpl();
		String studentNum = ri.getStudentNumByStuName(studentUserName);
		if(ri.addStudentResume(studentNum, stuResume, stuContact)){
			
			request.getSession().setAttribute("Resume", "是");
			String show = "<script language='javascript' type='text/javascript'>alert('提交简历成功！')</script>";
			out.println(show);
			String show1 = "<script language='javascript' type='text/javascript'>location.href='../servlet/IndexServlet'</script>";
			out.println(show1);
			
		} else {
			
			String show = "<script language='javascript' type='text/javascript'>alert('提交简历失败,请点击修改简历重新编辑！')</script>";
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
