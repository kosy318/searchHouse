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
    </style>
  </head>

  <body>
    
    <%@ include file="/common/nav.jsp" %>
    <!-- 코드 내용 추가할곳-->
    <main
      class="form-signin m-auto mt-5 pt-5 bg-"
      style="width: 500px;!important"
    >
      <form id="form-mypage" method="POST" action="">
      	<input type="hidden" name="act" value="mypage">
        <h1
          class="text-center color-b h5 mb-3 dark"
          style="font-size: 2.0rem;!important"
          id="PageUsername"
        ></h1>

        <div class="form-floating mt-4">
          <input
            type="text"
            class="form-control"
            id="floatingID"
            value="${ auth.id }"
            name="id"
            readonly
          />
          <label for="floatingID">ID</label>
        </div>
        
        <div class="form-floating mt-4">
          <input
            type="text"
            class="form-control"
            id="floatingName"
            value="${ auth.name }"
            name="name"
          />
          <label for="floatingID">Name</label>
        </div>
        <div class="form-floating mt-4">
          <input
            type="password"
            class="form-control"
            id="floatingPassword"
            name="password"
            placeholder=""
          />
          <label for="floatingPassword">Password</label>
        </div>
        <div class="form-floating mt-4">
          <input
            type="text"
            class="form-control"
            id="floatingAddress"
            value="${ auth.address }"
            name="address"
            placeholder=""
          />
          <label for="floatingAddress">Address</label>
        </div>
        <div class="form-floating mt-4">
          <input
            type="tel"
            class="form-control"
            id="floatingPhone"
            name="phone"
            value="${ auth.phone }"
            placeholder=""
            pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
          />
          <label for="floatingPhone">Phone Nb(010-1234-5678)</label>
        </div>
        <div class="row mt-4">
          <div class="col justify-content-end">
            <button
              class="w-5 btn btn-lg btn-primary"
              id="btn-modify"
              type="button"
              onclick="modify()"
            >
              수정하기
            </button>
            <button
              class="w-5 btn btn-lg btn-primary"
              id="btn-delete"
              type="button"
            >
              회원탈퇴
            </button>
          </div>
        </div>
        <p class="mt-5 mb-3 text-muted"></p>
      </form>
    </main>

    <%@ include file="/common/footer.jsp" %>
    
    <script>
  	document.querySelector("#btn-modify").addEventListener("click", function(){
  		if(!document.querySelector("#floatingPassword").value){
  			alert("비밀번호 입력!");
  			return;
  		} else{
  			let form = document.querySelector("#form-mypage");
  			form.setAttribute("action", "${root}/user");
  			form.submit();
  		}
  	});

  	document.querySelector("#btn-delete").addEventListener("click", function(){
    	location.href = "${root}/user?act=checkPwd";
  	});
  </script>
  </body>
</html>
