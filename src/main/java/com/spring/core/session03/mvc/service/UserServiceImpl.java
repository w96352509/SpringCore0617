package com.spring.core.session03.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.core.session03.mvc.model.User;
import com.spring.core.session03.mvc.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao; // @Autowired 自動配置
	
	@Override
	public void addUser(User user) {
		
		// 通過
		System.out.println("Service    --> add User :" + user);
		userDao.createUser(user);
		
	}

}
