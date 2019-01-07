<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>


<div class="col-lg-12 col-md-12">
	<div class="card open_task">
		<div class="header">
			<h2>Social Information</h2>
		</div>
		<div class="body">
			<div class="form-group">
				<button type="button" class="btn btn-primary addBtn" data-toggle="modal"
					data-target="#social">
					<i class="icon-plus"></i>&nbsp;Add Social Links
				</button>
			</div>


			<div class="table-responsive">
				<table class="table m-b-0 table-hover">
					<thead class="thead-light">
						<tr>
							<th>Name</th>
							<th>Url</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="tbodySocial">
						<!--Social Data Dynamically-->

						<c:forEach var="social" items="${profileSocialList}">
							<tr>

								<td><div class="w_social3">
										<c:choose>
											<c:when test="${social.socialName == 0}">
												<div class="facebook-widget">
													<div class="icon">
														<i class="fa fa-facebook"></i>
													</div>
												</div>
											</c:when>
											<c:when test="${social.socialName == 1}">
												<div class="google-widget">
													<div class="icon">
														<i class="fa fa-google-plus"></i>
													</div>
												</div>
											</c:when>
											<c:when test="${social.socialName == 2}">
												<div class="twitter-widget">
													<div class="icon">
														<i class="fa fa-twitter"></i>
													</div>
												</div>
											</c:when>
											<c:when test="${social.socialName == 3}">
												<div class="instagram-widget">
													<div class="icon">
														<i class="fa fa-instagram"></i>
													</div>
												</div>
											</c:when>
											<c:when test="${social.socialName == 4}">
												<div class="linkedin-widget">
													<div class="icon">
														<i class="fa fa-linkedin"></i>
													</div>
												</div>
											</c:when>
											<c:when test="${social.socialName == 5}">
												<div class="twitter-widget">
													<div class="icon">
														<i class="fa fa-skype"></i>
													</div>
												</div>
											</c:when>
											<c:when test="${social.socialName == 6}">
												<div class="google-widget">
													<div class="icon">
														<i class="fa fa-youtube"></i>
													</div>
												</div>
											</c:when>
										</c:choose>
									</div></td>
								<td><div>${social.socialLink}</div></td>
								<td><button data-toggle="modal" data-target="#social"
										type="button" class="btn btn-link btn-sm editSocial" title="Edit"
										name="${social.id}">
										<i class="fa fa-edit"></i>
									</button>
									<button type="button" data-type="confirm"
										class="btn btn-link btn-sm js-sweetalert" title="Delete"
										onclick="location.href='/deletesocial/${social.id}'">
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


<div class="modal fade" id="social" tabindex="-1" role="dialog"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="title" id="defaultModalLabel">Add Social</h4>
			</div>

			<form:form method="post" action="/addsocial"
				modelAttribute="profileSocial" id="formSocial">

				<div class="modal-body">
					<div class="form-group">
						<form:select class="custom-select" path="socialName" id="Socialname">
							<form:option value="0">Facebook</form:option>
							<form:option value="1">Google Plus</form:option>
							<form:option value="2">Twitter</form:option>
							<form:option value="3">Instagram</form:option>
							<form:option value="4">Linked In</form:option>
							<form:option value="5">Skype</form:option>
							<form:option value="6">Youtube</form:option>
						</form:select>
					</div>
					<div class="form-group">
						<form:input type="text" class="form-control"
							placeholder="Social URL" path="socialLink" id="SocialLink"/>
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