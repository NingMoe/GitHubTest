<%@ page language="java" import="java.util.*,cn.edu.sdust.tool.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

<title>山东科技大学&mdash;大学生就业网</title>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript"
	src="../Js/indexJs.js"></script>

</head>

<body>
		<div>
			<div class="top">
				<ul class="nav">
					<li><a href="http://www.sdkd.net.cn">学校主页</a>
					</li>
					<li><a href="../servlet/IndexServlet">就业网首页</a>
					</li>
					<li><a href="../servlet/RecruitmentServlet?flag=main">招聘信息</a>
					</li>
					<li><a href="../servlet/CareerFairServlet?flag=main">招聘会信息</a>
					</li>
					<li><a href="../servlet/ResumeServlet?flag=main">求职简历</a>
					</li>
					<li><a href="../servlet/DynamicServlet?flag=main">就业动态</a>
					</li>
					<li><a href="../servlet/PolicyServlet?flag=main">就业政策</a>
					</li>
					<li><a href="../servlet/MajorServlet?flag=main">专业介绍</a>
					</li>
					<li><a href="../servlet/ProcessServlet?flag=main">就业流程</a>
					</li>
					<li><a href="../servlet/DataServlet?flag=main">资料查询</a>
					</li>
					<li><a href="../servlet/OfficeBearerServlet?flag=main">公务员报考</a>
					</li>
					<li><a href="../servlet/LocalityServlet?flag=main">基层就业</a>
					</li>
				</ul>
			</div>
			<div class="gonggao">
			<%
				List<StuQuery> N_StuQuerys = new ArrayList<StuQuery>();
				N_StuQuerys = (List<StuQuery>)session.getAttribute("N_StuQuerys");
			 %>
				<table width="985" border="0" cellspacing="0" cellpadding="0"
					height="25">
					<tr>
						<td width="13%" height="25" align="center" valign="bottom"><font
							color="#6699CC" style="font-weight:bold;"> 公告栏--<a
								href="../servlet/NoticeServlet?flag=main">more</a></font>
						</td>
						<td width="90%" valign="bottom"><marquee scrollamount="6" ><font size="3">
						<%
						 for(StuQuery stuQuery:N_StuQuerys) {
						 %>
						 <a href="../servlet/NoticeServlet?flag=content&ID=<%=stuQuery.getiD()%>" style="color:red">[<%=stuQuery.getReleaseTime().substring(0, 10) %>]<%=stuQuery.getTitle() %></a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<% } %>
						</font></marquee></td>
					</tr>
				</table>
			</div>

			<div class="mid">
				<img src="../images/321.jpg" width="985px" />
			</div>
		</div>
</body>
</html>
