import com.thinking.machines.dmframework.*;
import com.thinking.machines.dmframework.exceptions.*;
import com.thinking.machines.tmdmodel.dl.*;
class eg
{
public static void main(String gg[])
{
try
{
Project project=new Project();
project.setTitle("Cart");
project.setMemberCode(1);
project.setDatabaseArchitectureCode(1);
project.setDateOfCreation(new java.sql.Date(System.currentTimeMillis()));
project.setTimeOfCreation(new java.sql.Time(System.currentTimeMillis()));
project.setNumberOfTable(0);
project.setWidth(800);
project.setHeight(1000);
DataManager dataManager=new DataManager();
dataManager.begin();
dataManager.insert(project);
dataManager.end();
}catch(Exception e)
{
System.out.println(e);
}
}
}