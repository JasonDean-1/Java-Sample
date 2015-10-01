package JDBC;


import java.sql.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class testLoginFrame
{
	private final String PROP_FILE = "mysql.ini";

	//driver是数据库驱动类,通过查驱动文档得到
	private String driver;
	//url是数据库的服务地址
	private String url;
	private String user;
	private String pass;
	//登陆界面的GUI组件
	private JFrame jf = new JFrame("登陆");
	private JTextField userField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("登陆");
	//执行JDBC操作的对象
	private Connection conn;
	private	Statement stmt;
	private	PreparedStatement pstmt;
	private ResultSet rs;

	public void init()throws Exception
	{
		Properties connProp = new Properties();
		connProp.load(new FileInputStream(PROP_FILE));
		driver = connProp.getProperty("driver");
		url = connProp.getProperty("url");
		user = connProp.getProperty("user");
		pass = connProp.getProperty("pass");
		//为登陆按钮添加事件监听器
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//登陆成功则显示"登陆成功"
				if (validate(userField.getText(), passField.getText()))
				{
					JOptionPane.showMessageDialog(jf, "登陆成功");
				}
				//否则显示"登陆失败"
				else
				{
					JOptionPane.showMessageDialog(jf, "登陆失败");
				}
			}
		});
		jf.add(userField , BorderLayout.NORTH);
		jf.add(passField);
		jf.add(loginButton , BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}

//	private boolean validate(String userName, String userPass)
//	{
//		try
//		{
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url , user ,pass);
//			stmt = conn.createStatement();
//			String sql = "select * from jdbc_test "
//				+ "where jdbc_name='" + userName 
//				+ "' and jdbc_desc='" + userPass + "'";
//			System.out.println(sql);
//			//如果查询的ResultSet里有超过一条的记录，则登陆成功
//			if (stmt.executeQuery(sql).next())
//			{
//				return true;
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			try
//			{
//				if (rs != null)
//				{
//					rs.close();
//				}
//				if (stmt != null)
//				{
//					stmt.close();
//				}
//				if (conn != null)
//				{
//					conn.close();
//				}				
//			}
//			catch (Exception e)
//			{
//				e.printStackTrace();
//			}
//		}
//		return false;
//	}

	private boolean validate(String userName, String userPass)
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url , user ,pass);
			pstmt = conn.prepareStatement("select * from jdbc_test "
				+ "where jdbc_name=? and jdbc_desc=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, userPass);
			//如果查询的ResultSet里有超过一条的记录，则登陆成功
			if (pstmt.executeQuery().next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
				}
				if (pstmt != null)
				{
					pstmt.close();
				}
				if (conn != null)
				{
					conn.close();
				}				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}


    public static void main(String[] args) throws Exception
    {
		new testLoginFrame().init();
    }
}

