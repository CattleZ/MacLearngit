<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>修改班级信息</title>
</head>
<body>
<center><h3>修改班级信息</h3></center>
<%
String tid = request.getParameter("tid");
request.setAttribute("tid", tid);
%>

<form action='${pageContext.request.contextPath}/classModifyServlet?me=modify' method="post">
    <table align="center" border="1" width="300px">
        <tr>
            <th>
                班级ID
            </th>
            <td>
                <input type="text" name="id" value='${requestScope.tid}' readonly="readonly" />
            </td>
        </tr>
        <tr>
            <th>
                班级名称
            </th>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <th>
               班级负责人ID
            </th>
            <td>
                <input type="text" name="tacher"/>
            </td>
        </tr>
        <tr>
            <th>
               数学老师ID
            </th>
            <td>
                <input type="text" name="math"/>
            </td>
        </tr>
        <tr>
            <th>
                语文老师ID
            </th>
            <td>
                <input type="text" name="china"/>
            </td>
        </tr>
        <tr>
            <th>
                英语老师ID
            </th>
            <td>
                <input type="text" name="english"/>
            </td>
        </tr>
        <tr>
            <th>
                学院ID
            </th>
            <td>
                <input type="text" name="d" value="501" readonly="readonly" />
            </td>
        </tr>
        <tr>
            <th>
               总人数
            </th>
            <td>
                <input type="text" name="total"/>
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