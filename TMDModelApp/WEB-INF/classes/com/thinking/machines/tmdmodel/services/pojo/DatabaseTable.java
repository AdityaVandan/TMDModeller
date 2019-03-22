package com.thinking.machines.tmdmodel.services.pojo;
import java.util.*;
public class DatabaseTable implements java.io.Serializable
{
private Integer code;
//private Integer projectCode;
private String name;
//private Integer databaseEngineCode;
private DatabaseEngine databaseEngine;
private LinkedList<DatabaseTableField> databaseTableFields;
private String note;
private Integer numberOfFields;
private Integer xCoor;
private Integer yCoor;
public DatabaseTable()
{
this.code=null;
//this.projectCode=null;
this.name=null;
this.databaseEngine=null;
this.databaseTableFields=null;
//this.databaseEngineCode=null;
this.note=null;
this.numberOfFields=null;
this.xCoor=0;
this.xCoor=0;
}
public void setCode(Integer code)
{
this.code=code;
}
public Integer getCode()
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
public void setDatabaseEngine(DatabaseEngine databaseEngine)
{
this.databaseEngine=databaseEngine;
}
public DatabaseEngine getDatabaseEngine()
{
return this.databaseEngine;
}
public void setDatabaseTableFields(LinkedList<DatabaseTableField> databaseTableFields)
{
this.databaseTableFields=databaseTableFields;
}
public LinkedList<DatabaseTableField> getDatabaseTableFields()
{
return this.databaseTableFields;
}
public void setNote(String note)
{
this.note=note;
}
public String getNote()
{
return this.note;
}
public void setNumberOfFields(Integer numberOfFields)
{
this.numberOfFields=numberOfFields;
}
public Integer getNumberOfFields()
{
return this.numberOfFields;
}
public void setXCoor(Integer xCoor)
{
this.xCoor=xCoor;
}
public Integer getXCoor()
{
return this.xCoor;
}
public void setYCoor(Integer yCoor)
{
this.yCoor=yCoor;
}
public Integer getYCoor()
{
return this.yCoor;
}
public boolean equals(Object object)
{
if(object==null) return false;
if(!(object instanceof DatabaseTable)) return false;
DatabaseTable anotherDatabaseTable=(DatabaseTable)object;
if(this.code==null && anotherDatabaseTable.code==null) return true;
if(this.code==null || anotherDatabaseTable.code==null) return false;
return this.code.equals(anotherDatabaseTable.code);
}
public int compareTo(DatabaseTable anotherDatabaseTable)
{
if(anotherDatabaseTable==null) return 1;
if(this.code==null && anotherDatabaseTable.code==null) return 0;
int difference;
if(this.code==null && anotherDatabaseTable.code!=null) return 1;
if(this.code!=null && anotherDatabaseTable.code==null) return -1;
difference=this.code.compareTo(anotherDatabaseTable.code);
return difference;
}
public int hashCode()
{
if(this.code==null) return 0;
return this.code.hashCode();
}
}
