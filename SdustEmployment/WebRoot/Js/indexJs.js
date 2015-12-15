// JavaScript Document
function checkform() {
	if (document.form2.keyword.value == ""
			|| document.form2.keyword.value == "--请输入查询关键字--") {
		alert("请输入查询关键字");
		document.form2.keyword.focus();
		return false;
	}
	return true;
}
function Ralert(){
	alert("您已经注册过了！");
}
function Jalert(){
	alert("请先登录！");
}
/*----------判断用户名------------*/
function checkming() {
	var checkObj = $("#username");
	var username = checkObj.val();
	$.get("../servlet/CheckStudentUserNameServlet?username="+username,null,callback);
}
function check(){
	var checkObj = $("#username");
	var username = checkObj.val();
	$.get("../servlet/CheckEnUserNameServlet?username="+username,null,callback);
}
function callback(data){
	alert(data);
}

$(function(){
	var code=$("#code");		//验证码图片
	//点击验证码图片，进行更换
	code.click(function(){
		code.attr("src","../Career/captcha.jsp?code="+new Date().getTime());//更新验证码的内容
	});
});
/*---------企业注册-----------*/
function JudgeEnterprise(){
	var username = document.formenter.username.value;
	var password = document.formenter.password.value;
	var password2 = document.formenter.password2.value;
	var cname = document.formenter.cname.value;
	var changye = document.formenter.changye.value;
	var ctype = document.formenter.ctype.value;
	var caddr = document.formenter.caddr.value;
	var cmore = document.formenter.cmore.value;
	var caddr2 = document.formenter.caddr2.value;
	var czip = document.formenter.czip.value;
	var cperson =document.formenter.cperson.value;
	var cphone =document.formenter.cphone.value;
	var cemail = document.formenter.cemail.value;
	if(username==""||password==""||password2==""||cname==""||changye==""||ctype==""
		||caddr==""||cmore==""||caddr2==""||czip==""||cperson==""||cphone==""||cemail==""){
		alert("带*的不能为空！");
	}
	else if(password!=password2){
		alert("前后密码不一致！");
	}else{
		$("form").submit();
	}
	
}

/*---------学生注册-----------*/
function JudgeStudent(){
	var username = document.formStu.username.value;
	var password = document.formStu.password.value;
	var confirmpwd = document.formStu.confirmpwd.value;
	var studentNum = document.formStu.studentNum.value;
	var tName = document.formStu.tName.value;
	if(username==""||password==""||confirmpwd==""||studentNum==""||tName==""){
		alert("带*的不能为空！");
	}
	else if(password!=confirmpwd){
		alert("前后密码不一致！");
	}else{
		$("form").submit();
	}
}
	
/*---------修改密码-----------*/
function updatePass(){
	var newPassObj = $("#newPass");
	var newPass = newPassObj.val();
	var newPass1Obj = $("#newPass1");
	var newPass1 = newPass1Obj.val();
	if(newPass!=newPass1){
		alert("新密码前后输入不一致，请重新输入密码！");
	}else{
		$("form").submit();
	}
}
	
/*---------提交简历-----------*/
function checkResume(){
	
	var birthday = document.resume.birthday.value;
	var nation = document.resume.nation.value;
	var graduateSchool = document.resume.school.value;
	var studentAddress = document.resume.address.value;
	var politicsStatus = document.resume.ps.value;
	if(birthday==""||nation==""||graduateSchool==""||studentAddress==""||politicsStatus==""){
		alert("带*的不能为空！");
	}else{
		$("form").submit();
	}
}
/*---------修改企业注册信息-----------*/	
function updateRegister(){
	var caddr2 = document.formenter.caddr2.value;
	var czip = document.formenter.czip.value;
	var cperson =document.formenter.cperson.value;
	var cphone =document.formenter.cphone.value;
	var cemail = document.formenter.cemail.value;
	if(caddr2==""||czip==""||cperson==""||cphone==""||cemail==""){
		alert("带*的不能为空！");
	}else{
		$("form").submit();
	}
}

/*---------发布招聘信息-----------*/
function Recruitment(){
	var title = document.recruitment.title.value;
	var author = document.recruitment.author.value;
	var enterprise = document.recruitment.enterprise.value;
	var job = document.recruitment.job.value;
	var address = document.recruitment.address.value;
	var origin = document.recruitment.origin.value;
	var content = document.recruitment.content.value;
	if(title==""||author==""||enterprise==""||job==""||address==""||origin==""||content==""){
		alert("带*的你能为空！");
	}else{
		$("form").submit();
	}
}
