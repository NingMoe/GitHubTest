<%@ page language="java" import="java.util.*,cn.edu.sdust.register.Enterprise"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>企业检索—山东科技大学&mdash;大学生就业网</title>



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
							<td width="351" background="../images/qiyesousuo_12.jpg">&nbsp;</td>
							<td width="350" background="../images/sub1_13.jpg" class="tablea"
								style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt;
								<a href="Javascript:window.history.go(-1)">企业检索</a>&gt;&gt;检索结果</td>
						</tr>
					</table>
				</div>
				<div class="sub_bottom">

					<table width="650" height="47" border="0" align="center"
						cellpadding="0" cellspacing="1" bgcolor="#ccccCC">
						<tr>
							<td height="35" align="center" bgcolor="#999999"
								style="color:#FFF">公司名字</td>
							<td height="35" align="center" bgcolor="#999999"
								style="color:#FFF">企业性质</td>
							<td height="35" align="center" bgcolor="#999999"
								style="color:#FFF">公司所在地</td>
							<td height="35" align="center" bgcolor="#999999"
								style="color:#FFF">员工人数</td>
							<td height="35" align="center" bgcolor="#999999"
								style="color:#FFF">注册资金</td>
						</tr>
						<%
							List<Enterprise> enterprises = new ArrayList<Enterprise>();
							enterprises = (List<Enterprise>) request
									.getAttribute("enterprises");
						%>
						<%
							for (Enterprise enterprise : enterprises) {
						%>
						<tr>
							<td height="40" align="center" bgcolor="#FFFFFF"><a href="../servlet/EnterSearchServlet?flag=content&enterpriseId=<%=enterprise.getEnterpriseId() %>"><%=enterprise.getEnterpriseName()%></a>
							</td>
							<td height="40" align="center" bgcolor="#FFFFFF"><a href="../servlet/EnterSearchServlet?flag=content&enterpriseId=<%=enterprise.getEnterpriseId() %>"><%=enterprise.getEnterpriseProp()%></a>
							</td>
							<td height="40" align="center" bgcolor="#FFFFFF"><a href="../servlet/EnterSearchServlet?flag=content&enterpriseId=<%=enterprise.getEnterpriseId() %>"><%=enterprise.getEnterpriseAddress() %></a>
							</td>
							<td height="40" align="center" bgcolor="#FFFFFF"><a href="../servlet/EnterSearchServlet?flag=content&enterpriseId=<%=enterprise.getEnterpriseId() %>"><%=enterprise.getEnterpriseEmpNum()%></a>
							</td>
							<td height="40" align="center" bgcolor="#FFFFFF"><a href="../servlet/EnterSearchServlet?flag=content&enterpriseId=<%=enterprise.getEnterpriseId() %>"><%=enterprise.getEnterpriseRegCap()%></a>
							</td>
						</tr>

						<%
							}
						%>

					</table>
					<div class="fenye">
						共有<%=session.getAttribute("count")%>条记录&nbsp;每页13条&nbsp;第<%=session.getAttribute("countPageNow")%>/<%=session.getAttribute("countPage")%>页
						&nbsp;&nbsp; <a
							href="../servlet/EnterSearchServlet?flag=index&countPageNow=1">首页</a>&nbsp;&nbsp;
						<%
							if ((Integer)session.getAttribute("countPageNow") == 1) {
						%>
						上一页
						<%
							} else {
						%>
						<a
							href="../servlet/EnterSearchServlet?flag=index&countPageNow=<%=(Integer) session.getAttribute("countPageNow") - 1%>">上一页</a>
						<%
							}
						%>&nbsp;&nbsp;
						<%
							if (session.getAttribute("countPageNow") == session
									.getAttribute("countPage")) {
						%>
						下一页
						<%
							} else {
						%>
						<a
							href="../servlet/EnterSearchServlet?flag=index&countPageNow=<%=(Integer) session.getAttribute("countPageNow") + 1%>">下一页</a>
						<%
							}
						%>&nbsp;&nbsp; <a
							href="../servlet/EnterSearchServlet?flag=index&countPageNow=<%=session.getAttribute("countPage")%>">尾页</a>
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
