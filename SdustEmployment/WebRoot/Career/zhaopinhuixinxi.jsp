<%@ page language="java" import="java.util.*,cn.edu.sdust.careerfair.*"
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
					<div class="sub_top">
						<table width="701" height="47" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<td width="351" background="../images/sub1_121.jpg">&nbsp;</td>
								<td width="350" background="../images/sub1_13.jpg"
									class="tablea" style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt; 招聘会信息</td>
							</tr>
						</table>
					</div>
					<div class="zhaopinhuixinxi_bottom">
					<div style="text-align:center; padding:15px 5px;">
						<form method="post" action="../servlet/CareerFairServlet">
							<input type="hidden" name="flag" value="main1"/>
							<p>&nbsp;</p>
							<center>
							<table width="300" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="150" align="right"><h4>招聘会时间：从：</h4></td>
								<td width="150"><input name="cFStartTime" value="<%=session.getAttribute("cFStartTime") %>"
										type="text" size="18" /></td>
							</tr>
							<tr>
								<td height="5"></td>
							</tr>
							<tr>
								<td width="150" align="right"><h4>到：</h4></td>
								<td width="150"><input name="cFStartTime1" value="<%=session.getAttribute("cFStartTime1") %>"
										type="text" size="18" /></td>
							</tr>
							<tr>
								<td height="5"></td>
							</tr>
							<tr>
								<td width="150" align="right"><h4>招聘会类别：</h4></td>
								<td width="150"><select name="cFClassfy">
											<option value="校内" <%if(session.getAttribute("cFClassfy").equals("校内")){ %> selected="selected"<%} %>>校内</option>
											<option value="校外" <%if(session.getAttribute("cFClassfy").equals("校外")){ %> selected="selected"<%} %>>校外</option>
											<option value="" <%if(session.getAttribute("cFClassfy").equals("")){ %> selected="selected"<%} %>>----</option>
									</select></td>
							</tr>
							<tr>
								<td height="5"></td>
							</tr>
							<tr>
								<td width="150" align="right"><h4>招聘会地点：</h4></td>
								<td width="150"><input name="CfStartPlace" value="<%=session.getAttribute("CfStartPlace") %>"
										type="text" size="18" /></td>
							</tr>
							<tr>
								<td height="5"></td>
							</tr>
							<tr>
								<td width="150" align="right"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;</td>
								<td width="150" align="left">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/></td>
							</tr>
							</table>
							</center>
						</form>
					</div>
					
						<%
							List<CareerFair> careerFairs = new ArrayList<CareerFair>();
							careerFairs = (List<CareerFair>)request.getAttribute("careerFairs");
						%>

						<ul>

							<% for(CareerFair careerFair:careerFairs) { %>

							<li><a href="../servlet/CareerFairServlet?flag=content&CFID=<%=careerFair.getcfID() %>"><font color="#3300FF">[<%=careerFair.getcFReleaseTime().substring(0, 10) %>]&nbsp;<%=careerFair.getcFClassfy() %></font>&nbsp;<%=careerFair.getcFTitle() %></a>
								<%if(careerFair.getcFTop().equals("1")) {%>
								&nbsp;&nbsp;<font
								style="color:#F30; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:10px;">[OnTop]</font>
								<%} %>
							</li>

							<% } %>
						</ul>

						<div class="fenye">
							共有<%=request.getSession().getAttribute("count")%>
							条记录&nbsp;&nbsp;每页13条&nbsp;&nbsp;第<%=request.getSession().getAttribute("countPageNow")%>/<%=request.getSession().getAttribute("countPage")%>页
							&nbsp;<a
								href="../servlet/CareerFairServlet?flag=index&countPageNow=1">首页</a>
							&nbsp;
							<%
								if ((Integer) request.getSession().getAttribute("countPageNow") == 1) {
							%>上一页<%
								} else {
							%>
							<a
								href="../servlet/CareerFairServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") - 1%>">上一页</a>&nbsp;
							<%
								}
								if (request.getSession().getAttribute("countPageNow") == request
										.getSession().getAttribute("countPage")) {
							%>下一页<%
								} else {
							%>
							<a
								href="../servlet/CareerFairServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") + 1%>">下一页</a>&nbsp;
							<%
								}
							%>
							<a
								href="../servlet/CareerFairServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute("countPage")%>">尾页</a>&nbsp;

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
