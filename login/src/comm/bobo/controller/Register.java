package comm.bobo.controller;

import java.io.IOException;
import static java.lang.Integer.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bobo.dao.UserDao;
import com.bobo.dao.imp.UserDaoImp;
import com.bobo.iter.Common;
import com.bobo.model.User;

public class Register extends HttpServlet implements Common {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String jianjie = request.getParameter("jianjie");
		String sage = request.getParameter("age");
		int age = parseInt(sage);

		if (!password.matches(REG_PASSWORD_EX)
				|| !repassword.matches(REG_PASSWORD_EX)) {
			request.setAttribute("error", ERROR_PASSWORD);
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else {
			if (!repassword.equals(password)) {
				request.setAttribute("error", ERROR_PASSWORD_NOT_SAME);
				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			} else {

				if (!username.matches(REG_USERNAME_EX)) {
					request.setAttribute("error", ERROR_USERNAME);
					request.getRequestDispatcher("register.jsp").forward(
							request, response);
				} else {
					User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					user.setJianjie(jianjie);
					user.setAge(age);
					UserDao udao = new UserDaoImp();
					boolean z = udao.register(user);
					if (z) {
						// 用请求重定向，不能用转发，否则会有重复提交
						response.sendRedirect("login.jsp");
					} else {
						request.setAttribute("error", ERROR_REGISTER);
						request.getRequestDispatcher("register.jsp").forward(
								request, response);
					}
				}
			}
		}
	}
}
