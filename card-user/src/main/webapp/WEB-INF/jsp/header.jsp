<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("uname") == null || session.getAttribute("uname").equals("")) {
		response.sendRedirect("/login");
	} else {
		String uname = (String) request.getSession().getAttribute("uname");
		int uid = (Integer) request.getSession().getAttribute("uid");
		String userPic = (String) request.getSession().getAttribute("upic");
		//session.removeAttribute("uname");
	}
	/*  try {
	    if (request.getSession(false) == null) {out.print("session empty");} 
	    else {String uname = (String) request.getSession().getAttribute("uname");}
	} catch (Exception e) {
		out.print(e);
	}
	*/
%>


<!doctype html>
<html lang="en">

<head>
<title>:: Mplify :: Calendar</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="description" content="Mplify Bootstrap 4.1.1 Admin Template">
<meta name="author" content="ThemeMakker, design by: ThemeMakker.com">

<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="assets/vendor/fullcalendar/fullcalendar.min.css">
<link rel="stylesheet"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/vendor/animate-css/animate.min.css">
<link rel="stylesheet"
	href="assets/vendor/font-awesome/css/font-awesome.min.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/color_skins.css">

<!-- Blog CSS -->
<link rel="stylesheet" href="assets/css/blog.css">

<!-- Datepicker 11-10-2018 -->
<link rel="stylesheet"
	href="../assets/vendor/bootstrap-datepicker/css/bootstrap-datepicker3.min.css">
<!-- Datepicker 11-10-2018 -->
<link rel="stylesheet"	href="assets/vendor/bootstrap-datepicker/css/bootstrap-datepicker3.min.css"> <!-- 7-12-2018 -->
	
<!-- Bootstrap Datepicker css -->

<!-- Sweet alert 28-9-2018 -->
<link rel="stylesheet" href="assets/vendor/sweetalert/sweetalert.css" />


<!-- Slider nouislider -->
<link rel="stylesheet" href="assets/vendor/nouislider/nouislider.min.css">


<!-- ImageUpload CSS -->
<link rel="stylesheet" href="../assets/vendor/dropify/css/dropify.min.css">

<!-- ChartJs CSS -->
<link rel="stylesheet" href="assets/vendor/chartist/css/chartist.min.css">
<link rel="stylesheet" href="assets/vendor/chartist-plugin-tooltip/chartist-plugin-tooltip.css">

<!-- Datatable -->
<link rel="stylesheet" href="assets/vendor/jquery-datatable/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="assets/vendor/jquery-datatable/fixedeader/dataTables.fixedcolumns.bootstrap4.min.css">
<link rel="stylesheet" href="assets/vendor/jquery-datatable/fixedeader/dataTables.fixedheader.bootstrap4.min.css">

<!-- VENDOR CSS LINE-CHART -->
 <link rel="stylesheet" href="assets/vendor/c3/c3.min.css">


<!-- Custom Js-->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body class="theme-blue">

	<!-- Page Loader -->
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="m-t-30">
				<img src="assets/images/thumbnail.png" width="48" height="48"
					alt="Mplify">
			</div>
			<p>Please wait...</p>
		</div>
	</div>
	<!-- Overlay For Sidebars -->
	<div class="overlay" style="display: none;"></div>

	<div id="wrapper">

		<nav class="navbar navbar-fixed-top">
			<div class="container-fluid">

				<div class="navbar-brand" style="background-color: #ffffff;">
					<a href="index.php"> <img src="assets/images/Specta.png"
						alt="Connect" class="img-responsive logo"> <span
						class="name" style="color: #6c757d;">Connect</span>
					</a>
				</div>

				<div class="navbar-right">
					<ul class="list-unstyled clearfix mb-0">
						<li>
							<div class="navbar-btn btn-toggle-show">
								<button type="button" class="btn-toggle-offcanvas">
									<i class="lnr lnr-menu fa fa-bars" style="color: #6c757d;"></i>
								</button>
							</div> <a href="javascript:void(0);"
							class="btn-toggle-fullwidth btn-toggle-hide"><i
								class="fa fa-bars"></i></a>
						</li>

						<li>
							<div id="navbar-menu">
								<ul class="nav navbar-nav">




									<%-- <li class="dropdown"><a href="javascript:void(0);"
										class="dropdown-toggle icon-menu" data-toggle="dropdown"
										aria-expanded="false"> <img class="rounded-circle"
											src="${userPic}" width="30" alt="">
									</a>
										<div class="dropdown-menu animated flipInY user-profile">
											<div class="d-flex p-3 align-items-center">
												<div class="drop-left m-r-10">
													<img src="${ userPic}" class="rounded"
														width="50" alt="">
												</div>
												<div class="drop-right">
													<h4>${uname}</h4>
													<h4>${uid}</h4>
													<p class="user-name">user@email</p>
												</div>
											</div>
											<div class="m-t-10 p-3 drop-list">
												<ul class="list-unstyled">
													<li><a href="page-profile.html"><i
															class="icon-user"></i>My Profile</a></li>
													<li><a href="app-inbox.html"><i
															class="icon-envelope-open"></i>Messages</a></li>
													<li><a href="javascript:void(0);"><i
															class="icon-settings"></i>Settings</a></li>
													<li class="divider"></li>
													<li><a href="/login"><i class="icon-power"></i>Logout</a></li>
												</ul>
											</div>
										</div>
										</li> --%>
										<li><a href="/login">Logout</a></li>
										<li><a href="/login" class="icon-menu js-right-sidebar"><i class="icon-power"  style="color:white;"></i></a></li>
										
										
									<!-- <li><a href="javascript:void(0);"
										class="icon-menu js-right-sidebar"><i
											class="icon-settings"></i></a></li> -->
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</nav>