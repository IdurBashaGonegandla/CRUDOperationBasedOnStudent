package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A 
{
	public  void creating()
	{
	Connection con = null;
	Statement s=null;
		try 
		{
			//Step 1;
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2:
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			
			//Step 3:
			s=con.createStatement();
			
			//Step 4:
			s.executeUpdate("create table emp1(ename varchar(40),esal int)");
			
		} 
		catch (ClassNotFoundException e) 
		{
		
			e.printStackTrace();
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		//Step 5:
		finally
		{
			try 
			{
				if(s!=null)
				{
				s.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
	
	}
	public void inserting(String name, int sal)
	{
		Connection con=null;
		Statement s=null;
		
		
		try 
		{
			//Step 1:
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2:
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			
			//Step 3:
			s=con.createStatement();
			
			//Step 4:
			String qry= "insert into emp1 values('"+name+"','"+sal+"')";
		    s.executeUpdate(qry);
			
			
			
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		//Step 5:
		finally 
		{
			try 
			{
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}
				
			} 
			catch (SQLException e) 
			{
		
				e.printStackTrace();
			}			
		}
	}

}
