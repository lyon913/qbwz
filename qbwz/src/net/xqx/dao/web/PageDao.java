package net.xqx.dao.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.xqx.controller.web.QyzzController;

public class PageDao
{

	public int getAmount(String sql) throws SQLException
	{
		Connection conn =getAptitudeConnection();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		int i= rs.getInt(1);
		rs.close();
		statement.close();
		conn.close();
		return i;
		
		
	}
//	链接考试成绩数据库
	public Connection getConnection()
	{

		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		String url = "jdbc:sqlserver://192.168.0.79:1433;databaseName=ExamReg";

		String username = "sa";

		String password = "xqx1234";

		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return conn;
	}
	/**
	 * 链接资质数据库
	 * 
	 * @return
	 */
	public Connection getAptitudeConnection()
	{

		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		String url = "jdbc:sqlserver://116.55.245.53:1433;databaseName=aptitude_2012";

		String username = "aptitude";

		String password = "LI,520.ni;hao'ma";

		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url, username,

			password);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return conn;
	}
	
	/**
	 * 关闭jdbc链接
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public void closeConnection(ResultSet rs,Statement st,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
