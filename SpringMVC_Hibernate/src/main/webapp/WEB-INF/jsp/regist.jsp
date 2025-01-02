<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style type="text/css">
th, td {
	border: solid 1px black
}
</style>

</head>

<body>
	<div class="container">
		<h1>歡迎使用註冊會員</h1>
		<form method="post"
			action="<%=request.getContextPath()%>/users/register">
			<input type="text" name="userName" placeholder="請輸入用戶名"> <br>
			<input type="text" name="userAccount" placeholder="請輸入用戶帳號">
			<br> <input type="text" name="userPass" placeholder="請輸入用戶密碼">
			<br> <input type="text" id="email" name="userEmail"
				placeholder="請輸入用戶信箱"> <span id="emlMsg"></span>

			<c:if test="${not empty erroMsg}">
				<ul>
					<c:forEach var="error" items="${erroMsg}">
						<li style="color: red">${error.defaultMessage}</li>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${status == 'exist'}">
				<ul>
					<h3 style="color: red;">此信箱有人註冊了!</h3>
				</ul>
			</c:if>
			<br> <input type="submit" value="註冊">
		</form>
	</div>

	<c:if test="${ user!=null }">
		<div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">姓名</th>
						<th scope="col">帳號</th>
						<th scope="col">信箱</th>
						<th scope="col">註冊日期</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">${ user.userId }</th>
						<td>${ user.userName }</td>
						<td>${ user.userAccount }</td>
						<td>${ user.userEmail }</td>
						<td>${ user.userCreateDate }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:if>

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

									$('#emlMsg').html(xhr.responseText);
								} else {
									alert("請求失敗，狀態碼: " + xhr.status);
								}
							}
						};

						xhr.open("POST", "/SpringMVC_JSP/users/check", true);
						xhr.setRequestHeader("Content-Type",
								"application/x-www-form-urlencoded");

						// 发送数据，获取输入框的值
						var email = $('#email').val(); // 获取输入框的值
						xhr.send("email=" + encodeURIComponent(email));
					});
		};
	</script>

</body>
</html>