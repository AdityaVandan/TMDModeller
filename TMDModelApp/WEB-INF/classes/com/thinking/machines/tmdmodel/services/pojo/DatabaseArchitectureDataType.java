package com.thinking.machines.tmdmodel.services.pojo;
public class DatabaseArchitectureDataType implements java.io.Serializable
{
private Integer code;
//private Integer databaseArchitectureCode;
private String dataType;
private Integer maxWidth;
private Integer defaultSize;
private Integer maxWidthOfPrecision;
private Boolean allowAutoIncrement;
public DatabaseArchitectureDataType()
{
this.code=null;
//this.databaseArchitectureCode=null;
this.dataType=null;
this.maxWidth=null;
this.defaultSize=null;
this.maxWidthOfPrecision=null;
this.allowAutoIncrement=null;
}
public void setCode(Integer code)
{
this.code=code;
}
public Integer getCode()
{
return this.code;
}
public void setDataType(String dataType)
{
this.dataType=dataType;
}
public String getDataType()
{
return this.dataType;
}
public void setMaxWidth(Integer maxWidth)
{
this.maxWidth=maxWidth;
}
public Integer getMaxWidth()
{
return this.maxWidth;
}
public void setDefaultSize(Integer defaultSize)
{
this.defaultSize=defaultSize;
}
public Integer getDefaultSize()
{
return this.defaultSize;
}
public void setMaxWidthOfPrecision(Integer maxWidthOfPrecision)
{
this.maxWidthOfPrecision=maxWidthOfPrecision;
}
public Integer getMaxWidthOfPrecision()
{
return this.maxWidthOfPrecision;
}
public void setAllowAutoIncrement(Boolean allowAutoIncrement)
{
this.allowAutoIncrement=allowAutoIncrement;
}
public Boolean getAllowAutoIncrement()
{
return this.allowAutoIncrement;
}
}
