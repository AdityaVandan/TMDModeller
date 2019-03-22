package com.thinking.machines.tmdmodel.services.pojo;
import java.util.*;
public class CurrentProject implements java.io.Serializable
{
private String name;
private LinkedList<ProjectTable> tables;
private int width;
private int height;
public CurrentProject()
{
this.name="";
this.tables=null;
this.width=800;
this.height=1000;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setTables(LinkedList<ProjectTable> tables)
{
this.tables=tables;
}
public LinkedList<ProjectTable> getTables()
{
return this.tables;
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