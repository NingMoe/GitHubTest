<%@ page language="java" import="java.util.*,cn.edu.sdust.recruitment.*"
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
									href="Javascript:window.history.go(-1)">招聘信息</a> &gt;&gt;
									全文</td>
							</tr>
						</table>
					</div>
					<div class="content_bottom">
					<%
						Recruitment recruitment = new Recruitment();
						recruitment = (Recruitment)request.getAttribute("recruitment");
					%>
						<div class="biao"><%=recruitment.getRecruitTitle() %></div>
						<div style="padding:10px 30px; text-align:center;">
							发布者：<%=recruitment.getRecruitAuthor() %>
							&nbsp;&nbsp;&nbsp; &nbsp; 更新时间:<%=recruitment.getRecruitReleaseTime() %>
							&nbsp; &nbsp;&nbsp; &nbsp; 点击阅读量：<%=recruitment.getRecruitPV() %></div>
						<div class="divp" style="text-align:left; margin:0 20px;">
								<%=recruitment.getRecruitContent() %>
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
