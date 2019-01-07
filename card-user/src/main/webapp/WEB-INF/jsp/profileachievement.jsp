<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>
<div class="row clearfix">
	<div class="col-lg-12 col-md-12">
		<div class="card open_task">
			<div class="header">
				<h2>Achievement Information</h2>
			</div>
			<div class="body">
				<div class="form-group">
					<button type="button" class="btn btn-primary addBtn" data-toggle="modal"
						data-target="#achievement">
						<i class="icon-plus"></i>&nbsp;Add Achievement Info
					</button>
				</div>

				<div class="table-responsive">
					<table class="table m-b-0 table-hover">
						<thead class="thead-light">
							<tr>
								<th>Name</th>
								<th>Description</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody id="tbodyAchievement">
							<!--	Achievement Data Dynamically-->

							<c:forEach var="ach" items="${profileAchievementList}">
								<tr>
									<td>${ach.title}</td>
									<td>${ach.description}</td>
									<td><button data-toggle="modal" data-target="#achievement"
											type="button" class="btn btn-link btn-sm editAchievement" title="Edit"
											name="${ach.id}">
											<i class="fa fa-edit"></i>
										</button>
										<button type="button" data-type="confirm"
											class="btn btn-link btn-sm js-sweetalert" title="Delete"
											onclick="location.href='/deleteachievement/${ach.id}'">
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
</div>
<div class="modal fade" id="achievement" tabindex="-1" role="dialog"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="title" id="defaultModalLabel">Add Achievement Detail</h4>
			</div>

			<form:form method="post" action="/addachievement"
				modelAttribute="profileAchievement" id="formAch">

				<div class="modal-body">
					<div class="form-group">
						<form:input type="text" class="form-control"
							placeholder="Achievement Name" path="title" id="AchievementName" />
					</div>
					<div class="form-group">
						<div class="form-line">
							<form:textarea class="form-control no-resize"
								placeholder="Achievement Description..." path="description" id="AchievementDescription" />
						</div>
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