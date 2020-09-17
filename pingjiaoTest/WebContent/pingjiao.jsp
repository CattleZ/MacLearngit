<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>评教</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/PingServlet?me=sping&sid=${requestScope.sid}" method="post">
<div style="margin-top: 40px;margin-bottom: 40px;margin-left: 130px;height: 40px">
        
        <div style="float: left;margin-right: 100px">
    学号：
     <span>${requestScope.sid}</span>
        </div>
   
    <div style="float: left;margin-right: 100px">
    请选择学科：
    <select name ="scice"style="width: 90px">
        <option>请选择</option>
        <option>数学</option>
        <option>语文</option>
        <option>英语</option>
        <option>计算机基础</option>
        <option>数据库管理</option>
        <option>Java基础</option>
        <option>马克思</option>
    </select>
        </div>
        
        
</div>

<table id="t1" align="center" border="1" width="800px">
    <tr>
        <th>评价项目</th>
        <th width="100px">分数</th>
    </tr>
    <tr>
        <td>
           <span> ${requestScope.toa.term1}</span>
        </td>
        <td>
            <select id="term1" name="term1">
                <option>0</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
            </select>分
        </td>
    </tr>
    <tr>
    <td>
        ${requestScope.toa.term2}
    </td>
    <td>
        <select id="term2" name="term2">
            <option>0</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>分
    </td>
    </tr>
    <tr>
    <td>
        ${requestScope.toa.term3}
    </td>
    <td>
        <select id="term3" name="term3">
            <option>0</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>分
    </td>
    </tr>

<tr>
    <td>
        ${requestScope.toa.term4}
    </td>
    <td>
        <select id="term4" name="term4">
            <option>0</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>分
    </td>
    </tr>    
<tr>
    <td>
        ${requestScope.toa.term5}
    </td>
    <td>
        <select id="term5" name="term5">
            <option>0</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>分
    </td>
    </tr>    
    <tr>
    <td>
        ${requestScope.toa.term6}
    </td>
    <td>
        <select id="term6" name="term6">
            <option>0</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>分
    </td>
    </tr>
<tr>
    <td>
        ${requestScope.toa.term7}
    </td>
    <td>
        <select id="term7" name="term7">
            <option>0</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>分
    </td>
    </tr>
<tr>
    <td>
        ${requestScope.toa.term8}
    </td>
    <td>
        <select id="term8" name="term8">
            <option>0</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>分
    </td>
    </tr>
    <tr>
    <td>
        ${requestScope.toa.term9}
    </td>
    <td>
        <select id="term9" name="term9">
            <option>0</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>分
    </td>
    </tr>
    <tr>
    <td>
        ${requestScope.toa.term10}
    </td>
    <td>
        <select id="term10" name="term10">
            <option>0</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>分
    </td>
    </tr>
    <tr>
        <td colspan="2"><div style="margin-bottom: 25px;float: left">其他意见：</div><textarea name="term11" cols="90" rows="3"></textarea></td>
    </tr>

</table>
    <div style="margin-left: 850px;margin-top: 30px">
    <input type="submit" value="提交" style="height: 30px"/>
    </div>
</form>
</body>
</html>