<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
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
.canvasStyle
{
border: 1px solid black;
overflow-x: scroll;
overflow-y: scroll;
}
</style>
</head>
<body id="page-top">

  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

   <button class="btn btn-link btn-sm text-white order-1 order-sm-01" id="sidebarToggle" href="#">
        
    <i class="fas fa-bars"></i>
      
   </button>

   <a class="navbar-brand mr-1" href="HomePage.jsp">Data Modeller</a>

    
  </nav>

  <div id="wrapper">

   <!--Sidebar-->
   <ul class="sidebar navbar-nav">
    <li class="nav-item">
     <a class="nav-link" href="HomePage.jsp">Home</a>
    </li>
    <li class="nav-item">
     <button class="nav-link bg-dark" onclick="saveChanges()">Save</button>
    </li>
    <li class="nav-item">
     <a class="nav-link" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
    </li>
   </ul>
   
   <!--Main Body-->
   <div id="content-wrapper">
    <div class="container-fluid">
     <div class="btn-toolbar bg-light" role="toolbar" aria-label="Toolbar">
      <div class="btn-group btn-group-justified overflow-auto" role=group aria-label="Tools">
       <label class="btn btn-sm" >Toolbar</label>
       <button class="btn btn-primary" id="addButton" onclick="addButtonClick()"><i class="fa fa-plus" style="color:black"></i></button>
       <button class="btn btn-link" id="deleteButton" onclick="deleteButtonClick()"><i class="fa fa-minus" style="color:black"></i></button>
       <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#scriptViewModal" onclick="scriptViewButtonClick()"><i class="fa fa-file" style="color:black"></i></a>
       <a class="btn btn-link" id="downloadImageButton" onclick="downloadImageButtonClick()"><i class="fa fa-download"></i></a>

      </div>
     </div>
<div id='canvasDivision' class='canvasStyle'>
     <canvas id="modellingCanvas" height="800" width="1000" class="canvasStyle ">
     </canvas>
</div>
    </div>
   </div>
  </div>


  <!-- Home Modal-->

  <div class="modal fade" id="homeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      
   <div class="modal-dialog" role="document">
        
    <div class="modal-content">
          
     <div class="modal-header">
            
      <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            
      <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              
       <span aria-hidden="true">×</span>
            
      </button>
        
     </div>
    
     <div class="modal-body">Select "Leave" below if you are ready to end your current session.</div>

     <div class="modal-footer">
     
      <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            
      <a class="btn btn-primary" href="HomePage.jsp">Leave</a>
    
     </div>
  
    </div>

   </div>
 
  </div>



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



  <!-- Script View Modal-->

  <div class="modal fade" id="scriptViewModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      
   <div class="modal-dialog modal-lg" role="document">
        
    <div class="modal-content">
          
     <div class="modal-header">
            
      <h5 class="modal-title" id="scriptViewModalLabel">Script Generation</h5>
            
      <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              
       <span aria-hidden="true">×</span>
            
      </button>
        
     </div>
    

     <div class="modal-body">
      <div class="container-fluid">
       <label class="col-form-label" style="color:blue;font-size:20pt">Select tables required for script generation: </label>
       <form id="tableForm">
        <div id="tableSelectionDivision" class="form-group row">
         <label class="col-sm-10 col-form-label">Table Name</label>
         <div class="col-sm-2 checkbox">
          <input type="checkbox" class="form-control sm" id="t-1">
         </div> 
        </div>
       </form>
      </div>
     </div>




     <div class="modal-footer">
     
      <button class="btn btn-primary" type="button" onclick="generateScript()">Generate</button>
            
      <button class="btn btn-default" data-dismiss="modal">Cancel</button>
    
     </div>
  

    </div>

   </div>
 
  </div>







  <!--Table Modal-->
  <div class="modal fade" id="tableModal" tabindex="-1" role="dialog" aria-abelledby="tableModalLabel" aria-hidden="true">
   <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
     <div class="modal-header">
      <h5 class="modal-title" id="ariaModalLabel">Table Config</h5>
      <button class="close" type="button" data-dismiss="modal" aria-label="Close" onclick='okFunction()'>
              
       <span aria-hidden="true">×</span>
            
      </button>
        
     </div>
     <div class="modal-body">
      <div class="container-fluid">
       <form id="tableForm">
        <div class="form-group row">
         <label class="col-sm-2 col-form-label">Table Name</label>
         <div class="col-sm-10">
          <input type="text" class="form-control" id="tableName">
         </div> 
        </div>
        <h3>Table</h3>
        <ul class="nav nav-tabs">
         <li class="active">
          <a class="nav-link active" data-toggle="tab" href="#tableModalTableTab">Description</a>
         </li>
         <li>
          <a class="nav-link" data-toggle="tab" href="#tableModalAttributeTab">Table View</a>
         </li>
         <li>
          <a class="nav-link hidden" data-toggle="tab" href="#addAttributeTab">Attribute</a>
         </li>
        </ul>
       </form>
