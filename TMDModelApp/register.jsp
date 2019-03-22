<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin - Register</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
<script src='/TMDModelApp/webservice/js/TMService.js'></script>
<script src='/TMDModelApp/webservice/js/member.js'></script>
<script>
function processRegistrationForm()
{
var registrationForm=$("#registrationForm");
var errors=0;
var firstName=registrationForm.find("#firstName");
if(!firstName.val().trim())
{
firstName.addClass("is-invalid");
errors++;
if(errors<=1) firstName.focus();
}
else
{
firstName.removeClass("is-invalid");
}
var lastName=registrationForm.find("#lastName");
if(!lastName.val().trim())
{
lastName.addClass("is-invalid");
errors++;
if(errors<=1) lastName.focus();
}
else
{
lastName.removeClass("is-invalid");
}

var mailID=registrationForm.find("#mailID");
if(!mailID.val().trim())
{
mailID.addClass("is-invalid");
errors++;
if(errors<=1) mailID.focus();
}
else
{
mailID.removeClass("is-invalid");
}

var mobileNumber=registrationForm.find("#mobileNumber");
if(!mobileNumber.val().trim())
{
mobileNumber.addClass("is-invalid");
errors++;
if(errors<=1) mobileNumber.focus();
}
else
{
mobileNumber.removeClass("is-invalid");
}

var inputPassword=registrationForm.find("#inputPassword");
if(!inputPassword.val().trim())
{
inputPassword.addClass("is-invalid");
errors++;
if(errors<=1) inputPassword.focus();
}
else
{
inputPassword.removeClass("is-invalid");
}

var confirmPassword=registrationForm.find("#confirmPassword");
if(!confirmPassword.val().trim())
{
confirmPassword.addClass("is-invalid");
errors++;
if(errors<=1) confirmPassword.focus();
}
else
{
confirmPassword.removeClass("is-invalid");
}
var member=new Member();
member.emailId=mailID.val();
member.firstName=firstName.val();
member.lastName=lastName.val();
member.password=inputPassword.val();
member.mobileNumber=mobileNumber.val();
var manager=new MemberManager();
alert(JSON.stringify(member));
//alert(member);
manager.addMember(member,function(result){
alert(result);
alert(JSON.stringify(result));
},function(result){
alert(result);
alert(JSON.stringify(result));
});
}
</script>

</head>
<body class="bg-dark">

  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
        <div class="card-body">
          <form id='registrationForm' action='/TMDModelApp/index.html'>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="firstName" class="form-control" placeholder="First name" required="required" autofocus="autofocus">
                    <label for="firstName">First name</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="lastName" class="form-control" placeholder="Last name" required="required">
                    <label for="lastName">Last name</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="email" id="mailID" class="form-control" placeholder="Email address" required="required">
                <label for="mailID">Email address</label>
              </div>
            </div>

            <div class="form-group">
              <div class="form-label-group">
                <input type="text" id="mobileNumber" class="form-control" placeholder="mobileNumber" required="required">
                <label for="mobileNumber">Mobile Number</label>
              </div>
            </div>


            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
                    <label for="inputPassword">Password</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm password" required="required">
                    <label for="confirmPassword">Confirm password</label>
                  </div>
                </div>
              </div>
            </div>


<div class='card card-register mx-auto mt-1'>
<div class='card-header'>Input security</div>
<div class='card-body'>
<div class='form-group'>
<div class='form-row'>
<div class='col-md-6'>
<img src='webservice/captcha' />
</div>
<div class='col-md-6'>
<div class='form-label-group'>
<input type='text' id='captchaCode' placeholder='CAPTCHA' required='required' class='form-control'>
<label for='captchaCode'>CAPTCHA</label>
</div>
</div>
</div>
</div>
</div> <!-- card body -->
</div> <!-- card -->



            <button type='button' onclick='processRegistrationForm()' class="btn btn-primary btn-block">Register</button>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="login.html">Login Page</a>
            <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
