<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Login</title>

    <!-- Bootstrap core CSS-->
    <link href="/TMDModelApp/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/TMDModelApp/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/TMDModelApp/css/sb-admin.css" rel="stylesheet">
<script>

function processLoginForm()
{
var loginForm=$("#loginForm")
var inputEmail=loginForm.find("#inputEmail");
var errors=0;
if(!inputEmail.val().trim())
{
inputEmail.addClass("is-invalid");
errors++;
inputEmail.focus();
}
else inputEmail.removeClass("is-invalid");
var inputPassword=loginForm.find("#inputPassword");
if(!inputPassword.val().trim())
{
inputPassword.addClass("is-invalid");
errors++;
inputPassword.focus();
}
else inputPassword.removeClass("is-invalid");
if(errors>0) return false;
return true;
}
</script>
  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
          <form id='loginForm' action='/TMDModelApp/webservice/member/login' onsubmit='return processLoginForm()'>
            <div class="form-group">
              <div class="form-label-group">
                <input type="email" id="inputEmail" name='argument-1' class="form-control" placeholder="Email address" required="required" autofocus="autofocus">
                <label for="inputEmail">Email address</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" id="inputPassword" name='argument-2' class="form-control" placeholder="Password" required="required">
                <label for="inputPassword">Password</label>
              </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="remember-me">
                  Remember Password
                </label>
              </div>
            </div>
            <button type='submit' class="btn btn-primary btn-block">Login</button>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="register.html">Register an Account</a>
            <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/TMDModelApp/vendor/jquery/jquery.min.js"></script>
    <script src="/TMDModelApp/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/TMDModelApp/vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
