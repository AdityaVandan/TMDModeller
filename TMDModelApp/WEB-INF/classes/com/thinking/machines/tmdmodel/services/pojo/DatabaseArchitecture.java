package com.thinking.machines.tmdmodel.services.pojo;
import java.util.*;
public class DatabaseArchitecture implements java.io.Serializable
{
private Integer code;
private String name;
private LinkedList<DatabaseEngine> databaseEngines;
private LinkedList<DatabaseArchitectureDataType> databaseArchitectureDataTypes;
private Integer maxWidthOfColumnName;
private Integer maxWidthOfTableName;
private Integer maxWidthOfRelationshipName;
public DatabaseArchitecture()
{
this.code=null;
this.name=null;
this.databaseEngines=null;
this.databaseArchitectureDataTypes=null;
this.maxWidthOfColumnName=null;
this.maxWidthOfTableName=null;
this.maxWidthOfRelationshipName=null;
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
public void setDatabaseEngines(LinkedList<DatabaseEngine> databaseEngines)
{
this.databaseEngines=databaseEngines;
}
public LinkedList<DatabaseEngine> getDatabaseEngines()
{
return this.databaseEngines;
}
public void setDatabaseArchitectureDataTypes(LinkedList<DatabaseArchitectureDataType> databaseArchitectureDataTypes)
{
this.databaseArchitectureDataTypes=databaseArchitectureDataTypes;
}
public LinkedList<DatabaseArchitectureDataType> getDatabaseArchitectureDataTypes()
{
return this.databaseArchitectureDataTypes;
}
public void setMaxWidthOfColumnName(Integer setMaxWidthOfColumnName)
{
this.maxWidthOfColumnName=maxWidthOfColumnName;
}
public Integer getMaxWidthOfColumnName()
{
return this.maxWidthOfColumnName;
}
public void setMaxWidthOfTableName(Integer maxWidthOfTableName)
{
this.maxWidthOfTableName=maxWidthOfTableName;
}
public Integer getMaxWidthOfTableName()
{
return this.maxWidthOfTableName;
}
public void setMaxWidthOfRelationshipName(Integer maxWidthOfRelationshipName)
{
this.maxWidthOfRelationshipName=maxWidthOfRelationshipName;
}
public Integer getMaxWidthOfRelationshipName()
{
return this.maxWidthOfRelationshipName;
}
}