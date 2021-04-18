package com.springSecurity.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDAO userDAO;
	
	public User getEmpDetails(String userName) {
		return userDAO.getEmpDetails(userName);
	}
}
