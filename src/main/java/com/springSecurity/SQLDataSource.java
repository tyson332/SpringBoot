package com.springSecurity;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class SQLDataSource {
	
	@Autowired
	SimpleDriverDataSource ds;
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws SQLException {
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
	    return jdbcTemplate;
	}
	
	@Bean
	public SimpleDriverDataSource getDriver() throws SQLException {
	    SimpleDriverDataSource ds = new SimpleDriverDataSource();
	    ds.setDriver(new oracle.jdbc.driver.OracleDriver());
	    ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	    ds.setUsername("root");
	    ds.setPassword("root");
	    return ds;
	}
	
}
