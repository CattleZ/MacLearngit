<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理学生</title>
</head>
<body>
<div style="float:left;margin-top: 40px;margin-bottom: 40px;margin-left: 450px"><h3>班级学生信息</h3></div>
<table border="1" width="80%" align="center" cellpadding="5" cellspacing="4">
		<tr>
		    <td>编号</td>
		    <td>学生学号</td>
			<td>姓名</td>
			<td>密码</td>
			<td>班级ID</td>
			<td>性别</td>
			<td>年龄</td>
			<td>住址</td>
			<td>操作</td>
		</tr>
		<!-- 迭代数据-->
		<c:choose>
			<c:when test="${not empty requestScope.culs}">
				<c:forEach var="emp" items= "${requestScope.culs}" varStatus="vs" >
					<tr>
					    <td>${vs.count}</td>
					    <td>${emp.sid}</td>
						<td>${emp.sname}</td>
						<td>${emp.spwd}</td>
						<td>${emp.classid}</td>
						<td>${emp.sgender}</td>
						<td>${emp.sage}</td>
						<td>${emp.saddress}</td>
						<td><a href='${pageContext.request.contextPath }/studentModify.jsp?sid=${emp.sid}'>修改</a>&nbsp;<a href='${pageContext.request.contextPath }/StumodifyServlet?sid=${emp.sid}&me=del'>删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="14">对不起，没有您要找的数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		 <tr>
        <td colspan="14" align="center"><a href='${pageContext.request.contextPath }/addStudent.jsp'>[添加学生]</a></td>
    </tr>
		<tr>
			<td colspan="14" align="center">
			当前第1 页 / 共 1 页
			<a>首页</a>
			<a>上一页</a>
			<a>下一页</a>
			<a>尾页</a> 
			</td>
		</tr>
		
	</table>
</body>
</html>