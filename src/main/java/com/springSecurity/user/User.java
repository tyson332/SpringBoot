package com.springSecurity.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
	
	private String id;
	private String username;
	private String password;
	private String roles;
	private String permissions;
	
	public User() {
		
	}
	public User(String id, String username, String password, String roles, String permissions) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.permissions = permissions;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public List<String> getRolesList(){
		List<String> arrayList = new ArrayList<>(); 
		if(this.roles.length()>0) {
			Collections.addAll(arrayList,this.roles.split(",")); 
		}
		return arrayList;
	}
	
	public List<String> getPermissionsList(){
		List<String> arrayList = new ArrayList<>(); 
		if(this.roles.length()>0) {
			Collections.addAll(arrayList,this.permissions.split(",")); 
		}
		return arrayList;
	}
}
