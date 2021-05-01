package com.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springSecurity.jwt.JwtFilter;
import com.springSecurity.user.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(name = "myproject.security.enabled", havingValue = "true", matchIfMissing = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtFilter jwtFilter;

	/**
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 *           Exception { auth .inMemoryAuthentication()
	 *           .withUser("admin1").password(passwordEncoder().encode("admin")).roles("ADMIN").and()
	 *           .withUser("admin2").password(passwordEncoder().encode("admin")).roles("ADMIN").authorities("MANAGER").and()
	 *           .withUser("user1").password(passwordEncoder().encode("user")).roles("USER").and()
	 *           .withUser("user2").password(passwordEncoder().encode("user")).roles("USER").authorities("LEAD");
	 *           }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests().antMatchers("/").permitAll()// bypass authetication and authorization
				.antMatchers("/authenticate").permitAll().antMatchers("/empList").permitAll()// bypass authetication and
																								// authorization
				.antMatchers("/empList2").permitAll()// bypass authetication and authorization
				.antMatchers("/profile").authenticated()// Authentication only required
				.antMatchers("/user/**").hasRole("USER")// Authetication and Authorization required
				.antMatchers("/admin/**").hasRole("ADMIN")// Authetication and Authorization required
				.antMatchers("/useroradmin").hasAnyRole("ADMIN", "USER")// Either admin or user role required
				// permissions
				.antMatchers("/listTeam").hasAuthority("LEAD")// Authetication, Authorization (since /user/** is
																// required) and permission required
				.antMatchers("/listEmp").hasAuthority("MANAGER")// Authetication, Authorization and permission required
				.antMatchers("/**").denyAll().and().httpBasic();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImpl);
		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
//		return new BCryptPasswordEncoder();
	}

}
