<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Strongly Typed by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<%@ include file="/common/header.jsp"%>
<body class="homepage is-preload">
	<%@ include file="/common/nav.jsp"%>
	<div id="page-wrapper">

		<!-- Features -->
		<section id="features">
			<div class="container">
				<header>
					<h2>
						<strong>아파트 매매</strong>
					</h2>
					<p>random 3</p>
				</header>
				<div class="row aln-center">
					<c:if test="${ !empty top3 }">
						<c:forEach begin="1" end="3" var="i">
							<div class="col-4 col-6-medium col-12-small">
								<!-- Feature -->
								<section>
									<header>
										<a href="#">
											<h3>
												<img src="images/${ i }.png" alt="" style="width: 20px" />&nbsp;&nbsp;${ top3[i-1].dong }&nbsp;&nbsp;
												${ top3[i-1].apartmentName }
											</h3>
										</a>
									</header>
									<p>${ top3[i-1].dealAmount } 천 원</p>
								</section>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${ empty top3 }">
						<c:redirect url="/main.home" />
					</c:if>

					<div class="col-12">
						<ul class="actions">
							<li><a href="#" class="button icon solid fa-file">아파트 매매
									검색</a></li>
						</ul>
					</div>
				</div>
			</div>
		</section>

		<!-- Banner -->
		<section id="banner">
			<div class="container">
				<p>공지사항</p>
			</div>
		</section>

		<!-- Main -->
		<section id="main">
			<div class="container">
				<div>
					<div class="col-4 col-12-medium">

						<!-- Excerpts -->
						<section>
							<ul class="divided">
								<li>
									<!-- Excerpt -->
									<article class="box excerpt">
										<header>
											<span class="date">July 30</span>
											<h3>
												<a href="#">Just another post</a>
											</h3>
										</header>
										<p>Lorem ipsum dolor odio facilisis convallis. Etiam non
											nunc vel est suscipit convallis non id orci lorem ipsum sed
											magna consequat feugiat lorem dolore.</p>
									</article>

								</li>
								<li>
									<!-- Excerpt -->
									<article class="box excerpt">
										<header>
											<span class="date">July 28</span>
											<h3>
												<a href="#">And another post</a>
											</h3>
										</header>
										<p>Lorem ipsum dolor odio facilisis convallis. Etiam non
											nunc vel est suscipit convallis non id orci lorem ipsum sed
											magna consequat feugiat lorem dolore.</p>
									</article>

								</li>
								<li>
									<!-- Excerpt -->
									<article class="box excerpt">
										<header>
											<span class="date">July 24</span>
											<h3>
												<a href="#">One more post</a>
											</h3>
										</header>
										<p>Lorem ipsum dolor odio facilisis convallis. Etiam non
											nunc vel est suscipit convallis non id orci lorem ipsum sed
											magna consequat feugiat lorem dolore.</p>
									</article>

								</li>
							</ul>
						</section>

					</div>

				</div>
			</div>
		</section>

		<%@ include file="/common/footer.jsp"%>


	</div>
</body>
</html>