<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="/common/header.jsp" %>
  <style>
    .btn-primary {
      --bs-btn-bg: #2eca6a;
      --bs-btn-border-color: #2eca6a; 
    }
    .alert-danger {
      --bs-alert-bg: white;
      --bs-alert-border-color: white;
    }
  </style>
  </head>

  <body>
    <%@ include file="/common/nav.jsp" %>
      <!-- 코드 내용 추가할곳-->
      <main class="form-signin m-auto mt-5 pt-5 bg-" style="width: 500px;!important">
        <form id="form-signup" method="POST" action="">
        	<input type="hidden" name="act" value="signup">
          <h1 class="color-b h5 mb-3 dark" style="font-size: 2.0rem;!important">Sign Up</h1>
      
          <div class="form-floating mt-4">
            <input type="text" class="form-control" id="floatingID" name="id" placeholder="user-id">
            <label for="floatingID">ID</label>
          </div>
          <div id="idcheck-result"></div>
          <div class="form-floating mt-4">
            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
            <label for="floatingPassword">Password</label>
          </div>
          <div class="form-floating mt-4">
            <input type="text" class="form-control" id="floatingUsername" name="name" placeholder="username">
            <label for="floatingUsername">Username</label>
          </div>
          <div class="form-floating mt-4">
            <input type="text" class="form-control" id="floatingAddress" name="address" placeholder="Address">
            <label for="floatingAddress">Address</label>
          </div>
          <div class="form-floating mt-4">
            <input type="tel" class="form-control" id="floatingPhone" name="phone" placeholder="010-1234-5678" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}">
            <label for="floatingPhone">Phone Nb(010-1234-5678)</label>
          </div>
          <div class="row mt-4">
            <div class="col justify-content-center">
              <button class="w-5 btn btn-lg btn-primary" id="btn-signup" type="button" onclick="signup()">회원가입</button>
            </div>
          </div>
          <p class="mt-5 mb-3 text-muted">
            <div class="alert alert-danger bg-white" id="alert-div" role="alert" style="display: none;">
            </div>
          </p>
        </form>
      </main>
    
    <%@ include file="/common/footer.jsp" %>
    <script>
    let isUseId = false;
    document.querySelector("#floatingID").addEventListener("keyup", function () {
  	 let userid = this.value;
  	 let resultDiv = document.querySelector("#idcheck-result");
  	 if(userid.length < 3 || userid.length > 16) {
  		 resultDiv.setAttribute("class", "mb-3 text-dark");
  		 resultDiv.textContent = "아이디는 4자 이상 16자 이하 입니다.";
  		 isUseId = false;
  	 } else {
			fetch("${root}/user?act=idcheck&id=" + userid)
				.then(response => response.text())
				.then(data => {
					console.log(data);
	    			 if(data == 0) {
	    			   resultDiv.setAttribute("class", "mb-3 text-primary");
	    		       resultDiv.textContent = userid + "는 사용할 수 있습니다.";
	    		       isUseId = true;
	    			 } else {
	    			   resultDiv.setAttribute("class", "mb-3 text-danger");
	      		       resultDiv.textContent = userid + "는 사용할 수 없습니다.";
	      		       isUseId = false;
	    			 }
				});
  	 }
    });
    
  	document.querySelector("#btn-signup").addEventListener("click", function(){
  		if(!document.querySelector("#floatingID").value){
  			alert("아이디 입력!");
  			return;
  		} else if(!document.querySelector("#floatingPassword").value){
  			alert("비밀번호 입력!");
  			return;
  		} else if(!document.querySelector("#floatingUsername").value){
  			alert("이름 입력!");
  			return;
  		} else{
  			let form = document.querySelector("#form-signup");
  			form.setAttribute("action", "${root}/user");
  			form.submit();
  		}
  	});
  </script>
  </body>
</html>
