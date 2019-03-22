function Administrator()
{
this.username="";
this.password="";
this.passwordKey="";
this.emailId="";
this.firstName="";
this.lastName="";
this.mobileNumber="";
}
function AdministratorManager()
{
this.AddAdministrator=function(argument1,successHandler,exceptionHandler)
{
service.postJSON('administrator/add',{
'argument-1': argument1
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.verifyCaptcha=function(argument1,successHandler,exceptionHandler)
{
service.postJSON('administrator/verifyCaptcha',{
'argument-1': argument1
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
}
var administratorManager=new AdministratorManager();
