<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
.hide {
	display: none;
}

.show {
	display: inline-block !important;
}
</style>
</head>
<body>
	<div class="container" style="margin-top: 100px">
		<div class="row">
			<div class="col-lg-8">
				<iframe width="100%" height="500px"
					src="https://www.youtube.com/embed/${videoDetail.href}"> </iframe>
			</div>
			<div class="col-lg-4">
				<h3>${videoDetail.title}</h3>
				<p>${videoDetail.description}</p>
				<p>${videoDetail.views}Views</p>
				<p>${videoDetail.shares}Shares</p>

				<a
					href="${pageContext.request.contextPath}/like?index=${videoDetail.id}&action=like"
					class="btn btn-secondary ${isLike}" style="width: 100px;"> Like
					<i class="fa-regular fa-thumbs-up"></i>
				</a> <a
					href="${pageContext.request.contextPath}/unlike?index=${videoDetail.id}&action=unlike"
					class="btn btn-secondary hide ${isUnlike}" style="width: 100px;">
					Unlike <i class="fa-regular fa-thumbs-up"></i>
				</a> <a
					href="${pageContext.request.contextPath}/share?index=${videoDetail.id}&action=share"
					class="btn btn-secondary " style="width: 100px"> Share <i
					class="fa-regular fa-share-from-square"></i>
				</a>
			</div>
		</div>

	</div>




	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
		
	</script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
