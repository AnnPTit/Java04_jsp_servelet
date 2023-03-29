<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Favorite</title>
<link rel="icon"
	href="https://i.seadn.io/gae/Bb1LirSLuImz350HEF-4dEf6w1XJnTnv_FGtqZE4pAWmxXYMlvgLfU3cmwOSDsMelDOOOGC9EF54QZgqmWdCCIYS1ypx3oNkf0ChSw?auto=format&w=1000"
	type="image/icon type">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>
	<header>
		<jsp:include page="../Layout/header.jsp"></jsp:include>
	</header>

	<div class="container">
		<h1 style="margin: 50px 0; border-bottom: 5px solid #000;">My
			Favorites</h1>
		<div class="row tm-catalog-item-list">
			<c:forEach items="${listFavorite}" var="x" varStatus="viTri">
				<div class="col-lg-4 col-md-6 col-sm-12 tm-catalog-item">
					<div class="position-relative tm-thumbnail-container">
						<%-- <iframe width="100%" height="315"
						src="https://www.youtube.com/embed/${x.href }"> </iframe> --%>
						<img alt="" style="width: 100%; height: 400px"
							src="${x.video.poster }"> <a
							href="${pageContext.request.contextPath}/video/detail?index=${x.video.id}"
							class="position-absolute tm-img-overlay"> <i
							class="fas fa-play tm-overlay-icon"></i>
						</a>
					</div>
					<div class="p-4 tm-bg-gray tm-catalog-item-description">
						<a style="text-decoration: none;"
							href="${pageContext.request.contextPath}/video/detail?index=${x.video.id}">
							<h3 class="tm-text-primary mb-3 tm-catalog-item-title">${x.video.title}</h3>
						</a>
						<p class="tm-catalog-item-text">${x.video.description }</p>
						View : <span>${x.video.views}</span> <br>Shares : <span>${x.video.shares}</span>
					</div>
				</div>
			</c:forEach>


		</div>

		<!-- Catalog Paging Buttons -->
	
	</div>
	<div class="container">
		<footer>
			<jsp:include page="../Layout/footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>