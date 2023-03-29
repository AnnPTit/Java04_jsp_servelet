<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Email</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<!-- Theme style -->
<link rel="stylesheet" href="../assets/css/admin.css">
</head>
<body>

	<div class="container">
		<div class="mx-auto pb-3 tm-about-text-container px-3">
			<div>
				<h1 style="margin: 50px">Share Video</h1>
			</div>
			<div class="row">
				<div class="col-lg-6 mb-5">


					<form id="contact-form"
						action="${pageContext.request.contextPath}/share?id=${video.id}" method="post"
						class="tm-contact-form">
						<div class="form-group">
							<input type="text" name="email" class="form-control rounded-0"
								placeholder="Email" required="" />
						</div>
						<div class="form-group">
							<input type="text" name="href" class="form-control rounded-0"
								placeholder="Video" required="" value="${video.href }"/>
						</div>

						<!-- <div class="form-group">
						<select class="form-control" id="contact-select" name="inquiry">
							<option value="-">Subject</option>
							<option value="sales">Sales &amp; Marketing</option>
							<option value="creative">Creative Design</option>
							<option value="uiux">UI / UX</option>
						</select>
					</div> -->


						<div class="form-group mb-0">

							<button type="submit"
								class="btn btn-primary rounded-0 d-block ml-auto mr-0 tm-btn-animate tm-btn-submit tm-icon-submit">
								<span>Send</span>
							</button>

						</div>
					</form>
				</div>
				<div class="col-lg-6">
					<div class="mapouter mb-60">
						<div class="gmap_canvas">
							<!-- <iframe width="100%" height="520" id="gmap_canvas"
							src="https://maps.google.com/maps?q=Av.+L%C3%BAcio+Costa,+Rio+de+Janeiro+-+RJ,+Brazil&t=&z=13&ie=UTF8&iwloc=&output=embed"
							frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe> -->
							<img alt="" src="${video.poster }"
								style="width: 250px; height: 250px">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
