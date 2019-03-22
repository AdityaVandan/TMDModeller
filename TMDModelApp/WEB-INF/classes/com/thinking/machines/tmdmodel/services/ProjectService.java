package com.thinking.machines.tmdmodel.services;
import com.thinking.machines.tmdmodel.services.pojo.*;
import com.thinking.machines.tmdmodel.Utilities.*;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.tmws.captcha.*;
import com.thinking.machines.tmws.*;
import com.thinking.machines.dmframework.*;
import com.thinking.machines.dmframework.exceptions.*;
import javax.servlet.*;
import javax.servlet.http.*;
@Path("/project")
public class ProjectService
{
private ServletContext servletContext;
private HttpSession session;
public void setHttpSession(HttpSession session)
{
this.session=session;
}
public void setServletContext(ServletContext servletContext)
{
this.servletContext=servletContext;
}
/*@Path("create")
@InjectSession
public TMForward create(Project project)
{
if(project.getTitle()==null) return TMForward('/home.jsp');
if(project.getDatabaseArchitecture()==null) return TMForward("/home.jsp");
com.thinking.machines.tmdmodel.dl.Project dlProject=new com.thinking.machines.tmdmodel.dl.Project();
dlProject.setTitle(project.getTitle());
dlProject.setDatabaseArchitecture(project.getDatabaseArchitecture());
java.util.Date newDate=new java.util.Date();
Date date=new Date(newDate.getTime());
java.text.SimpleDateFormat simpleDateFormat=new java.text.SimpleDateFormat("dd/mm/yy");
dlProject.setDate(date);
dl
//chud gayi hai

try
{
DataMangaer dataManager=new DataManager();
dataManager.begin();
dataManager.insert(dlProject);
dataManager.end();
return new TMForward("/ProjectView.jsp");
}catch(DMFramewrokException dmException)
{
}
catch(ValidatorException ve)
{
}
}
*/
@InjectApplication
@OnStart(1)
@Path("dbarchitecture")
public void dBArchitectureLoader()
{
java.util.List<com.thinking.machines.tmdmodel.dl.DatabaseArchitecture> dlArchitectureList;
java.util.List<DatabaseArchitecture> architectureList=new java.util.LinkedList<>();
DatabaseArchitecture architecture=null;

java.util.List<com.thinking.machines.tmdmodel.dl.DatabaseEngine> dlDatabaseEngineList;
java.util.List<com.thinking.machines.tmdmodel.dl.DatabaseArchitectureDataType> dlDataTypeList;
java.util.List<DatabaseEngine> databaseEngineList=new java.util.LinkedList<>();
java.util.List<DatabaseArchitectureDataType> dataTypeList=new java.util.LinkedList<>();
DatabaseEngine databaseEngine;
DatabaseArchitectureDataType dataType;

try
{
DataManager dataManager=new DataManager();
dataManager.begin();
dlArchitectureList=dataManager.select(com.thinking.machines.tmdmodel.dl.DatabaseArchitecture.class).query();
System.out.println("Architectures");
for(com.thinking.machines.tmdmodel.dl.DatabaseArchitecture dlObject: dlArchitectureList)
{
architecture=new DatabaseArchitecture();
architecture.setCode(dlObject.getCode());
System.out.println(architecture.getCode());
architecture.setName(dlObject.getName());
System.out.println(architecture.getName());
architecture.setMaxWidthOfColumnName(dlObject.getMaxWidthOfColumnName());
System.out.println(architecture.getMaxWidthOfColumnName());
architecture.setMaxWidthOfTableName(dlObject.getMaxWidthOfTableName());
System.out.println(architecture.getMaxWidthOfTableName());
architecture.setMaxWidthOfRelationshipName(dlObject.getMaxWidthOfRelationshipName());
System.out.println(architecture.getMaxWidthOfRelationshipName());

dlDatabaseEngineList=dataManager.select(com.thinking.machines.tmdmodel.dl.DatabaseEngine.class).where("databaseArchitectureCode").eq(architecture.getCode()).query();
dlDataTypeList=dataManager.select(com.thinking.machines.tmdmodel.dl.DatabaseArchitectureDataType.class).where("databaseArchitectureCode").eq(architecture.getCode()).query();
databaseEngineList=new java.util.LinkedList<>();
dataTypeList=new java.util.LinkedList<>();
System.out.println("Engines");
for(com.thinking.machines.tmdmodel.dl.DatabaseEngine dlEngine:dlDatabaseEngineList)
{
databaseEngine=new DatabaseEngine();
databaseEngine.setCode(dlEngine.getCode());
System.out.println(databaseEngine.getCode());
databaseEngine.setName(dlEngine.getName());
System.out.println(databaseEngine.getName());
databaseEngineList.add(databaseEngine);
}
System.out.println("DataTypes");
for(com.thinking.machines.tmdmodel.dl.DatabaseArchitectureDataType dlDataType:dlDataTypeList)
{
dataType=new DatabaseArchitectureDataType();
dataType.setCode(dlDataType.getCode());
System.out.println(dataType.getCode());
dataType.setDataType(dlDataType.getDataType());
System.out.println(dataType.getDataType());
dataType.setMaxWidth(dlDataType.getMaxWidth());
System.out.println(dataType.getMaxWidth());
dataType.setDefaultSize(dlDataType.getDefaultSize());
System.out.println(dataType.getDefaultSize());
dataType.setMaxWidthOfPrecision(dlDataType.getMaxWidthOfPrecision());
System.out.println(dataType.getMaxWidthOfPrecision());
dataType.setAllowAutoIncrement(dlDataType.getAllowAutoIncrement());
System.out.println(dataType.getAllowAutoIncrement());
dataTypeList.add(dataType);
}

architecture.setDatabaseEngines((java.util.LinkedList)databaseEngineList);
architecture.setDatabaseArchitectureDataTypes((java.util.LinkedList)dataTypeList);
architectureList.add(architecture);
}
dataManager.end();
servletContext.setAttribute("databaseArchitectures",architectureList);
}catch(DMFrameworkException dmFrameworkException)
{
System.out.println(dmFrameworkException.getMessage());
}

}

@InjectApplication
@Post
@Path("projectArchitecture")
public DatabaseArchitecture getDatabaseArchitecture()
{
java.util.LinkedList<DatabaseArchitecture> archList=(java.util.LinkedList)servletContext.getAttribute("databaseArchitectures");
return archList.get(0);
}
@InjectSession
@InjectApplication
@Path("projectDataStructure")
@Post
public boolean populateProject()
{
Member member=(Member)session.getAttribute("member");
java.util.LinkedList<Project> projects=new java.util.LinkedList<>();
java.util.LinkedList<com.thinking.machines.tmdmodel.dl.Project> dlProjects;
java.util.LinkedList<DatabaseArchitecture> architectures;
java.util.LinkedList<DatabaseTable> tables;
java.util.LinkedList<com.thinking.machines.tmdmodel.dl.DatabaseTable> dlTables;
java.util.LinkedList<DatabaseTableField> fields;
java.util.LinkedList<com.thinking.machines.tmdmodel.dl.DatabaseTableField> dlFields;
java.util.LinkedList<DatabaseArchitecture> databaseArchitectures;
DatabaseArchitecture databaseArchitecture;
DatabaseTable table;
DatabaseTableField field; 
databaseArchitectures=(java.util.LinkedList)servletContext.getAttribute("databaseArchitectures");

try
{
DataManager dataManager=new DataManager();
dataManager.begin();
dlProjects=(java.util.LinkedList<com.thinking.machines.tmdmodel.dl.Project>)dataManager.select(com.thinking.machines.tmdmodel.dl.Project.class).where("memberCode").eq(member.getCode()).query();
Project project;
int x=0;
int y=0;
for(com.thinking.machines.tmdmodel.dl.Project dlProject:dlProjects)
{
project=new Project();
project.setCode(dlProject.getCode());
project.setTitle(dlProject.getTitle());
project.setDateOfCreation(dlProject.getDateOfCreation());
project.setTimeOfCreation(dlProject.getTimeOfCreation());
project.setNumberOfTable(dlProject.getNumberOfTable());
project.setWidth(dlProject.getWidth());
project.setHeight(dlProject.getHeight());
System.out.println("--------------");
for(DatabaseArchitecture arch:databaseArchitectures)
{
x=dlProject.getDatabaseArchitectureCode();
y=arch.getCode();

System.out.println((x==y)+" x==y");
System.out.println(arch);
if(x==y)
{
System.out.println("Match Found");
project.setDatabaseArchitecture(arch);
}
}
System.out.println("--------------");
dlTables=(java.util.LinkedList<com.thinking.machines.tmdmodel.dl.DatabaseTable>)dataManager.select(com.thinking.machines.tmdmodel.dl.DatabaseTable.class).where("projectCode").eq(project.getCode()).query();
tables=new java.util.LinkedList<>();
for(com.thinking.machines.tmdmodel.dl.DatabaseTable dlTable:dlTables)
{
table=new DatabaseTable();
table.setCode(dlTable.getCode());
table.setName(dlTable.getName());
table.setNote(dlTable.getNote());
table.setNumberOfFields(dlTable.getNumberOfFields());
table.setXCoor(dlTable.getXCoor());
table.setYCoor(dlTable.getYCoor());
for(DatabaseArchitecture arch2:databaseArchitectures)
{
for(DatabaseEngine engine2:arch2.getDatabaseEngines())
{
if(engine2.getCode()==dlTable.getDatabaseEngineCode()) table.setDatabaseEngine(engine2);
}
}
System.out.println(table.getDatabaseEngine());
dlFields=(java.util.LinkedList<com.thinking.machines.tmdmodel.dl.DatabaseTableField>)dataManager.select(com.thinking.machines.tmdmodel.dl.DatabaseTableField.class).where("tableCode").eq(table.getCode()).query();
fields=new java.util.LinkedList<>();
for(com.thinking.machines.tmdmodel.dl.DatabaseTableField dlField:dlFields)
{
field=new DatabaseTableField();
field.setCode(dlField.getCode());
field.setName(dlField.getName());
field.setWidth(dlField.getWidth());
field.setNumberOfDecimalPlaces(dlField.getNumberOfDecimalPlaces());
field.setIsPrimaryKey(dlField.getIsPrimaryKey());
field.setIsAutoIncrement(dlField.getIsAutoIncrement());
field.setIsUnique(dlField.getIsUnique());
field.setIsNotNull(dlField.getIsNotNull());
field.setCheckConstraint(dlField.getCheckConstraint());
field.setNote(dlField.getNote());
for(DatabaseArchitecture arch:databaseArchitectures)
{
for(DatabaseArchitectureDataType dataTypes2:arch.getDatabaseArchitectureDataTypes())
{
if(dlField.getDatabaseArchitectureDataTypeCode()==dataTypes2.getCode()) field.setDatabaseArchitectureDataType(dataTypes2);
}
}
fields.add(field);
}
table.setDatabaseTableFields((java.util.LinkedList)fields);
tables.add(table);
}
project.setDatabaseTables((java.util.LinkedList)tables);
projects.add(project);
}
session.setAttribute("projects",projects);
for(Project pro:projects) System.out.println(pro.getTitle());

dataManager.end();
return true;
}catch(DMFrameworkException dmException)
{
dmException.printStackTrace();
return false;
}

}
@InjectSession
@InjectApplication
@Path("specifyCurrent")
@Post
public boolean specifyCurrent(int code)
{
java.util.LinkedList<Project> projects=(java.util.LinkedList<Project>)session.getAttribute("projects");
Project project=null;
for(Project pro:projects) if(pro.getCode()==code) project=pro;
if(project==null) return false;
Member member=(Member)session.getAttribute("member");
session.setAttribute("currentProject",project);
session.setAttribute("projectCode",code);
return true;
}



@InjectSession
@InjectApplication
@Path("saveProject")
@Post
public boolean saveProject(CurrentProject currentProject)
{
try
{
Member member=(Member)session.getAttribute("member");
int projectCode=(int)session.getAttribute("projectCode");
if(specifyCurrent(projectCode)) System.out.println("chala");
CurrentProject previousProject=(CurrentProject)session.getAttribute("currentTableComponent");
Project project=(Project)session.getAttribute("currentProject");
System.out.println(project.getDatabaseArchitecture());
com.thinking.machines.tmdmodel.dl.Project dlProject=new com.thinking.machines.tmdmodel.dl.Project();
com.thinking.machines.tmdmodel.dl.DatabaseTable dlTable;
com.thinking.machines.tmdmodel.dl.DatabaseTableField dlField;
dlProject.setCode(project.getCode());
dlProject.setTitle(project.getTitle());
dlProject.setMemberCode(member.getCode());
int daCode=0;
try
{
DataManager dataManager=new DataManager();
dataManager.begin();
java.util.LinkedList<com.thinking.machines.tmdmodel.dl.Project> pjs=(java.util.LinkedList<com.thinking.machines.tmdmodel.dl.Project>)dataManager.select(com.thinking.machines.tmdmodel.dl.Project.class).query();
for(com.thinking.machines.tmdmodel.dl.Project proj:pjs)
{
if(proj.getCode()==projectCode) daCode=proj.getDatabaseArchitectureCode();
}
dataManager.end();
}catch(DMFrameworkException ve)
{
ve.printStackTrace();
return false;
}

dlProject.setDatabaseArchitectureCode(daCode);

dlProject.setDateOfCreation(project.getDateOfCreation());
dlProject.setTimeOfCreation(project.getTimeOfCreation());
dlProject.setNumberOfTable(currentProject.getTables().size());
dlProject.setWidth(currentProject.getWidth());
dlProject.setHeight(currentProject.getHeight());

try
{
DataManager manager=new DataManager();
manager.begin();

manager.update(dlProject);
if(previousProject!=null)
{
for(ProjectTable prot:previousProject.getTables())
{
System.out.println("********************************");
System.out.println(prot.getName()+"----------");
for(ProjectTableField protf:prot.getFields())
{
System.out.println("protf: "+protf.getName());
manager.delete(com.thinking.machines.tmdmodel.dl.DatabaseTableField.class,protf.getCode());
}
System.out.println("********************************");
manager.delete(com.thinking.machines.tmdmodel.dl.DatabaseTable.class,prot.getCode());
}
}
else System.out.println("No tables existed before saving");
for(ProjectTable projectTable:currentProject.getTables())
{
dlTable=new com.thinking.machines.tmdmodel.dl.DatabaseTable();
dlTable.setProjectCode(project.getCode());
dlTable.setName(projectTable.getName());
dlTable.setDatabaseEngineCode(projectTable.getDatabaseEngineCode());
dlTable.setNote(projectTable.getNote());
dlTable.setNumberOfFields(projectTable.getFields().size());
dlTable.setXCoor(projectTable.getX());
dlTable.setYCoor(projectTable.getY());
System.out.println("dlTable starts---------------");
System.out.println(dlTable.getProjectCode());
System.out.println(dlTable.getName());
System.out.println(dlTable.getDatabaseEngineCode());
System.out.println(dlTable.getNote());
System.out.println(dlTable.getNumberOfFields());
System.out.println(dlTable.getXCoor());
System.out.println(dlTable.getYCoor());
System.out.println("dlTable ends---------------");
manager.insert(dlTable);
projectTable.setCode(dlTable.getCode());
System.out.println(dlTable.getCode());
manager.end();
manager=new DataManager();
manager.begin();
for(ProjectTableField projectTableField:projectTable.getFields())
{
dlField=new com.thinking.machines.tmdmodel.dl.DatabaseTableField();
dlField.setTableCode(dlTable.getCode());
dlField.setName(projectTableField.getName());
dlField.setDatabaseArchitectureDataTypeCode(projectTableField.getDatabaseArchitectureDataType());
dlField.setWidth(projectTableField.getWidth());
dlField.setNumberOfDecimalPlaces(projectTableField.getNumberOfDecimalPlaces());
dlField.setIsPrimaryKey(projectTableField.getIsPrimaryKey());
dlField.setIsAutoIncrement(projectTableField.getIsAutoIncrement());
dlField.setIsUnique(projectTableField.getIsUnique());
dlField.setIsNotNull(projectTableField.getIsNotNull());
if(projectTableField.getDefaultValue()==null || projectTableField.getDefaultValue().equals("")) dlField.setDefaultValue("0");
else dlField.setDefaultValue(projectTableField.getDefaultValue());
if(projectTableField.getNote()==null || projectTableField.getNote().equals("")) dlField.setNote("0");
else dlField.setNote(projectTableField.getNote());
if(projectTableField.getCheckConstraint()==null || projectTableField.getCheckConstraint().equals("")) dlField.setCheckConstraint("0");
else dlField.setCheckConstraint(projectTableField.getCheckConstraint());
System.out.println("dlField******************");
System.out.println(dlField.getTableCode());
System.out.println(dlField.getName());
System.out.println(dlField.getDatabaseArchitectureDataTypeCode());
System.out.println(dlField.getWidth());
System.out.println(dlField.getNumberOfDecimalPlaces());
System.out.println(dlField.getIsPrimaryKey());
System.out.println(dlField.getIsAutoIncrement());
System.out.println(dlField.getIsUnique());
System.out.println(dlField.getIsNotNull());
System.out.println(dlField.getDefaultValue());
System.out.println(dlField.getNote());
manager.insert(dlField);
projectTableField.setCode(dlField.getCode());
System.out.println(dlField.getCode());
System.out.println("dlField******************");
}

}
manager.end();
session.setAttribute("currentTableComponent",currentProject);
boolean didWork=populateProject();
if(didWork==false) System.out.println("populateProject did not work");
return true;
}catch(ValidatorException ve)
{
ve.printStackTrace();
java.util.HashMap<String,java.util.LinkedList<com.thinking.machines.dmframework.pojo.Pair<java.lang.Integer, java.lang.String>>> hm=ve.getExceptions();
for(String key: hm.keySet())
{
for(com.thinking.machines.dmframework.pojo.Pair<java.lang.Integer, java.lang.String> pair:hm.get(key))
{
System.out.println(pair.getFirst());
System.out.println(pair.getSecond());
}
}
return false;
}
catch(DMFrameworkException dmframeworkException)
{
dmframeworkException.printStackTrace();
return false;
}
//outer catch
}catch(NullPointerException nullPointerException)
{
nullPointerException.printStackTrace();
return false;
}

}
/*@Post
@Path("Sam")
public Object sam(CurrentProject project,ProjectTable table,ProjectTableField field)
{
return null;
}*/
@Post
@InjectSession
@Path("drawTables")
public CurrentProject drawTables()
{
try
{
java.util.LinkedList<ProjectTable> projectTables=new java.util.LinkedList<>();
ProjectTable projectTable;
java.util.LinkedList<ProjectTableField> projectTableFields=new java.util.LinkedList<>();
ProjectTableField projectTableField;
Project curProject=(Project)session.getAttribute("currentProject");
CurrentProject currentProject=new CurrentProject();
currentProject.setName(curProject.getTitle());
currentProject.setWidth(curProject.getWidth());
currentProject.setHeight(curProject.getHeight());
System.out.println("1 "+curProject);
DataManager manager=new DataManager();
manager.begin();
for(DatabaseTable dt:curProject.getDatabaseTables())
{
System.out.println("2 "+dt);
projectTable=new ProjectTable();
projectTable.setCode(dt.getCode());
projectTable.setName(dt.getName());
projectTable.setProjectCode(curProject.getCode());
//System.out.println(dt.getDatabaseEngine());
//System.out.println(dt.getDatabaseEngine().getName());
java.util.LinkedList<com.thinking.machines.tmdmodel.dl.DatabaseTable> de=(java.util.LinkedList<com.thinking.machines.tmdmodel.dl.DatabaseTable>)manager.select(com.thinking.machines.tmdmodel.dl.DatabaseTable.class).query();
for(com.thinking.machines.tmdmodel.dl.DatabaseTable dbt:de)
{
if(dbt.getCode()==projectTable.getCode()) projectTable.setDatabaseEngineCode(dbt.getDatabaseEngineCode());
}
//projectTable.setDatabaseEngine(dt.getDatabaseEngine().getName());
//projectTable.setDatabaseEngineCode(dt.getDatabaseEngine().getCode());
projectTable.setNote(dt.getNote());
projectTable.setX(dt.getXCoor());
projectTable.setY(dt.getYCoor());
projectTable.setNumberOfFields(dt.getNumberOfFields());
int serial=1;
projectTableFields=new java.util.LinkedList<>();
for(DatabaseTableField dtf:dt.getDatabaseTableFields())
{
System.out.println("3 "+dtf);
projectTableField=new ProjectTableField();
projectTableField.setCode(dtf.getCode());
projectTableField.setSerialNumber(serial++);
projectTableField.setName(dtf.getName());
projectTableField.setTableCode(dt.getCode());
projectTableField.setDatabaseArchitectureDataTypeName(dtf.getDatabaseArchitectureDataType().getDataType());
projectTableField.setDatabaseArchitectureDataType(dtf.getDatabaseArchitectureDataType().getCode());
projectTableField.setWidth(dtf.getWidth());
projectTableField.setNumberOfDecimalPlaces(dtf.getNumberOfDecimalPlaces());
projectTableField.setIsPrimaryKey(dtf.getIsPrimaryKey());
projectTableField.setIsAutoIncrement(dtf.getIsAutoIncrement());
projectTableField.setIsNotNull(dtf.getIsNotNull());
projectTableField.setIsUnique(dtf.getIsUnique());
projectTableField.setDefaultValue(dtf.getDefaultValue());
projectTableField.setCheckConstraint(dtf.getCheckConstraint());
projectTableField.setNote(dtf.getNote());
projectTableFields.add(projectTableField);

}



projectTable.setFields(projectTableFields);
projectTables.add(projectTable);
}
manager.end();
currentProject.setTables(projectTables);
session.setAttribute("currentTableComponent",currentProject);
return currentProject;
}catch(NullPointerException npe)
{
npe.printStackTrace();
return null;
}
catch(DMFrameworkException dm)
{
dm.printStackTrace();
return null;
}
/*try
{
DataManager manager=DataManager();
manager.begin();
java.util.LinkedList<com.thinking.machines.tmdmodel.dl.DatabaseTable> dltables=select(com.thinking.machines.tmdmodel.dl.DatabaseTable).where("projectCode").eq(curProject.getCode());
for(com.thinking.machines.tmdmodel.dl.DatabaseTable dlTable:dlTables)
{
projectTable=new ProjectTable();
projectTable.setCode(dlTable.getCode());
projectTable.setName(dlTable.getName());
projectTable.
}
manager.end();

session.setAttribute("currentTableComponent",currentProject);
}catch(ValidatorException ve)
{
java.util.HashMap<String,java.util.LinkedList<com.thinking.machines.dmframework.pojo.Pair<java.lang.Integer, java.lang.String>>> hm=ve.getExceptions();
for(String key: hm.keySet())
{
for(com.thinking.machines.dmframework.pojo.Pair<java.lang.Integer, java.lang.String> pair:hm.get(key))
{
System.out.println(pair.getFirst());
System.out.println(pair.getSecond());
}


}
catch(DMFrameworkException dm)
{
java.util.HashMap<String,java.util.LinkedList<com.thinking.machines.dmframework.pojo.Pair<java.lang.Integer, java.lang.String>>> hm=dm.getExceptions();
for(String key: hm.keySet())
{
for(com.thinking.machines.dmframework.pojo.Pair<java.lang.Integer, java.lang.String> pair:hm.get(key))
{
System.out.println(pair.getFirst());
System.out.println(pair.getSecond());
}
}
}
*/
}


@Post
@InjectSession
@Path("generateScript")
public String generateScript(String names)
{
if(names==null || names.equals("")) return null;
String tableNames[]=names.split(";");
StringBuffer sb=new StringBuffer;
CurrentProject currentProject=(CurrentProject)session.getAttribute("currentTableComponent");
java.util.LinkedList<ProjectTable> projectTables=project.getDatabaseTables();
java.util.LinkedList<ProjectTable> requiredTables=new java.util.LinkedList<DatabaseTable>();
for(String tableName:tableNames)
{
for(ProjectTable projectTable:projectTables)
{
if(tableName.equals(projectTable.getName())) requiredTables.add(projectTable);
}
}
sb.append(ScriptGenerator.generateSQLScript());
return sb.toString();
}



}