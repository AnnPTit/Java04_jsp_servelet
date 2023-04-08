<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home -Admin</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">DataTable with default features</h3>
		</div>

		<!-- /.card-header -->
		<div class="card-body">
			<table id="example1" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Title</th>
						<th>Link</th>
						<th>Total Like <a class="" style="width: 20px; height: 20px"
							href="${pageContext.request.contextPath}/admins/Admin?page=home&action=sortUpLike"><img
								alt="" style="width: 20px; height: 20px"
								src="https://cdn-icons-png.flaticon.com/512/5422/5422517.png"></a>
							<a class="" style="width: 20px; height: 20px"
							href="${pageContext.request.contextPath}/admins/Admin?page=home&action=sortDownLike"><img
								alt="" style="width: 20px; height: 20px"
								src="https://cdn-icons-png.flaticon.com/512/5422/5422495.png"></a>
						<th>Total View <a class="" style="width: 20px; height: 20px"
							href="${pageContext.request.contextPath}/admins/Admin?page=home&action=sortUpView"><img
								alt="" style="width: 20px; height: 20px"
								src="https://cdn-icons-png.flaticon.com/512/5422/5422517.png"></a>
							<a class="" style="width: 20px; height: 20px"
							href="${pageContext.request.contextPath}/admins/Admin?page=home&action=sortDownView"><img
								alt="" style="width: 20px; height: 20px"
								src="https://cdn-icons-png.flaticon.com/512/5422/5422495.png"></a>
						</th>
						<th>Total Share</th>
					</tr>
				</thead>
				<c:forEach items="${listVideo}" var="x" varStatus="i">
					<tbody>
						<tr>
							<td>${x.title }</td>
							<td>${x.href }</td>
							<td>${x.like }</td>
							<td>${x.view}</td>
							<td>${x.share}</td>
							<td><a
								href="${pageContext.request.contextPath}/admins/Admin?page=home&action=showUserLike&index=${x.id}">Show
									User Like</a> <a
								href="${pageContext.request.contextPath}/admins/Admin?page=home&action=showUserShare&index=${x.id}">Show
									User Share</a></td>
						</tr>
					</tbody>
				</c:forEach>

				<tfoot>
					<tr>
						<th>Rendering engine</th>
						<th>Browser</th>
						<th>Platform(s)</th>
						<th>Engine version</th>
						<th>CSS grade</th>
					</tr>
				</tfoot>
			</table>
		</div>
		<!-- /.card-body -->
	</div>

	<%-- 	<div>
		<select class="form-select" aria-label="Default select example">
			<c:forEach items="${listVideo}" var="x">
				<option value=""> <a href="${pageContext.request.contextPath}/admins/Admin?page=home&action=getUserLike" type="submit"></a></option>
			</c:forEach>
		</select>
	</div> --%>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">First</th>
				<th scope="col">Last</th>
				<th scope="col">Handle</th>
			</tr>
		</thead>
		<c:forEach items="${ListUserLike }" var="x">
			<tbody>
				<tr>
					<td>${x.username }</td>
					<td>${x.email}</td>
				</tr>

			</tbody>
		</c:forEach>
	</table>
</body>
</html>