<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	/* 
	if (session.getAttribute("uname") == null || session.getAttribute("uname").equals("")){
		 response.sendRedirect("/login");
	}else {
		session.removeAttribute("uname");
	}
	  try {
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
<title>:: Mplify :: Contact Grid</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="description" content="Mplify Bootstrap 4.1.1 Admin Template">
<meta name="author" content="ThemeMakker, design by: ThemeMakker.com">

<link rel="icon" href="favicon.ico" type="image/x-icon">

<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="../assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../assets/vendor/animate-css/animate.min.css">
<link rel="stylesheet"
	href="../assets/vendor/font-awesome/css/font-awesome.min.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/color_skins.css">

<!-- Blog CSS -->
<link rel="stylesheet" href="assets/css/blog.css">

</head>
<body class="theme-blue">

	<!-- Page Loader -->
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="m-t-30">
				<img src="../assets/images/thumbnail.png" width="48" height="48"
					alt="Mplify">
			</div>
			<p>Please wait...</p>
		</div>
	</div>
	<!-- Overlay For Sidebars -->
	<div class="overlay" style="display: none;"></div>

	<div id="wrapper">

		<div id="main-content" style="margin: 0px; float: none; width: auto;">
			<!-- width: auto;  added at 29-11-2018 date -->
			<div class="container-fluid">

				<div class="block-header">
					<div class="row">
						<div class="col-lg-5 col-md-8 col-sm-12" align="center">
							<!-- <h2>Connect</h2>-->

						</div>
					</div>
				</div>


				<div class="row clearfix" style="justify-content: center;">
					<!-- <div class="col-lg-3 col-md-6 col-sm-12"></div>-->

					<div class="col-lg-3 col-md-6 col-sm-12"
						style="max-width: fit-content;">
						<div class="card contact-card">

							<div class="header p-0">
								<a href="javascript:void(0);"><img
									src="${basicInfo.user_pic}" class="img-fluid" alt=""
									style="width: -webkit-fill-available; height: 300px; object-fit: cover;"></a>
							</div>
							<div class="body text-center">
								<div class="social-icon d-flex justify-content-between">
									<a href="mailto:${basicInfo.email}"
										class="btn btn-primary btn-round ml-0"><i
										class="icon-envelope"></i></a> <a href="tel:${basicInfo.mobile}"
										class="btn btn-primary btn-round mr-0"><i
										class="icon-call-out"></i></a>
								</div>
								<h6>
									${basicInfo.first_name} ${basicInfo.last_name} <small>${basicInfo.profession}</small><small>
										<!-- Specta -->
									</small>${n}
								</h6>
								<ul
									class="social-links list-unstyled d-flex justify-content-center">
									<c:forEach var="social" items="${socialList}">

										<li><a class="btn font-18" title="facebook"
											href="${social.socialLink}"> <c:choose>
													<c:when test="${social.socialName == 0}">
														<i class="fa fa-facebook"></i>
													</c:when>
													<c:when test="${social.socialName == 1}">
														<i class="fa fa-google-plus"></i>
													</c:when>
													<c:when test="${social.socialName == 2}">
														<i class="fa fa-twitter"></i>
													</c:when>
													<c:when test="${social.socialName == 3}">
														<i class="fa fa-instagram"></i>
													</c:when>
													<c:when test="${social.socialName == 4}">
														<i class="fa fa-linkedin"></i>
													</c:when>
													<c:when test="${social.socialName == 5}">
														<i class="fa fa-skype"></i>
													</c:when>
													<c:when test="${social.socialName == 6}">
														<i class="fa fa-youtube"></i>
													</c:when>
												</c:choose>
										</a></li>


									</c:forEach>
								</ul>
								<small>${ basicInfo.home_address } ${basicInfo.city} <br>
									${basicInfo.state} ${basicInfo.country}
								</small>
							</div>

							<div class="body text-center" style="padding-bottom: 0px">
								<div>
									<ul class="nav nav-tabs-new2"
										style="display: -webkit-inline-box;">
										<!-- style="display: -webkit-box;" -->
										<li class="nav-item"><a style="padding: 7px 15px;"
											class="nav-link active show" data-toggle="tab" href="#About">About</a></li>
										<li class="nav-item"><a style="padding: 7px 15px;"
											class="nav-link" data-toggle="tab" href="#Resume">Resume</a></li>
										<li class="nav-item"><a style="padding: 7px 15px;"
											class="nav-link" data-toggle="tab" href="#Portfolio">Portfolio</a></li>
									</ul>
								</div>
							</div>

							<div class="card">

								<div class="tab-content ">
									<div class="tab-pane active show" id="About">
										<div class="body">
											<small class="text-muted">Mobile: </small>
											<p class="m-b-0">${ basicInfo.mobile}</p>
											<hr class="m-t-0">
											<small class="text-muted">Email address: </small>
											<p class="m-b-0">${ basicInfo.email}</p>
											<hr class="m-t-0">
											<small class="text-muted">Web address: </small>
											<p class="m-b-0">${ basicInfo.web}</p>
											<hr class="m-t-0">
											<small class="text-muted">Birth Date: </small>
											<p class="m-b-0">${ basicInfo.birthday}</p>
											<hr class="m-t-0">
											<small class="text-muted">Gender: </small>
											<p class="m-b-0">${ basicInfo.gender}</p>
											<hr class="m-t-0">
											<!-- <small class="text-muted">Work Address: </small>
											<p>795 Folsom Ave, Suite 600 San Francisco, 94107</p>
											<div>
												<iframe
													src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1923731.7533500232!2d-120.39098936853455!3d37.63767091877441!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80859a6d00690021%3A0x4a501367f076adff!2sSan+Francisco%2C+CA%2C+USA!5e0!3m2!1sen!2sin!4v1522391841133"
													width="100%" height="150" frameborder="0" style="border: 0"
													allowfullscreen=""></iframe>
											</div> -->
											
											<div class="align-center">
											<a class="btn btn-primary" href="${contactFile}" role="button" id="DownloadVcard">Download Contact</a>
											</div>
										</div>
									</div>

									<div class="tab-pane" id="Resume">

										<div class="body">
											<div>
												<h6>Education</h6>
												<hr class="m-t-0" />
												<ul style="padding-left: 20px;">
													<c:forEach var="edu" items="${educationList}">
														<li>
															<P class="m-b-0">${edu.degree}</P> <small class="m-b-0">${edu.university}</small><br>
															<small class="m-b-0">${edu.passingYear}</small>
														</li>
													</c:forEach>
												</ul>
											</div>

											<div>
												<h6>Experience</h6>
												<hr class="m-t-0" />
												<ul style="padding-left: 20px;">
													<c:forEach var="exp" items="${experienceList}">
														<li>
															<P class="m-b-0">${exp.expDesignation}</P> <small
															class="m-b-0">${exp.expCompany}</small><br> <small
															class="m-b-0">${exp.expDuration}</small>
														</li>
													</c:forEach>
												</ul>
											</div>

											<div>
												<h6>Achievements</h6>
												<hr class="m-t-0" />
												<ul style="padding-left: 20px;">
													<c:forEach var="ach" items="${achievementList}">
														<li>
															<P class="m-b-0">${ach.title}</P> <small class="m-b-0">${ach.description}
														</small><br>
														</li>
													</c:forEach>
												</ul>
											</div>

											<div>
												<h6>Skill</h6>
												<hr class="m-t-0" />
												<ul style="padding-left: 20px;">
													<c:forEach var="skill" items="${skillList}">
														<li>
															<div class="form-group">
																<label class="d-block">${skill.skillName}<span
																	class="float-right">${skill.skillValue}%</span></label>
																<div class="progress">
																	<div class="progress-bar progress-bar-success"
																		role="progressbar" aria-valuenow="${skill.skillValue}"
																		aria-valuemin="0" aria-valuemax="100"
																		style="width: ${skill.skillValue}%;"></div>
																</div>
															</div>
														</li>
													</c:forEach>
												</ul>
											</div>

										</div>
									</div>

									<div class="tab-pane" id="Portfolio">

										<!-- <div class="body"> -->
										<div class="right-box">

											<div class="widget" style="text-align: -webkit-center;">
												<ul class="list-unstyled instagram-plugin m-b-0"
													style="width: 255px;">
													<c:forEach var="product" items="${productList}">

														<li><a href="javascript:void(0);" data-toggle="modal"
															data-target="#productenquiry" class="GetProduct"
															name="${product.id}"> <img src="${product.imageUrl}"
																alt="image description"
																style="width: 83px; height: 83px; object-fit: cover">
														</a></li>
													</c:forEach>
												</ul>
											</div>

										</div>

										<!-- </div> -->

									</div>

								</div>
								<!--End Tab Content-->

								<!--like-->
								<!--share-->
								<!--save-->

							</div>
							<!--End Card-->

						</div>
						<!-- end card  -->
					</div>
					<!-- end col lg 3 -->


				</div>
				<!--  end row flex -->

				<div class="modal fade" id="productenquiry" tabindex="-1"
					role="dialog" style="display: none;" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<input type="hidden" id="ProductId"> <input type="hidden"
								id="ProductUserId">
							<div class="modal-header">
								<h4 class="title" id="Name" id="defaultModalLabel">No Title</h4>
							</div>

							<div class="modal-body p-b-0">
								<div class="form-group align-center">
									<img src="assets/images/placeholder.jpg"
										style="width: 270px; height: 196px; object-fit: contain;"
										id="ProductImage">
								</div>

								<div class="form-group">
									DESCRIPTION:
									<div id="Description"></div>
								</div>
							</div>

							<form method="post" modelAttribute="enquiryModel"
								enctype="multipart/form-data" id="formEnquiry">

								<div class="modal-body p-t-0">

									<p>
										<b>Enquiry For This Product</b>
									</p>

									<div class="form-group">
										<input type="text" class="form-control" placeholder="Name"
											path="email" id="GuestName" />
									</div>
									<div class="row clearfix">
										<div class="col-md-6">
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Email"
													path="email" id="Email" />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<input type="number" class="form-control"
													placeholder="Contact" path="contact" id="Contact" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<textarea class="form-control" placeholder="Message..."
											path="message" id="Message"> </textarea>
									</div>

								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-primary"
										id="SubmitEnquiry">Submit</button>
									<button type="button" class="btn btn-simple"
										data-dismiss="modal" id="CloseEnquiry">CLOSE</button>
								</div>

							</form>

						</div>
					</div>
				</div>





			</div>
		</div>

	</div>

	<!-- Javascript -->
	<script src="assets/bundles/libscripts.bundle.js"></script>
	<script src="assets/bundles/vendorscripts.bundle.js"></script>
	<script src="assets/bundles/mainscripts.bundle.js"></script>

	<script src="assets/profileJs/productinfo.js"></script>
	<script src="assets/profileJs/jquery.client.js"></script>
	<script src="assets/profileJs/anay.js"></script> 

</body>
</html>
