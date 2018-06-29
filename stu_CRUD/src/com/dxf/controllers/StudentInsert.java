package com.dxf.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxf.dao.StuDao;
import com.dxf.dao.Imp.StuDaoImp;
import com.dxf.model.Student;

public class StudentInsert extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String encoding = "UTF-8";
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
			int stu_number = Integer.parseInt(request.getParameter("stu_number"));
			String name = request.getParameter("name");
			String sex = request.getParameter("sex"); 
			String birthdate = request.getParameter("birthdate");
			String birt = birthdate.substring(2);

				Student s = new Student();
				StuDao sdao = new StuDaoImp();
				s.setStu_number(stu_number);
				s.setName(name);
				s.setSex(sex);
				s.setBirthdate(birt);
				boolean b = sdao.insert(s);
				if(b==true){
					request.setAttribute("tishi", "操作成功");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
					request.setAttribute("tishi", "操作失败");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			
		
	}


}
