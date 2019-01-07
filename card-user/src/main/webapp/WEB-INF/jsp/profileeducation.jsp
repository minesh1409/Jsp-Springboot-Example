<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>


<div class="col-lg-12 col-md-12">
	<div class="card open_task">
		<div class="header">
			<h2>Education Information</h2>
		</div>
		<div class="body">
			<div class="form-group">
				<button type="button" class="btn btn-primary addBtn" data-toggle="modal"
					data-target="#education">
					<i class="icon-plus"></i>&nbsp;Add Education Info
				</button>
			</div>

			<div class="table-responsive">
				<table class="table m-b-0 table-hover">
					<thead class="thead-light">
						<tr>
							<th>Degree</th>
							<th>University</th>
							<th>Passing Year</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="tbodyEducation">
						<!--Education Data Dynamically-->
						<c:forEach var="edu" items="${profileEducationList}">
							<tr>								
								<td>${edu.degree}</td>
								<td>${edu.university}</td>
								<td>${edu.passingYear}</td>
								<td><button data-toggle="modal" data-target="#education" type="button" class="btn btn-link btn-sm editEducation" title="Edit" name="${edu.id}"> <%-- onclick="location.href='/editeducation/${edu.id}'" --%>
									<i class="fa fa-edit"></i>
									</button>
									<button type="button" data-type="confirm" class="btn btn-link btn-sm js-sweetalert" title="Delete" onclick="location.href='/deleteeducation/${edu.id}'">
										<i class="fa fa-trash-o text-danger"></i>
									</button>
								</td>
							</tr>
							
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="education" tabindex="-1" role="dialog"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="title" id="defaultModalLabel">Add Education Detail</h4>
			</div>

			<form:form method="post" action="/addeducation"
				modelAttribute="profileEducation" id="formEdu">

				<div class="modal-body">
					<div class="form-group">
						<input type="hidden" name="EduId" />
					</div>
					<div class="form-group">
						<form:input type="text" class="form-control" placeholder="Degree"
							path="degree" name="degree" id="Degree" />
					</div>
					<div class="form-group">
						<form:input type="text" class="form-control"
							placeholder="University" path="university" name="university" id="University" />
					</div>
					<div class="form-group">
						<form:input type="number" class="form-control"
							placeholder="Passing Year" maxlength="4" path="passingYear" name="passingYear" id="PassingYear" />
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
