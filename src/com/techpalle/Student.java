package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Student
{
	public static  String url="jdbc:mysql://localhost:3306/palle";
	public static String username="root";
	public static String password="admin";
	
	public static Connection con=null;
	public static Statement s=null;
	public static PreparedStatement ps =null;
	public static ResultSet rs=null;
	
		public static void creating()
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection(url, username, password);
				
				s=con.createStatement();
				
				s.executeUpdate("create table student (sid int primary key auto_increment,"
						+ "sname varchar(40)not null,sub varchar(40) ,email varchar(80) unique)");
				
				
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					if(s != null)
					{
						s.close();
					}
					if(con !=null) 
					{
						con.close();
					}
				}
				catch(SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		public static void inserting(String name,String subj,String mail) 
		{	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url, username, password);
				
				ps = con.prepareStatement("insert into student (sname, sub, email)values(?,?,?)");
				
				ps.setString(1, name);
				ps.setString(2, subj);
				ps.setString(3, mail);
				
				ps.executeUpdate();
				}
				catch(ClassNotFoundException | SQLException e) 
				{
				e.printStackTrace();
				}
				finally {
				try {
						if(ps != null)
						{
							ps.close();
						}
						if(con !=null) 
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
		
		public static void updating(int sid,String sub,String email )
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url, username, password);
				
				ps = con.prepareStatement("update student set sub=?,email=? where sid=?");
				
				ps.setString(1, sub);
				ps.setString(2, email);
				ps.setInt(3, sid);
				
				ps.executeUpdate();
				
			} 
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
			finally {
				try {
					if(ps != null)
					{
						ps.close();
					}
					if(con !=null) 
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
		
		public static void deleting(int sid) 
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection(url, username, password);
				
				ps = con.prepareStatement("delete from student where sid=?");
				
				
				ps.setInt(1, sid);
				
				ps.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			
			finally {
				try {
					if(ps != null)
					{
						ps.close();
					}
					if(con !=null) 
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
	public static void read() 
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection(url,username,password);
				
				
				String qry="select * from student";
				
				s=con.createStatement();
				
				 rs=s.executeQuery(qry);
				
				while (rs.next()==true) 
				{
					
					System.out.println(rs.getInt("sid"));
					System.out.println(rs.getString("sname"));
					System.out.println(rs.getString("sub"));
					System.out.println(rs.getString("email"));
				}
				
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
			try {
				if(rs != null)
				{
				 rs.close();
				}
				if(s !=null)
				{
					s.close();
				
				}
				if(con !=null)
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
			
		
	
	
	

