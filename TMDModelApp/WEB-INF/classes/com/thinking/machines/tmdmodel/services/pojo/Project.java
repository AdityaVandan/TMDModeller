package com.thinking.machines.tmdmodel.services.pojo;
import java.sql.*;
public class Project implements java.io.Serializable
{
private Integer code;
private String title;
//private Integer memberCode;
//private Integer databaseArchitectureCode;
private DatabaseArchitecture databaseArchitecture;
private Date dateOfCreation;
private Time timeOfCreation;
private java.util.LinkedList<DatabaseTable> databaseTables;
private Integer numberOfTable;
private int width;
private int height;
public Project()
{
this.code=null;
this.title=null;
//this.memberCode=null;
//this.databaseArchitectureCode=null;
this.databaseArchitecture=null;
this.dateOfCreation=null;
this.timeOfCreation=null;
this.databaseTables=null;
this.numberOfTable=null;
this.width=0;
this.height=0;
}
public void setCode(Integer code)
{
this.code=code;
}
public Integer getCode()
{
return this.code;
}
public void setTitle(String title)
{
this.title=title;
}
public String getTitle()
{
return this.title;
}
public void setDatabaseArchitecture(DatabaseArchitecture databaseArchitecture)
{
this.databaseArchitecture=databaseArchitecture;
}
public DatabaseArchitecture getDatabaseArchitecture()
{
return this.databaseArchitecture;
}
public void setDateOfCreation(Date dateOfCreation)
{
this.dateOfCreation=dateOfCreation;
}
public Date getDateOfCreation()
{
return this.dateOfCreation;
}
public void setTimeOfCreation(Time timeOfCreation)
{
this.timeOfCreation=timeOfCreation;
}
public Time getTimeOfCreation()
{
return this.timeOfCreation;
}
public void setDatabaseTables(java.util.LinkedList<DatabaseTable> databaseTables)
{
this.databaseTables=databaseTables;
}
public java.util.LinkedList<DatabaseTable> getDatabaseTables()
{
return this.databaseTables;
}
public void setNumberOfTable(Integer numberOfTable)
{
this.numberOfTable=numberOfTable;
}
public Integer getNumberOfTable()
{
return this.numberOfTable;
}
public void setWidth(int width)
{
this.width=width;
}
public int getWidth()
{
return this.width;
}
public void setHeight(int height)
{
this.height=height;
}
public int getHeight()
{
return this.height;
}
}
