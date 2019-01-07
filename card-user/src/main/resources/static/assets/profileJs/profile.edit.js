$(".addBtn").click(function() {
	$("#Submit").show();
	$("#Update").hide();
	$(".form-control").val("");
	
	$("#formSocial").attr("action","/addsocial");
	$("#formEdu").attr("action","/addeducation");
	$("#formExp").attr("action","/addexperience");	
	$("#formAch").attr("action","/addachievement");	
	$("#formSkill").attr("action","/addskill");
	$("#formProduct").attr("action","/addproduct");
		
	 $("#productImage").attr("src","assets/images/placeholder.jpg");
});



$(".editSocial").click(function() {
	
	$("#Submit").hide();
	$("#Update").show();

	var id = $(this).attr("name");
	console.log("id: " + id);

	$.get('/editsocial/'+id, function(data) {
		console.log(data);
		$("#Socialname").val(data.socialName);
		$("#SocialLink").val(data.socialLink);
		$("#formSocial").attr("action","/updatesocial/"+id)	
	}, 'json');
});



$(".editEducation").click(function() {
	
	$("#Submit").hide();
	$("#Update").show();

	var id = $(this).attr("name");
	console.log("id: " + id);

	$.get('/editeducation/'+id, function(data) {
		console.log(data);
		$("#Degree").val(data.degree);
		$("#University").val(data.university);
		$("#PassingYear").val(data.passingYear);
		$("#formEdu").attr("action","/updateeducation/"+id)	
	}, 'json');
});

$(".editExperience").click(function() {
	
	$("#Submit").hide();
	$("#Update").show();

	var id = $(this).attr("name");
	console.log("id: " + id);

	$.get('/editexperience/'+id, function(data) {
		console.log(data);
		$("#Designation").val(data.expDesignation);
		$("#Company").val(data.expCompany);
		$("#Duration").val(data.expDuration);
		$("#formExp").attr("action","/updateexperience/"+id)	
	}, 'json');

});

$(".editAchievement").click(function() {
	
	$("#Submit").hide();
	$("#Update").show();

	var id = $(this).attr("name");
	console.log("id: " + id);

	$.get('/editachievement/'+id, function(data) {
		console.log(data);
		$("#AchievementName").val(data.title);
		$("#AchievementDescription").val(data.description);
		$("#formAch").attr("action","/updateachievement/"+id)	
	}, 'json');

});


$(".editSkill").click(function() {
	
	$("#Submit").hide();
	$("#Update").show();

	var id = $(this).attr("name");
	console.log("id: " + id);

	$.get('/editskill/'+id, function(data) {
		console.log(data);
		$("#SkillName").val(data.skillName);
		$("#SkillValue").val(data.skillValue);
		$("#formSkill").attr("action","/updateskill/"+id)	
	}, 'json');

});


$(".editProduct").click(function() {
	
	$("#Submit").hide();
	$("#Update").show();
	
	var id = $(this).attr("name");
	console.log("id: " + id);

	$.get('/editproduct/'+id, function(data) {
		console.log(data);
		
		$("#Name").val(data.name);
		
		toDataURL(data.imageUrl, function(dataUrl){
            $("#productImage").attr("src",dataUrl);
        });
		
		//$("#productImage").val(data.imageUrl);
		
		$("#Description").val(data.description);
		$("#formProduct").attr("action","/updateproduct/"+id)
		
		
	}, 'json');

});


/*<button type="submit" class="btn btn-primary" id="Update" style="display: none">Update</button>*/