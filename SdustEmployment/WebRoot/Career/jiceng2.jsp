<%@ page language="java" import="java.util.*,cn.edu.sdust.tool.StuQuery"
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
									href="../servlet/LocalityServlet?flag=main">基层就业</a> &gt;&gt;
									全文</td>
							</tr>
						</table>
					</div>
					<%
						StuQuery stuQuery = (StuQuery) request.getAttribute("stuQuery");
					%>
					<div class="content_bottom">
						<div class="biao"><%=stuQuery.getTitle()%></div>
						<div style="padding:10px 30px; text-align:center;">
							作者：<%=stuQuery.getAuthor()%>
							&nbsp;&nbsp;&nbsp; &nbsp;来源：<%=stuQuery.getOrigin()%>&nbsp;
							&nbsp; &nbsp; &nbsp; 更新时间:<%=stuQuery.getReleaseTime()%>
							&nbsp; &nbsp;&nbsp; &nbsp; 点击阅读量：<%=stuQuery.getPv()%></div>
						<div class="divp" style="text-align:left; margin:0 20px;">
							<p><%=stuQuery.getContent()%></p>

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
