package com.thinking.machines.tmdmodel.services.pojo;
import java.util.*;
public class ProjectTable implements java.io.Serializable
{
private int code;
private String name;
private int projectCode;
private String databaseEngine;
private int databaseEngineCode;
private String note;
private int x;
private int y;
private int numberOfFields;
private LinkedList<ProjectTableField> fields;
private int width;
private int height;
public ProjectTable()
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
this.fields=new LinkedList<ProjectTableField>();
this.width=0;
this.height=0;
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setProjectCode(int projectCode)
{
this.projectCode=projectCode;
}
public int getProjectCode()
{
return this.projectCode;
}
public void setDatabaseEngine(String databaseEngine)
{
this.databaseEngine=databaseEngine;
}
public String getDatabaseEngine()
{
return this.databaseEngine;
}
public void setDatabaseEngineCode(int databaseEngineCode)
{
this.databaseEngineCode=databaseEngineCode;
}
public int getDatabaseEngineCode()
{
return this.databaseEngineCode;
}
public void setNote(String note)
{
this.note=note;
}
public String getNote()
{
return this.note;
}
public void setX(int x)
{
this.x=x;
}
public int getX()
{
return this.x;
}
public void setY(int y)
{
this.y=y;
}
public int getY()
{
return this.y;
}
public void setNumberOfFields(int numberOfFields)
{
this.numberOfFields=numberOfFields;
}
public int getNumberOfFields()
{
return this.numberOfFields;
}
public void setFields(LinkedList<ProjectTableField> fields)
{
this.fields=fields;
}
public LinkedList<ProjectTableField> getFields()
{
return this.fields;
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