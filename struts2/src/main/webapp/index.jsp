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
	.error-message {
        color: red
    }
</style>

</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>

	<h3>SELECT USER</h3>
	<s:form action="emp-list">
		<s:textfield name="userEmail" label="USEREMAIL"></s:textfield>
		<s:textfield name="userPass" label="USERPASS"></s:textfield>
		<s:submit></s:submit>
	</s:form>
	
	<h3>CREATE USER</h3>
	<s:form action="user-add">
		<s:textfield name="userName" label="USERNAME"></s:textfield>
		<s:textfield name="userAccount" label="USERACCOUNT"></s:textfield>
		<s:textfield name="userPass" label="USERPASS"></s:textfield>
		<s:textfield name="userEmail" id="email" label="USEREMAIL"></s:textfield><div id="emlMsg"></div>
		<s:fielderror cssClass="error-message" fieldName="email" />
		<s:submit></s:submit>
	</s:form>
	
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
		
	<h3>FORGET PASSWORD</h3>
	<s:form action="user-reset">
		<s:textfield name="userAccount" label="USERACCOUNT"></s:textfield>
		<s:textfield name="userEmail" label="USEREMAIL"></s:textfield>
		<s:submit id="reset"></s:submit>
	</s:form>
		
		
		<script type="text/javascript">
		window.onload = function() {

			$('#email').on('focus', function() {
				$("#emlMsg").html(""); // 清空 #emlMsg 的内容
			});

			$('#email').blur(
					function() {

						var xhr = new XMLHttpRequest();

						// 綁定狀態變化事件
						xhr.onreadystatechange = function() {
							if (xhr.readyState === 4) {
								if (xhr.status === 200) {
									console.log($('#email').val())
									$('#emlMsg').html(xhr.responseText);
								} else {
									alert("請求失敗，狀態碼: " + xhr.status);
								}
							}
						};

						xhr.open("POST", "http://localhost:8080/struts2/app/user-check.action", true);
						xhr.setRequestHeader("Content-Type",
								"application/x-www-form-urlencoded");

						// 发送数据，获取输入框的值
						var email = $('#email').val(); // 获取输入框的值
						xhr.send("userEmail=" + encodeURIComponent(email));
					});
			$('#reset').click(function() {
			      alert("已發送至郵件!");
			    });
		};
	</script>
	
</body>
</html>