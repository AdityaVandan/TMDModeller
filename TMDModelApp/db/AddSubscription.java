import java.sql.*;
class AddSubscription
{
public static void main(String gg[])
{
try
{
int monthly_rate=Integer.parseInt(gg[0]);
int yearly_rate=Integer.parseInt(gg[1]);
int free_projects=Integer.parseInt(gg[2]);
int free_tables=Integer.parseInt(gg[3]);
java.util.Date newDate=new java.util.Date();
Date date=new Date(newDate.getTime());
java.text.SimpleDateFormat simpleDateFormat=new java.text.SimpleDateFormat("dd/mm/yy");
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tmdmodeldb","tmdmodeldb","tmdmodeldb");
PreparedStatement ps=connection.prepareStatement("insert into subscription_plan (monthly_rate,yearly_rate,free_projects,free_tables,effective_from) values(?,?,?,?,?)");
String effective_from=simpleDateFormat.format(date);
ps.setInt(1,monthly_rate);
ps.setInt(2,yearly_rate);
ps.setInt(3,free_projects);
ps.setInt(4,free_tables);
ps.setDate(5,date);
ps.executeUpdate();
ps.close();
connection.close();
}catch(SQLException sqlException)
{
System.out.println(sqlException);
}
catch(ClassNotFoundException cnfe)
{
System.out.println(cnfe);
}
}
}