<%@ page language="java" import="java.util.*,cn.edu.sdust.tool.StuQuery"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
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
				<div class="content">
					<div class="content_top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							class="tablea" style="color:#ffffff;">
							<tr>
								<td width="2%" height="30">&nbsp;</td>
								<td width="98%" valign="bottom">您的位置：<a
									href="../servlet/IndexServlet">首页</a> &gt;&gt;发布招聘信息
							</tr>
						</table>
					</div>
					<div class="content_bottom">
						<p>&nbsp;</p><p>&nbsp;</p>
						<form action="../servlet/AddRecruitmentServlet" method="post" name="recruitment">
						<table width="690">
						<tr>
							<td width="130" align="right"><h2>*标题：</h2></td>
							<td width="560"><input type="text" name="title" id="title" size="40"/></td>
						</tr>
						<tr>
							<td width="130" align="right">&nbsp;</td>
							<td width="560"></td>
						</tr>
						<tr>
							<td width="130" align="right"><h2>*发布人：</h2></td>
							<td width="560"><input type="text" name="author" id="author" size="40"/></td>
						</tr>
						<tr>
							<td width="130" align="right">&nbsp;</td>
							<td width="560"></td>
						</tr>
						<tr>
							<td width="130" align="right"><h2>*发布企业：</h2></td>
							<td width="560"><input type="text" name="enterprise" id="author" size="40"/></td>
						</tr>
						<tr>
							<td width="130" align="right">&nbsp;</td>
							<td width="560"></td>
						</tr>
						<tr>
							<td width="130" align="right"><h2>*所需职位：</h2></td>
							<td width="560"><input type="text" name="job" id="author" size="40"/></td>
						</tr>
						<tr>
							<td width="130" align="right">&nbsp;</td>
							<td width="560"></td>
						</tr>
						<tr>
							<td width="130" align="right"><h2>*工作地点：</h2></td>
							<td width="560"><input type="text" name="address" id="author" size="40"/></td>
						</tr>
						<tr>
							<td width="130" align="right">&nbsp;</td>
							<td width="560"></td>
						</tr>
						<tr>
							<td width="130" align="right"><h2>*文章源自：</h2></td>
							<td width="560"><input type="text" name="origin" id="origin" size="40"/></td>
						</tr>
						
						<tr>
							<td width="130" align="right">&nbsp;</td>
							<td width="560"></td>
						</tr>
						<tr>
							<td width="130" align="right"><h2>*招聘信息：</h2></td>
							<td width="560"><textarea cols="70" rows="18" name="content" id="content"></textarea></td>
						</tr>
						</table>
						<p>&nbsp;</p><p>&nbsp;</p>
						<center>
							<input type="button" value="提交" onclick="javascript:Recruitment()"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="重置"/>
						</center>
						<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
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
