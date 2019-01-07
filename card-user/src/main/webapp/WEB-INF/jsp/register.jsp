<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<% 
	//int otp;
	/* if(request.getSession().getAttribute("otp")!= null ){
	otp = (Integer) request.getSession().getAttribute("otp");
	}else {
	 otp = 0;
	} */
%>

<!doctype html>
<html lang="en">

<head>
<title>:: Mplify :: Sign Up</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="description" content="Mplify Bootstrap 4.1.1 Admin Template">
<meta name="author" content="ThemeMakker, design by: ThemeMakker.com">

<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/vendor/animate-css/animate.min.css">
<link rel="stylesheet"
	href="assets/vendor/font-awesome/css/font-awesome.min.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/color_skins.css">


<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>
<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.10.2/validator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/validate.js/0.12.0/validate.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.js"></script>

</head>

<body class="theme-blue">
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle auth-main">
				<div class="auth-box">
					<div class="mobile-logo">
						<a href="index.html"><img src="assets/images/logo-icon.svg"
							alt="Mplify"></a>
					</div>
					<div class="auth-left">
						<div class="left-top">
							<a href="index.html"> <img src="assets/images/logo-icon.svg"
								alt="Mplify"> <span>Mplify</span>
							</a>
						</div>
						<div class="left-slider">
							<img src="assets/images/login/1.jpg" class="img-fluid" alt="">
						</div>
					</div>

					<div class="auth-right">


						<div class="card">
							<div class="header">
								<p class="lead">Create an account</p>
							</div>
							<div class="body">
								<form:form class="form-auth-small" action="/registeration" methot="post" modelAttribute="userReg" id="RegForm">
									
									<div id="basicRegisterDiv" style="display: block">
										<div id="MobileDiv">
											<div class="form-group">
												<label for="signup-email" class="control-label sr-only">Card Id</label> 
												<form:input type="text" class="form-control" id="cardId" path="cardId" name="cardId" value="" placeholder="Enter Your Card Id"/>
											</div>
											<div class="form-group">
												<label for="signup-email" class="control-label sr-only">User Name</label> 
												<form:input type="text" class="form-control" id="userName"  path="userName"  name="userName" placeholder="Enter User Name"/>
											</div>
											<div class="form-group">
												<label for="signup-password" class="control-label sr-only">Password</label>
												<form:input type="password" class="form-control" id="password" path="password" name="password" placeholder="Enter Password" />
											</div>
											<div class="form-group">
												<label for="signup-email" class="control-label sr-only">Enter Your Mobile No</label> 
												<form:input type="number" class="form-control"  placeholder="Enter Contact No" maxlength="10" minlength="10" id="contactNumber" path="mobile" name="contactNumber"   />
											</div>
										</div>
										<div id="OtpDiv" style="display: none;" >
											<div class="form-group">
												<label for="signup-email" class="control-label sr-only">Enter OTP</label> 
												<input type="number" class="form-control" id="otpNumber" name="otptxt" maxlength="6" placeholder="Enter OTP" />
											</div>
										</div>
										
										
										<button type="button" id="nextbtn" class="btn btn-primary btn-lg btn-block">Next</button>
										<button type="button" id=submitbtn class="btn btn-primary btn-lg btn-block" style="display: none;">Register</button>
									
									</div>
									<div class="bottom">
										<span class="text-danger">${regMessage}</span>
										<span class="helper-text">Already have an account? <a href="/login">Login</a></span>
									</div>
								</form:form>



							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>

	function mobileTOotp(){
		$("#nextbtn").hide();
		$("#MobileDiv").hide();
		$("#OtpDiv").show();
		$("#submitbtn").show();
	};
	
	function isvalid(name){
		
		if($(name).val() == ''){
			$(name).css("border-color","red");
			return false;
		}else{
			$(name).css("border-color","");
			return true;
		}
	}
	
	var ValidFlag = false; 
	$("#cardId").keyup(function(){
		isvalidcardId();
	});	
	function isvalidcardId(){
		var cardId=$("#cardId").val();
		if(cardId.length == 6){
			$.get('/checkcardid/'+cardId, function(data) {
				if(data == true){
					$("#cardId").css("border-color","green");
					ValidFlag = true;
					
				}	else{
					ValidFlag = false;
				}
			});
		}else{
			$("#cardId").css("border-color","red");
			ValidFlag = false;
		}
	}
	
	$("#nextbtn").click(function(){	
		var cId = ValidFlag;
		var uName = isvalid("#userName");
		var pass = isvalid("#password");
		var cNumber = isvalid("#contactNumber");	
		
		var contact=$("#contactNumber").val();
		
		if(contact.length == 10){
			cNumber = true
		}else{
			cNumber = false
		}
		
		
		
		if(cId && uName && pass && cNumber){	
			
			mobileTOotp();
			
			$.get('/getotp/'+contact, function(data) {
				console.log("send otp");				
			})
			.done(function() {
				$.get('/otp', function(otp) {
					console.log("get otp");
					sessionStorage.setItem('otp', otp);
				});
  			});		
		}	
		
	});
	
	$('#otpNumber').on("input", function() {
		  var otptxt = this.value;
		  var otp = sessionStorage.getItem('otp');   <%-- <%= otp%> --%>
		  if(otptxt == otp){
			  console.log("otpmatch");
			  $("#otpNumber").css("border-color","green");
			  $("#submitbtn").attr("type","submit");
			  sessionStorage.removeItem('otp');
		  }else{
			  $("#otpNumber").css("border-color","red");
			  $("#submitbtn").attr("type","button");
		  }
		  
		});
	
	</script>
		
	<!-- END WRAPPER -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>



</body>
</html>
