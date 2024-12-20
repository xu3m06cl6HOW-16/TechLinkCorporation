<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="studentList" value="${studentList}" />

<html>
<head>
<meta charset="UTF-8">
<title>學生資料</title>
</head>
<body>

	<c:forEach var="Student" items="${studentList}">

		<div style="display: flex; justify-content: space-between;">
			<span>${Student.sno}</span> <span>${Student.sname}</span> <span>${Student.sbday}</span>
			<span>${Student.ssex}</span> <span>${Student.smail}</span> <span>${Student.spwd}</span>
		</div>

	</c:forEach>

</body>
</html>