<%@ page language="java" import="java.util.*,cn.edu.sdust.resume.StudentInfo"
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
							<td width="351" background="../images/jianli_12.jpg">&nbsp;</td>
							<td width="350" background="../images/sub1_13.jpg" class="tablea"
								style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt; 求职简历</td>
						</tr>
					</table>
				</div>
				<div class="sub_bottom">
					<div style="text-align:center; padding:15px 5px;">
						<form method="post" action="../servlet/ResumeServlet">
							<input type="hidden" name="flag" value="main1"/>
							<table width="605" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="100" height="40" align="left"
										style="font-size:14px; font-weight:bold;"><h3>&nbsp;简历查询：</h3>
									</td>
									<td width="154" height="30" align="left">&nbsp;</td>
									<td width="85" height="30">&nbsp;</td>
									<td width="266" height="30" align="left">&nbsp;</td>
								</tr>
								<tr>
									<td height="30" align="right"><h3>姓名：</h3>
									</td>
									<td height="30" align="left"><input name="name" value="<%=session.getAttribute("studentName") %>"
										type="text" id="name" size="18" style="padding:2px;" />
									</td>
									<td height="30" align="right"><h3>性别：</h3>
									</td>
									<td height="30" align="left"><select name="sex" id="sex">
											<option value="男" <%if(session.getAttribute("gender").equals("男")){ %> selected="selected"<%} %>>男</option>
											<option value="女" <%if(session.getAttribute("gender").equals("女")){ %> selected="selected"<%} %>>女</option>
											<option value="" <%if(session.getAttribute("gender").equals("")){ %> selected="selected"<%} %>>----</option>
									</select>
									</td>
								</tr>
								<tr>
									<td height="30" align="right"><h3>学历：
									</h3>
									</td>
									<td height="30" align="left"><select name="level"
										id="level">
											<option value="专科" <%if(session.getAttribute("eduBg").equals("专科")){ %> selected="selected"<%} %>>专科</option>
											<option value="本科" <%if(session.getAttribute("eduBg").equals("本科")){ %> selected="selected"<%} %>>本科</option>
											<option value="硕士研究生" <%if(session.getAttribute("eduBg").equals("硕士研究生")){ %> selected="selected"<%} %>>硕士研究生</option>
											<option value="博士研究生" <%if(session.getAttribute("eduBg").equals("博士研究生")){ %> selected="selected"<%} %>>博士研究生</option>
											<option value="" <%if(session.getAttribute("eduBg").equals("")){ %> selected="selected"<%} %>>----</option>
									</select>
									</td>
									<td height="30" align="right"><h3>学制：</h3>
									</td>
									<td height="30" align="left"><select name="years"
										id="years">
											<option value="2" <%if(session.getAttribute("los").equals("2")){ %> selected="selected"<%} %>>2</option>
											<option value="3" <%if(session.getAttribute("los").equals("3")){ %> selected="selected"<%} %>>3</option>
											<option value="4" <%if(session.getAttribute("los").equals("4")){ %> selected="selected"<%} %>>4</option>
											<option value="5" <%if(session.getAttribute("los").equals("5")){ %> selected="selected"<%} %>>5</option>
											<option value="" <%if(session.getAttribute("los").equals("")){ %> selected="selected"<%} %>>----</option>
									</select>
									</td>
								</tr>
								<tr>
									<td height="30" align="right"><h3>专业：</h3>
									</td>
									<td height="30" align="left"><input name="Specialized" value="<%=session.getAttribute("major") %>"
										type="text" id="textfield6" size="18" style="padding:2px;" />
									</td>
									<td height="30" align="right"><h3>生源地：</h3>
									</td>
									<td height="30" align="left"><input name="native" value="<%=session.getAttribute("nativePlace") %>"
										type="text" id="textfield7" size="20" style="padding:2px;" />
									</td>
								</tr>
								<tr>
									<td height="50" align="right">&nbsp;</td>
									<td height="30" align="center"><input type="submit"
										name="button2" id="button2" value="查询" /></td>
									<td height="30" align="center"><input type="reset"
										name="button3" id="button3" value="重置" />
									</td>
									<td height="30" align="left" valign="top"><font
										color="#3366FF">（生源地输入市级单位即可，如输入&ldquo;青岛&rdquo;）</font>
									</td>
								</tr>
							</table>
						</form>
					</div>

					<%
							List<StudentInfo> studentInfos = (List<StudentInfo>) request
									.getAttribute("studentInfos");
						%>
					<ul>
						<%
								for (StudentInfo studentInfo : studentInfos) {
							%>
						<li><a
							href="../servlet/ResumeServlet?flag=content&StuNum=<%=studentInfo.getStudentNum() %>"><%=studentInfo.getMajor() %>&nbsp;&nbsp;
							<%=studentInfo.getStudentName() %>&nbsp;&nbsp;<%=studentInfo.getGender() %>&nbsp;&nbsp;<%=studentInfo.getEduBg() %></a>
						</li>
						<%
								}
							%>
					</ul>

					<div class="fenye">
						共有<%=request.getSession().getAttribute("count")%>
						条记录&nbsp;&nbsp;每页13条&nbsp;&nbsp;第<%=request.getSession().getAttribute("countPageNow")%>/<%=request.getSession().getAttribute("countPage")%>页
						&nbsp;<a
							href="../servlet/ResumeServlet?flag=index&countPageNow=1">首页</a>
						&nbsp;
						<%
								if ((Integer) request.getSession().getAttribute("countPageNow") == 1) {
							%>上一页<%
								} else {
							%>
						<a
							href="../servlet/ResumeServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") - 1%>">上一页</a>&nbsp;
						<%
								}
								if (request.getSession().getAttribute("countPageNow") == request
										.getSession().getAttribute("countPage")) {
							%>下一页<%
								} else {
							%>
						<a
							href="../servlet/ResumeServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute(
						"countPageNow") + 1%>">下一页</a>&nbsp;
						<%
								}
							%>
						<a
							href="../servlet/ResumeServlet?flag=index&countPageNow=<%=(Integer) request.getSession().getAttribute("countPage")%>">尾页</a>&nbsp;

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
