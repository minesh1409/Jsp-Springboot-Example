<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>

<div class="col-lg-12 col-md-12">
	<div class="card open_task">
		<div class="header">
			<h2>Experience Information</h2>
		</div>
		<div class="body">
			<div class="form-group">
				<button type="button" class="btn btn-primary addBtn" data-toggle="modal"
					data-target="#experience">
					<i class="icon-plus"></i>&nbsp;Add Experience Info
				</button>
			</div>

			<div class="table-responsive">
				<table class="table m-b-0 table-hover">
					<thead class="thead-light">
						<tr>
							<th>Designation</th>
							<th>Company</th>
							<th>Duration</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="tbodyExperience">
						<!--Experience Data Dynamically-->

						 <c:forEach var="exp" items="${profileExperienceList}">
							<tr>
								<td>${exp.expDesignation}</td>
								<td>${exp.expCompany}</td>
								<td>${exp.expDuration}</td>
								<td><button data-toggle="modal" data-target="#experience"
										type="button" class="btn btn-link btn-sm editExperience" title="Edit"
										name="${exp.id}">
										<i class="fa fa-edit"></i>
									</button>
									<button type="button" data-type="confirm"
										class="btn btn-link btn-sm js-sweetalert" title="Delete"
										onclick="location.href='/deleteexperience/${exp.id}'">
										<i class="fa fa-trash-o text-danger"></i>
									</button></td>
							</tr>
						</c:forEach> 

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="experience" tabindex="-1" role="dialog"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="title" id="defaultModalLabel">Add Experience Detail</h4>
			</div>

			<form:form method="post" action="/addexperience"
				modelAttribute="profileExperience" id="formExp">

				<div class="modal-body">
					
					<div class="form-group">
						<form:input type="text" class="form-control"
							placeholder="Designation" path="expDesignation" id="Designation" />
					</div>
					<div class="form-group">
						<form:input type="text" class="form-control" placeholder="Company"
							path="expCompany" id="Company" />
					</div>
					<div class="form-group">
						<form:input type="text" class="form-control"
							placeholder="Duration" maxlength="12" path="expDuration" id="Duration" />
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="Submit">Submit</button>
					<button type="submit" class="btn btn-primary" id="Update" style="display: none">Update</button>
					<button type="button" class="btn btn-simple" data-dismiss="modal">CLOSE</button>
				</div>

			</form:form>

		</div>
	</div>
</div>

<%@include file="footer.jsp"%>