<%@ page language="java" import="java.util.*,cn.edu.sdust.major.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<link href="css/scrollstyle.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function checkform1() {
		if (document.form3.keyword1.value == "") {
			alert("请输入查询关键字");
			document.form3.keyword1.focus();
			return false;
		}
		return true;
	}
</script>
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
								<td width="351" background="../images/zhuanye_12.jpg">&nbsp;</td>
								<td width="350" background="../images/sub1_13.jpg"
									class="tablea" style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt; 专业介绍</td>
							</tr>
						</table>
					</div>
					<div class="sub_bottom">
						<form method="post"
							action="../servlet/MajorServlet">
							<input type="hidden" name="flag" value="main1"/>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="21%" height="50">&nbsp;</td>
									<td width="16%">请输入专业关键字：</td>
									<td width="25%"><input type="text" name="major"
										value="<%=session.getAttribute("major") %>" />
									</td>
									<td width="38%" align="left"><input type="submit"
										name="button2" id="button2" value="专业查询" /></td>
								</tr>
							</table>
						</form>
						<%if(session.getAttribute("major").equals("")) {%>
						<%
							List<MajorInfo> majorInfos = (List<MajorInfo>) request
									.getAttribute("majorInfos");
						%>
						<ul style="margin-left:40px;">
						<%
							for (MajorInfo majorInfo : majorInfos) {
						%>
							<li class="zhuanye1" style="margin:0px 50px 0 0;"><a
								href="../servlet/MajorServlet?flag=content&ID=<%=majorInfo.getMajorId()%>"><%=majorInfo.getMajorName()%></a></li>
						<%} %>

						</ul><br/>
						<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
							<div class="fenye">
							共有<%=request.getSession().getAttribute("count")%> 
							条记录&nbsp;&nbsp;每页20条&nbsp;&nbsp;第<%=request.getSession().getAttribute("countPageNow")%>/<%=request.getSession().getAttribute("countPage")%>页
							&nbsp;<a
								href="../servlet/MajorServlet?flag=index&countPageNow=1">首页</a>
							&nbsp;
							<%
								if ((Integer) request.getSession().getAttribute("countPageNow") == 1) {
							%>上一页<%
								} else {
							%>
							<a
								href="../servlet/MajorServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") - 1%>">上一页</a>&nbsp;
							<%
								}
								if (request.getSession().getAttribute("countPageNow") == request
										.getSession().getAttribute("countPage")) {
							%>下一页<%
								} else {
							%>
							<a
								href="../servlet/MajorServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") + 1%>">下一页</a>&nbsp;
							<%
								}
							%>
							<a
								href="../servlet/MajorServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute("countPage")%>">尾页</a>&nbsp;

						</div>
						<%} else { %>
						<%
							List<MajorInfo> majorInfos = (List<MajorInfo>) request
									.getAttribute("majorInfos");
						%>
						<ul >
						<%
							for (MajorInfo majorInfo : majorInfos) {
						%>
							<li>
							<a href="../servlet/MajorServlet?flag=content&ID=<%=majorInfo.getMajorId()%>"><%=majorInfo.getMajorName()%></a>
							</li>
						<%} %>

						</ul><br/>
						
						<%} %>
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
