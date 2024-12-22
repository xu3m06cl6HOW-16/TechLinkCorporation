<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="studentList" value="${studentList}" />

<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>學生資料</title>
</head>
<body class="p-3 m-0 border-0 bd-example m-0 border-0 bd-example-row">

	<div class="container text-center">
		<div class="row">
			<div class="col">SNO</div>
			<div class="col">SNAME</div>
			<div class="col">SBDAY</div>
			<div class="col">SSEX</div>
			<div class="col">SMAIL</div>
			<div class="col">SPWD</div>
		</div>
	</div>
	<br>
	<c:forEach var="Student" items="${studentList}">

		<div class="container text-center">
			<div class="row">
				<div class="col">${Student.sno}</div>
				<div class="col">${Student.sname}</div>
				<div class="col">${Student.sbday}</div>
				<div class="col">${Student.ssex}</div>
				<div class="col">${Student.smail}</div>
				<div class="col">${Student.spwd}</div>
			</div>
		</div>

	</c:forEach>


</body>
</html>