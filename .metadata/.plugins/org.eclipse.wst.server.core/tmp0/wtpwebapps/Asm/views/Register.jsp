<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
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
<link rel="stylesheet" href="../assets/css/Login.css">
<style type="text/css">
.form-control {
	padding: 10px;
	font-size: 20px;
}

.form-label {
	font-size: 20px;
}

.login__title {
	font-size: 40px;
}
</style>
</head>
<body>
	<div class="container register__main">
		<h3 class="login__title">Register</h3>

		<form class="row g-3"
			action="${pageContext.request.contextPath}/register" method="post">
			<h4 style="color: red;">${error }</h4>
			<div class="col-md-6">
				<label for="validationServer01" class="form-label">User name</label>
				<!-- Them class isValid để check đúng  -->
				<input type="text" class="form-control" id="validationServer01"
					value="" required name="username" />
				<div class="valid-feedback">Looks good!</div>
			</div>

			<div class="col-md-6">
				<label for="validationServerUsername" class="form-label">Email</label>
				<div class="input-group has-validation">
					<span class="input-group-text" id="inputGroupPrepend3">@</span>
					<!-- Thêm class is-valied để check sai -->
					<input type="email" class="form-control"
						id="validationServerUsername"
						aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback"
						required name="email" />
					<div id="validationServerUsernameFeedback" class="invalid-feedback">
						Please choose a Email.</div>
				</div>
			</div>



			<div class="col-md-3">
				<label for="validationServer06" class="form-label">Password</label>
				<!-- Thêm class is-valied để check sai -->
				<input type="password" class="form-control" id="validationServer06"
					aria-describedby="validationServer06Feedback" required
					name="password" />
				<div id="validationServer06Feedback" class="invalid-feedback">
					Please provide a valid password.</div>
			</div>
			<div class="col-md-3">
				<label for="validationServer06" class="form-label">Re
					Password</label>
				<!-- Thêm class is-valied để check sai -->
				<input type="password" class="form-control" id="validationServer06"
					aria-describedby="validationServer06Feedback" required
					name="repassword" />
				<div id="validationServer06Feedback" class="invalid-feedback">
					Please re a valid password.</div>
			</div>

			<div class="col-12">
				<!-- Thêm class is-valied để check sai-->

				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="invalidCheck2" required /> <label class="form-check-label"
						for="invalidCheck2"> Agree to terms and conditions </label>
				</div>
			</div>

			<div class="col-12">
				<button class="btn register__btn" type="submit">Register</button>
			</div>
		</form>
	</div>

</body>
</html>