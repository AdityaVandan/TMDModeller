function CurrentProject()
{
this.name="";
this.tables=null;
this.width=0;
this.height=0;
}
function DatabaseArchitecture()
{
this.code=0;
this.name="";
this.databaseEngines=null;
this.databaseArchitectureDataTypes=null;
this.maxWidthOfColumnName=0;
this.maxWidthOfTableName=0;
this.maxWidthOfRelationshipName=0;
}
function ProjectManager()
{
this.getDatabaseArchitecture=function(successHandler,exceptionHandler)
{
service.postJSON('project/projectArchitecture',{
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.dBArchitectureLoader=function(successHandler,exceptionHandler)
{
service.getJSON('project/dbarchitecture',null,function(){
successHandler();
},function(exception){
exceptionHandler(exception);
});
}
this.saveProject=function(argument1,successHandler,exceptionHandler)
{
service.postJSON('project/saveProject',{
'argument-1': argument1
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.specifyCurrent=function(argument1,successHandler,exceptionHandler)
{
service.postJSON('project/specifyCurrent',{
'argument-1': argument1
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.populateProject=function(successHandler,exceptionHandler)
{
service.postJSON('project/projectDataStructure',{
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
this.drawTables=function(successHandler,exceptionHandler)
{
service.postJSON('project/drawTables',{
},
function(result){
successHandler(result);
},function(exception){
exceptionHandler(exception);
});
}
}
var projectManager=new ProjectManager();
