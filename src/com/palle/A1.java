package com.palle;

import java.sql.*;

public class A1 {

	Connection con = null;
	Statement s = null;
	PreparedStatement ps=null;
//	
//	 String selectSQL = "SELECT * FROM emp2 WHERE id =?,?,?";

	public static String url = "jdbc:mysql://localhost:3306/jdbc";
	public String username = "root";
	public static String password = "admin";

	public void creating() {

		try {
			// Step 1:
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2:
			con = DriverManager.getConnection(url, username, password);

			// Step 3:
			s = con.createStatement();

			// Step 4:
			// s.executeUpdate("create table emp2(eid int primary key auto_increment, ename
			// varchar(50) not null ,esal int , email varchar(50) unique )");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} 
		finally 
		{
			if (s != null) 
			{
				try 
				{
					s.close();
				} 
				catch (SQLException e) 
				{

					e.printStackTrace();
				}
			}
			if (con != null) 
			{
				try
				{
					con.close();
				} 
				catch (SQLException e) 
				{

					e.printStackTrace();
				}
			}
		}

	}

	public void inserting(String name, int sal, String mail) throws ClassNotFoundException, SQLException 
	{
		
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);
			
			ps=con.prepareStatement("insert into emp2(ename,esal,email) values (?,?,?)");			
			ps.setString(1, name);
			ps.setInt(2, sal);
			ps.setString(3, mail);
			
			
			ps.executeUpdate();
			
			
			ps.close();
			con.close();
		
	}
	
	public void updating( int id,String name, int sal, String mail) throws ClassNotFoundException, SQLException 
	{
		
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);
			
			ps=con.prepareStatement("update emp2 set ename=? , esal =? , email=? where eid=?");			
			
			ps.setString(1, name);
			ps.setInt(2, sal);
			ps.setString(3, mail);
			ps.setInt(4, id);
			
			ps.executeUpdate();
			
			
			ps.close();
			con.close();
		
	}
	
	public void deleting( int id) throws ClassNotFoundException, SQLException 
	{
		
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);
			
			ps=con.prepareStatement("delete from emp2  where eid=?");			
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			
			ps.close();
			con.close();
		
	}


}
