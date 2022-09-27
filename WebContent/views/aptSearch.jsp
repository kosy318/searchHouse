<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/header.jsp"%>
</head>
<body>

	<%@ include file="/common/nav.jsp"%>
	<!-- ======= Property Search Section ======= -->
	<div class="click-closed"></div>
	<!-- Form Search Star -->
	<div class="container mt-5 pt-5" id="modal">
		<div class="title-box-d">
			<h3 class="title-d">아파트 매매 정보 검색</h3>
		</div>
		<!-- <span class="close-container right-boxed bi bi-x"></span> -->
		<div class="container-wrap form">
			<form class="form-a" method="GET" action="${root}/apt?act=searchProcess">
				<div class="row">
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="Type">도시</label> <select
								class="form-control form-select form-control-a" id="sido" name="sido">
								<option value="">시도 선택</option>
								<c:forEach items="${sidoList }" var="sidoinfo">
									 <option value="${sidoinfo.sidoName }">${sidoinfo.sidoName }</option> 
								</c:forEach>
								<%-- <c:choose>
										<c:when test="${cookie.sidoName } eq ${sido.sidoName }">
											<option value="${sido.sidoName }" selected>${sido.sidoName }</option>
										</c:when>
										<c:otherwise>
											<option value="${sido.sidoName }">${sido.sidoName }</option>
										</c:otherwise>
									</c:choose> --%>
							</select>
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="city">구군</label> <select
								class="form-control form-select form-control-a" id="gugun" name="gugun">
								<option value="">구군선택</option>
							</select>
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="bedrooms">동</label> <select
								class="form-control form-select form-control-a" id="dong" name="dong">
								<option value="">동선택</option>
							</select>
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="bathrooms">연도</label> <select
								class="form-control form-select form-control-a" id="year" name="year"></select>
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="price">월</label> <select
								class="form-control form-select form-control-a" id="month" name="month">
								<option value="">매매월선택</option>
							</select>
						</div>
					</div>
					<div class="col-md-12 mt-5">
						<button type="submit" class="btn btn-b" id="apt-btn">가져오기</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
