package com.thinking.machines.tmdmodel.Utilities;
import java.io.*;
import java.util.*;
import com.thinking.machines.tmdmodel.services.pojo;
public class ScriptGenerator
{
public static String generateSQLScript(LinkedList<ProjectTable> tables)
{
StringBuffer stringBuffer=new StringBuffer();
StringBuffer extraBuffer=new StringBuffer();
StringBuffer endingBuffer=new StringBuffer();
int length;
for(ProjectTable table:tables)
{
stringBuffer.append("create table "+name+"(\r\n");
length=table.getProjectTableFields().size();
for(ProjectTableField field:table.getProjectTableFields())
{
stringBuffer.append(field.getName());
if(field.getWidth()>0) stringBuffer.append(" ("+field.getWidth()+")");
if(field.getIsNotNull()) stringBuffer.append(" NOT NULL");
if(field.getIsAutoIncrement()) stringBuffer.append(" AUTO_INCREMENT");
if(field.getCheckConstraint()!=null && !field.getCheckConstraint().equals("") && !field.getCheckConstraint().equals("")) stringBuffer.append("\r\n, CHECK ("+field.getCheckConstraint()+")")
if(field.getIsUnique()) extraBuffer.append("\r\n, UNIQUE("+field.getName()+")");
if(field.getIsPrimaryKey()) extraBuffer.append("\r\n, PRIMARY KEY ("+field.getName()+")")
if(length>1) stringBuffer.append(",\r\n");
if(field.getDefaultValue!=null && !field.getDefaultValue().equals("") && !field.getDefaultValue().equals("0")) endingBuffer.append("ALTER TABLE "+table.getName()+"\r\n ALTER "+field.getName()+" SET DEFAULT '"+field.getDefaultValue()+"');
}
stringBuffer.append(extraBuffer.toString());
extraBuffer.delete(0,extraBuffer.length());
stringBuffer.append(") ENGINE = "+table.getDatabaseEngine()+";\r\n");
stringBuffer.append("\r\n");
stringBuffer.append("\r\n");
stringBuffer.append("\r\n");
stringBuffer.append(endingBuffer.toString());
stringBuffer.append("\r\n");
stringBuffer.append("\r\n");
stringBuffer.append("\r\n");

}
return stringBuffer.toString();
}



public static String GenerateJPAScripts(LinkedList<ProjectTable> tables)
{

}



}