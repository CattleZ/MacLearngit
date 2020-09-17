<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>添加教师信息</title>
</head>
<body>
<center><h3>添加教师信息</h3></center>
<%
String tid = request.getParameter("tid");
request.setAttribute("tid", tid);
%>

<form action='${pageContext.request.contextPath}/teacherSerScore?me=add' method="post">
    <table align="center" border="1" width="300px">
        <tr>
            <th>
                教工号
            </th>
            <td>
                <input type="text" name="id"  />
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
                用户名
            </th>
            <td>
                <input type="text" name="username"/>
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