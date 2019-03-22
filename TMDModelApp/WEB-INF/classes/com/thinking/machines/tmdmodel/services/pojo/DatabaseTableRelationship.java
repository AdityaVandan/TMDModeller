package com.thinking.machines.tmdmodel.services.pojo;
public class DatabaseTableRelationship
{
private Integer code;
private String name;
private DatabaseTable parentTable;
private DatabaseTable childTable;
public DatabaseTableRelationship()
{
this.code=0;
this.name="";
this.parentTable=null;
this.childTable=null;
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
public void setParentTable(DatabaseTable parentTable)
{
this.parentTable=parentTable;
}
public DatabaseTable getParentTable()
{
return this.parentTable;
}
public void setChildTable(DatabaseTable childTable)
{
this.childTable=childTable;
}
public DatabaseTable getChildTable()
{
return this.childTable;
}
}