<!--tab content-->
<div class="tab-content">
 <div id="tableModalTableTab" class="tab-pane fade in active">
  <div class="form-group">
   <label for="tableNote">Table description:</label>
   <textarea class="form-control" rows="5" id="tableNote"></textarea>
   <label for="tableEngine">Engine:</label>
   <select class="form-control" id="tableEngine">
   
   </select>
   <button type=button class="btn btn-primary" align='center' onclick="okFunction()">Ok</button>
  </div>
 </div>
 
 <div id="addAttributeTab" class="tab-pane fade">
  <div class="form-group">
   <label for="attributeName">Attribute Name</label>
   <input type="text" class="form-control" id="attributeName" name="attributeName"></input>
   <label for="attributeType">Attribute Type</label>
   <select class="form-control" id="attributeType">
    <option>Integer</option>
   </select>
   <label for="attributeLength">Length</label>
   <input type="number" class="form-control" id="attributeLength" name="attributeLength"></input>
   <div class="checkbox">
    <label class="checkbox-inline"><input type="checkbox" id="pk" value="">isPrimaryKey</label>
    <label class="checkbox-inline"><input type="checkbox" id="un" value="">isUnique</label>
    <label class="checkbox-inline"><input type="checkbox" id="nn" value="">isNotNull</label>
    <label class="checkbox-inline"><input type="checkbox" id="ai" value="">isAutoIncrement</label>
    
   </div>
   <label for="contraint">Check Contraint</label>
   <input type="text" class="form-control" id="constraint">
   <label for="def">Def</label>
   <input type="text" class="form-control" id="def">
   <label for="fieldNote">Note</label>
   <textarea class="form-control" id="fieldNote" rows="5"></textarea>
  </div>
  <div class="form-group">
   <button type="button" class="btn btn-block btn-primary" onclick="addAttribute()">Add</button>
  </div>
 </div>


 <div id="tableModalAttributeTab" class="tab-pane fade">
  <table class="table table-bordered" id="tableView">
   <thead>
    <tr>
    <th>S.No.</th>
    <th>Field   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
    <th>Type</th>
    <th>Check Constraint</th>
    <th>Def</th>
    <th>Options</th>
    <th>Contstraints</th>
    </tr>
   </thead>
  </table>
  <div class="btn-group">
   <button type="button" class="btn btn-primary" onclick="okFunction()">Ok</button>
   <button class="btn btn-default" type='button' onclick="removeAll()">default</button>
  </div>
 </div>
</div>



      </div>
     </div>
    </div>
   </div>
  </div>

<script src="/TMDModelApp/webservice/js/TMService.js"></script>
<script src="/TMDModelApp/webservice/js/project.js"></script>
<script>
var engines;
var architectureDataTypes;
var architectureName="";
var projectName="";
function setupModalSelection()
{
var manager=new ProjectManager();
manager.getDatabaseArchitecture(function(result){
console.log(result);
engines=result.databaseEngines;
architectureDataTypes=result.databaseArchitectureDataTypes;
architectureName=result.name;
engines=result.databaseEngines;
var tableEngine=document.getElementById("tableEngine");
var attributeType=document.getElementById("attributeType");
var eng;
for(i=0;i<architectureDataTypes.length;i++)
{
attributeType.options[i]=new Option(architectureDataTypes[i].dataType,architectureDataTypes[i].code);
}
for(j=0;j<engines.length;j++) tableEngine.options[j]=new Option(engines[j].name,engines[j].code);
drawPreviousTables();

},
function(exception){
alert(exception);
});
}
function setupPage()
{
setupModalSelection();
}

