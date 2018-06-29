package com.bobo.iter;

public interface Common {
	String REG_USERNAME_EX = "[a-zA-Z0-9]{3,15}";
	String REG_PASSWORD_EX = "[0-9]{3,15}";
	String ERROR_USERNAME = "用户名必须3,15字母数字";
	String ERROR_PASSWORD = "密码必须是3-15位数字！！！";
	String ERROR_PASSWORD_NOT_SAME = "两次密码不一致！！！";
	String ERROR_LOGIN = "登录失败";
	String ERROR_REGISTER = "注册失败";
}
