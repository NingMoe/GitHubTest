package cn.edu.sdust.recruitment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddRecruitmentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddRecruitmentServlet() {
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
		
		String recruitTitle = request.getParameter("title");
		String recruitAuthor = request.getParameter("author");
		String recruitOrgin = request.getParameter("origin");
		String recruitContent = request.getParameter("content");
		String recruitEntName = request.getParameter("enterprise");
		String recruitJob = request.getParameter("job");
		String recruitWorkplace = request.getParameter("address");
		
		Recruitment recruitment = new Recruitment();
		recruitment.setRecruitAuthor(recruitAuthor);
		recruitment.setRecruitContent(recruitContent);
		recruitment.setRecruitOrgin(recruitOrgin);
		recruitment.setRecruitTitle(recruitTitle);
		recruitment.setRecruitJob(recruitJob);
		recruitment.setRecruitWorkplace(recruitWorkplace);
		recruitment.setRecruitEntName(recruitEntName);
		
		RecruitmentInterface ri = new RecruitmentImpl();
		if(ri.addRecruitment(recruitment)){
			String show = "<script language='javaScript' type='text/javascript'>alert('添加招聘信息成功！')</script>";
			out.println(show);
			String show1 = "<script language='javaScript' type='text/javascript'>location.href='../servlet/IndexServlet'</script>";
			out.println(show1);
		}else{
			String show = "<script language='javaScript' type='text/javascript'>alert('添加招聘信息失败！')</script>";
			out.println(show);
			String show1 = "<script language='javaScript' type='text/javascript'>location.href='../Career/fabuzhaopinxinxi.jsp'</script>";
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
