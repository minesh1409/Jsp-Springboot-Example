<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>

<form:form id="BasicForm" method="post" action="/profilebasic"
	novalidate="" modelAttribute="profileBasic"
	enctype="multipart/form-data">

	<div class="col-lg-12 col-md-12">
		<div class="card open_task">
			<div class="header">
				<h2>Basic Information</h2>
			</div>



			<div class="row clearfix">
				<div class="col-lg-4 col-md-6">
					<div class="card " align="center">
						<div class="header">
							<h2>Profile Picture</h2>
						</div>
						<div class="body">
							<div class="profile-image">
							
								<img src=" ${profilepic}" class="rounded-circle"
									alt="" style="height:140px; width:140px; object-fit: cover">
							</div>
							<div class="border-top p-t-20 m-t-20 text-left">
								<div class="m-t-15">
									<div class="custom-file">
										<input type="file" name="file">
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>


				<div class="col-lg-8 col-md-6">
					<div class="card">
						<div class="header">
							<h2>Basic Validation</h2>
						</div>
						<div class="body">

							<div class="form-group">
								<div class="form-line">
									<form:input type="text" class="form-control"
										placeholder="First Name" path="first_name" />
								</div>
							</div>
							<div class="form-group">
								<div class="form-line">
									<form:input type="text" class="form-control"
										placeholder="Last Name" path="last_name" />
								</div>
							</div>
							<div class="form-group">
								<div class="form-line">
									<label>Birthdate</label>
									<div class="input-group mb-3">
										<form:input data-provide="datepicker"
											data-date-autoclose="true" class="form-control"
											path="birthday" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label>Gender</label> <br> <label class="fancy-radio">
									<form:radiobutton name="gender" value="male" required=""
										data-parsley-errors-container="#error-radio"
										data-parsley-multiple="gender" path="gender" /> <span><i></i>Male</span>
								</label> <label class="fancy-radio"> <form:radiobutton
										name="gender" value="female" data-parsley-multiple="gender"
										path="gender" /> <span><i></i>Female</span>
								</label>
								<p id="error-radio"></p>
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>

						</div>
					</div>
				</div>




			</div>

			<h6 style="text-align: center;"> ${message} </h6>

		</div>
	</div>

</form:form>

<%@include file="footer.jsp"%>