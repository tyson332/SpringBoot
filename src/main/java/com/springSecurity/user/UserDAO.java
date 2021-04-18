package com.springSecurity.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User getEmpDetails(String userName) {
		StringBuilder query = new StringBuilder();
		query.append("select EMP_ID, EMP_USERNAME, EMP_PASS, EMP_ROLES, EMP_PERMISSIONS from emp_temp where EMP_USERNAME=?");
		User user =jdbcTemplate.queryForObject(query.toString(),new Object[] {userName}, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(
						rs.getString("EMP_ID"),
						rs.getString("EMP_USERNAME"),
						rs.getString("EMP_PASS"),
						rs.getString("EMP_ROLES"),
						rs.getString("EMP_PERMISSIONS"));
			}
			
		});
		return user;
	}
}
