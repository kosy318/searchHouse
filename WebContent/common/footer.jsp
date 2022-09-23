<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!-- ======= Footer ======= -->
<section class="section-footer bg-white">
	<div class="container">
		<div class="row"></div>
	</div>
</section>
<footer class="bg-white">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="socials-a">
					<ul class="list-inline">
						<li class="list-inline-item"><a href="#"> <i
								class="bi bi-facebook" aria-hidden="true"></i>
						</a></li>
						<li class="list-inline-item"><a href="#"> <i
								class="bi bi-twitter" aria-hidden="true"></i>
						</a></li>
						<li class="list-inline-item"><a href="#"> <i
								class="bi bi-instagram" aria-hidden="true"></i>
						</a></li>
						<li class="list-inline-item"><a href="#"> <i
								class="bi bi-linkedin" aria-hidden="true"></i>
						</a></li>
					</ul>
				</div>
				<div class="copyright-footer">
					<p class="copyright color-text-a">
						&copy; Copyright <span class="color-a">by SSAFY</span>. All rights
						reserved.
					</p>
				</div>
			</div>
		</div>
	</div>
</footer>
<!-- End  Footer -->

<div id="preloader"></div>
<a href="#"
	class="back-to-top d-flex align-items-center justify-content-center"><i
	class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="${root}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${root}/assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="${root}/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${root}/assets/js/main.js"></script>