<%@ page language="java" import="java.util.*"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../Js/jQuery.js"></script>
<script type="text/javascript" src="../Js/indexJs.js"></script>
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
				<div class="content">
					<div class="content_top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							class="tablea" style="color:#ffffff;">
							<tr>
								<td width="2%" height="30">&nbsp;</td>
								<td width="98%" valign="bottom">您的位置：<a
									href="../servlet/IndexServlet">首页</a> &gt;&gt;修改密码
							</tr>
						</table>
					</div>
					<div class="content_bottom">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<form action="../servlet/UpdatePassServlet" method="post">
					<center>
					<table>
					<tr>
					<td>旧密码:</td>
					<td><input type="password" name="oldPass" id="oldPass"/></td>
					</tr>
					<tr>
					<td>新密码:</td>
					<td><input type="password" name="newPass" id="newPass"/></td>
					</tr>
					<tr>
					<td>确认新密码:</td>
					<td><input type="password" name="newPass1" id="newPass1"/></td>
					</tr>
					</table>
					<p>&nbsp;</p>
					<input type="button" value="提交" onclick="javascript:updatePass()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置"/>
					</center>
					</form>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
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
