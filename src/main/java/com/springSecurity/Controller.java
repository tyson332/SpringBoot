package com.springSecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	/**
	 * Accessable without Authentication and authorization
	 * @return
	 */
	@GetMapping("/")
	public String getWelcomePage() {
		return "Hello....welcome to our website";
	}
	
	/**
	 * All logged in users
	 * Accessable with authentication but authorization not required
	 * @return
	 */
	@GetMapping("/profile")
	public String getProfile() {
		return "Welcome to profile page";
	}
	
	/**
	 * Only logged in user with role USER can access this
	 * @return
	 */
	@GetMapping("/user")
	public String getUser() {
		return "Hello User Role";
	}
	
	/**
	 * Only loggged in admin can access this
	 * @return
	 */
	@GetMapping("/admin")
	public String getAdmin() {
		return "Hello Admin Role";
	}
	
	/**
	 * Either User or Admin
	 * @return
	 */
	@GetMapping("/useroradmin")
	public String getUserOrAdmin() {
		return "Hello User or Admin Role";
	}
	

}
