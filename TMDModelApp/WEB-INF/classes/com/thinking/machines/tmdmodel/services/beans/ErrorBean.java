package com.thinking.machines.tmdmodel.services.beans;
import java.util.*;
public class ErrorBean implements java.io.Serializable
{
private LinkedList<String> genericErrors=new LinkedList<>();
private HashMap<String,String> propertyErrors=new HashMap<>();
public void addError(String property,String error)
{
propertyErrors.put(property,error);
}
public void addError(String error)
{
genericErrors.add(error);
}
public String getError(String property)
{
String err=propertyErrors.get(property);
if(err==null) err="";
return err;
}
public LinkedList<String> getGenericErrors()
{
return this.genericErrors;
}
public boolean hasErrors()
{
return this.propertyErrors.size()>0 || this.genericErrors.size()>0;
}
}