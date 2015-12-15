<%@ page language="java" import="java.util.*,cn.edu.sdust.careerfair.CareerFair,cn.edu.sdust.recruitment.Recruitment,cn.edu.sdust.resume.StudentInfo,cn.edu.sdust.tool.StuQuery"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>山东科技大学&mdash;大学生就业网</title>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript"
	src="../Js/indexJs.js"></script>

</head>

<body>
	<div class=main_1>
		<!-- ----------head---------- -->
		<div>
			<jsp:include page="main.jsp" />
		</div>
		<!-- ----------left---------- -->
		<div>
			<jsp:include page="main_left.jsp" />
		</div>
		<!-- ----------right---------- -->
		<div class="rightdiv" id="body_1">
			<div class="sub">
				<div class="zhaopinhuixinxi">
					<div class="zhaopinhuixinxi_top">
						<table width="100%" height="36" border="0" cellpadding="0"
							cellspacing="0" class="tablea">
							<tr>
								<td width="75%" height="25">&nbsp;</td>
								<td width="25%" align="center" ><a href="../servlet/CareerFairServlet?flag=main">更多</a>
								</td>
							</tr>
						</table>
					</div>
					<div class="zhaopinhuixinxi_bottom">
						<%
							List<CareerFair> careerFairs = new ArrayList<CareerFair>();
							careerFairs = (List<CareerFair>)request.getAttribute("careerFairs");
						%>

						<ul>

							<% for(CareerFair careerFair:careerFairs) { %>

							<li><a href="../servlet/CareerFairServlet?flag=content&CFID=<%=careerFair.getcfID() %>"><font color="#3300FF">[<%=careerFair.getcFReleaseTime().substring(0, 10)%>]&nbsp;<%=careerFair.getcFClassfy() %></font>&nbsp;<%=careerFair.getcFTitle() %></a>
								&nbsp;&nbsp;
							<%if(careerFair.getcFTop().equals("1")) { %>
								<font style="color:#F30; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px;">[OnTop]</font>
							<%} %>
							</li>

							<% } %>
						</ul>

					</div>
				</div>


				<div class="xinxi">
					<div class="xinxi_top">
						<table width="100%" height="25" border="0" cellpadding="0"
							cellspacing="0" class="tablea">
							<tr>
								<td width="75%" height="25">&nbsp;</td>
								<td width="25%" align="center" valign="bottom"><a href="../servlet/RecruitmentServlet?flag=main">更多</a>
								</td>
							</tr>
						</table>
					</div>
					<div class="xinxi_bottom">

						<%
							List<Recruitment> recruitments = new ArrayList<Recruitment>();
							recruitments = (List<Recruitment>)request.getAttribute("recruitments");
						%>

						<ul>
							<% for(Recruitment recruitment:recruitments) { %>

							<li><a href="../servlet/RecruitmentServlet?flag=content&ID=<%=recruitment.getRecruitId()%>"><font color="#3300FF">[<%=recruitment.getRecruitReleaseTime().substring(0, 10) %>]&nbsp;<%=recruitment.getRecruitWorkplace() %></font>&nbsp;<%=recruitment.getRecruitTitle() %></a>
							<%if(recruitment.getRecruitTop().equals("1")) {%>
								&nbsp;&nbsp;<font
								style="color:#F30; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px;">[OnTop]</font>
								<%} %>
							</li>

							<% } %>

						</ul>

					</div>
					<iframe src="../ncss/index.html" frameborder="0" width="100%"
						height="105" scrolling="no"></iframe>
				</div>

				<div class="jianli">
					<div class="jianli_top">
						<table width="100%" height="25" border="0" cellpadding="0"
							cellspacing="0" class="tablea">
							<tr>
								<td width="73%" height="25">&nbsp;</td>
								<td width="27%" align="center" valign="bottom"><a
									href="../servlet/ResumeServlet?flag=main">更多</a></td>
							</tr>
						</table>
					</div>
					<div class="jianli_bottom">
						<%
								List<StudentInfo> studentInfos = new ArrayList<StudentInfo>();
								studentInfos = (List<StudentInfo>)request.getAttribute("studentInfos");
							 %>
						<ul>
							<% for(StudentInfo studentInfo:studentInfos) { %>
							<li><a href="../servlet/ResumeServlet?flag=content&StuNum=<%=studentInfo.getStudentNum() %>"><%=studentInfo.getMajor() %>&nbsp;&nbsp;<%=studentInfo.getStudentName() %>&nbsp;&nbsp;<%=studentInfo.getNativePlace() %></a>
								&nbsp;&nbsp;<font
								style="color:#F30; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px;"></font>
							</li>
							<%} %>
						</ul>
					</div>
				</div>

				<div class="zhengce">
					<div class="zhengce_top">
						<table width="100%" height="25" border="0" cellpadding="0"
							cellspacing="0" class="tablea">
							<tr>
								<td width="73%" height="25">&nbsp;</td>
								<td width="27%" align="center" valign="bottom"><a
									href="../servlet/PolicyServlet?flag=main">更多</a></td>
							</tr>
						</table>
					</div>
					<div class="jianli_bottom">
						<%
							List<StuQuery> P_StuQuerys = new ArrayList<StuQuery>();
							P_StuQuerys = (List<StuQuery>)request.getAttribute("P_StuQuerys");
						 %>
						<ul>

							<% for(StuQuery P_StuQuery:P_StuQuerys) { %>
							<li>
								<%if(P_StuQuery.getTitle().length() >= 18) {%>
								<a href="../servlet/PolicyServlet?flag=content&ID=<%=P_StuQuery.getiD()%>"><font color="#3300FF">[<%=P_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=P_StuQuery.getTitle().substring(0, 18) %>....</a>
								<%} else { %>
								<a href="../servlet/PolicyServlet?flag=content&ID=<%=P_StuQuery.getiD()%>"><font color="#3300FF">[<%=P_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=P_StuQuery.getTitle() %></a>
								<%} %>
							</li>

							<%} %>

						</ul>
					</div>
				</div>

				<div class="liucheng">
					<div class="liucheng_top">
						<table width="100%" height="25" border="0" cellpadding="0"
							cellspacing="0" class="tablea">
							<tr>
								<td width="73%" height="25">&nbsp;</td>
								<td width="27%" align="center" valign="bottom"><a
									href="../servlet/ProcessServlet?flag=main">更多</a></td>
							</tr>
						</table>
					</div>
					<div class="jianli_bottom">
						<%
							List<StuQuery> J_StuQuerys = new ArrayList<StuQuery>();
							J_StuQuerys = (List<StuQuery>)request.getAttribute("J_StuQuerys");
						 %>
						<ul>

							<% for(StuQuery J_StuQuery:J_StuQuerys) { %>
							<li>
								<%if(J_StuQuery.getTitle().length() >= 18) {%>
								<a href="../servlet/ProcessServlet?flag=content&ID=<%=J_StuQuery.getiD()%>"><font color="#3300FF">[<%=J_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=J_StuQuery.getTitle().substring(0, 18) %>....</a>
								<%} else { %>
								<a href="../servlet/ProcessServlet?flag=content&ID=<%=J_StuQuery.getiD()%>"><font color="#3300FF">[<%=J_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=J_StuQuery.getTitle() %></a>
								<%} %>
							</li>

							<% } %>

						</ul>
					</div>
				</div>


				<div class="jiqiao">
					<div class="jiqiao_top">
						<table width="100%" height="25" border="0" cellpadding="0"
							cellspacing="0" class="tablea">
							<tr>
								<td width="73%" height="25">&nbsp;</td>
								<td width="27%" align="center" valign="bottom"><a
									href="../servlet/SkillServlet?flag=main">更多</a></td>
							</tr>
						</table>
					</div>
					<div class="jianli_bottom">
						<%
							List<StuQuery> C_StuQuerys = new ArrayList<StuQuery>();
							C_StuQuerys = (List<StuQuery>)request.getAttribute("C_StuQuerys");
						 %>
						<ul>

							<% for(StuQuery C_StuQuery:C_StuQuerys) { %>

							<li>
								<%if(C_StuQuery.getTitle().length() >= 18) {%>
								<a href="../servlet/SkillServlet?flag=content&ID=<%=C_StuQuery.getiD()%>"><font color="#3300FF">[<%=C_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=C_StuQuery.getTitle().substring(0, 18) %>....</a>
								<%} else { %>
								<a href="../servlet/SkillServlet?flag=content&ID=<%=C_StuQuery.getiD()%>"><font color="#3300FF">[<%=C_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=C_StuQuery.getTitle() %></a>
								<%} %>
							</li>

							<% } %>

						</ul>
					</div>
				</div>


				<div class="liucheng">
					<div class="liucheng_top"
						style="background:url(../images/add_tit_32.png) no-repeat 0 0;">
						<table width="100%" height="25" border="0" cellpadding="0"
							cellspacing="0" class="tablea">
							<tr>
								<td width="73%" height="25">&nbsp;</td>
								<td width="27%" align="center" valign="bottom"><a
									href="../servlet/OfficeBearerServlet?flag=main">更多</a></td>
							</tr>
						</table>
					</div>
					<div class="jianli_bottom">
						<%
							List<StuQuery> O_StuQuerys = new ArrayList<StuQuery>();
							O_StuQuerys = (List<StuQuery>)request.getAttribute("O_StuQuerys");
						 %>
						<ul>

							<% for(StuQuery O_StuQuery:O_StuQuerys) { %>

							<li>
								<%if(O_StuQuery.getTitle().length() >= 18) {%>
								<a href="../servlet/OfficeBearerServlet?flag=content&ID=<%=O_StuQuery.getiD()%>"><font color="#3300FF">[<%=O_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=O_StuQuery.getTitle().substring(0, 18) %>....</a>
								<%} else { %>
								<a href="../servlet/OfficeBearerServlet?flag=content&ID=<%=O_StuQuery.getiD()%>"><font color="#3300FF">[<%=O_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=O_StuQuery.getTitle() %></a>
								<%} %>

							</li>

							<%} %>

						</ul>
					</div>
				</div>


				<div class="jiqiao">
					<div class="jiqiao_top"
						style="background:url(../images/add_tit_33.png) no-repeat 0 0;">
						<table width="100%" height="25" border="0" cellpadding="0"
							cellspacing="0" class="tablea">
							<tr>
								<td width="73%" height="25">&nbsp;</td>
								<td width="27%" align="center" valign="bottom"><a
									href="../servlet/LocalityServlet?flag=main">更多</a></td>
							</tr>
						</table>
					</div>
					<div class="jianli_bottom">
						<%
							List<StuQuery> L_StuQuerys = new ArrayList<StuQuery>();
							L_StuQuerys = (List<StuQuery>)request.getAttribute("L_StuQuerys");
						 %>
						<ul>

							<% for(StuQuery L_StuQuery:L_StuQuerys) { %>

							<li>
								<%if(L_StuQuery.getTitle().length() >= 18) {%>
								<a href="../servlet/LocalityServlet?flag=content&ID=<%=L_StuQuery.getiD()%>"><font color="#3300FF">[<%=L_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=L_StuQuery.getTitle().substring(0, 18) %>....</a>
								<%} else { %>
								<a href="../servlet/LocalityServlet?flag=content&ID=<%=L_StuQuery.getiD()%>"><font color="#3300FF">[<%=L_StuQuery.getReleaseTime().substring(0, 10) %>]</font>&nbsp;<%=L_StuQuery.getTitle() %></a>
								<%} %>

							</li>

							<%} %>

						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- ----------copyright---------- -->
		<div>
			<jsp:include page="copyright.jsp" />
		</div>
	</div>
	<!-- ----------share---------- -->
	<jsp:include page="main_share.jsp" />
</body>
</html>
