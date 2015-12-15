<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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
								<td width="351" background="../images/qiyesousuo_12.jpg">&nbsp;</td>
								<td width="350" background="../images/sub1_13.jpg"
									bgcolor="#FFFFFF" class="tablea" style="color:#FFF;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp; 您所在的位置：<a href="../servlet/IndexServlet">首页</a> &gt;&gt; 企业检索</td>
							</tr>
						</table>
					</div>
					<div class="sub_bottom">
						<form action="../servlet/EnterSearchServlet" method="post">
						<input type="hidden" name="flag" value="main"/>
						<table>
							<tr>
								<td height="35" colspan="3">&nbsp;</td>
							</tr>
							<tr>
								<td width="252" height="40" align="right">公司名称：</td>
								<td colspan="2"><input name="names" type="text"
									size="30" style="padding:2px;" /></td>
							</tr>
							<tr>
								<td height="40" align="right">公司所在地：</td>
								<td colspan="2"><input name="suozai" type="text"
									size="30" style="padding:2px;" /></td>
							</tr>
							<tr>
								<td height="40" align="right">企业性质：</td>
								<td colspan="2"><select name="xingzhi">
										<option value="" selected="selected">----请选择----</option>
										<option value="行政机关">行政机关</option>
										<option value="社会团体">社会团体</option>
										<option value="事业单位">事业单位</option>
										<option value="国有企业">国有企业</option>
										<option value="外资企业">外资企业</option>
										<option value="中外合资">中外合资</option>
										<option value="民营企业">民营企业</option>
										<option value="私营企业">私营企业</option>
								</select></td>
							</tr>
							<tr>
								<td height="40" align="right">注册资金：</td>
								<td height="35" colspan="2" align="left" valign="middle"><select
								 name="zijin">
										<option value="" selected="selected">----请选择----</option>
										<option value="100万以下">100万以下</option>
										<option value="100万－500万">100万－500万</option>
										<option value="500万－1000万">500万－1000万</option>
										<option value="1000万－5000万">1000万－5000万</option>
										<option value="5000万以上">5000万以上</option>
								</select></td>
							</tr>
							<tr>
								<td height="40" align="right">雇员人数：</td>
								<td height="35" colspan="2" align="left" valign="middle"><select
									 name="renshu">
										<option value="" selected="selected">----请选择----</option>
										<option value="50人以下">50人以下</option>
										<option value="50&mdash;100人">50&mdash;100人</option>
										<option value="100&mdash;200人">100&mdash;200人</option>
										<option value="200&mdash;500人">200&mdash;500人</option>
										<option value="500&mdash;1000人">500&mdash;1000人</option>
										<option value="1000人以上">1000人以上</option>
								</select></td>
							</tr>

							<tr>
								<td height="50" align="right" valign="bottom">&nbsp;</td>
								<td width="83" height="35" align="left" valign="bottom"><input
									type="submit" name="button2" id="button2" value="查询"
									onclick="location.href='qiyejiansuo2.html'" /></td>
								<td width="333" height="35" align="left" valign="bottom"><input
									type="reset" name="button3" id="button3" value="重置" /></td>
							</tr>
							</table>
						</form>
						<p>&nbsp;</p><p>&nbsp;</p>
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