function drawPreviousTables()
{
var projectManager=new ProjectManager();
projectManager.drawTables(function(currentProject){
console.log(currentProject);
var previousCanvas=document.getElementById("modellingCanvas");
projectName=currentProject.name;
previousCanvas.width=currentProject.width;
previousCanvas.hieght=currentProject.height;
var tableComponent;
var databaseTable;
var field;
for(var i=0;i<currentProject.tables.length;i++)
{
tableComponent=new TableComponent(currentProject.tables[i].x,currentProject.tables[i].y,currentProject.tables[i].name);
tableComponent.databaseTable.code=currentProject.tables[i].code;
tableComponent.databaseTable.name=currentProject.tables[i].name;
tableComponent.projectCode=currentProject.tables[i].projectCode;
tableComponent.databaseTable.databaseEngine=currentProject.tables[i].databaseEngineCode;
tableComponent.databaseTable.note=currentProject.tables[i].note;
tableComponent.databaseTable.numberOfFields=currentProject.tables[i].numberOfFields;
for(var j=0;j<currentProject.tables[i].fields.length;j++)
{
field=new Field();
field.serialNumber=currentProject.tables[i].fields[j].serialNumber;
field.code=currentProject.tables[i].fields[j].code;
field.name=currentProject.tables[i].fields[j].name;
field.tableCode=currentProject.tables[i].fields[j].tableCode;
field.databaseArchitectureDataType=currentProject.tables[i].fields[j].databaseArchitectureDataType;
field.databaseArchitectureDataTypeName=currentProject.tables[i].fields[j].databaseArchitectureDataTypeName;
field.width=currentProject.tables[i].fields[j].width;
field.numberOfDecimalPlaces=currentProject.tables[i].fields[j].numberOfDecimalPlaces;
field.isPrimaryKey=currentProject.tables[i].fields[j].isPrimaryKey;
field.isUnique=currentProject.tables[i].fields[j].isUnique;
field.isNotNull=currentProject.tables[i].fields[j].isNotNull;
field.isAutoIncrement=currentProject.tables[i].fields[j].isAutoIncrement;
field.defaultValue=currentProject.tables[i].fields[j].defaultValue;
field.checkConstraint=currentProject.tables[i].fields[j].checkConstraint;
field.note=currentProject.tables[i].fields[j].note;
tableComponent.databaseTable.fields.push(field);
}
tables.push(tableComponent);
tableComponent.draw();
}




},function(exception){
alert(exception)
});

}



window.onload=setupPage;



</script>


<script>
function removeAll()
{
alert('chala')
$("#tableView tbody").empty();
}

