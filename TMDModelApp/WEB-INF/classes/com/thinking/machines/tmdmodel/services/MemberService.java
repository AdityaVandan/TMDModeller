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
@Path("/member")
public class MemberService
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
@InjectSession
@Post
@Path("verifyCaptcha")
public Object verifyCaptcha(String captcha)
{
//try
//{
Captcha c=(Captcha)session.getAttribute(Captcha.CAPTCHA_NAME);
boolean isValid=c.isValid(captcha);
session.removeAttribute(Captcha.CAPTCHA_NAME);
return isValid;
//}catch(DMFrameworkException dmFrameworkException)
//{
//return new Exception(dmFrameworkException.getMessage());
//}
}
@Post
@Path("add")
public Object addMember(Member member)
{
if(member.getEmailId()==null || member.getEmailId().equals("")) return false;
if(member.getPassword()==null || member.getPassword().equals("")) return false;
if(member.getFirstName()==null || member.getFirstName().equals("")) return false;
if(member.getLastName()==null || member.getLastName().equals("")) return false;
if(member.getMobileNumber()==null || member.getMobileNumber().equals("")) return false;
com.thinking.machines.tmdmodel.dl.Member dlMember=new com.thinking.machines.tmdmodel.dl.Member();
String key=java.util.UUID.randomUUID().toString();
String password=member.getPassword();
String encryptedPassword=Utility.encrypt(password,key);
dlMember.setEmailId(member.getEmailId());
dlMember.setPassword(encryptedPassword);
dlMember.setPasswordKey(key);
dlMember.setFirstName(member.getFirstName());
dlMember.setLastName(member.getLastName());
dlMember.setMobileNumber(member.getMobileNumber());
dlMember.setStatus("Y");
dlMember.setNumberOfProjects(0);
try
{
DataManager dataManager=new DataManager();
dataManager.begin();
//dataManager.select(com.thinking.machines.)




dataManager.insert(dlMember);
dataManager.end();
return true;
}catch(ValidatorException validatorException)
{
return new Exception(validatorException.getMessage());
}
catch(DMFrameworkException dmFrameworkException)
{
return new Exception(dmFrameworkException.getMessage());
}
}
@Path("login")
@InjectSession
@InjectApplication
public Object login(String inputEmail,String inputPassword)
{
if(inputEmail==null || inputEmail.equals("")) return new TMForward("/TMDModelApp/index.jsp");
if(inputPassword==null || inputPassword.equals("")) return new TMForward("/TMDModelApp/index.jsp");
java.util.List<com.thinking.machines.tmdmodel.dl.Member> dlMembers;
com.thinking.machines.tmdmodel.dl.Member dlMember;

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
dlMembers=dataManager.select(com.thinking.machines.tmdmodel.dl.Member.class).where("emailId").eq(inputEmail).query();
if(dlMembers.size()==0)
{
dataManager.end();
return new TMForward("/index.jsp");
}
dlMember=dlMembers.get(0);
System.out.println(dlMember.getEmailId());
System.out.println(dlMember.getFirstName());
String originalPassword=Utility.decrypt(dlMember.getPassword(),dlMember.getPasswordKey());
System.out.println(originalPassword);
if(!originalPassword.equals(inputPassword))
{
dataManager.end();
return new TMForward("/index.jsp");
}
Member member=new Member();
member.setCode(dlMember.getCode());
member.setEmailId(dlMember.getEmailId());
member.setPassword(originalPassword);
member.setFirstName(dlMember.getFirstName());
member.setLastName(dlMember.getLastName());
member.setMobileNumber(dlMember.getMobileNumber());
session.setAttribute("member",member);




dlProjects=(java.util.LinkedList<com.thinking.machines.tmdmodel.dl.Project>)dataManager.select(com.thinking.machines.tmdmodel.dl.Project.class).where("memberCode").eq(dlMember.getCode()).query();
Project project;
int xx=0;
int yy=0;
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
System.out.println("&&&&&&&&&&&&&&&");
for(DatabaseArchitecture arch:databaseArchitectures)
{
xx=dlProject.getDatabaseArchitectureCode();
yy=arch.getCode();
System.out.println((xx==yy)+" x==y");
if(dlProject.getDatabaseArchitectureCode()==arch.getCode())
{
System.out.println("Match Found "+arch);
project.setDatabaseArchitecture(arch);
}

}
System.out.println("&&&&&&&&&&&&&&&");
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
int x=0;
int y=0;
for(DatabaseArchitecture arch2:databaseArchitectures)
{
System.out.println("**************");
for(DatabaseEngine engine2:arch2.getDatabaseEngines())
{
x=engine2.getCode();
y=dlTable.getDatabaseEngineCode();
System.out.println(engine2.getCode()+" "+dlTable.getDatabaseEngineCode());
System.out.println((x==y)+" x+y");
System.out.println(engine2.getCode()==dlTable.getDatabaseEngineCode());
System.out.println(engine2.getName());
if(x==y) 
{
System.out.println("Match hua");
table.setDatabaseEngine(engine2);
}

}
}
System.out.println("+++++++++++++++++ "+table.getDatabaseEngine());


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





dataManager.end();
session.setAttribute("projects",projects);



return new TMForward("/HomePage.jsp");
}catch(DMFrameworkException dmFrameworkException)
{
System.out.println(dmFrameworkException);
return new Exception(dmFrameworkException.getMessage());
}
catch(ServiceException se)
{
return new Exception(se.getMessage());
}
}
@Post
@InjectSession
@Path("check")
public java.util.LinkedList<Project> check()
{
java.util.LinkedList<Project> p=(java.util.LinkedList<Project>)session.getAttribute("projects");
System.out.println("p "+p);
return p;
}
@Post
@InjectSession
@Path("logout")
public TMForward logout()
{
session.removeAttribute("member");
session.removeAttribute("projects");
return new TMForward("/index.jsp");
}

