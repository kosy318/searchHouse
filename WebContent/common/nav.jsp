<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-trans navbar-expand-lg">
	<div class="container">
		<button class="navbar-toggler collapsed" type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarDefault"
			aria-controls="navbarDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span></span> <span></span> <span></span>
		</button>
		<a class="navbar-brand text-brand" href="${root }/index.jsp">구해줘 <span
			class="color-b">Home</span>
		</a>

		<div class="navbar-collapse collapse justify-content-center"
			id="navbarDefault">
			<ul class="navbar-nav">
				<c:if test="${auth ne null}">
					<li class="nav-item" id="login-menu" style="display: none"><a
						class="nav-link" id="btn-mvlogin">로그인</a></li>
					<li class="nav-item" id="logout-menu" style="display: block"><a
						class="nav-link" id="btn-logout">로그아웃</a></li>
				</c:if>
				<c:if test="${auth eq null }">
					<li class="nav-item" id="login-menu" style="display: block"><a
						class="nav-link" id="btn-mvlogin">로그인</a></li>
					<li class="nav-item" id="logout-menu" style="display: none"><a
						class="nav-link" id="btn-logout">로그아웃</a></li>
				</c:if>

				<li class="nav-item"><a class="nav-link" id="btn-mvmypage">마이페이지</a>
				</li>
				<li class="nav-item"><a class="nav-link" id="btn-mvusersearch">회원조회</a>
				</li>
				<li class="nav-item"><a class="nav-link" id="btn-mvnotice">공지사항</a>
				</li>
			</ul>
		</div>

		<button type="button"
			class="btn btn-b-n navbar-toggle-box navbar-toggle-box-collapse"
			data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01"
			id="search-btn">
			<i class="bi bi-search"></i> <span style="margin-left: 10px">아파트
				매매 검색</span>
		</button>
	</div>
</nav>
<script>
	document.getElementById("search-btn").addEventListener("click", function() {
		location.href = "${root}/apt?act=mvsearch&sidoName=&gugunName=&dongName=";
	});

	// 회원가입 페이지로 이동
	document.querySelector("#btn-logout").addEventListener("click", function() {
		location.href = "${root}/user?act=logout";
	});
	document.querySelector("#btn-mvlogin").addEventListener("click",
			function() {
				location.href = "${root}/user?act=mvlogin";
			});
	document.querySelector("#btn-mvmypage").addEventListener("click",
			function() {
				console.log("mvMyPage");

				location.href = "${root}/user?act=mvmypage";
			});
	document.querySelector("#btn-mvusersearch").addEventListener("click",
			function() {
				console.log("mv User Search");
				location.href = "${root}/user?act=mvsearch";
			});
	document.querySelector("#btn-mvnotice").addEventListener("click",
			function() {
				console.log("mv Notice");
				location.href = "${root}/notice?act=list";
			});
</script>