//var saved=true;
var drawingAllTables=false;
var selectedTable=null;
var currentTable=null;
var tableNum=1;
var defaultRectSizeHeight=100;
var defaultRectSizeWidth=200;
var addButtonClicked=0;
var currentEvent=0;
var NONE=0;
var CREATE_TABLE=1;
var DELETE_TABLE=2;
var tables=[];
var headerColor="red";
var rowColor="#555";
var headerFont="20pt Calibri bold";
var rowFont="14pt Calibri";
function Field()
{
this.serialNumber=0;
this.code=0;
this.name="";
this.tableCode=0;
this.databaseArchitectureDataType=architectureDataTypes[0].code;
this.databaseArchitectureDataTypeName="";
this.width=0;
this.numberOfDecimalPlaces=0;
this.isPrimaryKey=false;
this.isAutoIncrement=false;
this.isUnique=false;
this.isNotNull=false;
this.defaultValue="";
this.checkConstraint="";
this.note="";
}
function DatabaseTable()
{
this.code=0;
this.name="";
this.projectCode=0;
this.databaseEngine=engines[0].code;
this.note="";
this.numberOfFields=0;
this.fields=[];
}
function ProjectTable()
{
this.code=0;
this.name="";
this.projectCode=0;
this.databaseEngine="";
this.databaseEngineCode=0;
this.note="";
this.x=0;
this.y=0;
this.numberOfFields=0;
this.fields=null;
this.width=0;
this.height=0;
}
function ProjectTableField()
{
this.code=0;
this.serialNumber=0;
this.name="";
this.tableCode=0;
this.databaseArchitectureDataTypeName="";
this.databaseArchitectureDataType=0;
this.width=0;
this.numberOfDecimalPlaces=0;
this.isPrimaryKey=false;
this.isUnique=false;
this.isAutoIncrement=false;
this.isNotNull=false;
this.defaultValue="";
this.checkConstraint="";
this.note="";
}
function saveChanges()
{
//check boxes
var currentProject=new CurrentProject();
var projectTables=[];
var projectTable;
var projectTableFields=[];
var projectTableField;
currentProject.name="${currentProject.title}";
currentProject.width=canvas.width;
currentProject.height=canvas.height;

for(var i=0;i<tables.length;i++)
{
projectTable=new ProjectTable();
projectTable.name=tables[i].databaseTable.name;
projectTable.projectCode=${currentProject.code};
projectTable.databaseEngineCode=parseInt(tables[i].databaseTable.databaseEngine);
projectTable.databaseEngine=tables[i].databaseTable.databaseEngine;
projectTable.note=tables[i].databaseTable.note;
//alert(projectTable.xCoor);
projectTable.x=tables[i].drawableTable.xCoor;
projectTable.y=tables[i].drawableTable.yCoor;
projectTable.numberOfFields=tables[i].databaseTable.fields.length;
projectTable.width=tables[i].drawableTable.width;
projectTable.height=tables[i].drawableTable.height;
projectTableFields=new Array();
for(var j=0;j<tables[i].databaseTable.fields.length;j++)
{
projectTableField=new ProjectTableField();
projectTableField.serialNumber=j+1;
projectTableField.name=tables[i].databaseTable.fields[j].name;
projectTableField.tableCode=0;//prob
projectTableField.databaseArchitectureDataType=parseInt(tables[i].databaseTable.fields[j].databaseArchitectureDataType);
projectTableField.databaseArchitectureDataTypeName=tables[i].databaseTable.fields[j].databaseArchitectureDataTypeName;
projectTableField.width=tables[i].databaseTable.fields[j].width;
projectTableField.numberOfDecimalPlaces=tables[i].databaseTable.fields[j].numberOfDecimalPlaces;
projectTableField.isPrimaryKey=tables[i].databaseTable.fields[j].isPrimaryKey;
projectTableField.isAutoIncrement=tables[i].databaseTable.fields[j].isAutoIncrement;
projectTableField.isUnique=tables[i].databaseTable.fields[j].isUnique;
projectTableField.isNotNull=tables[i].databaseTable.fields[j].isNotNull;
projectTableField.defaultValue=tables[i].databaseTable.fields[j].defaultValue;
projectTableField.checkConstraint=tables[i].databaseTable.fields[j].checkConstraint;
projectTableField.note=tables[i].databaseTable.fields[j].note;
projectTableFields.push(projectTableField);
}
projectTable.fields=projectTableFields;
projectTables.push(projectTable);
}
currentProject.tables=projectTables;
console.log(currentProject);
var projectManager=new ProjectManager();
projectManager.saveProject(currentProject,function(result){
alert(result);
},function(exception){
alert(exception);
});
}

