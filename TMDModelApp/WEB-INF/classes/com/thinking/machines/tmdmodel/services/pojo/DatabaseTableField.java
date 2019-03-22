package com.thinking.machines.tmdmodel.services.pojo;
public class DatabaseTableField implements java.io.Serializable,Comparable<DatabaseTableField>
{
private Integer code;
//private Integer tableCode;
private String name;
//private Integer databaseArchitectureDataTypeCode;
private DatabaseArchitectureDataType databaseArchitectureDataType;
private Integer width;
private Integer numberOfDecimalPlaces;
private Boolean isPrimaryKey;
private Boolean isAutoIncrement;
private Boolean isUnique;
private Boolean isNotNull;
private String defaultValue;
private String checkConstraint;
private String note;
public DatabaseTableField()
{
this.code=null;
//this.tableCode=null;
this.name=null;
//this.databaseArchitectureDataTypeCode=null;
this.databaseArchitectureDataType=null;
this.width=null;
this.numberOfDecimalPlaces=null;
this.isPrimaryKey=null;
this.isAutoIncrement=null;
this.isUnique=null;
this.isNotNull=null;
this.defaultValue=null;
this.checkConstraint=null;
this.note=null;
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
public void setWidth(Integer width)
{
this.width=width;
}
public void setDatabaseArchitectureDataType(DatabaseArchitectureDataType databaseArchitectureDataType)
{
this.databaseArchitectureDataType=databaseArchitectureDataType;
}
public DatabaseArchitectureDataType getDatabaseArchitectureDataType()
{
return this.databaseArchitectureDataType;
}
public Integer getWidth()
{
return this.width;
}
public void setNumberOfDecimalPlaces(Integer numberOfDecimalPlaces)
{
this.numberOfDecimalPlaces=numberOfDecimalPlaces;
}
public Integer getNumberOfDecimalPlaces()
{
return this.numberOfDecimalPlaces;
}
public void setIsPrimaryKey(Boolean isPrimaryKey)
{
this.isPrimaryKey=isPrimaryKey;
}
public Boolean getIsPrimaryKey()
{
return this.isPrimaryKey;
}
public void setIsAutoIncrement(Boolean isAutoIncrement)
{
this.isAutoIncrement=isAutoIncrement;
}
public Boolean getIsAutoIncrement()
{
return this.isAutoIncrement;
}
public void setIsUnique(Boolean isUnique)
{
this.isUnique=isUnique;
}
public Boolean getIsUnique()
{
return this.isUnique;
}
public void setIsNotNull(Boolean isNotNull)
{
this.isNotNull=isNotNull;
}
public Boolean getIsNotNull()
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
public boolean equals(Object object)
{
if(object==null) return false;
if(!(object instanceof DatabaseTableField)) return false;
DatabaseTableField anotherDatabaseTableField=(DatabaseTableField)object;
if(this.code==null && anotherDatabaseTableField.code==null) return true;
if(this.code==null || anotherDatabaseTableField.code==null) return false;
return this.code.equals(anotherDatabaseTableField.code);
}
public int compareTo(DatabaseTableField anotherDatabaseTableField)
{
if(anotherDatabaseTableField==null) return 1;
if(this.code==null && anotherDatabaseTableField.code==null) return 0;
int difference;
if(this.code==null && anotherDatabaseTableField.code!=null) return 1;
if(this.code!=null && anotherDatabaseTableField.code==null) return -1;
difference=this.code.compareTo(anotherDatabaseTableField.code);
return difference;
}
public int hashCode()
{
if(this.code==null) return 0;
return this.code.hashCode();
}
}
