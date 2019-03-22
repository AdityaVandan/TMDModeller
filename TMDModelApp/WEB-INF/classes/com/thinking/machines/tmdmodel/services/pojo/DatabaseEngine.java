package com.thinking.machines.tmdmodel.services.pojo;
public class DatabaseEngine implements java.io.Serializable,Comparable<DatabaseEngine>
{
private Integer code;
//private Integer databaseArchitectureCode;
private String name;
public DatabaseEngine()
{
this.code=0;
//this.databaseArchitectureCode=null;
this.name="";
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
public boolean equals(Object object)
{
if(object==null) return false;
if(!(object instanceof DatabaseEngine)) return false;
DatabaseEngine anotherDatabaseEngine=(DatabaseEngine)object;
if(this.code==null && anotherDatabaseEngine.code==null) return true;
if(this.code==null || anotherDatabaseEngine.code==null) return false;
return this.code.equals(anotherDatabaseEngine.code);
}
public int compareTo(DatabaseEngine anotherDatabaseEngine)
{
if(anotherDatabaseEngine==null) return 1;
if(this.code==null && anotherDatabaseEngine.code==null) return 0;
int difference;
if(this.code==null && anotherDatabaseEngine.code!=null) return 1;
if(this.code!=null && anotherDatabaseEngine.code==null) return -1;
difference=this.code.compareTo(anotherDatabaseEngine.code);
return difference;
}
public int hashCode()
{
if(this.code==null) return 0;
return this.code.hashCode();
}
}
