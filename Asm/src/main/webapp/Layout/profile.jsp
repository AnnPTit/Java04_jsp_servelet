<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<form method="POST" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/views/profile">
<h2 class="text-center" style="color: red;">${erorr}</h2>
		<div class="input-group mb-3" style="margin-top: 100px">
			<span class="input-group-text" id="basic-addon1">User Name</span> <input
				type="text" class="form-control" placeholder="Username"
				aria-label="Username" aria-describedby="basic-addon1"
				name="username" value="${userLogged.username}">
		</div>


		<div class="mb-3">
			<label for="formFile" class="form-label">Avatar
				</label> <input class="form-control" type="file" id="formFile" name="avatar">
		</div>
		
		<div>
			<%--<img width="80" height="80"
				src="${pageContext.request.contextPath}/upload/${userLogged.avatar}"> --%>
				<img src="${pageContext.request.contextPath}/upload/${userLogged.avatar}" class="rounded mx-auto d-block" alt="avatar" style="width: 400px;height: 500px">
		</div>

		<div>
			<input type="submit" value="Submit" class="btn btn-secondary">
		</div>

	</form>
</div>