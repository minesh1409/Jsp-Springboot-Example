$(".addBtn").click(function() {
	$("#Submit").show();
	$("#Update").hide();
	$(".form-control").val("");
	
	$("#formDocument").attr("action","/adddocument");	
	$("#documentImage").attr("src","assets/images/placeholder.jpg");
	$("#documentImage1").attr("src","assets/images/placeholder.jpg");
});

$(".editDocument").click(function() {
	
	$("#Submit").hide();
	$("#Update").show();
	
	var id = $(this).attr("name");
	console.log("id: " + id);

	$.get('/editdocument/'+id, function(data) {
		console.log(data);
		
		$("#Name").val(data.name);
		
		toDataURL(data.frontImageUrl, function(dataUrl){
            $("#documentImage").attr("src",dataUrl);
        });
		toDataURL(data.backImageUrl, function(dataUrl){
			$("#documentImage1").attr("src",dataUrl);
		});
		//$("#productImage").val(data.imageUrl);
		$("#formDocument").attr("action","/updatedocument/"+id)
		
	}, 'json');

});
