<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">

<head>
<title>:: Mplify :: Login</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="description" content="Mplify Bootstrap 4.1.1 Admin Template">
<meta name="author" content="ThemeMakker, design by: ThemeMakker.com">

<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/vendor/animate-css/animate.min.css">
<link rel="stylesheet"
	href="assets/vendor/font-awesome/css/font-awesome.min.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/color_skins.css">
</head>

<body class="theme-blue">
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle auth-main">
				<div class="auth-box">
					<div class="mobile-logo">
						<a href="index.html"><img src="assets/images/logo-icon.svg"
							alt="Mplify"></a>
					</div>
					<div class="auth-left">
						<div class="left-top">
							<a href="index.html"> <img src="assets/images/logo-icon.svg"
								alt="Mplify"> <span>DigiCard</span>
							</a>
						</div>
						<div class="left-slider">
							<img src="assets/images/login/1.jpg" class="img-fluid" alt="">
						</div>
					</div>
					<div class="auth-right">

						<div class="card">
							<div class="header">
								<p class="lead">Log in</p>
							</div>
							<div class="body">
								<form:form class="form-auth-small" action="login" method="post" modelAttribute="adminLogin">
									<div class="form-group">
										<label for="signin-email" class="control-label sr-only">User Name</label> 
											<form:input type="text" path="userName" class="form-control" value="" placeholder="User Name"/>
									</div>
									<div class="form-group">
										<label for="signin-password" class="control-label sr-only">Password</label>
										<form:input type="password" path="password" class="form-control" id="signin-password" value="" placeholder="Password" />
									</div>
									
									<div class="form-group">
										<span class="text-danger">${error}</span>
										<span class="text-success">${success}</span>										
									</div>

									<button type="submit" class="btn btn-primary btn-lg btn-block">LOGIN</button>
									<!-- <div class="bottom">
										<span class="helper-text m-b-10"><i class="fa fa-lock"></i> <a href="page-forgot-password.html">Forgot password?</a></span>
										<span>Don't have an account? <a href="/register">Register</a></span>
									</div> -->
																	
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->


	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
		
	</script>


</body>
</html>
