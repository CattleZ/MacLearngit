<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <title>学生登陆入口</title>
    <link rel="icon" href="loginSpecial/images/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="loginSpecial/images/favicon.ico" type="image/x-icon"/>
    <link href="loginSpecial/css/default.css" rel="stylesheet" type="text/css" />
    <!--必要样式-->
    <link href="loginSpecial/css/styles.css" rel="stylesheet" type="text/css" />
    <link href="loginSpecial/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="loginSpecial/css/loaders.css" rel="stylesheet" type="text/css" />
    <script src="loginSpecial/js/jquery-2.1.1.min.js"></script>

</head>
<body>
<div class='login'>

    <!--<img class="MyLogo" src="loginSpecial/images/logo01.png" alt="   LOGO">-->
    <div class='login_title'>
        <span>学生登录</span>
    </div>
    <div class='login_fields'>
    <%
    String conpath = request.getContextPath();
    String url =conpath+"/LoginServlet?me=student";
    pageContext.setAttribute("url", url);
    pageContext.setAttribute("conpath", conpath);
    %>
    
  <form action='${url}' method="post" id="form2">
        <div class='login_fields__user'>
            <div class='icon'>
                <img alt="" src='loginSpecial/img/user_icon_copy.png'>
            </div>
            <input name="login" placeholder='用户名' maxlength="16" class="username" type='text' autocomplete="off" />
            <div class='validation'>
                <img alt="" src='loginSpecial/img/tick.png'>
            </div>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img alt="" src='loginSpecial/img/lock_icon_copy.png'>
            </div>
            <input name="pwd" class="passwordNumder" placeholder='密码' maxlength="16" type='text' autocomplete="off">
            <div class='validation'>
                <img alt="" src='loginSpecial/img/tick.png'>
            </div>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img alt="" src='loginSpecial/img/key.png'>
            </div>
            <input name="code" placeholder='验证码' maxlength="4"  class="ValidateNum" type='text' name="ValidateNum" autocomplete="off">
            <div class='validation' style="opacity: 1; right: -5px;top: -3px;">
                <canvas  class="J_codeimg" id="myCanvas" onclick="Code();">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
            </div>
        </div>
        <div class='login_fields__submit'>
            <input type='button' value='登录' size="1">
        </div>
  </form>
    </div>  
    <div class='success'>
    </div>
    <div class='disclaimer'>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='${conpath}/adminLogin.jsp'><font color="green">管理员登陆</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${conpath}/studentLogin.jsp"><font color="red">学生登陆</font></a>
       &nbsp;&nbsp;&nbsp;&nbsp;<a href="${conpath}/teacherLogin.jsp"><font color="orange">教师登陆</font></a>
    </div>
</div>
<div class='authent'>
    <div class="loader" style="height: 60px;width: 60px;margin-left: 28px;margin-top: 40px">
        <div class="loader-inner ball-clip-rotate-multiple">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>
    <p>认证中...</p>
</div>
<div class="OverWindows"></div>
<link href="loginSpecial/layui/css/layui.css" rel="stylesheet" type="text/css" />
<!--<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>-->
<script type="text/javascript" src="loginSpecial/js/jquery-ui.min.js"></script>
<script type="text/javascript" src='loginSpecial/js/stopExecutionOnTimeout.js?t=1'></script>
<script src="loginSpecial/layui/layui.js" type="text/javascript"></script>
<script src="loginSpecial/js/Particleground.js" type="text/javascript"></script>
<script src="loginSpecial/js/Treatment.js" type="text/javascript"></script>
<script src="loginSpecial/js/jquery.mockjax.js" type="text/javascript"></script>
<script src="loginSpecial/js/controlLogin.js" type="text/javascript"></script>
</body>
</html>
