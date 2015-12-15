
<%@ page language="java" import="java.util.*,cn.edu.sdust.recruitment.*"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>信息招聘&mdash;大学生就业网</title>
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
				<div class="sub_top">
					<table width="701" height="47" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="351" background="../images/sub1_12.jpg">&nbsp;</td>
							<td width="350" background="../images/sub1_13.jpg" 
								style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt;
								招聘信息</td>
						</tr>
					</table>
				</div>
				<div class="sub_bottom">
					<div style="text-align:center; padding:15px 5px;">
						<form id="form3" name="form3" method="post"
							action="../servlet/RecruitmentServlet">
							<input type="hidden" name="flag" value="main1"/>
							<center>
								<table width="300" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="150" align="right"><h4>招聘信息时间：从：</h4>
										</td>
										<td width="150"><input name="time" value="<%=session.getAttribute("recruitReleaseTime") %>"
											type="text" size="18" />
										</td>
									</tr>
									<tr>
										<td height="5"></td>
									</tr>
									<tr>
										<td width="150" align="right"><h4>到：</h4>
										</td>
										<td width="150"><input name="time1" value="<%=session.getAttribute("recruitReleaseTime1") %>"
											type="text" size="18" />
										</td>
									</tr>
									<tr>
										<td height="5"></td>
									</tr>
									<tr>
										<td width="150" align="right"><h4>招聘企业：</h4>
										</td>
										<td width="150"><input type="text" name="enterprise"
											size="18" value="<%=session.getAttribute("recruitEntName") %>" />
										</td>
									</tr>
									<tr>
										<td height="5"></td>
									</tr>
									<tr>
										<td width="150" align="right"><h4>所需职位：</h4>
										</td>
										<td width="150"><input name="job" value="<%=session.getAttribute("recruitJob") %>" type="text"
											size="18" />
										</td>
									</tr>
									<tr>
										<td height="5"></td>
									</tr>
									<tr>
										<td width="150" align="right"><h4>就业地点：</h4>
										</td>
										<td width="150"><input name="address" value="<%=session.getAttribute("recruitWorkplace") %>"
											type="text" size="18" />
										</td>
									</tr>
									<tr>
										<td height="5"></td>
									</tr>
									<tr>
										<td width="150" align="right"><input type="submit"
											value="提交" />&nbsp;&nbsp;&nbsp;</td>
										<td width="150" align="left">&nbsp;&nbsp;&nbsp;<input
											type="reset" value="重置" />
										</td>
									</tr>
								</table>
							</center>
						</form>
					</div>
					<%
						List<Recruitment> recruitments = (List<Recruitment>) request
								.getAttribute("recruitments");
					%>
					<ul>
						<%
							for (Recruitment recruitment : recruitments) {
						%>
						<li><a
							href="../servlet/RecruitmentServlet?flag=content&ID=<%=recruitment.getRecruitId()%>"><font
								color="#3300FF">[<%=recruitment.getRecruitReleaseTime().substring(0, 10)%>]&nbsp;<%=recruitment.getRecruitWorkplace() %></font>&nbsp;<%=recruitment.getRecruitTitle()%></a>
								<%if(recruitment.getRecruitTop().equals("1")) {%>
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
							href="../servlet/RecruitmentServlet?flag=index&countPageNow=1">首页</a>
						&nbsp;
						<%
							if ((Integer) request.getSession().getAttribute("countPageNow") == 1) {
						%>上一页<%
							} else {
						%>
						<a
							href="../servlet/RecruitmentServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") - 1%>">上一页</a>&nbsp;
						<%
							}
							if (request.getSession().getAttribute("countPageNow") == request
									.getSession().getAttribute("countPage")) {
						%>下一页<%
							} else {
						%>
						<a
							href="../servlet/RecruitmentServlett?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") + 1%>">下一页</a>&nbsp;
						<%
							}
						%>
						<a
							href="../servlet/RecruitmentServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute("countPage")%>">尾页</a>&nbsp;

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
