package com.thinking.machines.tmdmodel.services.pojo;
public class DatabaseTableRelationshipKey
{
private Integer code;
private DatabaseTableRelationship databasetableRelationShip;
private DatabaseTableField parentDatabaseTableField;
private DatabaseTableField childDatabaseTableField;
public DatabaseTableRelationshipKey()
{
this.code=0;
this.databasetableRelationShip=null;
this.parentDatabaseTableField=null;
this.childDatabaseTableField=null;
}
public void setCode(Integer code)
{
this.code=code;
}
public Integer getCode()
{
return this.code;
}
public void setDatabasetableRelationShip(DatabaseTableRelationship databasetableRelationShip)
{
this.databasetableRelationShip=databasetableRelationShip;
}
public DatabaseTableRelationship getDatabasetableRelationShip()
{
return this.databasetableRelationShip;
}
public void setParentDatabaseTableField(DatabaseTableField parentDatabaseTableField)
{
this.parentDatabaseTableField=parentDatabaseTableField;
}
public DatabaseTableField getParentDatabaseTableField()
{
return this.parentDatabaseTableField;
}
public void setChildDatabaseTableField(DatabaseTableField childDatabaseTableField)
{
this.childDatabaseTableField=childDatabaseTableField;
}
public DatabaseTableField getChildDatabaseTableField()
{
return this.childDatabaseTableField;
}

}