function calculateDimensions(databaseTable)
{
this.dimensions=[];
this.dimensions[0]=0;
this.dimensions[1]=0;
var context=canvas.getContext('2d');
context.font=headerFont;
this.headerMetrics=context.measureText(databaseTable.name);
context.font=rowFont;
this.rowWidth=0;
this.rowMetrics=this.headerMetrics;
var fieldString;
this.tempMetrics=null;
for(i=0;i<databaseTable.fields.length;i++)
{
fieldString=databaseTable.fields[i].name+" "+databaseTable.fields[i].databaseArchitectureDataTypeName+" "+databaseTable.fields[i].checkConstraint+" ";
if(databaseTable.fields[i].isPrimaryKey) fieldString=fieldString+"PK ";
if(databaseTable.fields[i].isUnique) fieldString=fieldString+"UN ";
if(databaseTable.fields[i].isNotNull) fieldString=fieldString+"NN ";
if(databaseTable.fields[i].isAutoIncrement) fieldString=fieldString+"AI";
this.tempMetrics=context.measureText(fieldString);
if(rowWidth<tempMetrics.width)
{
this.rowMetrics=this.tempMetrics;
rowWidth=tempMetrics.width;
}
//alert(rowWidth+" "+this.rowMetrics.width+" "+this.tempMetrics.width+" "+this.headerMetrics.width);

}
this.rowMetrics.height=20;
if(this.rowMetrics.width>this.headerMetrics.width) dimensions[0]=this.rowMetrics.width+100;
else dimensions[0]=this.headerMetrics.width+100;
var h1,h2;
if(databaseTable.fields.length>0) dimensions[1]=databaseTable.fields.length*(this.rowMetrics.height)+5*(databaseTable.fields.length)+40+5;
else dimensions[1]=databaseTable.fields.length*(this.rowMetrics.height)+45;
return dimensions;
}
function DrawableTable(xCoor,yCoor,databaseTable)
{
this.defaultWidth=defaultRectSizeWidth;
this.defaultHeight=defaultRectSizeHeight;
this.width=0;
this.height=0;
this.xCoor=xCoor;
this.yCoor=yCoor;
this.databaseTable=databaseTable;
var that=this;
this.draw=function(){
var context=canvas.getContext('2d');
this.dimensions=calculateDimensions(databaseTable);
width=dimensions[0];
height=dimensions[1];
var diff=0;
if(canvas.height<yCoor+height+20)
{
diff=yCoor+height+20-canvas.height;
canvas.height=(canvas.height+diff+100);
}
if(canvas.width<xCoor+width+20)
{
diff=xCoor+width+20-canvas.width;
canvas.width=(canvas.width+diff+100);
}
context.beginPath();
context.clearRect(xCoor,yCoor,width,height);
context.rect(xCoor,yCoor,width,height);
//alert(xCoor+" "+yCoor+" "+width+" "+height);
context.font=headerFont;
context.moveTo(xCoor,yCoor+40);
context.lineTo(xCoor+width,yCoor+40);
context.fillStyle=headerColor;
context.font=headerFont;
context.fillText(databaseTable.name,xCoor+20,yCoor+27);
context.fillStyle=rowColor;
context.font=rowFont;
context.fillStyle=rowColor;
var fieldString="";
for(i=0;i<databaseTable.fields.length;i++)
{
if(databaseTable.fields[i].width==0) fieldString=databaseTable.fields[i].name+" "+databaseTable.fields[i].databaseArchitectureDataTypeName+" "+databaseTable.fields[i].checkConstraint;
else fieldString=databaseTable.fields[i].name+" "+databaseTable.fields[i].databaseArchitectureDataTypeName+"("+databaseTable.fields[i].width+")"+" "+databaseTable.fields[i].checkConstraint;
if(databaseTable.fields[i].isPrimaryKey) fieldString=fieldString+"PK ";
if(databaseTable.fields[i].isUnique) fieldString=fieldString+"UN ";
if(databaseTable.fields[i].isNotNull) fieldString=fieldString+"NN ";
if(databaseTable.fields[i].isAutoIncrement) fieldString=fieldString+"AI";
context.fillText(fieldString,xCoor+20,yCoor+40+(i+1)*20+(i+1)*5); //20->rowMetrics.height
}
context.stroke();
that.width=width;
that.height=height;
if(diff!=0)
{
//console.log(diff+" "+databaseTable.name);
drawAllTables();
}
};

}
function drawAllTables()
{
//alert(tables.length+" draw All tables")
var context=canvas.getContext('2d');
context.clearRect(0,0,canvas.width,canvas.height);
for(var i=0;i<tables.length;i++)
{
//alert("table"+" "+i);
tables[i].draw();
}
}
function TableComponent(xCoor,yCoor,name)
{
this.x=xCoor;
this.y=yCoor;
this.databaseTable=new DatabaseTable();
this.databaseTable.name=name;
this.drawableTable=new DrawableTable(xCoor,yCoor,this.databaseTable);
this.draw=function()
{
this.drawableTable.draw();
};
}
function createModalTable()
{
var tableEngine=document.getElementById("tableEngine");
var databaseTable=currentTable.databaseTable;
var serial=1;
//alert(currentTable.databaseTable.databaseEngine);
for(i=0;i<tableEngine.options.length;i++)
{
//alert(tableEngine.options[i].);
if(tableEngine.options[i].value==currentTable.databaseTable.databaseEngine) tableEngine.selectedIndex=i;
}
$("#tableView tbody").empty();
var modalTable=document.getElementById('tableView');
var tableBody=document.createElement('tbody');
tableBody.id='tableBody';
var td;
var tr;
this.editRowEvent=function(a)
{
return function(){
alert(edit)
};
};
this.deleteRowEvent=function(a)
{
return function(){
databaseTable.fields.splice(a,1);
createModalTable();
};
};
this.swap=function(x,y)
{
return function(){
if(x<0 || y>=databaseTable.fields.length) return;
var z=databaseTable.fields[x];
databaseTable.fields[x]=databaseTable.fields[y];
databaseTable.fields[y]=z;
createModalTable();
};
};
var stg="";
for(var i=0;i<databaseTable.fields.length;i++)
{
tr=document.createElement('tr');
td=document.createElement('td');
td.innerHTML=i+1;
td.id=databaseTable.fields[i].name+"1";
tr.appendChild(td);
td=document.createElement('td');
td.innerHTML=databaseTable.fields[i].name;
td.id=databaseTable.fields[i].name+"2";
tr.appendChild(td);
td=document.createElement('td');
if(databaseTable.fields[i].width==0) td.innerHTML=databaseTable.fields[i].databaseArchitectureDataTypeName;
else td.innerHTML=databaseTable.fields[i].databaseArchitectureDataTypeName+"("+databaseTable.fields[i].width+")";
td.id=databaseTable.fields[i].name+"3";
tr.appendChild(td);
td=document.createElement('td');
td.innerHTML=databaseTable.fields[i].checkConstraint;
td.id=databaseTable.fields[i].name+"4";
tr.appendChild(td);
td=document.createElement('td');
td.innerHTML=databaseTable.fields[i].defaultValue;
td.id=databaseTable.fields[i].name+"5";
tr.appendChild(td);
td=document.createElement('button');
td.innerHTML='edit';
td.setAttribute('class','btn btn-primary');
td.id=databaseTable.fields[i].name+"6";
td.onclick=this.editRowEvent(i);
tr.appendChild(td);
td=document.createElement('button');
td.innerHTML='delete';
td.setAttribute('class','btn btn-default');
td.id=databaseTable.fields[i].name+"7";
td.onclick=deleteRowEvent(i,databaseTable);
tr.appendChild(td);
td=document.createElement('button');
td.innerHTML='up';
td.setAttribute('class','btn btn-primary');
td.id=databaseTable.fields[i].name+"8";
td.onclick=this.swap(i-1,i);
tr.appendChild(td);
td=document.createElement('button');
td.innerHTML='down';
td.setAttribute('class','btn btn-default');
td.id=databaseTable.fields[i].name+"9";
td.onclick=swap(i,i+1);
tr.appendChild(td);
stg="";
td=document.createElement('td');
if(databaseTable.fields[i].isPrimaryKey) stg=stg+"PK ";
if(databaseTable.fields[i].isNotNull) stg=stg+"NN ";
if(databaseTable.fields[i].isUnique) stg=stg+"UN ";
if(databaseTable.fields[i].isAutoIncrement) stg=stg+"AI ";
td.innerHTML=stg;
td.id=databaseTable.fields[i].name+"10";
tr.appendChild(td);
tableBody.appendChild(tr);
}
modalTable.appendChild(tableBody);
}
function addButtonClick()
{
if(addButtonClicked==NONE) currentEvent=addButtonClicked=CREATE_TABLE;
else currentEvent=addButtonClicked=NONE;
}
function deleteButtonClick()
{
currentEvent=DELETE_TABLE;
if(selectedTable)
{
for(i=0;i<tables.length;i++)
{
if(tables[i]==selectedTable)
{
tables.splice(i,1);
drawAllTables();
break;
}
}
}
currentEvent=NONE;
}
function scriptViewButtonClick()
{
var tableForm=document.getElementById("tableForm");
while(tableForm.firstChild) tableForm.removeChild(tableForm.firstChild);
var tableDivision;
var tableLabel;
var checkBoxDivision;
var tableCheckBox;
var selectAllCheckBox;
tableDivision=document.createElement("div");
tableDivision.setAttribute("class","form-group row");
tableLabel=document.createElement("label");
tableLabel.setAttribute("class","col-sm-10 col-form-label");
tableLabel.innerHTML="Select All";
tableLabel.style.fontWeight="900";
checkBoxDivision=document.createElement("div");
checkBoxDivision.setAttribute("class","col-sm-2 checkbox");
tableCheckBox=document.createElement("input");
tableCheckBox.setAttribute("type","checkbox");
tableCheckBox.setAttribute("class","form-control sm");
tableCheckBox.id="scriptCheckBox";
tableCheckBox.checked=true;
checkBoxDivision.appendChild(tableCheckBox);
tableDivision.appendChild(tableLabel);
tableDivision.appendChild(checkBoxDivision);
tableForm.appendChild(tableDivision);
selectAllCheckBox=tableCheckBox;
for(var i=0;i<tables.length;i++)
{
tableDivision=document.createElement("div");
tableDivision.setAttribute("class","form-group row");
tableLabel=document.createElement("label");
tableLabel.setAttribute("class","col-sm-10 col-form-label");
tableLabel.innerHTML=tables[i].databaseTable.name;
checkBoxDivision=document.createElement("div");
checkBoxDivision.setAttribute("class","col-sm-2 checkbox");
tableCheckBox=document.createElement("input");
tableCheckBox.setAttribute("type","checkbox");
tableCheckBox.setAttribute("class","form-control sm");
tableCheckBox.id="scriptCheckBox"+i;
tableCheckBox.checked=true;
checkBoxDivision.appendChild(tableCheckBox);
tableDivision.appendChild(tableLabel);
tableDivision.appendChild(checkBoxDivision);
tableForm.appendChild(tableDivision);
}
selectAllCheckBox.addEventListener('change',function()
{
if(this.checked)
{
for(var x=0;x<tables.length;x++) document.getElementById("scriptCheckBox"+x).checked=true;
}
else
{
for(var x=0;x<tables.length;x++) document.getElementById("scriptCheckBox"+x).checked=false;
}
});

}
function downloadImageButtonClick()
{
var downloadImageButton=document.getElementById("downloadImageButton");
var image=canvas.toDataURL("image/png").replace("imag/png","image/octet-stream");
downloadImageButton.download=projectName+".png";
downloadImageButton.setAttribute("href",image);
}

