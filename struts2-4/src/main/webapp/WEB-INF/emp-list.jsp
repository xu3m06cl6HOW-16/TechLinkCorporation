<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table style="border:solid 1px black">
		<thead>
			<tr>
				<td>ID</td>
				<td>USER_NAME</td>
				<td>USER_ACCOUNT</td>
				<td>USER_PASS</td>
				<td>USER_EMAIL</td>
				<td>USER_CREATE_DATE</td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="#request.emps">
				<tr>
					<td>${employeeId }</td>
					<td>${firstName }</td>
					<td>${lasttName }</td>
					<td>${Email }</td>
					<td><a href="">Edit</a></td>
					<td><a href="">Delete</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

</body>
</html>