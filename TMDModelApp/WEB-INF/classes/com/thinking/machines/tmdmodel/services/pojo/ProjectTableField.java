package com.thinking.machines.tmdmodel.services.pojo;
public class ProjectTableField implements java.io.Serializable
{
private int code;
private int serialNumber;
private String name;
private int tableCode;
private String databaseArchitectureDataTypeName;
private int databaseArchitectureDataType;
private int width;
private int numberOfDecimalPlaces;
private boolean isPrimaryKey;
private boolean isAutoIncrement;
private boolean isUnique;
private boolean isNotNull;
private String defaultValue;
private String checkConstraint;
private String note;
public ProjectTableField()
{
this.code=0;
this.serialNumber=0;
this.name="";
this.tableCode=0;
this.databaseArchitectureDataTypeName="";
this.databaseArchitectureDataType=0;
this.width=0;
this.numberOfDecimalPlaces=0;
this.isPrimaryKey=false;
this.isAutoIncrement=false;
this.isUnique=false;
this.isNotNull=false;
this.defaultValue="null";
this.checkConstraint="nothing";
this.note="Note";
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setSerialNumber(int serialNumber)
{
this.serialNumber=serialNumber;
}
public int getSerialNumber()
{
return this.serialNumber;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setTableCode(int tableCode)
{
this.tableCode=tableCode;
}
public int getTableCode()
{
return this.tableCode;
}
public void setDatabaseArchitectureDataTypeName(String databaseArchitectureDataTypeName)
{
this.databaseArchitectureDataTypeName=databaseArchitectureDataTypeName;
}
public String getDatabaseArchitectureDataTypeName()
{
return this.databaseArchitectureDataTypeName;
}
public void setDatabaseArchitectureDataType(int databaseArchitectureDataType)
{
this.databaseArchitectureDataType=databaseArchitectureDataType;
}
public int getDatabaseArchitectureDataType()
{
return this.databaseArchitectureDataType;
}
public void setWidth(int width)
{
this.width=width;
}
public int getWidth()
{
return this.width;
}
public void setNumberOfDecimalPlaces(int numberOfDecimalPlaces)
{
this.numberOfDecimalPlaces=numberOfDecimalPlaces;
}
public int getNumberOfDecimalPlaces()
{
return this.numberOfDecimalPlaces;
}
public void setIsPrimaryKey(boolean isPrimaryKey)
{
this.isPrimaryKey=isPrimaryKey;
}
public boolean getIsPrimaryKey()
{
return this.isPrimaryKey;
}
public void setIsAutoIncrement(boolean isAutoIncrement)
{
this.isAutoIncrement=isAutoIncrement;
}
public boolean getIsAutoIncrement()
{
return this.isAutoIncrement;
}
public void setIsUnique(boolean isUnique)
{
this.isUnique=isUnique;
}
public boolean getIsUnique()
{
return this.isUnique;
}
public void setIsNotNull(boolean isNotNull)
{
this.isNotNull=isNotNull;
}
public boolean getIsNotNull()
{
return this.isNotNull;
}
public void setDefaultValue(String defaultValue)
{
this.defaultValue=defaultValue;
}
public String getDefaultValue()
{
return this.defaultValue;
}
public void setCheckConstraint(String checkConstraint)
{
this.checkConstraint=checkConstraint;
}
public String getCheckConstraint()
{
return this.checkConstraint;
}
public void setNote(String note)
{
this.note=note;
}
public String getNote()
{
return this.note;
}
}