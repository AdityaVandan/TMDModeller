package com.thinking.machines.tmdmodel.services.pojo;
public class Member implements java.io.Serializable
{
private int code;
private String emailId;
private String password;
private String firstName;
private String lastName;
private String mobileNumber;
public Member()
{
this.code=0;
this.emailId=null;
this.password=null;
this.firstName=null;
this.lastName=null;
this.mobileNumber=null;
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setEmailId(String emailId)
{
this.emailId=emailId;
}
public String getEmailId()
{
return this.emailId;
}
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
public void setFirstName(String firstName)
{
this.firstName=firstName;
}
public String getFirstName()
{
return this.firstName;
}
public void setLastName(String lastName)
{
this.lastName=lastName;
}
public String getLastName()
{
return this.lastName;
}
public void setMobileNumber(String mobileNumber)
{
this.mobileNumber=mobileNumber;
}
public String getMobileNumber()
{
return this.mobileNumber;
}
}
