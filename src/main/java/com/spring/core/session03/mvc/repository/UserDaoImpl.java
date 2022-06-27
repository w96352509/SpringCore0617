package com.spring.core.session03.mvc.repository;

import org.springframework.stereotype.Repository;

import com.spring.core.session03.mvc.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public void createUser(User user) {
			System.out.println("Repository --> 新增使用者 :" + user);
	}
	
	
	
}
