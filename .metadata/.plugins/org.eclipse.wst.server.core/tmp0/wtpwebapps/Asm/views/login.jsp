<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
</head>
<body>
	<div class="container">
		<div class="row login__main">
			<div class="col-lg-6 col-sm-12">
				<h3 class="login__title">ACCESS TO YOUR ACCOUNT</h3>
				<h4>${error }</h4>
				<h4>${mess }</h4>
				<form action="${pageContext.request.contextPath }/views/login"
					class="login__input" method="post">
					<input type="text" id="em" placeholder="Enter Your Username"
						required name="username" /> <input type="password" required
						placeholder="Enter Your Password" name="password" />
					<button class="login__btn" type="submit">Login</button>
				</form>

				<a href="${pageContext.request.contextPath }/views/forgot"
					class="forget__login">Have you forgotten your password?</a>
			</div>
			<div class="col-lg-2"></div>
			<div class="col-lg-4 col-sm-12">
				<h3 class="login__title">YOU NEED A ACCOUNT ?</h3>
				<div class="login__input">
					<a class="login__btn register__btn--log"
						href="${pageContext.request.contextPath }/views/register">Register</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>