@InjectApplication
@InjectSession
@Post
@Path("createProject")
public boolean createProject(String name,Integer code)
{
int num=0;
System.out.println(num++);
System.out.println("da faq"+(java.util.LinkedList<Project>)session.getAttribute("projects"));
java.util.LinkedList<Project> projects=(java.util.LinkedList<Project>)session.getAttribute("projects");
System.out.println(projects);

Member member=(Member)session.getAttribute("member");
System.out.println(member.getFirstName());
for(Project pro:projects)
{
if(pro.getTitle().trim().equals(name.trim()))
{
System.out.println("Project already exists");
return false;
//return new TMForward("/TMDModelApp/HomePage.jsp");
}
}
System.out.println(num++);
com.thinking.machines.tmdmodel.dl.Project dlProject=new com.thinking.machines.tmdmodel.dl.Project();
dlProject.setTitle(name);
dlProject.setMemberCode(member.getCode());
dlProject.setDatabaseArchitectureCode(code);
System.out.println(System.currentTimeMillis());
dlProject.setDateOfCreation(new java.sql.Date(System.currentTimeMillis()));
dlProject.setTimeOfCreation(new java.sql.Time(System.currentTimeMillis()));
dlProject.setNumberOfTable(0);
dlProject.setWidth(800);
dlProject.setHeight(1000);
System.out.println(num++);
try
{
DataManager dataManager=new DataManager();
dataManager.begin();
//resume here dataManager.
dataManager.insert(dlProject);
dataManager.end();
System.out.println("Code:"+dlProject.getCode());
Project project=new Project();
project.setCode(dlProject.getCode());
project.setTitle(dlProject.getTitle());
java.util.LinkedList<DatabaseArchitecture> databaseArchitectures=(java.util.LinkedList<DatabaseArchitecture>)servletContext.getAttribute("databaseArchitectures");
DatabaseArchitecture selectedArchitecture=null;
for(DatabaseArchitecture da:databaseArchitectures)
{
selectedArchitecture=da;
}
System.out.println("DA: "+selectedArchitecture.getName());
project.setDatabaseArchitecture(selectedArchitecture);
project.setDateOfCreation(dlProject.getDateOfCreation());
project.setTimeOfCreation(dlProject.getTimeOfCreation());
project.setDatabaseTables(new java.util.LinkedList<DatabaseTable>());
project.setNumberOfTable(dlProject.getNumberOfTable());
project.setWidth(dlProject.getWidth());
project.setHeight(dlProject.getHeight());
projects.add(project); 
session.setAttribute("projectCode",project.getCode());
session.setAttribute("projects",projects);
session.setAttribute("currentProject",project);
return true;
//login(member.getEmailId(),member.getPassword());
//return new TMForward("/TMDModelApp/ProjectView.jsp");
}catch(ValidatorException validatorException)
{
System.out.println("member/createProject"+validatorException.getMessage());
//return new Exception(validatorException.getMessage());
//return new TMForward("/TMDModelApp/home.jsp");
return false;
}
catch(DMFrameworkException dmFrameworkException)
{
System.out.println("member/createProject"+dmFrameworkException.getMessage());
//return new TMForward("/TMDModelApp/home.jsp");
return false;
}
catch(Exception e)
{
e.printStackTrace();
return false;
}
}
@InjectSession
@Post
@Path("openProject")
public boolean openProject(int code)
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

}