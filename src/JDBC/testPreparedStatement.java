package JDBC;

import java.sql.*;
import java.util.*;
import java.io.*;


public class testPreparedStatement
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;

	public void initParam(String paramFile)throws Exception
	{
		//使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public void insertUseStatement()throws Exception
	{
		long start = System.currentTimeMillis();
		try
		{
			//使用Connection来创建一个Statment对象
			stmt = conn.createStatement();
			//需要使用100条SQL语句来插入100条记录
			for (int i = 0; i < 100 ; i++ )
			{
				stmt.executeUpdate("insert into student_table values(null,'姓名"
					+ i + "',1)");
			}
			System.out.println("使用Statement费时:" + (System.currentTimeMillis() - start));
		}
		//使用finally块来关闭数据库资源
		finally
		{
			if (stmt != null)
			{
				stmt.close();
			}
		}
	}

	public void insertUsePrepare()throws Exception
	{
		long start = System.currentTimeMillis();
		try
		{
			//使用Connection来创建一个PreparedStatment对象
			pstmt = conn.prepareStatement("insert into student_table values(null,?,1)");
			//100次为PreparedStatement的参数设置，就可以插入100条记录
			for (int i = 0; i < 100 ; i++ )
			{
				pstmt.setString(1 , "姓名" + i);
				pstmt.executeUpdate();
			}
			System.out.println("使用PreparedStatement费时:" + (System.currentTimeMillis() - start));
		}
		//使用finally块来关闭数据库资源
		finally
		{
			if (pstmt != null)
			{
				pstmt.close();
			}
		}

	}
	//定义打开连接的方法
	public void getConn()throws Exception
	{
		if (conn == null)
		{
			//加载驱动
			Class.forName(driver);
			//获取数据库连接
			conn = DriverManager.getConnection(url , user , pass);
		}
	}
	//定义关闭连接的方法
	public void closeConn()throws Exception
	{
		if (conn != null)
		{
			conn.close();
		}
	}

	public static void main(String[] args) throws Exception
	{
		testPreparedStatement pt = null;
		try
		{
			pt = new testPreparedStatement();
			pt.initParam("mysql.ini");
			pt.getConn();
			pt.insertUseStatement();
			pt.insertUsePrepare();
		}
		finally
		{
			pt.closeConn();
		}
	}
}