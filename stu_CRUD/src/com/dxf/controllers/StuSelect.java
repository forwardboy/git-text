package com.dxf.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxf.dao.StuDao;
import com.dxf.dao.Imp.StuDaoImp;
import com.dxf.model.Student;

public class StuSelect extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int stu_number = Integer.parseInt(request.getParameter("stu_number"));
		Student student = null;
		StuDao sdao = new StuDaoImp();
		student = sdao.select(stu_number);
		if (student != null) {
			request.setAttribute("setudent_id", student.getId());
			request.setAttribute("setudent_stu_number", student.getStu_number());
			request.setAttribute("setudent_name", student.getName());
			request.setAttribute("setudentid_sex", student.getSex());
			request.setAttribute("setudentid_birthdate", student.getBirthdate());
			request.setAttribute("tishi", "操作成功");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("tishi", "操作失败");
			request.getRequestDispatcher("index.jsp").forward(request,
					response);
		}

	}

}
