<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("admin") == null || session.getAttribute("admin").equals("")) {
		response.sendRedirect("login");
	} else {
		String uname = (String) request.getSession().getAttribute("admin");
		}
	
%>


<!doctype html>
<html lang="en">

    <head>
        <title>CONNECT ADMIN</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <meta name="description" content="Mplify Bootstrap 4.1.1 Admin Template">
        <meta name="author" content="ThemeMakker, design by: ThemeMakker.com">

        <link rel="icon" href="favicon.ico" type="image/x-icon">
        <!-- VENDOR CSS -->
        <link rel="stylesheet" href="assets/vendor/fullcalendar/fullcalendar.min.css">
        <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/vendor/animate-css/animate.min.css">
        <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">

        <!-- MAIN CSS -->
        <link rel="stylesheet" href="assets/css/main.css">
        <link rel="stylesheet" href="assets/css/color_skins.css">
        
        <!--Jquery Table-->
         <!-- J-Query Table-->
        <link rel="stylesheet" href="assets/vendor/jquery-datatable/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="assets/vendor/jquery-datatable/fixedeader/dataTables.fixedcolumns.bootstrap4.min.css">
        <link rel="stylesheet" href="assets/vendor/jquery-datatable/fixedeader/dataTables.fixedheader.bootstrap4.min.css">
        
        <!-- Sweet alert 28-9-2018 -->
        <link rel="stylesheet" href="assets/vendor/sweetalert/sweetalert.css"/>
        
        <!-- Slider nouislider -->
        <link rel="stylesheet" href="assets/vendor/nouislider/nouislider.min.css">


        <!-- Custom Js-->
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    </head>
    <body class="theme-blue">

        <!-- Page Loader -->
        <div class="page-loader-wrapper">
            <div class="loader">
                <div class="m-t-30"><img src="assets/images/thumbnail.png" width="48" height="48" alt="Mplify"></div>
                <p>Please wait...</p>        
            </div>
        </div>
        <!-- Overlay For Sidebars -->
        <div class="overlay" style="display: none;"></div>

        <div id="wrapper">

            <nav class="navbar navbar-fixed-top">
                <div class="container-fluid">

                    <div class="navbar-brand" style="background-color: #ffffff;">
                        <a href="javascript:void(0)">
                            <img src="assets/images/user.png" alt="Connect Logo" class="img-responsive logo">
                            <span class="name" style="color: #6c757d;">Admin</span>
                        </a>
                    </div>

                    <div class="navbar-right">
                        <ul class="list-unstyled clearfix mb-0">
                            <li>
                                <div class="navbar-btn btn-toggle-show">
                                    <button type="button" class="btn-toggle-offcanvas"><i class="lnr lnr-menu fa fa-bars" style="color: #6c757d;"></i></button>
                                </div>                        
                                <a href="javascript:void(0);" class="btn-toggle-fullwidth btn-toggle-hide"><i class="fa fa-bars"></i></a>
                            </li>

                            <li>
                                <div id="navbar-menu">
                                    <ul class="nav navbar-nav">
                                    
										<li><a href="logout">Logout</a></li>
										<li><a href="login" class="icon-menu js-right-sidebar"><i class="icon-power"  style="color:white;"></i></a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>