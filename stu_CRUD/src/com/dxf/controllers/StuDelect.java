package com.dxf.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxf.dao.StuDao;
import com.dxf.dao.Imp.StuDaoImp;

public class StuDelect extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int stu_number = Integer.parseInt(request.getParameter("stu_number"));
	
		StuDao sdao = new StuDaoImp();
		
		boolean b = sdao.delect(stu_number);
		if(b==true){
			request.setAttribute("tishi", "操作成功");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("tishi", "操作失败");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request, response);
			}


}
