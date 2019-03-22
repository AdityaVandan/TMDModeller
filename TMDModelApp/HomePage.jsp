<jsp:useBean id='member' scope='session' class='com.thinking.machines.tmdmodel.services.pojo.Member'/>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/TMDModelApp/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/TMDModelApp/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/TMDModelApp/css/sb-admin.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
    
<script src="/TMDModelApp/vendor/jquery/jquery.min.js"></script>
    
<script src="/TMDModelApp/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    
<!-- Core plugin JavaScript-->
    
<script src="/TMDModelApp/vendor/jquery-easing/jquery.easing.min.js"></script>

    
<!-- Page level plugin JavaScript-->
    
<!--script src="/TMDModelApp/vendor/chart.js/Chart.min.js" /script-->
    
<script src="/TMDModelApp/vendor/datatables/jquery.dataTables.js"></script>
    
<script src="/TMDModelApp/vendor/datatables/dataTables.bootstrap4.js"></script>

    
<!-- Custom scripts for all pages-->
    
<script src="/TMDModelApp/js/sb-admin.min.js"></script>

    
<!-- Demo scripts for this page-->
    
<!--script src="/TMDModelApp/js/demo/datatables-demo.js"></script-->
    
<!--script src="/TMDModelApp/js/demo/chart-area-demo.js"></script-->

<style>
</style>
</head>
<body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

   <a class="navbar-brand mr-1" href="home.jsp">Data Modeller</a>

   <ul class='navbar-nav ml-auto'>
    <li class='nav-item'>
     <a class="nav-link" href='#' data-toggle="modal" data-target="#logoutModal">logout</a>
    </li>
   </ul>
  </nav>

  <div id="wrapper">

   <!--Sidebar-->
   <ul class="sidebar navbar-nav">
    <li class="nav-item">
     <a class="nav-link" href="home.jsp" >Options</a>
    </li>
    <li class="nav-item">
     <a class="nav-link" href="#" data-toggle="modal" data-target="#createProjectModal">Create Project</a>
    </li>
    <li class="nav-item">
     <a class="nav-link" href="#" data-toggle="modal" data-target="#openProjectModal">Open Project</a>
    </li>
   </ul>
   <div id="content-wrapper">
    <div class="container-fluid">
     <h5 class="alert-success form-control">Welcome back,${member.firstName}</h5>
${requestScope.member.firstName}
<button onclick='exampleButton()'>ex</button>
    </div>
   </div>


<!--Create Project Modal-->
  <div class="modal fade" id="createProjectModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      
   <div class="modal-dialog" role="document">
        
    <div class="modal-content">
          
     <div class="modal-header">
            
      <h5 class="modal-title" id="exampleModalLabel">Project</h5>
           
      <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              
       <span aria-hidden="true">x</span>
            
      </button>
        
     </div>
    
     <div class="modal-body">
      <div class='container-fluid'>
       <form id='createModalForm' action='/TMDModelApp/Project.jsp'>
        <div class='form-group'>
         <label for="projectNameTextField">Project Name:</label>
         <input type='text' class="form-control" id="projectNameTextField"></input>
         <label for="databaseArchitectureSelection">DatabaseArchitecture:</label>
         <select class="form-control" id="databaseArchitectureSelection">
          <option>none</option>
          <c:forEach items="${databaseArchitectures}" var="da">          
           <option value='${da.code}'><c:out value="${da.name}"></c:out></option>
          </c:forEach>
         </select>
        </div>
       </form>
      </div>
     </div>

     <div class="modal-footer">
     
      <button class="btn btn-primary" type="button" data-dismiss="modal" onclick='createProject()'>Create</button>
            
      <a class="btn btn-secondary" href="home.jsp">Cancel</a>
    
     </div>
  
    </div>

   </div>
 
  </div>


<!--Open Project Modal-->
  <div class="modal fade" id="openProjectModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      
   <div class="modal-dialog" role="document">
        
    <div class="modal-content">
          
     <div class="modal-header">
            
      <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            
      <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              
       <span aria-hidden="true">×</span>
            
      </button>
        
     </div>
    
     <div class="modal-body">
      <label for="projectSelection">Select Project:</label>
      <select id="projectSelection" class="form-control">
       <c:forEach items='${projects}' var='project'>
        <option value='${project.code}'>${project.title}</option>
       </c:forEach>
      </select>
     </div>

     <div class="modal-footer">
     
      <button class="btn btn-primary" type="button" data-dismiss="modal" onclick="openProjectFunction()">Open</button>
            
      <button class="btn btn-secondary" onclick="">Cancel</button>
    
     </div>
  
    </div>

   </div>
 
  </div>

<form id='projectForm' action='/TMDModelApp/Project.jsp'>
</form>
<!-- Logout Modal-->

  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      
   <div class="modal-dialog" role="document">
        
    <div class="modal-content">
          
     <div class="modal-header">
            
      <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            
      <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              
       <span aria-hidden="true">×</span>
            
      </button>
        
     </div>
    
     <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>

     <div class="modal-footer">
     
      <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            
      <button class="btn btn-primary" onclick="document.getElementById('logoutForm').submit()">Logout</button>
    
     </div>
  
<form id='logoutForm' action='/TMDModelApp/webservice/member/logout'>  
</form>
    </div>

   </div>
 
  </div>

<script src='/TMDModelApp/webservice/js/TMService.js'></script>
<script src='/TMDModelApp/webservice/js/member.js'></script>
<script>
function openProjectFunction()
{
var project=document.getElementById("projectSelection");
var projectValue=project.value;
var memberManager=new MemberManager();
memberManager.openProject(projectValue,function(result){
alert(result);
document.getElementById("projectForm").submit();
},function(exception){
alert(exception)
});

}
function exampleButton()
{
var projectSelection=document.getElementById('projectSelection');
}
function createProject()
{
var projectName=document.getElementById('projectNameTextField');
var da=document.getElementById('databaseArchitectureSelection');
var memberCode='${member.emailId}';
if(projectName.value.length==0)
{
return;
}
var memberManager=new MemberManager();
memberManager.createProject(projectName.value,da.value,function(result){
if(result==true)
{
document.getElementById("createModalForm").submit();
}
else alert(result+" some error");
},function(exception){
alert(exception);
});

//if for repetition of projectname0
}
</script>
</body>
</html>