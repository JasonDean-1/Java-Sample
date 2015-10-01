package JDBC;

import java.sql.*;
import java.util.*;
import java.io.*;


public class testCallableStatementTest
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	Connection conn;
	CallableStatement cstmt;

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

	public void callProcedure()throws Exception
	{
		try
		{
			//加载驱动
			Class.forName(driver);
			//获取数据库连接
			conn = DriverManager.getConnection(url , user , pass);
			//使用Connection来创建一个CallableStatment对象
			cstmt = conn.prepareCall("{call add_pro(?,?,?)}");
			cstmt.setInt(1, 4);
			cstmt.setInt(2, 5);
			//注册CallableStatement的第三个参数是int类型
			cstmt.registerOutParameter(3, Types.INTEGER);
			//执行存储过程
			cstmt.execute();
			//获取，并输出存储过程传出参数的值。
            System.out.println("执行结果是: " + cstmt.getInt(3));
		}
		//使用finally块来关闭数据库资源
		finally
		{
			if (cstmt != null)
			{
				cstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		testCallableStatementTest ct = new testCallableStatementTest();
		ct.initParam("mysql.ini");
		ct.callProcedure();
	}
}