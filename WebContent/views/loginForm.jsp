<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/common/header.jsp"%>
<style>
.btn-primary { -
	-bs-btn-bg: #2eca6a; -
	-bs-btn-border-color: #2eca6a;
}

.alert-danger { -
	-bs-alert-bg: white; -
	-bs-alert-border-color: white;
}

#form-login {
	width: 500px;
	margin: auto;
}

button{
	margin-top: 1em;
	width: 200px;
}
</style>
</head>

<body>
	<%@ include file="/common/nav2.jsp"%>

	<!-- 코드 내용 추가할곳-->
	<form id="form-login" method="POST" action="">
		<h1 style="margin-bottom: 1em; font-size: 2.0rem;!important">Login</h1>

		<div>
			<label for="floatingID">ID</label> <input type="text"
				id="floatingID" name="id" placeholder="user-id">
		</div>
		<div>
			<label for="floatingPassword">Password</label> <input type="password"
				id="floatingPassword" name="password"
				placeholder="Password">
		</div>
		<div style="display: flex; justify-content: space-around;">
			<div>
				<button id="btn-login"
					type="button" onclick="login()">로그인</button>
			</div>
			<div>
				<button id="btn-go-signup"
					type="button" onclick="goSignUp()">회원가입</button>
			</div>
		</div>
		<p>
		<div id="alert-div" role="alert"
			style="display: none;"></div>
		</p>
	</form>
	<%@ include file="/common/footer.jsp"%>
</body>
<script>
	document.querySelector("#btn-login").addEventListener("click", function() {
		if (!document.querySelector("#floatingID").value) {
			alert("아이디 입력!");
			return;
		} else if (!document.querySelector("#floatingPassword").value) {
			alert("비밀번호 입력!");
			return;
		} else {
			let form = document.querySelector("#form-login");
			form.setAttribute("action", "${root}/loginProcess.home");
			form.submit();
		}
	});

	document.querySelector("#btn-go-signup").addEventListener("click",
			function() {
				location.href = "${root}/signupForm.home";
			});
</script>
</html>
