package cn.edu.sdust.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sdust.careerfair.CareerFair;
import cn.edu.sdust.recruitment.Recruitment;
import cn.edu.sdust.resume.StudentInfo;
import cn.edu.sdust.tool.StuQuery;

public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public IndexServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		IndexInterface ii = new IndexImpl();

		List<CareerFair> careerFairs = new ArrayList<CareerFair>();
		careerFairs = ii.getAllTopCareerFair();
		List<Recruitment> recruitments = new ArrayList<Recruitment>();
		recruitments = ii.getAllTopRecruitment();
		List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
		studentInfos = ii.getAllTopResume();
		List<StuQuery> P_StuQuerys = new ArrayList<StuQuery>();
		P_StuQuerys = ii.getAllTopEmpPolicy();
		List<StuQuery> J_StuQuerys = new ArrayList<StuQuery>();
		J_StuQuerys = ii.getAllTopJSP();
		List<StuQuery> C_StuQuerys = new ArrayList<StuQuery>();
		C_StuQuerys = ii.getAllTopConmmSkill();
		List<StuQuery> O_StuQuerys = new ArrayList<StuQuery>();
		O_StuQuerys = ii.getAllTopOfficeBearer();
		List<StuQuery> L_StuQuerys = new ArrayList<StuQuery>();
		L_StuQuerys = ii.getAllTopLocality();
		List<StuQuery> N_StuQuerys = new ArrayList<StuQuery>();
		N_StuQuerys = ii.getAllTopNotice();
		Total total = new Total();
		total = ii.getAllTotal();

		request.setAttribute("careerFairs", careerFairs);
		request.setAttribute("recruitments", recruitments);
		request.setAttribute("studentInfos", studentInfos);
		request.setAttribute("P_StuQuerys", P_StuQuerys);
		request.setAttribute("J_StuQuerys", J_StuQuerys);
		request.setAttribute("C_StuQuerys", C_StuQuerys);
		request.setAttribute("O_StuQuerys", O_StuQuerys);
		request.setAttribute("L_StuQuerys", L_StuQuerys);
		request.getSession().setAttribute("total", total);
		request.getSession().setAttribute("N_StuQuerys", N_StuQuerys);
		request.getRequestDispatcher("../Career/index.jsp").forward(request,
				response);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
