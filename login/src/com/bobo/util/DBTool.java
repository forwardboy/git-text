package com.bobo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.Statement;

public class DBTool {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String url = "jdbc:mysql://localhost:3306/login";
	private static String user = "root";
	private static String password = "123456";

	public static Connection getCon() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	// 测试数据库连接
	// public static void main(String[] args) {
	// System.out.println(getCon());
	// }

}