function clearAttributeTab()
{
$("#attributeName").val("");
$("#attributeType option:eq(1)");
$("#attributeLength").val(0);
$("#constraint").val("");
$("#def").val("");
$("#fieldNote").val("");
}
function okFunction()
{
var engine=document.getElementById("tableEngine");
currentTable.databaseTable.name=tableName.value;
currentTable.databaseTable.note=tableNote.value;
currentTable.databaseTable.databaseEngine=engine.value;
clearAttributeTab();
currentTable.draw();
currentTable=null;
$("#tableModal").modal('toggle');

}
function addAttribute()
{
var attributeName=document.getElementById("attributeName");
var attributeType=document.getElementById("attributeType");
var constraint=document.getElementById("constraint");
var def=document.getElementById("def");
var attributelength=document.getElementById("attributeLength");
var fieldNote=document.getElementById("fieldNote");
var field=new Field();
if(attributeName.value=="")
{
alert("problem adding field");
return;
}
field.serialNumber=currentTable.databaseTable.fields.length+1;
field.name=attributeName.value;
field.databaseArchitectureDataType=attributeType.value;
//alert(attributeType.value);
field.databaseArchitectureDataTypeName=architectureDataTypes[attributeType.value-1].dataType;
if(document.getElementById("ai").checked) field.isAutoIncrement=true;
if(document.getElementById("pk").checked) field.isPrimaryKey=true;
else
{
if(document.getElementById("nn").checked) field.isNotNull=true;
if(document.getElementById("un").checked) field.isUnique=true;
}
field.checkConstraint=constraint.value;
field.defaultValue=def.value;
field.width=attributeLength.value;
field.note=fieldNote.value;
currentTable.databaseTable.fields.push(field);
clearAttributeTab();
createModalTable();
}
function drawSelectedTable(x,y)
{
var tableComp=findTableComponent(x,y);
var context=canvas.getContext('2d');
if(tableComp)
{
if(selectedTable==tableComp)
{
context.clearRect(0,0,canvas.width,canvas.height);
selectedTable=null;
drawAllTables();
return;
}
selectedTable=tableComp;
var xCoor=tableComp.drawableTable.xCoor;
var yCoor=tableComp.drawableTable.yCoor;
var width=tableComp.drawableTable.width;
var height=tableComp.drawableTable.height;
context.clearRect(0,0,canvas.width,canvas.height);
drawAllTables();
context.beginPath();
context.fillStyle="blue";
context.arc(xCoor,yCoor,4,0,2*Math.PI);
context.fill();
context.stroke();
context.beginPath();
context.arc(xCoor+width,yCoor,4,0,2*Math.PI);
context.fill();
context.stroke();
context.beginPath();
context.arc(xCoor,yCoor+height,4,0,2*Math.PI);
context.fill();
context.stroke();
context.beginPath();
context.arc(xCoor+width,yCoor+height,4,0,2*Math.PI);
context.fill();
context.stroke();
}
else
{
context.clearRect(0,0,canvas.width,canvas.height);
selectedTable=null;
drawAllTables();
return;
}


}

