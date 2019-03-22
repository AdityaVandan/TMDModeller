function LinkedList()
{
}
function TMForward()
{
}
function Member()
{
this.code=0;
this.emailId="";
this.password="";
this.firstName="";
this.lastName="";
this.mobileNumber="";
}
function MemberManager()
{
this.check=function(successHandler,exceptionHandler)
{
service.postJSON('member/check',{
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.logout=function(successHandler,exceptionHandler)
{
service.postJSON('member/logout',{
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.login=function(argument1,argument2,successHandler,exceptionHandler)
{
service.getJSON('member/login?argument-1='+encodeURI(argument1)+'&'+'argument-2='+encodeURI(argument2),null,function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.addMember=function(argument1,successHandler,exceptionHandler)
{
service.postJSON('member/add',{
'argument-1': argument1
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.createProject=function(argument1,argument2,successHandler,exceptionHandler)
{
service.postJSON('member/createProject',{
'argument-1': argument1,
'argument-2': argument2
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.openProject=function(argument1,successHandler,exceptionHandler)
{
service.postJSON('member/openProject',{
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
service.postJSON('member/verifyCaptcha',{
'argument-1': argument1
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
}
var memberManager=new MemberManager();
