<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="header">
	<div class="container">

		<!-- Logo -->
		<h1 id="logo">
			<a href="index.jsp">구해줘 홈즈🏚</a>
		</h1>
		<p>손쉽게 매매 가능한 아파트 검색을 체험하세요</p>

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<c:if test="${id ne null}"> <!-- 로그인이 되어있으면 -->
					<li style="display: inline-block"><a class="icon solid fa-cog" href="${ root }/logout.home" id="btn-logout"><span>로그아웃</span></a></li>
				</c:if>
				<c:if test="${id eq null }"> <!-- 로그인 안돼있으면 -->
					<li style="display: inline-block"><a class="icon solid fa-cog" href="${ root }/login.home" id="btn-mvlogin"><span>로그인</span></a></li>
				</c:if>
				<li><a class="icon fa-chart-bar" href="no-sidebar.html"><span>마이페이지</span></a></li>
				<li><a class="icon solid fa-sitemap" href="no-sidebar.html"><span>회원조회</span></a></li>
				<li><a class="icon solid fa-home" href="${ root }/dealSearch.home"><span>아파트 매매 검색</span></a></li>
			</ul>
		</nav>

	</div>
</section>