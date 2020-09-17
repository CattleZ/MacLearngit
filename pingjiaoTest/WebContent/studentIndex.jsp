<%@page import="entity.student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生登陆</title>
    <script type="text/javascript">
        function f1() {
           var ele = document.getElementsByName("ifram");
           ele[0].setAttribute("src","pingJiaoServlet?me=pingjiao&sid=${requestScope.stu.sid}") 
        }
        function f2() {
            var ele = document.getElementsByName("ifram")
            ele[0].setAttribute("src","pingJiaoServlet?me=modify&sid=${requestScope.stu.sid}")
        }
    </script>
</head>
<body>
<div id="s_Tou" style="border:1px solid aliceblue;height: 42px">
    <div style="width: 10px;height: 30px;align-content: center;margin-right: 10px;float: left;margin-top: 9px"></div>
    <div style="width: 100px;height: 30px;align-content: center;margin-right: 0px;float: left;margin-top: 9px"><a href='./studentLogin.jsp'>注销</a></div>
    <div style="width: 100px;height: 30px;align-content: center;margin-right: 10px;float: left;margin-top: 9px"><a>姓名:${requestScope.stu.sname}</a></div>
    <div style="width: 150px;height: 30px;align-content: center;margin-right: 10px;float: left;margin-top: 9px"><a>学号:${requestScope.stu.sid}</a></div>
    <div style="width: 150px;height: 30px;align-content: center;margin-right: 10px;float: left;margin-top: 9px"><a>学院:${requestScope.dname}</a></div>
    <div style="width: 150px;height: 30px;align-content: center;margin-right: 10px;float: left;margin-top: 9px"><a>班级:${requestScope.clas}</a></div>
    <div style="width: 120px;height: 30px;float: right"></div>
    <div style="width: 400px;height: 42px;align-content: center;margin-left: 10px;float: right ">
        <marquee scrollamount="10" style="align-items: center;margin-top: 9px ;width: 400px"><a style="font-size: 20px">欢迎光临！校训：明德  砺学 日新 致远</a></marquee>
    </div>
</div>

<div id="s_caidan" style="border: 1px solid black;width: 201px;float: left">
    <table align="center" border="1" width="200px">
        <tr>
            <th>目录索引</th>
        </tr>
        <tr>
            <td>
                <a onclick="f1()">>评教</a>
            </td>
        </tr>
        <tr>
            <td>
                <a>  >在线课堂 </a>
            </td>
        </tr>
        <tr>
            <td>
                <a>  >我的课表 </a>
            </td>
        </tr>
        <tr>
            <td>
                <a>  >信息查询 </a>
            </td>
        </tr>
        <tr>
            <td>
                <a onclick="f2()"> >修改个人信息 </a>
            </td>
        </tr>
    </table>
</div>
<div>
    <iframe name="ifram" src="pingjiao.jsp" style="width:1050px;height: 885px;background-color: azure;float: left;margin-left: 20px"></iframe>
</div>
</body>
</html>