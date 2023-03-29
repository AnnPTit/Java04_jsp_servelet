<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager User -Admin</title>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">DataTable with default features</h3>
			<h3>${Mess }</h3>
		</div>
		<!-- /.card-header -->
		<div class="card-body">
			<table id="example1" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Username</th>
						<th>role</th>
						<th>Email</th>
						<th>Funtion</th>

					</tr>
				</thead>
				<c:forEach items="${listUser }" var="x" varStatus="i">
					<tbody>
						<tr>
							<td>${x.username }</td>
							<td><c:if test="${x.isAdmin == true}">Admin </c:if> <c:if
									test="${x.isAdmin == false}">User </c:if></td>

							<td>${x.email }</td>
							<td><a
								href="${pageContext.request.contextPath}/admins/Admin/deleteUser?index=${x.id}">Delete</a></td>
						</tr>
					</tbody>
				</c:forEach>

				<tfoot>
					<tr>
						<th>Rendering engine</th>
						<th>Browser</th>
						<th>Platform(s)</th>
						<th>Engine version</th>

					</tr>
				</tfoot>
			</table>
		</div>
		<!-- /.card-body -->
	</div>
	
</body>
</html>