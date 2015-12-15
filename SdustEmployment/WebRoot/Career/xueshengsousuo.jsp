<%@ page language="java" import="java.util.*"
	pageEncoding="utf-8"%>
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
							<td width="351" background="../images/xueshengsousuo_12.jpg">&nbsp;</td>
							<td width="350" background="../images/sub1_13.jpg" class="tablea"
								style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 您所在的位置：<a
								href="../servlet/IndexServlet">首页</a> &gt;&gt; 学生验证</td>
						</tr>
					</table>
				</div>

				<div class="sub_bottom">
					<form action="../servlet/VerifyServlet" method="post">
						<table>
							<tr>
								<td height="35" colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td width="137" height="40" align="right">姓名：</td>
								<td colspan="2"><input name="studentName" type="text"
									size="18" style="padding:2px;" />*</td>
							</tr>
							<tr>
								<td height="40" align="right">性别：</td>
								<td colspan="2"><select name="gender">
										<option selected="selected" value="">---请选择---</option>
										<option value="男">男</option>
										<option value="女">女</option>
								</select>*</td>
							</tr>
							<tr>
								<td height="40" align="right">学历：</td>
								<td colspan="2"><select name="eduBg">
										<option selected="selected" value="">---请选择---</option>
										<option value="专科">专科</option>
										<option value="本科">本科</option>
										<option value="硕士研究生">硕士研究生</option>
										<option value="博士研究生">博士研究生</option>

								</select>*</td>
							</tr>
							<tr>
								<td height="40" align="right">学制：</td>
								<td height="35" colspan="2" align="left" valign="middle"><select
									name="los">
										<option value="" selected="selected">---请选择---</option>
										<option value="2">2年制</option>
										<option value="3">3年制</option>
										<option value="4">4年制</option>
										<option value="5">5年制</option>
								</select>*</td>
							</tr>
							<tr>
								<td height="40" align="right">专业：</td>
								<td height="35" colspan="2" align="left" valign="middle"><input
									name="major" type="text" id="textfield9" size="22"
									style="padding:2px;" />*</td>
							</tr>
							<tr>
								<td height="40" align="right">生源地：</td>
								<td height="35" colspan="2" align="left" valign="middle"
									style="font-size:12px; font-weight:normal;"><input
									name="nativePlace" type="text" size="22"
									style="padding:2px;" />*
									请直接输入最小地址单位，如：&ldquo;山东青岛&rdquo;请直接输入&ldquo;青岛&rdquo;</td>
							</tr>
							<tr>
								<td height="50" align="right" valign="bottom">&nbsp;</td>
								<td width="107" height="35" align="left" valign="bottom"><input
									type="submit" name="button2" id="button2" value="查询"
									onclick="location.href='xueshengsousuo2.html'" /></td>
								<td width="424" height="35" align="left" valign="bottom"><input
									type="reset" name="button3" id="button3" value="重置" /></td>
							</tr>
						</table>
						<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
					</form>

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
