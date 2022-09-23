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

    <main id="main">
      <!-- 코드 내용 추가할곳-->
      <div class="container mt-5">
          <!-- Email address input-->
          <form class="row" id="form-search-info" method="POST" action="">
          	<input type="hidden" name="act" value="search-userinfo">
            <div class="col-sm-10">
              <input
                class="form-control form-control-lg"
                id="searchInfo"
                name="search-info"
                type="text"
                placeholder="Search Username or ID"
              />
            </div>
            <div class="col-sm-2">
              <button
                class="btn btn-lg btn-primary"
                id="btn-search"
                type="button"
                onclick="search()"
              >
                Search
              </button>
            </div>
          <div class="d-none" id="submitSuccessMessage">
            <div class="text-center mb-3">
              <div class="fw-bolder">Form submission successful!</div>
              <p>To activate this form, sign up at</p>
              <a
                class="text-white"
                href="https://startbootstrap.com/solution/contact-forms"
                >https://startbootstrap.com/solution/contact-forms</a
              >
            </div>
          </div>
          <div class="d-none" id="submitErrorMessage">
            <div class="text-center text-danger mb-3">
              Error sending message!
            </div>
          </div>
        </form>

        <table
          class="table table-hover text-center"
          id="userTable"
        >
          <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Address</th>
            <th>Phone</th>
          </tr>
          <tbody>
 			<c:forEach var="u" items="${ userlist }">
				<tr>
				<td>${ u.id }</td>
				<td>${ u.name }</td>
				<td>${ u.address }</td>
				<td>${ u.phone }</td>
				</tr>
			</c:forEach>         
           </tbody>
        </table>
      </div>
    </main>
    
    <%@ include file="/common/footer.jsp" %>
    
    <script>
  	document.querySelector("#btn-search").addEventListener("click", function(){
  		if(!document.querySelector("#searchInfo").value){
  			alert("이름 또는 아이디를 입력해주세요");
  			return;
  		} else{
  			let form = document.querySelector("#form-search-info");
  			form.setAttribute("action", "${root}/user");
  			form.submit();
  		}
  	});
  </script>
  </body>
</html>
