package com.thinking.machines.tmdmodel.dl;
import com.thinking.machines.dmframework.annotations.*;
@Display(value="Database Table")
@Table(name="database_table")
public class DatabaseTable implements java.io.Serializable,Comparable<DatabaseTable>
{
@Sort(priority=1)
@Display(value="code")
@Column(name="code")
private Integer code;
@Display(value="project code")
@Column(name="project_code")
private Integer projectCode;
@Display(value="name")
@Column(name="name")
private String name;
@Display(value="database engine code")
@Column(name="database_engine_code")
private Integer databaseEngineCode;
@Display(value="note")
@Column(name="note")
private String note;
@Display(value="number of fields")
@Column(name="number_of_fields")
private Integer numberOfFields;
@Display(value="x coor")
@Column(name="xCoor")
private Integer xCoor;
@Display(value="y coor")
@Column(name="yCoor")
private Integer yCoor;
public DatabaseTable()
{
this.code=null;
this.projectCode=null;
this.name=null;
this.databaseEngineCode=null;
this.note=null;
this.numberOfFields=null;
this.xCoor=null;
this.yCoor=null;
}
public void setCode(Integer code)
{
this.code=code;
}
public Integer getCode()
{
return this.code;
}
public void setProjectCode(Integer projectCode)
{
this.projectCode=projectCode;
}
public Integer getProjectCode()
{
return this.projectCode;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setDatabaseEngineCode(Integer databaseEngineCode)
{
this.databaseEngineCode=databaseEngineCode;
}
public Integer getDatabaseEngineCode()
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
