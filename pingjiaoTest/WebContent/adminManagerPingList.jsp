<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>设计评教指标</title>
</head>
<style type='text/css'>
td{
text-align:center;
}
</style>
<body>


<form action="${pageContext.request.contextPath }/PingServlet?me=aping" method="post">
<div style="margin-top: 40px;margin-bottom: 40px;align:center;height: 40px">
   
        <center>设计评教内容</center>
        
</div>

<table id="t1" align="center" border="1" width="80%">
    <tr >
       <td>
       项目
       </td>
       <td>
       内容
       </td>
    </tr>
    <tr>
        <td>
           <span>项目一</span>
        </td>
        <td>
           <input type="text" name="term1" value='${requestScope.toa.term1}' size="110" />
        </td>
    </tr>
    
    <tr>
    <td>
       <span>项目二</span>
    </td>
    <td>
        <input type="text" name="term2" value='${requestScope.toa.term2}' size="110"/>
    </td>
    </tr>
    <tr>
    <td>
       <span>项目三</span>
    </td>
    <td>
        <input type="text" name="term3" value='${requestScope.toa.term3}' size="110"/>
    </td>
    </tr>

<tr>
    <td>
       <span>项目四</span>
    </td>
    <td>
        <input type="text" name="term4" value='${requestScope.toa.term4}'size="110" />
    </td>
    </tr>    
<tr>
    <td>
       <span>项目五</span>
    </td>
    <td>
       <input type="text" name="term5" value='${requestScope.toa.term5}' size="110"/>
    </td>
    </tr>    
    <tr>
    <td>
        <span>项目六</span>
    </td>
    <td>
        <input type="text" name="term6" value='${requestScope.toa.term6}'size="110" />
    </td>
    </tr>
<tr>
    <td>
       <span>项目七</span>
    </td>
    <td>
       <input type="text" name="term7" value='${requestScope.toa.term7}' size="110"/>
    </td>
    </tr>
<tr>
    <td>
       <span>项目八</span>
    </td>
    <td>
       <input type="text" name="term8" value='${requestScope.toa.term8}' size="110"/>
    </td>
    </tr>
    <tr>
    <td>
       <span>项目九</span>
    </td>
    <td>
       <input type="text" name="term9" value='${requestScope.toa.term9}' size="110" />
    </td>
    </tr>
    <tr>
    <td>
        <span>项目十</span>
    </td>
    <td>
       <input type="text" name="term10" value='${requestScope.toa.term10}'size="110" />
    </td>
    </tr>

</table>
    <div style="margin-left: 850px;margin-top: 30px">
    <input type="submit" value="确认更改" style="height: 30px"/>
    </div>
</form>
</body>
</html>