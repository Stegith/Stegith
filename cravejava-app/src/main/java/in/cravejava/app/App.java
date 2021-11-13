package in.cravejava.app;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
public class App
{
	public static void main(String[] args) {
		try
		{
			Scanner sc=new Scanner(System.in);
			// TODO Auto-generated method stub
		System.out.println("Enter the Department");
		String n=sc.nextLine();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myprojects","root","");
	Statement ps=con.createStatement();	
	String s="select distinct(Dept) from project";
	ResultSet rs=ps.executeQuery(s);
	ArrayList<String> obj=new ArrayList<String>();
	while(rs.next())
	{
	obj.add(rs.getString("Dept"));
	}
	String str="select COUNT(dept) from project where Dept='"+n+"'";
	ResultSet r=ps.executeQuery(str);
	if(obj.contains(n))
	{
		while(r.next())
		{
		System.out.println("The details are from "+n);
		System.out.println("Students count: "+r.getInt("Count(Dept)"));
	}
		
	}
	else
	{
		System.out.println("Unknown Department----Try again..");
	}
	con.close();
		}
catch(Exception e)
{
	e.printStackTrace();
}

	}

}
