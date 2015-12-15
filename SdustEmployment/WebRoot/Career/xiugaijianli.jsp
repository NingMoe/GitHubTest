<%@ page language="java" import="java.util.*,cn.edu.sdust.tool.StuQuery,cn.edu.sdust.resume.*"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link href="../Css/indexCss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../Js/jQuery.js"></script>
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
									href="../servlet/IndexServlet">首页</a> &gt;&gt;修改简历
							</tr>
						</table>
					</div>
					<div class="content_bottom"><center>
					<%
						StudentInfo studentInfo = new StudentInfo();
						StuResume stuResume = new StuResume();
						StuContact stuContact = new StuContact();
						studentInfo = (StudentInfo)request.getAttribute("studentInfo");
						stuResume = (StuResume)request.getAttribute("stuResume");
						stuContact = (StuContact)request.getAttribute("stuContact");
					 %>
					<h1>修改个人简历</h1>
					<p>&nbsp;</p><p>&nbsp;</p>
						<form method="post" action="../servlet/UpdateResumeServlet">
						<table width="500">
						<tr>
							<td width="100" align="right"><h3>姓名：</h3></td>
							<td width="150"><input type="text" size="18" readonly value="<%=studentInfo.getStudentName() %>"/></td>
							<td width="100" align="right"><h3>性别：</h3></td>
							<td width="150"><input type="text" size="18" readonly value="<%=studentInfo.getGender() %>"/></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>学制：</h3></td>
							<td width="150"><input type="text" size="18" readonly value="<%=studentInfo.getLos() %>"/></td>
							<td width="100" align="right"><h3>专业：</h3></td>
							<td width="150"><input type="text" size="18" readonly value="<%=studentInfo.getMajor() %>"/></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>生源地：</h3></td>
							<td width="150"><input type="text" size="18" readonly value="<%=studentInfo.getNativePlace() %>"/></td>
							<td width="100" align="right"><h3>出生日期：</h3></td>
							<td width="150"><input type="text" size="18" name="birthday" id="birthday" value="<%=stuResume.getBirthday().substring(0, 10) %>" /></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>民族：</h3></td>
							<td width="150"><input type="text" size="18" name="nation" id="nation" value="<%=stuResume.getNation() %>"/></td>
							<td width="100" align="right"><h3>毕业学校：</h3></td>
							<td width="150"><input type="text" size="18" name="school" id="school" value="<%=stuResume.getGraduateSchool() %>" /></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>联系电话：</h3></td>
							<td width="150"><input type="text" size="18" name="tel" id="tel" value="<%=stuContact.getStudentTel() %>"/></td>
							<td width="100" align="right"><h3>邮箱：</h3></td>
							<td width="150"><input type="text" size="18" name="email" id="email" value="<%=stuContact.getStudentEmail() %>"/></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>QQ：</h3></td>
							<td width="150"><input type="text" size="18" name="qq" id="qq" value="<%=stuContact.getStudentQQ() %>"/></td>
							<td width="100" align="right"><h3>邮编：</h3></td>
							<td width="150"><input type="text" size="18" name="zip" id="zip" value="<%=stuContact.getStudentZip() %>"/></td>
						</tr>
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
							<td width="100" align="right">&nbsp;</td>
							<td width="150">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>家庭住址：</h3></td>
							<td width="150"><input type="text" size="18" name="address" id="address" value="<%=stuContact.getStudentAddress() %>" /></td>
							<td width="100" align="right"><h3>政治面貌：</h3></td>
							<td width="150"><input type="text" size="18" name="ps" id="ps" value="<%=stuResume.getPoliticsStatus() %>"/></td>
						</tr>
						
						</table>
						</p><p>&nbsp;</p>
						<table width="500">
						<tr>
							<td width="100" align="right"><h3>语言能力：</h3></td>
							<td width="400"><textarea cols="53" rows="4" name="language" id="language" ><%=stuResume.getLanguage() %></textarea></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="400">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>专业知识：</h3></td>
							<td width="400"><textarea cols="53" rows="4" name="expertise" id="expertise" ><%=stuResume.getExpertise() %></textarea></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="400">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>兴趣爱好：</h3></td>
							<td width="400"><textarea cols="53" rows="8" name="hobby" id="hobby" ><%=stuResume.getHobby() %></textarea></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="400">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>获奖情况：</h3></td>
							<td width="400"><textarea cols="53" rows="8" name="award" id="award" ><%=stuResume.getAwards() %></textarea></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="400">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>项目/科研经历：</h3></td>
							<td width="400"><textarea cols="53" rows="8" name="projectAcademic" id="ProjectAcademic" ><%=stuResume.getProjectAcademic() %></textarea></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="400">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>实践/工作经历：</h3></td>
							<td width="400"><textarea cols="53" rows="8" name="practiceWork" id="practiceWork" ><%=stuResume.getPracticeWork() %></textarea></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="400">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>求职意向：</h3></td>
							<td width="400"><textarea cols="53" rows="8" name="jobIntension" id="jobIntension" ><%=stuResume.getJobIntension() %></textarea></td>
						</tr>
						
						<tr>
							<td width="100" align="right">&nbsp;</td>
							<td width="400">&nbsp;</td>
						</tr>
						
						<tr>
							<td width="100" align="right"><h3>自我评价：</h3></td>
							<td width="400"><textarea cols="53" rows="8" name="selfAssessment" id="selfAssessment" ><%=stuResume.getSelfAssessment() %></textarea></td>
						</tr>
						</table>
						<p>&nbsp;</p><p>&nbsp;</p>
						<input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置"/>
						</form>
						<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
						</center>
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
