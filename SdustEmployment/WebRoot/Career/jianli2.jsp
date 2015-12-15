<%@ page language="java" import="java.util.*,cn.edu.sdust.resume.StudentInfo,cn.edu.sdust.resume.StuResume,cn.edu.sdust.resume.StuContact"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>山东科技大学&mdash;大学生就业网</title>
<style type="text/css">
<!--
.STYLE1 {
	font-family: "宋体";
	font-weight: bold;
	font-size: xx-large;
}

.STYLE2 {
	font-size: 16px;
}
-->
</style>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript"
	src="../Js/indexJs.js"></script>

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
									href="../servlet/IndexServlet">首页</a> &gt;&gt; <a
									href="Javascript:window.history.go(-1)">求职简历</a> &gt;&gt;
									全文</td>
							</tr>
						</table>
					</div>
				<div class="sub_bottom">
					<div style="text-align:center; padding:15px 5px;">
					<%
						StuResume stuResume = (StuResume)request.getAttribute("stuResume");
						StuContact stuContact = (StuContact)request.getAttribute("stuContact");
						StudentInfo studentInfo_r = (StudentInfo)request.getAttribute("studentInfo_r");
					 %>
						<table width="682" border="1" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="75" colspan="4"><div align="center">
										<span class="STYLE1">个人简历表</span>
									</div>
								</td>
							</tr>
							<tr>
								<td width="133" height="41"><div align="center"
										class="STYLE2">姓名：</div>
								</td>
								<td width="195"><%=studentInfo_r.getStudentName() %></td>
								<td width="134"><div align="center" class="STYLE2">毕业学校：</div>
								</td>
								<td width="192"><%=stuResume.getGraduateSchool() %></td>
							</tr>
							<tr>
								<td height="42"><div align="center">
										<span class="STYLE2">民族：</span>
									</div>
								</td>
								<td><%=stuResume.getNation() %></td>
								<td><div align="center">
										<span class="STYLE2">性别：</span>
									</div>
								</td>
								<td><%=studentInfo_r.getGender() %></td>
							</tr>
							<tr>
								<td height="42"><div align="center">
										<span class="STYLE2">专业：</span>
									</div>
								</td>
								<td><%=studentInfo_r.getMajor() %></td>
								<td><div align="center">
										<span class="STYLE2">学制：</span>
									</div>
								</td>
								<td><%=studentInfo_r.getLos() %></td>
							</tr>
							<tr>
								<td height="42"><div align="center">
										<span class="STYLE2">出生日期：</span>
									</div>
								</td>
								<td><%=stuResume.getBirthday().substring(0, 10) %></td>
								<td><div align="center">
										<span class="STYLE2">学历：</span>
									</div>
								</td>
								<td><%=studentInfo_r.getEduBg() %></td>
							</tr>
							<tr>
								<td height="42"><div align="center" class="STYLE2">生源地：</div>
								</td>
								<td><%=studentInfo_r.getNativePlace() %></td>
								<td><div align="center" class="STYLE2">政治面貌：</div>
								</td>
								<td><%=stuResume.getPoliticsStatus() %></td>
							</tr>

							<tr>
								<td height="81"><div align="center" class="STYLE2">语言能力：</div>
								</td>
								<td colspan="3"><%=stuResume.getLanguage() %></td>
							</tr>
							<tr>
								<td height="88"><div align="center" class="STYLE2">专业知识：</div>
								</td>
								<td colspan="3"><%=stuResume.getExpertise() %></td>
							</tr>
							<tr>
								<td height="103"><div align="center" class="STYLE2">兴趣爱好：</div>
								</td>
								<td colspan="3"><%=stuResume.getHobby() %></td>
							</tr>
							<tr>
								<td height="174"><div align="center" class="STYLE2">获奖情况：</div>
								</td>
								<td colspan="3"><%=stuResume.getAwards() %></td>
							</tr>
							<tr>
								<td height="172"><div align="center" class="STYLE2">项目/科研经历：</div>
								</td>
								<td colspan="3"><%=stuResume.getProjectAcademic() %></td>
							</tr>
							<tr>
								<td height="355"><div align="center" class="STYLE2">实践/工作经历：</div>
								</td>
								<td colspan="3"><%=stuResume.getPracticeWork() %></td>
							</tr>
							<tr>
								<td height="61"><div align="center" class="STYLE2">求职意向：</div>
								</td>
								<td colspan="3"><%=stuResume.getJobIntension() %></td>
							</tr>
							<tr>
								<td height="158"><div align="center" class="STYLE2">自我评价：</div>
								</td>
								<td colspan="3"><%=stuResume.getSelfAssessment() %></td>
							</tr>
						</table>
						<%if(session.getAttribute("userName")!=null && session.getAttribute("loginbtn").equals("company")) {%>
						<p>&nbsp;</p>
						<table width="683" border="1" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td width="133" height="43" class="STYLE2"><div
										align="center">联系电话：</div>
								</td>
								<td width="195" ><%=stuContact.getStudentTel() %></td>
								<td width="134"><div align="center" class="STYLE2">邮编：</div>
								</td>
								<td width="192"><%=stuContact.getStudentZip() %></td>
							</tr>
							<tr>
								<td height="46" class="STYLE2"><div align="center">邮箱：</div>
								</td>
								<td width="195"><%=stuContact.getStudentEmail() %></td>
								<td width="134"><div align="center" class="STYLE2">QQ：</div>
								</td>
								<td width="192"><%=stuContact.getStudentQQ() %></td>
							</tr>
							<tr>
								<td height="48" class="STYLE2"><div align="center">家庭住址：</div>
								</td>
								<td colspan="3"><%=stuContact.getStudentAddress() %></td>
							</tr>
						</table>
						<%} else { %>
						<p>&nbsp;</p><p>&nbsp;</p>
						<center><h3><font color="red">企业用户请登录之后查看联系方式！</font></h3></center>
						<p>&nbsp;</p><p>&nbsp;</p>
						<% } %>
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