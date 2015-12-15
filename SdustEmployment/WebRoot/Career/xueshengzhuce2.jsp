<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>学生注册—山东科技大学&mdash;大学生就业网</title>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<script src="../Js/jQuery.js" type="text/javascript"></script>
<script src="../Js/indexJs.js" type="text/javascript"></script>
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
								<td width="351" background="../images/xueshengzhuce_12.jpg">&nbsp;</td>
								<td width="350" background="../images/sub1_13.jpg"
									class="tablea" style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
									class="tablea" style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt; 学生注册</td>
							</tr>
						</table>
					</div>
					<div class="sub_auto">

						
							<form name="formStu" method="post" action="../servlet/StudentRegisterServlet">
								<table width="600" border="0" cellpadding="0" cellspacing="0"
									style="font-size:14px; font-weight:bold;">
									<tr>
										<td height="35" colspan="3">&nbsp;</td>
									</tr>
									<tr>
										<td width="168" height="40" align="right">用户名：</td>
										<td width="149" valign="middle"><input name="username" id="username"
											type="text"  size="18" style="padding:2px;" />
										*<a href="javascript:checkming()"
											>检查用户名</a></td>
									</tr>
									<tr>
										<td height="40" align="right">密码：</td>
										<td colspan="2"><input name="password" id="password" type="password"
											 size="18" style="padding:2px;" />&nbsp;*</td>
									</tr>
									<tr>
										<td height="40" align="right">密码确认：</td>
										<td colspan="2"><input name="confirmpwd" id="confirmpwd" type="password"
											 size="18" style="padding:2px;" />&nbsp;*</td>
									</tr>
									<tr>
										<td height="40" align="right">学号：</td>
										<td height="35" colspan="2" align="left" valign="middle"><input
											name="studentNum" id="studentNum" type="text"  size="18"
											style="padding:2px;" />&nbsp;*</td>
									</tr>
									<tr>
										<td height="40" align="right">真实姓名：</td>
										<td height="35" colspan="2" align="left" valign="middle"><input
											name="tName" id="tName" type="text" size="18"
											style="padding:2px;" />&nbsp;*</td>
									</tr>
									<tr>
										<td height="50" align="right" valign="bottom"><input
											type="button" name="button2"  value="进行注册" onclick="javascript:JudgeStudent()"/>&nbsp;</td>
										<td height="35" colspan="2" align="left" valign="bottom">&nbsp;<input
											type="reset" value="重新填写" /></td>
									</tr>
								</table>
							</form>
							<p>&nbsp;</p>
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

