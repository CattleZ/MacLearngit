<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询评教信息</title>
<script src="./node_modules/echarts/dist/echarts.js"></script>
</head>
<body>
     <form action="${pageContext.request.contextPath }/adminOperaScore?me=searAll2" method="post">
<div style="margin-top: 40px;margin-bottom: 40px;margin-left: 130px;height: 40px float:left">
       
    <div style="float: left;margin-right: 80px">
    请选择学科：
    <select name ="scice"style="width: 90px">
        <option>请选择</option>
        <option>数学</option>
        <option>语文</option>
        <option>英语</option>
    </select>
        </div>  
        <div style="float: left;margin-right: 200px">    
         <input type="submit" value="查询" width="90px" />
        </div>

</div>
</form>
<div style="margin-top: 40px;margin-bottom: 40px;margin-left: 130px;height: 40px float:left">
<form action="${pageContext.request.contextPath }/adminOperaScore?me=tedao" method="post" >
 <button type="submit" style="width:180px;height:30px;" >统计教师得分情况</button>
</form>
</div>
	<table border="1" width="80%" align="center" cellpadding="5" cellspacing="4">
		<tr>
		    <td>编号</td>
		    <td>学生学号</td>
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
			<td>其他</td>
		</tr>
		<!-- 迭代数据-->
		<c:choose>
			<c:when test="${not empty requestScope.culs}">
				<c:forEach var="emp" items= "${requestScope.culs}" varStatus="vs" >
					<tr>
					    <td>${vs.count}</td>
					    <td>${emp.sid}</td>
						<td>${emp.scient}</td>
						<td >${emp.term1}</td>
						<td >${emp.term2}</td>
						<td >${emp.term3}</td>
						<td >${emp.term4}</td>
						<td >${emp.term5}</td>
						<td >${emp.term6}</td>
						<td >${emp.term7}</td>
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
		 <td colspan="3">平均分</td>
		 <td id='1'>${requestScope.ls[0]}</td>
		 <td id='2'>${requestScope.ls[1]}</td>
		 <td id='3'>${requestScope.ls[2]}</td>
		 <td id='4'>${requestScope.ls[3]}</td>
		 <td id='5'>${requestScope.ls[4]}</td>
		 <td id='6'>${requestScope.ls[5]}</td>
		 <td id='7'>${requestScope.ls[6]}</td>
		 <td id='8'>${requestScope.ls[7]}</td>
		 <td id='9'>${requestScope.ls[8]}</td>
		 <td id='10'>${requestScope.ls[9]}</td>
		 <td >无</td>
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
	
	<div style="padding:20px;width:100%;height:100%;align:center;margin-left: 90px">
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 80%;height:600px;align:center">
</div>
</div>
<script>
    var x1 = document.getElementById("1").textContent;
    var x2 = document.getElementById("2").textContent;
    var x3 = document.getElementById("3").textContent;
    var x4 = document.getElementById("4").textContent;
    var x5 = document.getElementById("5").textContent;
    var x6 = document.getElementById("6").textContent;
    var x7 = document.getElementById("7").textContent;
    var x8 = document.getElementById("8").textContent;
    var x9 = document.getElementById("9").textContent;
    var x10 = document.getElementById("10").textContent;
    var  day = [x1,x2,x3,x4,x5,x6,x7,x8,x9,x10];
    var myChart = echarts.init(document.getElementById('main'), 'macarons');
    option = {
    	    color: ['#3398DB'],
    	    tooltip: {
    	        trigger: 'axis',
    	        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
    	            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    	        }
    	    },
    	    grid: {
    	        left: '3%',
    	        right: '4%',
    	        bottom: '3%',
    	        containLabel: true
    	    },
    	    xAxis: [
    	        {
    	            type: 'category',
    	            data: ['Term1', 'Term2', 'Term3', 'Term4', 'Term5', 'Term6', 'Term7','Term8','Term9','Term10'],
    	            axisTick: {
    	                alignWithLabel: true
    	            }
    	        }
    	    ],
    	    yAxis: [
    	        {
    	            type: 'value'
    	      
    	        }
    	    ],
    	    series: [
    	        {
    	            name: '直接访问',
    	            type: 'bar',
    	            barWidth: '60%',
    	            data: day
    	        }
    	    ]
    	};
    myChart.setOption(option);//将option添加到mychart中
</script>
</body>
</html>