var canvas=document.getElementById("modellingCanvas");
canvas.addEventListener('click',function(evt){
if(addButtonClicked==NONE)
{
var rect=canvas.getBoundingClientRect();
var xCoor=evt.clientX-rect.left;
var yCoor=evt.clientY-rect.top;
//alert("dud")
drawSelectedTable(xCoor,yCoor);
return;
}
var context=canvas.getContext('2d');
var rect=canvas.getBoundingClientRect();
var mousePosX=evt.clientX-rect.left;
var mousePosY=evt.clientY-rect.top;
//context.beginPath();
originalPosx=mousePosX-defaultRectSizeWidth/2;
originalPosy=mousePosY-defaultRectSizeHeight/4;
/*context.clearRect(originalPosx,originalPosy,defaultRectSizeWidth,defaultRectSizeHeight);
context.rect(originalPosx,originalPosy,defaultRectSizeWidth,defaultRectSizeHeight);
context.font="20pt Calibri bold";
context.fillStyle=headerColor;
context.fillText("table-"+tableNum,originalPosx+20,originalPosy+27);
context.moveTo(originalPosx,originalPosy+40);
context.lineTo(originalPosx+defaultRectSizeWidth,originalPosy+40);
context.stroke();*/
var tableComp=new TableComponent(originalPosx,originalPosy,"table-"+tableNum);
tableNum++;
tableComp.draw();
tables.push(tableComp);
currentEvent=addButtonClicked=NONE;
});

function findTableComponent(xPos,yPos)
{
var tableComponent;
for(i=0;i<tables.length;i++)
{
tableComponent=tables[i];
//alert(tableComponent.drawableTable.height)
if(xPos>tableComponent.x && xPos<(tableComponent.x+tableComponent.drawableTable.width)) if(yPos>tableComponent.y && yPos<(tableComponent.y+tableComponent.drawableTable.height)) return tableComponent;
}
}
canvas.addEventListener('dblclick',function(evt){
var rect=canvas.getBoundingClientRect();
var mousePosX=evt.clientX-rect.left;
var mousePosY=evt.clientY-rect.top;
var tableModal=$("#tableModal");
tableComponent=findTableComponent(mousePosX,mousePosY);
if(tableComponent==null) return;
$("#tableName").val(tableComponent.databaseTable.name);
$('#tableNote').val(tableComponent.databaseTable.note);
currentTable=tableComponent;
createModalTable();
tableModal.modal({
keyboard: false,
backdrop: 'static'
});
});




</script>



</body>
</html>