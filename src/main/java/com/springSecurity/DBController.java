package com.springSecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/empList")
	public List<String> getEmpList(){
		List<String>data=jdbcTemplate.queryForList("select emp_name from emp1",String.class);
		return data;
	}
}
