<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@include file="sidebar.jsp"%>

<div class="col-lg-12 col-md-12">
	<div class="card open_task">
		<div class="header">
			<h2>Document Information</h2>
		</div>
		<div class="body">
			<div class="form-group">
				<button type="button" class="btn btn-primary addBtn" data-toggle="modal"
					data-target="#document">
					<i class="icon-plus"></i>&nbsp;Add Document
				</button>
			</div>

			<div class="table-responsive">
				<table class="table m-b-0 table-hover">
					<thead class="thead-light">
						<tr>
							<th>Image</th>
							<th>Name</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="tbodyDocument">
						<!--Experience Data Dynamically-->

						 <c:forEach var="document" items="${documentList}">
							<tr>
								<td><img src="${document.frontImageUrl}" class="" alt="" style="width: 45px; height: 45px; object-fit: cover;">
									<img src="${document.backImageUrl}" class="" alt="" style="width: 45px; height: 45px; object-fit: cover;">
								</td>
								<td>${document.name}</td>
								<td><button data-toggle="modal" data-target="#document"
										type="button" class="btn btn-link btn-sm editDocument" title="Edit"
										name="${document.id}">
										<i class="fa fa-edit"></i>
									</button>
									<button type="button" data-type="confirm"
										class="btn btn-link btn-sm js-sweetalert" title="Delete"
										onclick="location.href='/deletedocument/${document.id}'">
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

<div class="modal fade" id="document" tabindex="-1" role="dialog"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="title" id="defaultModalLabel">Add Document </h4>
			</div>

			<form:form method="post" action="/adddocument"
				modelAttribute="documentModel" enctype="multipart/form-data" id="formDocument">

				<div class="modal-body">
				
				<div class="form-group">
						<form:input type="text" class="form-control" placeholder="Title"
							path="name" id="Name" />
					</div>
					
					
					<div class="form-group align-center">
						<input type="file" name="file" id="imageFile" hidden>
						<img src="assets/images/placeholder.jpg" style="width:270px; height: 196px; object-fit: contain;" id="documentImage">
						<p>Front Image</span>
					</div> 
					
					
					<div class="form-group align-center">
						<input type="file" name="file1" id="imageFile1" hidden>
						<img src="assets/images/placeholder.jpg" style="width:270px; height: 196px; object-fit: contain;" id="documentImage1">
						<p>Back Image</p>
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

<script>

//click on image to open file or browser
$("#documentImage").click(function(){
	$('#imageFile').trigger('click');
});

//when file load it display image in base64
$(document).on('change', '#imageFile',function (){
	if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#documentImage').attr('src', e.target.result);
        }
        reader.readAsDataURL(this.files[0]);
    }
    //user_photo.split(',')[1];
});

// load base64 image
function toDataURL(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onload = function() {
        var reader = new FileReader();
        reader.onloadend = function() {
            callback(reader.result);
        }
        reader.readAsDataURL(xhr.response);
    };
    xhr.open('GET', url);
    xhr.responseType = 'blob';
    xhr.send();
};
/* toDataURL(userCard[0].user_photo_url, function(dataUrl){
    $("#user_photo").attr("src",dataUrl);
}); */ //calling 
</script>

<script>

//click on image to open file or browser
$("#documentImage1").click(function(){
	$('#imageFile1').trigger('click');
});

//when file load it display image in base64
$(document).on('change', '#imageFile1',function (){
	if (this.files && this.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#documentImage1').attr('src', e.target.result);
        }
        reader.readAsDataURL(this.files[0]);
    }
    //user_photo.split(',')[1];
});

// load base64 image
function toDataURL(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onload = function() {
        var reader = new FileReader();
        reader.onloadend = function() {
            callback(reader.result);
        }
        reader.readAsDataURL(xhr.response);
    };
    xhr.open('GET', url);
    xhr.responseType = 'blob';
    xhr.send();
};
/* toDataURL(userCard[0].user_photo_url, function(dataUrl){
    $("#user_photo").attr("src",dataUrl);
}); */ //calling 
</script>

<script src="assets/profileJs/document.edit.js" ></script>

<%@include file="footer.jsp"%>