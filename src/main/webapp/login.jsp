<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder" %>
<%@page import="org.springframework.security.web.WebAttributes" %>
<%@page import="org.apache.commons.lang.StringUtils" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<body>
<%! private String getAuthenticationExceptionMessage(){
    Exception exp=(Exception)ContextHolder.getHttpSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    if(exp==null){
        exp=(Exception)ContextHolder.getRequest().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
    if(exp!=null){
        return exp.getMessage();
    }
    return null;
     
}%>
<%String error=getAuthenticationExceptionMessage();
if(StringUtils.isNotEmpty(error)){
    out.println("Login Error:"+error);    
}%>
<h1>登录</h1>
<form action="security_check_" method="post">
    用户名：<input type="text" name="username_"><br>
    密码：<input type="password" name="password_"><br>
    验证码:<input type="text" name="captcha_"><img src="generate.captcha.action?width=150&height=60"><br>
    自动登录：<input type="checkbox" name="remember_me_"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>