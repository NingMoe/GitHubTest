<%@ page language="java" import="java.util.*,cn.edu.sdust.index.Total" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../Js/jQuery.js"></script>
<script language="javascript" type="text/javascript"
	src="../Js/indexJs.js"></script>

</head>

<body>
	<div class="left">
		<div class="logo"></div>
		<div class="login">
			<%if(session.getAttribute("userName")==null) {%>
			<form id="loginForm" method="post" action="../servlet/LoginServlet"
				name="login">
				<table width="87%" border="0" cellspacing="0" cellpadding="0"
					style="width: 206px;">
					<tr>
						<td width="50%" height="66" align="right" valign="bottom"><font
							size="-1">用户名：</font>
						</td>
						<td colspan="3" valign="bottom"><input name="c_name"
							type="text" size="14" /></td>
					</tr>
					<tr>
						<td height="30" align="right" valign="bottom"><font size="-1">密&nbsp;
								码：</font>
						</td>
						<td colspan="3" valign="bottom"><input name="c_pass"
							type="password" size="14" /></td>
					</tr>
					<tr>
						<td height="30" align="right" valign="bottom"><font size="-1">验证码：</font>
						</td>
						<td height="26" colspan="2" valign="bottom"><input
							name="yanzheng" type="text" size="5" />
						</td>
						<td width="37%" valign="bottom"><img id="code"
							src="../Career/captcha.jsp" alt="验证码,看不清楚?请点击刷新验证码"
							style="cursor:pointer;" />
						</td>

					</tr>
					<tr>
						<td height="30" colspan="2" align="right" valign="bottom"><input
							name="loginbtn" type="radio" value="student" checked="checked" /><font
							size="-1"> 学生登录</font>
						</td>
						<td height="30" colspan="2" align="left" valign="bottom">&nbsp;
							<input type="radio" name="loginbtn" value="company" /> <font
							size="-1">企业登录</font>
						</td>
					</tr>
					<tr>
						<td height="30" colspan="2" align="right" valign="bottom"><input
							type="submit" value=""
							style="border:0;width:60px;height:25px;cursor:pointer;background:url(../images/index_13.jpg);" />
							&nbsp;</td>
						<td height="40" colspan="2" align="left" valign="bottom">&nbsp;
							<input type="reset" value=""
							style="border:0;width:60px;height:25px;cursor:pointer;background:url(../images/index_15.jpg);" />
						</td>
					</tr>
				</table>
			</form>
			<%} else if(session.getAttribute("loginbtn").equals("student")) { %>
			<center>
				<br>
				<br>
				<br>
				<br>
				<br>
				<h4><%=session.getAttribute("userName") %>,欢迎你！
				</h4>
				<br>
				<h5>
					<a href="../servlet/FileQueryServlet">档案查询</a>
				</h5>
				<br>
				<h5>
					<a href="../Career/xiugaimima.jsp">修改密码</a>
				</h5>
				<br>
				<h5>
					<a href="../servlet/ExitServlet">退出登录</a>
				</h5>
			</center>
			<%} else { %>
			<center>
				<br>
				<br>
				<br>
				<br>
				<h4><%=session.getAttribute("userName") %>,欢迎你！
				</h4>
				<br>
				<h5>
					<a href="../Career/fabuzhaopinxinxi.jsp">发布招聘信息</a>
				</h5>
				<br>
				<h5>
					<a href="../servlet/UpdateRegisterServlet?flag=main">修改注册信息</a>
				</h5>
				<br>
				<h5>
					<a href="../Career/xiugaimima.jsp">修改密码</a>
				</h5>
				<br>
				<h5>
					<a href="../servlet/ExitServlet">退出登录</a>
				</h5>
			</center>
			<%} %>
		</div>
		<div class="xuesheng">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="tablea">
				<tr>
					<td height="45" colspan="2" align="right" valign="bottom">
						<%if(session.getAttribute("userName")==null) {%> <a
						href="../Career/xueshengzhuce.jsp">学生注册</a> <%} else { %> <a
						href="javascript:Ralert();">学生注册</a> <%} %>
					</td>
					<td width="38%" align="left" valign="bottom">&nbsp; <%if(session.getAttribute("userName")==null) {%>
						<a href="javascript:Jalert();">填写简历</a> <%} else if(session.getAttribute("Resume").equals("是")) { %>
						<a href="../servlet/GetResumeInfoServlet">修改简历</a> <%} else if(session.getAttribute("loginbtn").equals("student")) {%>
						<a href="../servlet/WriteResumeServlet">填写简历</a> <%} else {%> <a
						href="">填写简历</a> <% } %>
					</td>
				</tr>
				<tr>
					<td height="25" colspan="2" align="right" valign="bottom"><a
						href="../servlet/SkillServlet?flag=main">技巧交流</a></td>
					<td align="left" valign="bottom">&nbsp; <a
						href="../Career/qiyejiansuo.jsp">企业检索</a></td>
				</tr>
				<tr>
					<td width="45%" height="25">&nbsp;</td>
					<td colspan="2" align="left" valign="bottom">&nbsp;<a
						href="http://sdkd.51langtu.com/" target="_blank">职业规划测评</a></td>
				</tr>
			</table>
		</div>
		<div class="qiye">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				class="tablea">
				<tr>
					<td height="45" align="right" valign="bottom">
						<%if(session.getAttribute("userName")==null) {%> <a
						href="../Career/qiyezhuce.jsp">企业注册</a> <%} else { %> <a
						href="javascript:Ralert();">企业注册</a> <%} %>
					</td>
					<td width="38%" align="left" valign="bottom">&nbsp; <a
						href="../Career/xueshengsousuo.jsp">学生验证</a></td>
				</tr>
				<tr>
					<td height="25" align="right" valign="bottom"><a
						href="../servlet/ResumeServlet?flag=main">简历查看</a></td>
					<td align="left" valign="bottom"></td>
				</tr>

			</table>
		</div>
		<div class="jiange"></div>
		<div class="contact">
			<a href="../Career/contact.jsp"><img src="../images/index_30.jpg"
				border="0" /> </a>
		</div>
		<div class="friend">
			<a href="../Career/friend.jsp"><img src="../images/index_31.jpg"
				border="0" /> </a>
		</div>
		<div class="tongji">
		<%
			Total total = new Total();
			total = (Total)session.getAttribute("total");
		
		 %>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="18%" height="45" valign="bottom">&nbsp;</td>
					<td width="82%" valign="bottom"><font color="#3366FF">本站共有文章：<%=total.getEssay() %>
							篇</font></td>
				</tr>
				<tr>
					<td height="30" valign="bottom">&nbsp;</td>
					<td height="30" valign="bottom"><font color="#3366FF">共有注册企业：<%=total.getEnterprise() %>家</font>
					</td>
				</tr>
				<tr>
					<td height="30" valign="bottom">&nbsp;</td>
					<td height="30" valign="bottom"><font color="#3366FF">共有学生简历：<%=total.getResume() %>个</font>
					</td>
				</tr>
				<tr>
					<td height="30" valign="bottom">&nbsp;</td>
					<td height="30" valign="bottom"><font color="#3366FF">本站来访人数：<%=total.getVisitor() %>位</font>
					</td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>
