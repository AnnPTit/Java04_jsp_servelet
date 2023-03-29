<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<a
					href="${pageContext.request.contextPath}/admins/Admin?page=AddNewVideo"
					class="btn btn-primary">Add New</a>
			</div>
			<br> <br>
			<!-- /.col-md-6 -->
			<c:forEach items="${listVideo}" var="x" varStatus="viTri">
				<div class="col-lg-12">
					<div class="card card-primary card-outline">
						<div class="card-header">
							<h5 class="m-0">${x.title }</h5>
						</div>
						<div class="card-body">
							<h6 class="card-title">${x.description}</h6>

							<p class="card-text">
								<span>${x.views} Views</span> <span>${x.shares} Shares</span>
							</p>
							<div style="width: 150px; height: 150px; float: right;">
								<%-- <iframe width="100%" height="100%"
									src="https://www.youtube.com/embed/${x.href }"> </iframe> --%>
								<img alt="" style="width: 100%; height: 100%" src="${x.poster }">
							</div>
							<a
								href="${pageContext.request.contextPath}/admins/Admin?page=Update&id=${x.id}"
								class="btn btn-primary">Update</a> <a
								href="${pageContext.request.contextPath}/admins/Admin?page=Delete&id=${x.id}"
								class="btn btn-primary">Delete</a>
						</div>
					</div>
				</div>
			</c:forEach>

			<!-- /.col-md-6 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>