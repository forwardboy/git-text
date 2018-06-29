package com.bobo.dao;

import com.bobo.model.User;

public interface UserDao {
	public User login(String username, String password);

	public boolean register(User user);
}
