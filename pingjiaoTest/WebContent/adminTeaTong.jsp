<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询评教信息</title>
</head>
<body>
    
<div style="margin-top: 40px;margin-bottom: 40px;margin-left: 130px;height: 40px float:left">
     <center>统计教师得分情况</center>
</div>
	<table border="1" width="80%" align="center" cellpadding="5" cellspacing="4">
		<tr>
		    <td>排名</td>
		    <td>姓名</td>
		    <td>学科</td>
			<td>指标一</td>
			<td>指标二</td>
			<td>指标三</td>
			<td>指标四</td>
			<td>指标五</td>
			<td>指标六</td>
			<td>指标七</td>
			<td>指标八</td>
			<td>指标九</td>
			<td>指标十</td>
			<td>平均分</td>
		</tr>
		<!-- 迭代数据-->
		<c:choose>
			<c:when test="${not empty requestScope.culs}">
				<c:forEach var="emp" items= "${requestScope.culs}" varStatus="vs" >
					<tr>
					    <td>${vs.count}</td>
					    <td>${emp.sid}</td>
						<td>${emp.scient}</td>
						<td>${emp.term1}</td>
						<td>${emp.term2}</td>
						<td>${emp.term3}</td>
						<td>${emp.term4}</td>
						<td>${emp.term5}</td>
						<td>${emp.term6}</td>
						<td>${emp.term7}</td>
						<td>${emp.term8}</td>
						<td>${emp.term9}</td>
						<td>${emp.term10}</td>
						<td>${emp.others}</td>
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