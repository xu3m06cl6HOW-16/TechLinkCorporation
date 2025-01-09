<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	tr,td{
		border:solid 1px black
	}
</style>
</head>
<body>
<h1>您的資料:</h1>
	
		<table>
			<thead>
				<tr>
					<td>userId</td>
					<td>userName</td>
					<td>userAccount</td>
					<td>userPass</td>
					<td>userEmail</td>
					<td>userCreateDate</td>
				</tr>
				</thead>
				<tbody>
					<tr>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.userAccount }</td>
						<td>${user.userPass }</td>
						<td>${user.userEmail }</td>
						<td>${user.userCreateDate }</td>
					</tr>
				</tbody>
			
		</table>
			
		
	

</body>
</html>