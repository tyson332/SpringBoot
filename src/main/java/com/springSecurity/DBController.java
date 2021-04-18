package com.springSecurity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurity.user.User;
import com.springSecurity.user.UserService;

@RestController
public class DBController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/empList")
	public List<String> getEmpList(){
		List<String>data=jdbcTemplate.queryForList("select emp_name from emp1",String.class);
		return data;
	}
	
	
	@PostMapping("/empList2")
	public User getEmpList2(@RequestBody Map<String,String> data){
		return userService.getEmpDetails(data.get("loginId"));
	}
}
