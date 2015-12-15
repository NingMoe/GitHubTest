<%@ page language="java" import="java.util.*,cn.edu.sdust.tool.StuQuery" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<link href="css/scrollstyle.css" rel="stylesheet" type="text/css" />
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
					<div class="sub_top">
						<table width="701" height="47" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td width="351" background="../images/liucheng_12.jpg">&nbsp;</td>
								<td width="350" background="../images/sub1_13.jpg"
									class="tablea" style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt; 就业流程</td>
							</tr>
						</table>
					</div>
					<div class="sub_bottom">
						<%
							List<StuQuery> stuQuerys = (List<StuQuery>) request
									.getAttribute("stuQuerys");
						%>
						<ul>
							<%
								for (StuQuery stuQuery : stuQuerys) {
							%>
							<li><a
								href="../servlet/ProcessServlet?flag=content&ID=<%=stuQuery.getiD()%>"><%=stuQuery.getReleaseTime().substring(0, 10) %>&nbsp;<%=stuQuery.getTitle()%></a>
								<%if(stuQuery.getTop().equals("1")) { %>
								&nbsp;&nbsp;<font
								style="color:#F30; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px;">[OnTop]</font>
								<%} %>
							</li>
							<%
								}
							%>
						</ul>
						<div class="fenye">
							共有<%=request.getSession().getAttribute("count")%>
							条记录&nbsp;&nbsp;每页13条&nbsp;&nbsp;第<%=request.getSession().getAttribute("countPageNow")%>/<%=request.getSession().getAttribute("countPage")%>页
							&nbsp;<a
								href="../servlet/ProcessServlet?flag=index&countPageNow=1">首页</a>
							&nbsp;
							<%
								if ((Integer) request.getSession().getAttribute("countPageNow") == 1) {
							%>上一页<%
								} else {
							%>
							<a
								href="../servlet/ProcessServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") - 1%>">上一页</a>&nbsp;
							<%
								}
								if (request.getSession().getAttribute("countPageNow") == request
										.getSession().getAttribute("countPage")) {
							%>下一页<%
								} else {
							%>
							<a
								href="../servlet/ProcessServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") + 1%>">下一页</a>&nbsp;
							<%
								}
							%>
							<a
								href="../servlet/ProcessServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute("countPage")%>">尾页</a>&nbsp;

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
