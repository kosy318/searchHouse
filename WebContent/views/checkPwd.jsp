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
      <main class="form-signin m-auto mt-5 pt-5 " style="width: 500px;!important">
        <form id="form-check" method="POST" action="">
        	<input type="hidden" name="act" value="delete">
          <h1 class="color-b h5 mb-3 dark" style="font-size: 2.0rem;!important">비밀번호 확인</h1>
      
          <div class="form-floating mt-4">
            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
            <label for="floatingPassword">Password</label>
          </div>
          <div class="row mt-4">
            <div class="col">
              <button class="w-100 btn btn-lg btn-primary" id="btn-check" type="button" onclick="login()">확인</button>
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
  	document.querySelector("#btn-check").addEventListener("click", function(){
  		if(!document.querySelector("#floatingPassword").value){
  			alert("비밀번호 입력!");
  			return;
  		} else{
  			let form = document.querySelector("#form-check");
  			form.setAttribute("action", "${root}/user");
  			form.submit();
  		}
  	});
  </script>
  </body>
</html>