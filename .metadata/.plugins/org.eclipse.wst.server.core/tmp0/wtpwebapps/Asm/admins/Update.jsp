<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="mx-auto pb-3 tm-about-text-container px-3">
	<div>
		<h1 style="margin: 50px">Update Video</h1>
	</div>
	<div class="row">
		<div class="col-lg-6 mb-5">


			<form id="contact-form"
				action="${pageContext.request.contextPath}/admins/Admin/update"
				method="post" class="tm-contact-form">
				<div class="form-group">
					<input type="text" name="title" class="form-control rounded-0"
						placeholder="Title" required="" value="${video.title}" />
				</div>
				<div class="form-group">
					<input type="text" name="poster" class="form-control rounded-0"
						placeholder="Poster" required="" value="${video.poster}" />
				</div>
				<div class="form-group">
					<input type="text" name="href" class="form-control rounded-0"
						placeholder="href" required="" value="${video.href}" />
				</div>
				<!-- <div class="form-group">
						<select class="form-control" id="contact-select" name="inquiry">
							<option value="-">Subject</option>
							<option value="sales">Sales &amp; Marketing</option>
							<option value="creative">Creative Design</option>
							<option value="uiux">UI / UX</option>
						</select>
					</div> -->
				<div class="form-group">
					<input name="description" class="form-control rounded-0"
						placeholder="Description" value="${video.description}"></input>
				</div>

				<div class="form-group mb-0">

					<button type="submit"
						class="btn btn-primary rounded-0 d-block ml-auto mr-0 tm-btn-animate tm-btn-submit tm-icon-submit">
						<span>Submit</span>
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
