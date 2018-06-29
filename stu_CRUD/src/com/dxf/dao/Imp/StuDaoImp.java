package com.dxf.dao.Imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dxf.dao.StuDao;
import com.dxf.model.Student;
import com.dxf.util.DBTool;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class StuDaoImp implements StuDao{

	@Override
	public boolean insert(Student student) {
		 Connection con=(Connection) DBTool.getCon();
		 String sql="insert into student (stu_number,name,sex,birthdate) values(?,?,?,?)";
		 try {
			con.setAutoCommit(false);
			PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, student.getStu_number());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getSex());
			pstmt.setString(4, student.getBirthdate());
			pstmt.execute();
			con.commit();
			return true;
		} catch (SQLException e) {
			 DBTool.rollback(con);
		}
		return false;
	}
	

	@Override
	public Student select(int stu_number) {
		Connection con=(Connection) DBTool.getCon();
		 String sql="select * from student where stu_number=?";
		 Student student=null;
		 ResultSet rs=null;
		 PreparedStatement pstmt=null;
		 //con.prepareCall(sql)//���ô洢��̣��ٶ�
		try {
			pstmt= (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, stu_number);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				student = new Student();
				student.setId(rs.getInt(1));
				student.setStu_number(rs.getInt(2));
				student.setName(rs.getString(3));
				student.setSex(rs.getString(4));
				student.setBirthdate(rs.getString(5));
				 
			}
			
			
		} catch (SQLException e) {
			 
		}finally{
			DBTool.close(rs);
			DBTool.close(pstmt);
			DBTool.close(con);
			 
		}
		 
		return student;
	}

	@Override
	public boolean update(Student st) {
		 Connection con=(Connection) DBTool.getCon();
		 Statement stmt=null;
		 StuDao sdao = new StuDaoImp();
		 String sql="update student set name='"+st.getName()+"',sex='"+st.getSex()+"' ,birthdate='"+st.getBirthdate()+"' where stu_number="+st.getStu_number();
		 try {
			 stmt=con.createStatement();
			 stmt.execute(sql);
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			 DBTool.close(con);
		}
		return false;
	}

	@Override
	public boolean delect(int stu_number) {
		 Connection con=(Connection) DBTool.getCon();
		 PreparedStatement pstmt=null;
		 boolean success=false;
		 String sql="delete from student where stu_number=?";
		 try {
			con.setAutoCommit(false);
			pstmt=(PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, stu_number);
			pstmt.execute();
			con.commit();
			success=true;
		} catch (SQLException e) {
			 DBTool.rollback(con);
		}//
		 finally{
			 
			 DBTool.close(pstmt);
			 DBTool.close(con);
		 }
		return success;
	}

}
