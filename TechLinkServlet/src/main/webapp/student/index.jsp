<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
		<form method="post"
			action="<%=request.getContextPath()%>/student/inserStudent.jsp">
			<input type="submit" value="開始使用">
		</form>
	</div>

</body>
</html>