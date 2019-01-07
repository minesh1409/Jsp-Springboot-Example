$(".GetProduct").click(function() {
	
	var email= $("#Email").val('');
	var contact= $("#Contact").val('');
	var message= $("#Message").val('');
	var id = $(this).attr("name");
	console.log("id: " + id);

	$.get('/getproduct/' + id, function(data) {
		console.log(data);	
		$("#ProductId").text(data.id);
		$("#Name").text(data.name);
		$("#ProductImage").attr("src", data.imageUrl);
		$("#Description").val(data.description);
		$("#ProductUserId").val(data.userId);
	}, 'json');

});


$("#SubmitEnquiry").click(function() {

	var name= $("#GuestName").val();
	var email= $("#Email").val();
	var contact= $("#Contact").val();
	var message= $("#Message").val();
	var productId= $("#ProductId").text();
	var productUserId= $("#ProductUserId").val();
	
	console.log("email: " + email);
	console.log("contact: " + contact);
	console.log("message: " + message);
	console.log("name: " + name);
	console.log("productId: " + productId);
	console.log("productUserId: " + productUserId);
	
	$("#CloseEnquiry").trigger("click");
	
	$.post('/addenquiry',{email:email, contact:contact, message:message, guestName:name, productId:productId, userId:productUserId }, function(data) {
		alert(data);
	},);
	
});