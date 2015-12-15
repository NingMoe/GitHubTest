<%@ page language="java" import="java.util.*,cn.edu.sdust.register.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>企业注册—山东科技大学&mdash;大学生就业网</title>


<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../Js/jQuery.js"></script>
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
					<div class="content_top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							class="tablea" style="color:#ffffff;">
							<tr>
								<td width="2%" height="30">&nbsp;</td>
								<td width="98%" valign="bottom">您的位置：<a
									href="../servlet/IndexServlet">首页</a> &gt;&gt;修改注册信息</td>
							</tr>
						</table>
					</div>
					<div class="sub_auto">
						<%
							Enterprise enterprise = new Enterprise();
							enterprise = (Enterprise)request.getAttribute("enterprise");
						
						 %>
							<form method="post" name="formenter" action="../servlet/UpdateRegisterServlet">
								<p>&nbsp;</p><p>&nbsp;</p>
								<input type="hidden" name="flag" value="main1"/>
								<table width="638">
									<tr>
										<td align="right" width="131" bgcolor="#ffffff">* 通讯地址</td>
										<td align="left" width="181" bgcolor="#ffffff"><input
											id="caddr2" maxlength="50" name="caddr2" value="<%=enterprise.getPostalAddress() %>" />
										</td>
									</tr>
										
									<tr>
										<td align="right" width="83" bgcolor="#ffffff"><span
											class="red">*</span> 邮政编码</td>
										<td align="left" width="238" bgcolor="#ffffff"><input
											id="czip" maxlength="6" name="czip" value="<%=enterprise.getEnterpriseZip() %>" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#ffffff"><span class="red">*</span>
											联系人</td>
										<td align="left" bgcolor="#ffffff"><input id="cperson"
											maxlength="20" name="cperson" value="<%=enterprise.getEnterpriseAttn() %>" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#ffffff">联系人职务</td>
										<td align="left" bgcolor="#ffffff"><input id="cposition"
											maxlength="10" name="cposition" value="<%=enterprise.getEnterprisePost() %>" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#ffffff"><span class="red">*
										</span>联系电话</td>
										<td align="left" bgcolor="#ffffff"><input id="cphone"
											maxlength="20" name="cphone"  value="<%=enterprise.getEnterprisePhone() %>"/>
										</td>
									</tr>
									
									<tr>
										<td align="right" bgcolor="#ffffff">传真号码</td>
										<td align="left" bgcolor="#ffffff"><input id="cfax"
											maxlength="20" name="cfax" value="<%=enterprise.getFaxNum() %>" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#ffffff">手机号码</td>
										<td align="left" bgcolor="#ffffff"><input id="cmobile"
											maxlength="11" name="cmobile" value="<%=enterprise.getPhoneNum() %>" />
										</td>
									</tr>
									
									<tr>
										<td align="right" bgcolor="#ffffff"><span class="red">*</span>
											电子邮箱</td>
										<td align="left" bgcolor="#ffffff"><input id="cemail"
											name="cemail" value="<%=enterprise.getEnterpriseEmail() %>" />
										</td>
									</tr>
									<tr>
										<td align="right" bgcolor="#ffffff">公司主页</td>
										<td align="left" bgcolor="#ffffff"><input id="cwww"
											name="cwww"  value="<%=enterprise.getEnterpriseIndex() %>"/>
										</td>
									</tr>
									<tr>
										<td align="left" bgcolor="#ffffff">&nbsp;</td>
										<td align="left" bgcolor="#ffffff">&nbsp;</td>
									</tr>
									<tr>
										<td height="30" colspan="4" align="center" bgcolor="#FFFFFF">
										<input type="button"  value="提交" onclick="javascript:updateRegister() " />
											&nbsp; <input type="reset" value="重置" />
										</td>
									</tr>
								</table>
								<p>&nbsp;</p>
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