/*
		document.querySelector("#apt-btn").addEventListener("click", function () {
	   let sidoSel = document.querySelector("#sido");
	   let sido = sidoSel[sidoSel.selectedIndex].innerText;
	   let gugunSel = document.querySelector("#gugun");
	   let gugun = gugunSel[gugunSel.selectedIndex].innerText;
	   let dongSel = document.querySelector("#dong");
	   let dong = dongSel[dongSel.selectedIndex].innerText;
	   let regCode = gugunSel[gugunSel.selectedIndex].value.substr(0, 5);
	   let yearSel = document.querySelector("#year");
	   let year = yearSel[yearSel.selectedIndex].value;
	   let monthSel = document.querySelector("#month");
	   let month = monthSel[monthSel.selectedIndex].value;
	   let dealYM = year + month;

	   var data = {
	     sido: sido,
	     gugunSel: gugunSel,
	     gugun: gugun,
	     dong: dong,
	     regCode: regCode,
	     yearSel: yearSel,
	     year: year,
	     monthSel: monthSel,
	     month: month,
	     dealYM: dealYM,
	   };
 	   localStorage.setItem("data", JSON.stringify(data));
	   window.location = "aptlist.html"; 
	   
	   
	 }); 

	 let date = new Date();
*/
	  window.onload = function () {
	   let yearEl = document.querySelector("#year");
	   let yearOpt = `<option value="">매매년도선택</option>`;
	   let year = date.getFullYear();
	   for (let i = year; i > year - 20; i--) {
	     yearOpt += `<option value="${i}">${i}년</option>`;
	   }
	   yearEl.innerHTML = yearOpt;
	   
	 };

		/*   
	 document.querySelector("#year").addEventListener("change", function () {
	   let month = date.getMonth() + 1;
	   let monthEl = document.querySelector("#month");
	   let monthOpt = `<option value="">매매월선택</option>`;
	   let yearSel = document.querySelector("#year");
	   let m = yearSel[yearSel.selectedIndex].value == date.getFullYear() ? month : 13; // date.getFullYear() 현재년도
	   for (let i = 1; i < m; i++) {
	     monthOpt += `<option value="${i < 10 ? "0" + i : i}">${i}월</option>`;
	   }
	   monthEl.innerHTML = monthOpt;
	 });

	 // https://juso.dev/docs/reg-code-api/
	 // let url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
	 // let regcode = "*00000000";
	 // 전국 특별/광역시, 도
	 // https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000

	 // 시도가 바뀌면 구군정보 얻기.
	 document.querySelector("#sido").addEventListener("change", function () {
		 console.log(this[this.selectedIndex].value);
	   if (this[this.selectedIndex].value) {
	     let locname = this[this.selectedIndex].value;
	    console.log("sidoName change" + locname);
	     getGugun("gugun", locname);
	   } else {
	     initOption("gugun");
	     initOption("dong");
	   }
	 });

	 function getGugun(selid, locname) {
		   const url = "https://localhost:8080/WhereIsMyHome/apt";
		   let params = "act=mvsearch&sidoName="+locname;
		   fetch(`${url}?${params}`)
		     .then((response) => response.json())
		     .then((data) => addOption(selid, data));
	};
	 */
	 // 구군이 바뀌면 동정보 얻기.
	 document.querySelector("#gugun").addEventListener("change", function () {
	   if (this[this.selectedIndex].value) {
	     let locname = this[this.selectedIndex].value;
	     getDong("dong", locname);
	   } else {
	     initOption("dong");
	   }
	 });
	 /*
	 function getDong(selid, locname) {
		   const url = "https://localhost:8080/WhereIsMyHome/apt";
		   let params = "act=mvsearch&sidoName=";
		   fetch(`${url}?${params}`)
		     .then((response) => response.json())
		     .then((data) => addOption(selid, data));
	};

 	 function sendRequest(selid, locname) {
	   const url = "https://localhost:8080/WhereIsMyHome/apt";
	   let params = "act=mvsearch&sidoName="
	   fetch(`${url}?${params}`)
	     .then((response) => response.json())
	     .then((data) => addOption(selid, data));
	 } 

	 function addOption(selid, data) {
		 console.log(data);
	   let opt = ``;
	   initOption(selid);
	   switch (selid) {
	     case "sido":
	       opt += `<option value="">시도선택</option>`;
	       data.regcodes.forEach(function (regcode) {
	         opt += `
	   <option value="${sidoList.sidoName}">${sidoList.sidoName}</option>
	   `;
	       });
	       break;
	     case "gugun":
	       opt += `<option value="">구군선택</option>`;
	       for (let i = 0; i < data.regcodes.length; i++) {
	         if (i != data.regcodes.length - 1) {
	           if (
	             data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
	             data.regcodes[i].name.split(" ").length !=
	               data.regcodes[i + 1].name.split(" ").length
	           ) {
	             data.regcodes.splice(i, 1);
	             i--;
	           }
	         }
	       }
	       let name = "";
	       data.regcodes.forEach(function (regcode) {
	         if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
	         else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
	         opt += `
	   <option value="${regcode.code}">${name}</option>
	   `;
	       });
	       break;
	     case "dong":
	       opt += `<option value="">동선택</option>`;
	       let idx = 2;
	       data.regcodes.forEach(function (regcode) {
	         if (regcode.name.split(" ").length != 3) idx = 3;
	         opt += `
	   <option value="${regcode.code}">${regcode.name.split(" ")[idx]}</option>
	   `;
	       });
	   }
	   document.querySelector(`#${selid}`).innerHTML = opt; 
	 }

	 function initOption(selid) {
	   let options = document.querySelector(`#${selid}`);
	   options.length = 0;
	   // let len = options.length;
	   // for (let i = len - 1; i >= 0; i--) {
	   //   options.remove(i);
	   // }
	 }
	 
	 */
</script>
	<!-- End Property Search Section -->
	

</body>
</html>