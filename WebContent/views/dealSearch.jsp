<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/header.jsp"%>
</head>
<style>
button {
	margin-top: 1em;
	width: 200px;
}
</style>
<body>
	<%@ include file="/common/nav2.jsp"%>
	<div style="text-align: center;">
		<h2>아파트 매매 정보 검색</h2>
	</div>
	<div id="modal" style="display: flex; justify-content: center;">
		<div style="width: 500px;">
			<form method="GET" action="">
				<div>
					<div>
						<div>
							<label>도시</label> <select id="sido" name="sido">
								<option>시도 선택</option>
								<c:forEach items="${ sidoList }" var="sido" >
									<option value="${ sido }">${ sido }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div>
						<div>
							<label>구군</label> <select id="gugun" name="gugun">
								<option>구군선택</option>
							</select>
						</div>
					</div>
					<div>
						<div>
							<label>동</label> <select id="dong" name="dong">
								<option>동선택</option>
							</select>
						</div>
					</div>
					<div>
						<div>
							<label>연도</label> <select id="year" name="year"></select>
						</div>
					</div>
					<div>
						<div>
							<label>월</label> <select id="month" name="month">
								<option>매매월선택</option>
							</select>
						</div>
					</div>
					<div>
						<button type="submit" id="search">가져오기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="/common/footer.jsp"%>
	<script>
		let now = new Date();
		let nowYear = now.getFullYear();
		let nowMonth = now.getMonth() + 1;
		let sido = document.querySelector("#sido");
		let gugun = document.querySelector("#gugun");
		let dong = document.querySelector("#dong");
		let year = document.querySelector("#year");
		let month = document.querySelector("#month");

		window.onload = function() {
			let yearOpt = "<option>매매년도선택</option>";
			for (let i = nowYear; i > nowYear - 20; i--) {
				yearOpt += "<option value="+i+">" + i + "년</option>";
			}
			year.innerHTML = yearOpt;
		}

		year.addEventListener("change", function() {
			let inputMonth = (year.value == nowYear)? nowMonth : 12;
			let monthOpt = "<option>매매월선택</option>";
			for(let i = 1; i<=inputMonth; i++){
				monthOpt += "<option value="+i+">"+i+"월</option>";
			}
			month.innerHTML = monthOpt;
		})
		
		sido.addEventListener("change", function(){
			gugun.innerHTML = "<option>구군선택</option>";
			getData(gugun, sido.value, null);
		})
		gugun.addEventListener("change", function(){
			dong.innerHTML = "<option>동선택</option>";
			getData(dong, sido.value, gugun.value);
		})
		
		function getData(id, sidoName, gugunName){
			let contextPath = getContextPath();
			let url = contextPath + "\/getNames.home?sido=" + sidoName + "&gugun=";
			if(gugunName != null) url += gugunName;
			fetch(url)
				.then((response) => response.json())
				.then((data) => addOpt(id, data));
		}
		
		function addOpt(id, data){
			let opt="";
			data.forEach(function (d){
				opt += "<option value="+d.code+">"+d.name+"</option>";
			})
			id.innerHTML += opt;
		}
		
		function getContextPath(){
			let hostIndex = location.href.indexOf(location.host) + location.host.length;
			let contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex+1));
			return location.origin + contextPath;
		}
	</script>
</body>
</html>