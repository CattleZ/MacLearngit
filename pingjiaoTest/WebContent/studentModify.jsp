<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
</head>
<body>
<center><h3>修改个人信息</h3></center>
<% 
String sid = request.getParameter("sid");
System.out.println("jsp:"+sid);
if(!"".equals(sid)||sid!=null){
	request.setAttribute("sid",sid);
}else{
	request.setAttribute("sid",request.getAttribute("sid"));
}
%>

<form action='${pageContext.request.contextPath}/StumodifyServlet?me=modify' method="post">
    <table align="center" border="1" width="300px">
        <tr>
            <th>
                学号
            </th>
            <td>
                <input type="text" name="id" value='${requestScope.sid}' readonly="readonly"/ />
            </td>
        </tr>
        <tr>
            <th>
                姓名
            </th>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <th>
                密码
            </th>
            <td>
                <input type="password" name="passw"/>
            </td>
        </tr>
        <tr>
        <th>
            班级
        </th>
        <td>
            <a name="classid" ></a>
        </td>
        </tr>
        <tr>
            <th>
                姓别
            </th>
            <td>
                <input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女" checked="checked"/>女
            </td>
        </tr>
        <tr>
            <th>
                年龄
            </th>
            <td>
                <input type="text" name="age"/>
            </td>
        </tr>
        <tr>
            <th>
                电话
            </th>
            <td>
                <input type="text" name="phone"/>
            </td>
        </tr>
        <tr>
            <th>
                邮箱
            </th>
            <td>
                <input type="text" name="mail"/>
            </td>
        </tr>
        <tr>
            <th>
                QQ
            </th>
            <td>
                <input type="text" name="qq"/>
            </td>
        </tr>
        <tr>
            <th>
                住址
            </th>
            <td>
                <input type="text" name="addr" />
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="save" value="保存" size="7"/>
                <input type="reset" name="redir" value="重置" size="7">
            </td>
        </tr>
    </table>
</form>
</body>
</html>