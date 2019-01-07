<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>

<form:form id="ContactForm" method="post" action="/contact"
	novalidate="" modelAttribute="profileContact"
	enctype="multipart/form-data">
	
	<div class="col-lg-12 col-md-12">
		<div class="card open_task">
			<div class="header">
				<h2>Contact Information</h2>
			</div>
			<div class="body">
				<div class="row clearfix">
					<div class="col-lg-6 col-md-12">

						<div class="form-group">
							<div class="form-line">
								<form:input type="text" class="form-control" placeholder="Address" path="home_address"/>
							</div>
						</div>
						<div class="form-group">
							<div class="form-line">
								<form:input type="text" class="form-control" placeholder="State" path="state"/>
							</div>
						</div>
						<div class="form-group">
							<div class="form-line">
								<form:input type="text" class="form-control" placeholder="Country" path="country"/>
							</div>
						</div>
						<div class="form-group">
							<div class="form-line">
								<form:input type="text" class="form-control" placeholder="city" path="city"/>
							</div>
						</div>

					</div>

					<div class="col-lg-6 col-md-12">
						<div class="form-group">
							<form:input type="number" class="form-control"
								placeholder="Contact Number" path="mobile"/> <span class="help-block">(999)
								999-9999</span>
						</div>
						<div class="form-group">
							<form:input type="email" class="form-control"
								placeholder="Email Address" required="" path="email"/> <span
								class="help-block">xyz@xyz.com</span>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon3">https://www.</span>
							</div>
							<form:input type="text" class="form-control" id="basic-url"
								aria-describedby="basic-addon3" placeholder="website" path="web" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</div>
	</div>
	
</form:form>

<%@include file="footer.jsp"%>