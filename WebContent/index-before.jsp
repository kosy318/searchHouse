<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/common/header.jsp"%>
</head>

<body>


	<%@ include file="/common/nav.jsp"%>

	<!-- ======= Intro Section ======= -->
	<!-- slide start -->
	<div class="intro intro-carousel swiper position-relative">
		<div class="swiper-wrapper">
			<div class="swiper-slide carousel-item-a intro-item bg-image"
				style="background-image: url(assets/img/slide-1.jpeg)">
				<div class="overlay overlay-a"></div>
				<div class="intro-content display-table">
					<div class="table-cell">
						<div class="container">
							<div class="row">
								<div class="col-lg-8">
									<div class="intro-body">
										<h1 class="intro-title mb-4">
											<span class="color-b">시</span>그니엘 레지던스
										</h1>
										<p class="intro-title-top">
											서울특별시 송파구 <br /> 올림픽로 300
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="swiper-slide carousel-item-a intro-item bg-image"
				style="background-image: url(assets/img/slide-2.jpeg)">
				<div class="overlay overlay-a"></div>
				<div class="intro-content display-table">
					<div class="table-cell">
						<div class="container">
							<div class="row">
								<div class="col-lg-8">
									<div class="intro-body">
										<h1 class="intro-title mb-4">
											<span class="color-b">나</span>인원 한남
										</h1>
										<p class="intro-title-top">
											서울특별시 용산구 <br /> 한남대로 91
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="swiper-slide carousel-item-a intro-item bg-image"
				style="background-image: url(assets/img/slide-3.jpeg)">
				<div class="overlay overlay-a"></div>
				<div class="intro-content display-table">
					<div class="table-cell">
						<div class="container">
							<div class="row">
								<div class="col-lg-8">
									<div class="intro-body">
										<h1 class="intro-title mb-4">
											<span class="color-b">P</span>H 129
										</h1>
										<p class="intro-title-top">
											서울특별시 강남구<br /> 청담동 129
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="swiper-pagination"></div>
	</div>
	<!-- slide end -->
	<!-- End Intro Section -->

	<main id="main"> <!-- ======= Latest News Section ======= -->
	<section class="section-news section-t8">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="title-wrap d-flex justify-content-between">
						<div class="title-box">
							<h2 class="title-a">공지사항</h2>
						</div>
						<div class="title-link">
							<a href="notice.bod">All Posts <span
								class="bi bi-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
			</div>

			<div id="news-carousel" class="swiper">
				<div class="swiper-wrapper">
					<div class="carousel-item-c swiper-slide">
						<div class="card-box-b card-shadow news-box">
							<div class="img-box-b">
								<img src="assets/img/post-3.jpg" alt="" class="img-b img-fluid" />
							</div>
							<div class="card-overlay">
								<div class="card-header-b">
									<div class="card-category-b">
										<a href="#" class="category-b">House</a>
									</div>
									<div class="card-title-b">
										<h2 class="title-2">
											<a href="blog-single.html">지혜롭게
												내 집 마련하기<br /> 팁
											</a>
										</h2>
									</div>
									<div class="card-date">
										<span class="date-b">2022-09-07</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End carousel item -->

					<div class="carousel-item-c swiper-slide">
						<div class="card-box-b card-shadow news-box">
							<div class="img-box-b">
								<img src="assets/img/post-5.jpg" alt="" class="img-b img-fluid" />
							</div>
							<div class="card-overlay">
								<div class="card-header-b">
									<div class="card-category-b">
										<a href="#" class="category-b">Home</a>
									</div>
									<div class="card-title-b">
										<h2 class="title-2">
											<a href="blog-single2.html">벼락
												부자 되는 법 <br /> 팁
											</a>
										</h2>
									</div>
									<div class="card-date">
										<span class="date-b">2022-09-07</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End carousel item -->
					<div class="carousel-item-c swiper-slide">
						<div class="card-box-b card-shadow news-box">
							<div class="img-box-b">
								<img src="assets/img/post-7.jpg" alt="" class="img-b img-fluid" />
							</div>
							<div class="card-overlay">
								<div class="card-header-b">
									<div class="card-category-b">
										<a href="#" class="category-b">Home</a>
									</div>
									<div class="card-title-b">
										<h2 class="title-2">
											<a href="blog-single3.html">강남
												불패 <br /> 역사
											</a>
										</h2>
									</div>
									<div class="card-date">
										<span class="date-b">2022-09-07</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End carousel item -->
				</div>
			</div>

			<div class="news-carousel-pagination carousel-pagination"></div>
		</div>
	</section>
	<!-- End Latest News Section --> 
	</main>
	<!-- End #main -->

	<!-- footer -->

	<%@ include file="/common/footer.jsp" %>

</body>
</html>
