<%@ page language="java" import="java.util.*,cn.edu.sdust.resume.StudentInfo" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>学生档案查询—山东科技大学&mdash;大学生就业网</title>
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
								<td width="351" background="../images/dangan_12.jpg">&nbsp;</td>
								<td width="350" background="../images/sub1_13.jpg"
									class="tablea" style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt; 档案查询</td>
							</tr>
						</table>
					</div>
					<div class="sub_bottom"><center>
							<%
								StudentInfo studentInfo = new StudentInfo();
								studentInfo = (StudentInfo)request.getAttribute("studentInfo");
							 %>
						<p>&nbsp;</p>
						<p>&nbsp;</p>
						<table width="473" border="0" align="center" cellpadding="0"
							cellspacing="1" bgcolor="#CCCCCC">
							&nbsp;&nbsp;
							<tr>
								<td width="111" height="30" align="center" bgcolor="#999999"
									style="color:#FFF">姓名</td>
								<td width="275" align="center" bgcolor="#999999"
									style="color:#FFF">档案地址</td>
								<td width="87" align="center" bgcolor="#999999"
									style="color:#FFF">机要号</td>
							</tr>
							&nbsp;&nbsp;
							<tr>
								<td height="30" align="center" bgcolor="#FFFFFF"><%=studentInfo.getStudentName() %></td>
								<td align="center" bgcolor="#FFFFFF"><%=studentInfo.getFileAddress() %></td>
								<td align="center" bgcolor="#FFFFFF"><%=studentInfo.getFileArchive() %></td>
							</tr>
						</table>
						<p>&nbsp;</p>
						<p>&nbsp;</p>
						<p>&nbsp;</p>
						</center>		
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
