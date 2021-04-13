package com.springSecurity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

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
	
	@GetMapping("/listTeam")
	public List<String> listTeam() {
		List<String> list = new ArrayList();
		list.add("Team Memeber 1");
		list.add("Team Memeber 2");
		list.add("Team Memeber 3");
		return list;
	}
	
	@GetMapping("/listEmp")
	public List<String> listEmp() {
		List<String> list = new ArrayList();
		list.add("Team Memeber 1");
		list.add("Team Memeber 2");
		list.add("Team Memeber 3");
		list.add("Team Lead 1");
		list.add("Team Lead 2");
		return list;
	}

}
