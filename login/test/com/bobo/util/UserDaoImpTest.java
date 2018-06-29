package com.bobo.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bobo.dao.imp.UserDaoImp;
import com.bobo.model.User;

public class UserDaoImpTest {
	
    UserDaoImp udao;
	@Before
 
	public void setUp() throws Exception {
		udao=new UserDaoImp();
	}

	@After
	public void tearDown() throws Exception {
		udao=null;
	}

	@Test
	public void testRegister() {
		User user=new User();
		user.setUsername("xlm");
		user.setPassword("666");
		user.setAge(1);
        user.setJianjie("hahah");
		boolean z=udao.register(user);
		assertEquals(true, z);
	}
	@Test
	public void testLogin()
	{
		User user=udao.login("xlm", "666");
		System.out.println(user);
		assertNotNull(user);
	}
	/*@Test
	public void testDeleteByUserName()
	{
		boolean z=udao.deleteByUserName("xlm");
		assertEquals(true, z);
	}
	@Test
   public void testGetLastRegisterUser()
   {
	   String s=udao.getLastRegisterUser();
	   assertEquals("xxxxxxx", s);
   }*/
}
