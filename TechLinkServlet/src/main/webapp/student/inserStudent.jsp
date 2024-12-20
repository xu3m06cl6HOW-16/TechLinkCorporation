<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="auccessNum" value="${auccessNum}" />
<c:set var="insertNum" value="${insertNum}" />
<html>
<head>
<meta charset="UTF-8">
<title>學生建檔系統</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/student/css/student.css">
</head>
<body>

	<div class="container">
		<h1>歡迎使用學生建檔系統</h1>
		<form method="post" action="<%=request.getContextPath()%>/student.do">
			<label for="studentNum">請輸入要產生學生資料數量的筆數:</label> <input type="number"
				id="studentNum" name="studentNum" required> <br> <br>

			<!-- 提交按鈕 -->
			<input id="stuSub" type="submit" value="提交"> <input
				type="hidden" name="action" value="insertStudent">
		</form>
		<br>
		<c:if test="${auccessNum != null}">
			<h5 id="stuSub" style = "color:green">成功 ${auccessNum} 筆</h5>
			<h5 id="stuSub" style = "color:red">失敗 ${insertNum-auccessNum} 筆</h5>
		</c:if>
		<br>
		<form method="post" action="<%=request.getContextPath()%>/student.do">
			<input id="stuSub" type="submit" value="查詢學生資料"> <input
				type="hidden" name="action" value="selectStudentList">
		</form>
		
	</div>

</body>
</html>