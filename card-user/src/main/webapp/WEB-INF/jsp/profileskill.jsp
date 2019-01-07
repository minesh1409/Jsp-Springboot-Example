<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>

<div class="col-lg-12 col-md-12">
	<div class="card open_task">
		<div class="header">
			<h2>Skill Information</h2>
		</div>
		<div class="body">
			<div class="form-group">
				<button type="button" class="btn btn-primary addBtn" data-toggle="modal"
					data-target="#skill">
					<i class="icon-plus"></i>&nbsp;Add skill
				</button>
			</div>

			<div class="table-responsive">
				<table class="table m-b-0 table-hover">
					<thead class="thead-light">
						<tr>
							<th>Name</th>
							<th>Progress</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="tbodyskill">
						<!-- Skill Data Dynamically -->

						<c:forEach var="skill" items="${profileSkillList}">
							<tr>
								<td><div>${skill.skillName}</div></td>
								<td><div class='progress progress-xs'>
										<div class='progress-bar' role='progressbar' aria-valuemin='0'
											aria-valuemax='100' style='width: ${skill.skillValue}%;'>
										</div></td>
										
										<td><button data-toggle="modal" data-target="#skill"
											type="button" class="btn btn-link btn-sm editSkill" title="Edit"
											name="${skill.id}">
											<i class="fa fa-edit"></i>
										</button>
										<button type="button" data-type="confirm"
											class="btn btn-link btn-sm js-sweetalert" title="Delete"
											onclick="location.href='/deleteskill/${skill.id}'">
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

<div class="modal fade" id="skill" tabindex="-1" role="dialog"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
	
	<form:form method="post" action="/addskill"
				modelAttribute="profileSkill" id="formSkill">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="title" id="defaultModalLabel">Add Skill</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<form:input type="text" class="form-control" placeholder="Skill Name" path="skillName" id="SkillName" />
				</div>
				<div class="form-group">
					<form:input type="text" class="form-control" placeholder="0 - 100" path="skillValue" id="SkillValue"/>
				</div>

			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary" id="Submit">Submit</button>
				<button type="submit" class="btn btn-primary" id="Update" style="display: none">Update</button>
				<button type="button" class="btn btn-simple" data-dismiss="modal">CLOSE</button>
			</div>
		</div>
		</form:form>
		
	</div>
</div>

<%@include file="footer.jsp"%>