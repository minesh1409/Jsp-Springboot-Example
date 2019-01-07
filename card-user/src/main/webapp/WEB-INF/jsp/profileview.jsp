<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>

<!-- <div class="block-header">
					<div class="row">
						<div class="col-lg-5 col-md-8 col-sm-12" align="center">
							<h2>Connect</h2>

						</div>
					</div>
				</div> -->


<div class="row clearfix" style="justify-content: center; margin: auto;">
	<!-- <div class="col-lg-3 col-md-6 col-sm-12"></div>-->

	<div class="col-lg-3 col-md-6 col-sm-12"
		style="max-width: fit-content;">
		<div class="card contact-card">

			<div class="header p-0">
				<a href="javascript:void(0);"> <img
					src="${profileBasicInfo.user_pic}" class="img-fluid" alt=""
					style="width: -webkit-fill-available; height: 300px; object-fit: cover;">
					<!-- ../assets/images/lg/avatar1.jpg -->
				</a>
			</div>
			<div class="body text-center">
				<div class="social-icon d-flex justify-content-between">
					<a href="javascript:void(0);"
						class="btn btn-primary btn-round ml-0"><i
						class="icon-envelope"></i></a> <a href="javascript:void(0);"
						class="btn btn-primary btn-round mr-0"><i
						class="icon-call-out"></i></a>
				</div>
				<h6>
					${profileBasicInfo.first_name} ${profileBasicInfo.last_name} <small>${profileBasicInfo.profession}</small><small>
					</small>${n}
				</h6>
				<ul class="social-links list-unstyled d-flex justify-content-center">

					<c:forEach var="social" items="${profileSocialList}">

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
						<!-- <li><a class="btn font-18" title="instagram"
										href="javascript:void(0);"><i class="fa fa-youtube"></i></a></li>  -->

					</c:forEach>

				</ul>
				<small> ${ profileBasicInfo.home_address },
					${profileBasicInfo.city} <br> ${profileBasicInfo.state},
					${profileBasicInfo.country}
				</small>
			</div>

			<div class="body text-center" style="padding-bottom: 0px">
				<div>
					<!-- <ul class="nav nav-tabs-new2" style="display: -webkit-box;"> -->
					<ul class="nav nav-tabs-new2" style="display: -webkit-inline-box;">
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
							<p class="m-b-0">${profileBasicInfo.mobile}</p>
							<hr class="m-t-0">
							<small class="text-muted">Email address: </small>
							<p class="m-b-0">${profileBasicInfo.email}</p>
							<hr class="m-t-0">
							<small class="text-muted">Web address: </small>
							<p class="m-b-0">${profileBasicInfo.web}</p>
							<hr class="m-t-0">
							<small class="text-muted">Birth Date: </small>
							<p class="m-b-0">${profileBasicInfo.birthday}</p>
							<hr class="m-t-0">
							<small class="text-muted">Gender: </small>
							<p class="m-b-0">${profileBasicInfo.gender}</p>
							<hr class="m-t-0">
							<!-- <small class="text-muted">Work Address: </small>
											<p>795 Folsom Ave, Suite 600 San Francisco, 94107</p>
											<div>
												<iframe
													src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1923731.7533500232!2d-120.39098936853455!3d37.63767091877441!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80859a6d00690021%3A0x4a501367f076adff!2sSan+Francisco%2C+CA%2C+USA!5e0!3m2!1sen!2sin!4v1522391841133"
													width="100%" height="150" frameborder="0" style="border: 0"
													allowfullscreen=""></iframe>
											</div> -->
						</div>
					</div>

					<div class="tab-pane" id="Resume">

						<div class="body">
							<div>
								<h6>Education</h6>
								<hr class="m-t-0" />

								<ul style="padding-left: 20px;">
									<c:forEach var="edu" items="${profileEducationList}">

										<li>
											<P class="m-b-0">${edu.degree}</P> <small class="m-b-0">${edu.university}</small><br>
											<small class="m-b-0">${edu.passingYear}</small>
										</li>
										<!-- <li>
														<P class="m-b-0">Computer Engineering</P> <small
														class="m-b-0">D.A.Degree</small><br> <small
														class="m-b-0">2017</small>
													</li> -->

									</c:forEach>

								</ul>
							</div>

							<div>
								<h6>Experience</h6>
								<hr class="m-t-0" />
								<ul style="padding-left: 20px;">

									<c:forEach var="exp" items="${profileExperienceList}">

										<li>
											<P class="m-b-0">${exp.expDesignation}</P> <small
											class="m-b-0">${exp.expCompany}</small><br> <small
											class="m-b-0">${exp.expDuration}</small>
										</li>
										<!-- <li>
														<P class="m-b-0">Specta</P> <small class="m-b-0">Front
															end</small><br> <small class="m-b-0">3-mnth</small>
													</li> -->

									</c:forEach>

								</ul>
							</div>

							<div>
								<h6>Achievements</h6>
								<hr class="m-t-0" />
								<ul style="padding-left: 20px;">

									<c:forEach var="ach" items="${profileAchievementList}">

										<li>
											<P class="m-b-0">${ach.title}</P> <small class="m-b-0">${ach.description}
										</small><br>
										</li>
										<!-- <li>
														<P class="m-b-0">Computer Engineering</P> <small
														class="m-b-0">make soft web template editing make
															soft web template editing </small><br>
													</li> -->

									</c:forEach>

								</ul>
							</div>

							<div>
								<h6>Skill</h6>
								<hr class="m-t-0" />
								<ul style="padding-left: 20px;">

									<c:forEach var="skill" items="${profileSkillList}">

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
										<!-- <li>
														<div class="form-group">
															<label class="d-block">New skill<span
																class="float-right">77%</span></label>
															<div class="progress">
																<div class="progress-bar progress-bar-success"
																	role="progressbar" aria-valuenow="77" aria-valuemin="0"
																	aria-valuemax="100" style="width: 77%;"></div>
															</div>
														</div>
													</li> -->

									</c:forEach>

								</ul>
							</div>

						</div>
					</div>

					<div class="tab-pane" id="Portfolio">
						
						<!-- <div class="body"> -->


							<div class="right-box">

								<div class="widget" style="text-align: -webkit-center;">
									<ul class="list-unstyled instagram-plugin m-b-0" style="width: 255px;">
									
									<c:forEach var="product" items="${productList}">
									
										<li><a href="javascript:void(0);">
										<img src="${product.imageUrl}" alt="image description" style="width:83px; height:83px; object-fit:cover">
										</a></li>
												
												
										<!-- <li><a href="javascript:void(0);"><img
												src="../assets/images/blog/06-img.jpg"
												alt="image description" style="width: 83px;"></a></li>
										<li><a href="javascript:void(0);"><img
												src="../assets/images/blog/07-img.jpg"
												alt="image description" style="width: 83px;"></a></li>
										<li><a href="javascript:void(0);"><img
												src="../assets/images/blog/08-img.jpg"
												alt="image description" style="width: 83px;"></a></li>
										<li><a href="javascript:void(0);"><img
												src="../assets/images/blog/09-img.jpg"
												alt="image description" style="width: 83px;"></a></li>
										<li><a href="javascript:void(0);"><img
												src="../assets/images/blog/10-img.jpg"
												alt="image description" style="width: 83px;"></a></li>
										<li><a href="javascript:void(0);"><img
												src="../assets/images/blog/11-img.jpg"
												alt="image description" style="width: 83px;"></a></li>
										<li><a href="javascript:void(0);"><img
												src="../assets/images/blog/12-img.jpg"
												alt="image description" style="width: 83px;"></a></li>
										<li><a href="javascript:void(0);"><img
												src="../assets/images/blog/13-img.jpg"
												alt="image description" style="width: 83px;"></a></li> -->
												
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
	</div>


</div>

<%@include file="footer.jsp"%>