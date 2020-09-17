<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>班级管理</title>
</head>
<body>
<div style="float:left;margin-top: 40px;margin-bottom: 40px;margin-left: 450px"><h3>学院班级信息</h3></div>
<table border="1" width="80%" align="center" cellpadding="5" cellspacing="4">
		<tr>
		    <td>编号</td>
		    <td>班级ID</td>
			<td>班级名称</td>
			<td>班级负责人ID</td>
			<td>数学老师ID</td>
			<td>语文老师ID</td>
			<td>英语老师ID</td>
			<td>总人数</td>
			<td>操作</td>
		</tr>
		<!-- 迭代数据-->
		<c:choose>
			<c:when test="${not empty requestScope.culs}">
				<c:forEach var="emp" items= "${requestScope.culs}" varStatus="vs" >
					<tr>
					    <td>${vs.count}</td>
					    <td>${emp.classid}</td>
					    <td>${emp.classname}</td>
						<td>${emp.cteacherid}</td>
						<td>${emp.cmathid}</td>
						<td>${emp.cchinaid}</td>
						<td>${emp.cEnglishid}</td>
						<td>${emp.ctotal}</td>
						<td><a href='${pageContext.request.contextPath }/modifyClass.jsp?tid=${emp.classid}'>修改</a>&nbsp;<a href='${pageContext.request.contextPath }/classModifyServlet?classid=${emp.classid}&me=del'>删除</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="8">对不起，没有您要找的数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		 <tr>
        <td colspan="14" align="center"><a href='${pageContext.request.contextPath }/addClass.jsp'>[添加班级]</a></td>
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