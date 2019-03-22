package com.thinking.machines.tmdmodel.services;
import com.thinking.machines.tmdmodel.services.pojo.*;
import com.thinking.machines.tmdmodel.Utilities.*;
import com.thinking.machines.tmws.annotations.*;
import com.thinking.machines.dmframework.*;
import com.thinking.machines.dmframework.exceptions.*;
import com.thinking.machines.tmws.*;
import com.thinking.machines.tmws.captcha.*;
import javax.servlet.*;
import javax.servlet.http.*;
@Path("/administrator")
public class AdministratorService
{
public HttpSession session;
public void setHttpSession(HttpSession session)
{
this.session=session;
}
@InjectSession
@Post
@Path("verifyCaptcha")
public Object verifyCaptcha(String captcha)
{
Captcha c=(Captcha)session.getAttribute(Captcha.CAPTCHA_NAME);
System.out.println(Captcha.CAPTCHA_NAME+"     "+captcha);
System.out.println(c);
boolean isValid=c.isValid(captcha);
session.removeAttribute(Captcha.CAPTCHA_NAME);
return isValid;
}
@Post
@Path("add")
public Object AddAdministrator(Administrator administrator)
{
if(administrator.getUsername()==null || administrator.getUsername().equals("")) return false;
if(administrator.getPassword()==null || administrator.getPassword().equals("")) return false;
if(administrator.getEmailId()==null || administrator.getEmailId().equals("")) return false;
if(administrator.getFirstName()==null || administrator.getFirstName().equals("")) return false;
if(administrator.getLastName()==null || administrator.getLastName().equals("")) return false;
if(administrator.getMobileNumber()==null || administrator.getMobileNumber().equals("")) return false;
String key=java.util.UUID.randomUUID().toString();
String password=administrator.getPassword();
String encryptedPassword=Utility.encrypt(password,key);
administrator.setPasswordKey(key);
administrator.setPassword(encryptedPassword);
com.thinking.machines.tmdmodel.dl.Administrator dlAdministrator=new com.thinking.machines.tmdmodel.dl.Administrator();
dlAdministrator.setUsername(administrator.getUsername());
dlAdministrator.setPassword(administrator.getPassword());
dlAdministrator.setPasswordKey(administrator.getPasswordKey());
dlAdministrator.setEmailId(administrator.getEmailId());
dlAdministrator.setFirstName(administrator.getFirstName());
dlAdministrator.setLastName(administrator.getLastName());
dlAdministrator.setMobileNumber(administrator.getMobileNumber());
try
{
DataManager dataManager=new DataManager();
dataManager.begin();
dataManager.insert(dlAdministrator);
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
@Post
@InjectSession
@Path("eg")
public Object eg()
{
try
{
return session.getAttribute("projects");
}catch(Exception e)
{
e.printStackTrace();
return e;
}
}
}