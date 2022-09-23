<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/common/header.jsp"%>

</head>

<body>
	<%@ include file="/common/nav.jsp"%>

	<!-- 코드 내용 추가할곳-->
	<main id="main">
	<div style="height: 140px"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="title-box-d">
					<h3 class="title-d"></h3>
				</div>
			</div>
			<div class="col-md-2">
				<button type="button" id="btn-map"
					class="btn btn-b-n navbar-toggle-box navbar-toggle-box-collapse float-end"
					data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01">
					<i class="bi bi-map"></i> <span style="margin-left: 10px">지도</span>
				</button>
				<button type="button" id="btn-list" style="display: none"
					class="btn btn-b-n navbar-toggle-box navbar-toggle-box-collapse float-end"
					data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01">
					<i class="bi bi-table"></i> <span style="margin-left: 10px">테이블</span>
				</button>
			</div>
		</div>
		<table class="table table-hover text-center" id="table">
			<tr>
				<th>아파트이름</th>
				<th>층</th>
				<th>면적</th>
				<th>법정동</th>
				<th>거래금액</th>
			</tr>
			<tbody id="aptlist">
				<c:forEach items="${ apts }" var="apt"> 
					<tr>
						<td>${apt.aptName }</td>
						<td>${apt.floor }</td>
						<td>${apt.area}</td>
						<td>${apt.dongName }</td>
						<td>${apt.dealAmount }</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</main>
	<%@ include file="/common/footer.jsp"%>

</body>
</html>
