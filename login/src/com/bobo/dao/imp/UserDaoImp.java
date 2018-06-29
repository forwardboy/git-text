package com.bobo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bobo.dao.UserDao;
import com.bobo.model.User;
import com.bobo.util.DBTool;

public class UserDaoImp implements UserDao {

	@Override
	public User login(String username, String password) {
		Connection con = DBTool.getCon();
		String sql = "select * from user where username=? and password=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setJianjie(rs.getString("jianjie"));
				user.setAge(rs.getInt("age"));

			}
		} catch (SQLException e) {
		} finally {
			DBTool.close(rs);
			DBTool.close(pstmt);
			DBTool.close(con);

		}

		return user;
	}

	@Override
	public boolean register(User user) {
		Connection con = DBTool.getCon();
		String sql = "insert into user (username,password,jianjie,age) value(?,?,?,?)";
		PreparedStatement pstmt = null;
		boolean b = false;
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getJianjie());
			pstmt.setInt(4, user.getAge());
			pstmt.execute();
			con.commit();
			b = true;
		} catch (SQLException e) {
			DBTool.rollback(con);

		} finally {
			DBTool.close(con);
			DBTool.close(pstmt);
		}
		return b;
	}
}