<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="image/jpeg"%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:useBean id="image" scope="page" class="cn.edu.sdust.login.MakeCertPic"/>
<%	
	String str = image.getCertPic(0,0,response.getOutputStream());
	session.setAttribute("captcha",str);
	out.clear();
	out = pageContext.pushBody();
%>
