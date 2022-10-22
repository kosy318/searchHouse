<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/header.jsp"%>
</head>
<style>
button{
	margin-top: 1em;
	width: 200px;
}
</style>
<body>

	<%@ include file="/common/nav2.jsp"%>
	<!-- ======= Property Search Section ======= -->
	<!-- Form Search Star -->
		<div style="text-align: center;">
			<h2>아파트 매매 정보 검색</h2>
		</div>
	<div id="modal" style="display:flex; justify-content: center;">
		<!-- <span class="close-container right-boxed bi bi-x"></span> -->
		<div style="width: 500px;">
			<form method="GET" action="${root}/apt?act=searchProcess">
				<div>
					<div>
						<div>
							<label for="Type">도시</label> <select id="sido" name="sido">
								<option value="">시도 선택</option>
								<c:forEach items="${sidoList }" var="sidoinfo">
									<option value="${sidoinfo.sidoName }">${sidoinfo.sidoName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div>
						<div>
							<label for="city">구군</label> <select id="gugun" name="gugun">
								<option value="">구군선택</option>
							</select>
						</div>
					</div>
					<div>
						<div>
							<label for="bedrooms">동</label> <select id="dong" name="dong">
								<option value="">동선택</option>
							</select>
						</div>
					</div>
					<div>
						<div>
							<label for="bathrooms">연도</label> <select id="year" name="year"></select>
						</div>
					</div>
					<div>
						<div>
							<label for="price">월</label> <select id="month" name="month">
								<option value="">매매월선택</option>
							</select>
						</div>
					</div>
					<div>
						<button type="submit" id="apt-btn">가져오기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/common/footer.jsp"%>
	<script>
		window.onload = function(){
			let year = document.querySelector("#year");
			let yearOpt = "<option value=''>"
		}
	</script>
</body>
</html>