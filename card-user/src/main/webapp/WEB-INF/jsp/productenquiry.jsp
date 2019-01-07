<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>

<div class="col-lg-12 col-md-12">
	<div class="card open_task">
		<div class="header">
			<h2>Inquiry Information</h2>
		</div>
		<div class="body">
			<!-- <div class="form-group">
				<button type="button" class="btn btn-primary addBtn" data-toggle="modal"
					data-target="#experience">
					<i class="icon-plus"></i>&nbsp;Add Experience Info
				</button>
			</div> -->

			<div class="table-responsive">
				<table class="table m-b-0 table-hover">
					<thead class="thead-light">
						<tr>
							<th>Product Name</th>
							<th>Name</th>
							<th>Email</th>
							<th>Contact</th>
							<th>Message</th>
						</tr>
					</thead>
					<tbody id="tbodyEnquiry">
						<!--Experience Data Dynamically-->

						 <c:forEach var="inquiry" items="${productEnquiryList}">
							<tr>
								<td>${inquiry.productName}</td>
								<td>${inquiry.guestName}</td>
								<td>${inquiry.email}</td>
								<td>${inquiry.contact}</td>
								<td>${inquiry.message}</td>
							</tr>
						</c:forEach> 

					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>



<%@include file="footer.jsp"%>