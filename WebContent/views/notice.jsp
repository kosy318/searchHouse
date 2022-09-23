<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/header.jsp" %>
    <%@ include file="/common/nav.jsp" %>
<c:if test="${notices == null}">
	<script type="text/javascript">
		alert("정상적인 URL 접근이 아닙니다.");
		location.href = "${root}/notice?act=list&key=&word=";
	</script>
</c:if>
      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            공지사항
          </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <div class="row align-self-center mb-2">
            <div class="col-md-2 text-start">
              <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">
                글쓰기
              </button>
            </div>
          </div>
          <table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">조회수</th>
                <th scope="col">작성일</th>
              </tr>
            </thead>
            <tbody>
			<c:forEach var="notice" items="${notices}">
              <tr class="text-center">
                <th scope="row">${notice.num}</th>
                <td class="text-start">
                  <a
                    href="#"
                    class="notice-title link-dark"
                    data-no="${notice.num}"
                    style="text-decoration: none"
                  >
                    	${notice.title}
                  </a>
                </td>
                <td>${notice.count}</td>
                <td>${notice.regdate}</td>
              </tr>
			</c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <form id="form-no-param" method="get" action="${root}/notice">
      <input type="hidden" id="act" name="act" value="notice-view">
      <input type="hidden" id="key" name="key" value="${param.key}">
      <input type="hidden" id="word" name="word" value="${param.word}">
      <input type="hidden" id="num" name="num" value="">
    </form>
    <script>
      let titles = document.querySelectorAll(".notice-title");
      titles.forEach(function (title) {
        title.addEventListener("click", function () {
       	 	document.querySelector("#num").value = this.getAttribute("data-no");
       	 	document.querySelector("#form-no-param").submit();
        });
      });
      document.querySelector("#btn-mv-register").addEventListener("click", function () {
        location.href = "${root}/notice?act=mvwrite";
      });
    </script>
<%@ include file="/common/footer.jsp" %>