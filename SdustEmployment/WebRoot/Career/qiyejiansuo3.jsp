<%@ page language="java" import="java.util.*,cn.edu.sdust.register.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>企业检索—山东科技大学&mdash;大学生就业网</title>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />

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
			<div class="sub_top">
				<table width="701" height="47" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="351" background="../images/qiyesousuo_12.jpg">&nbsp;</td>
						<td width="350" background="../images/sub1_13.jpg" class="tablea"
							style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt;<a href="Javascript:window.history.go(-2)"> 企业检索</a>&gt;&gt;<a href="Javascript:window.history.go(-1)">检索结果</a>&gt;&gt;全文</td>
					</tr>
				</table>
				</div>
				<div class="sub_bottom">
				<p>&nbsp;</p><p>&nbsp;</p>
				<% 
				Enterprise enterprise = new Enterprise();
				
				enterprise = (Enterprise)request.getAttribute("enterprise");
				%>
				<table width="692" border="0" cellpadding="0" cellspacing="1"
					bgcolor="#CCCCCC" style="margin-bottom:20px;">
					<tr>
						<td width="87" height="35" align="center" bgcolor="#FFFFFF">企业名称：</td>
						<td width="266" height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseName() %></td>
						<td width="88" align="center" bgcolor="#FFFFFF">成立时间：</td>
						<td width="251" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseRegtime() %></td>
					</tr>
					<tr>
						<td height="35" align="center" bgcolor="#FFFFFF">所属行业：</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseIndus() %></td>
						<td height="35" align="center" bgcolor="#FFFFFF">企业性质：</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseProp() %></td>
					</tr>
					<tr>
						<td height="35" align="center" bgcolor="#FFFFFF">雇员人数：</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseEmpNum() %></td>
						<td height="35" align="center" bgcolor="#FFFFFF">注册资金：</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseRegCap() %></td>
					</tr>
					<tr>
						<td height="35" align="center" bgcolor="#FFFFFF">公司地址：</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseAddress() %></td>
						<td height="35" align="center" bgcolor="#FFFFFF">&nbsp;</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;</td>
					</tr>
					<tr>
						<td height="35" align="center" valign="top" bgcolor="#FFFFFF"><br />公司简介：</td>
						<td height="35" colspan="3" bgcolor="#FFFFFF"
							style="line-height:2em; padding:15px;">&nbsp;<%=enterprise.getEnterpriseBrief() %></td>
					</tr>
					</table>
					<%if(session.getAttribute("userName")!=null && session.getAttribute("loginbtn").equals("student")) {%>
					<table width="692" border="0" cellpadding="0" cellspacing="1"
					bgcolor="#CCCCCC" style="margin-bottom:20px;">
					<tr>
						<td width="87" height="35" align="center" bgcolor="#FFFFFF">联系电话：</td>
						<td width="266" height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterprisePhone() %></td>
						<td width="88" height="35" align="center" bgcolor="#FFFFFF">联系人：</td>
						<td width="251" height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseAttn() %></td>
					</tr>
					<tr>
						<td height="35" align="center" bgcolor="#FFFFFF">通信地址：</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getPostalAddress() %></td>
						<td height="35" align="center" bgcolor="#FFFFFF">联系人职位：</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterprisePost() %></td>
					</tr>
					<tr>
						<td height="35" align="center" bgcolor="#FFFFFF">邮政编码：</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterprisePost() %></td>
						<td height="35" align="center" bgcolor="#FFFFFF">公司主页：</td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseIndex() %></td>
					</tr>
					<tr>
						<td height="35" align="center" bgcolor="#FFFFFF">电子邮箱：<br /></td>
						<td height="35" bgcolor="#FFFFFF">&nbsp;<%=enterprise.getEnterpriseEmail() %></td>
						<td height="35" align="center" bgcolor="#FFFFFF"><br /></td>
						<td height="35" bgcolor="#FFFFFF"></td>
					</tr>
					</table>
					<%} else { %>
					<p>&nbsp;</p><p>&nbsp;</p>
						<center><h3><font color="red">学生用户请登录之后查看联系方式！</font></h3></center>
					<% } %>
					<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
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

