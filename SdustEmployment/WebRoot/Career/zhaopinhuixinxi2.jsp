<%@ page language="java" import="java.util.*,cn.edu.sdust.careerfair.*"
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
				<div class="content">
					<div class="content_top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							class="tablea" style="color:#ffffff;">
							<tr>
								<td width="2%" height="30">&nbsp;</td>
								<td width="98%" valign="bottom">您的位置：<a
									href="../servlet/IndexServlet">首页</a> &gt;&gt; <a
									href="Javascript:window.history.go(-1)">招聘会信息</a> &gt;&gt;
									全文</td>
							</tr>
						</table>
					</div>
					<div class="content_bottom">
					<%
						CareerFair careerFair = new CareerFair();
						careerFair = (CareerFair)request.getAttribute("careerFair");
					%>
						<div class="biao"><%=careerFair.getcFTitle() %></div>
						<div style="padding:10px 30px; text-align:center;">
							发布者：<%=careerFair.getcFPublisher() %>
							&nbsp;&nbsp;&nbsp; &nbsp; 更新时间:<%=careerFair.getcFReleaseTime() %>
							&nbsp; &nbsp;&nbsp; &nbsp; 点击阅读量：<%=careerFair.getcFPV() %></div>
						<div class="divp" style="text-align:left; margin:0 20px;"><center>
						<table width="400" border="1" cellpadding="0" cellspacing="0">
							<tr>
								<td width="130" align="right" height="30"><h4>招聘会时间：</h4></td>
								<td width="270">&nbsp;<%=careerFair.getcFStartTime().substring(0, 10) %></td>
							</tr>
							<tr>
								<td width="130" align="right" height="30"><h4>招聘会地点：</h4></td>
								<td width="270">&nbsp;<%=careerFair.getCfStartPlace() %></td>
							</tr>
							<tr>
								<td width="130" align="right" height="50"><h4>招聘企业：</h4></td>
								<td width="270">&nbsp;<%=careerFair.getcFEnterprises() %></td>
							</tr>
							<tr>
								<td width="130" align="right" height="30"><h4>参加资格：</h4></td>
								<td width="270">&nbsp;<%=careerFair.getcFEligibility() %></td>
							</tr>
							<tr>
								<td width="130" align="right" height="50"><h4>携带物品：</h4></td>
								<td width="270">&nbsp;<%=careerFair.getcFThing() %></td>
							</tr>
						</table>
						
						
						</center>

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
