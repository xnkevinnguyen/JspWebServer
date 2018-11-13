package model;



import java.util.Date;

import enums.UserRole;

public class UserModel {
	private long user_id;
	private String first_name;
	private String email;
	private String password;
	private UserRole role;
	private Date last_login;
	private String created;
	

	public UserModel() {
		this.first_name = null;
		this.email = null;
		this.password = null;
		this.role = UserRole.MEMBER;
		this.last_login =  null;
	}
	
	public UserModel(long user_id) {
		this.user_id = user_id;
	}
	
	public UserModel(String first_name, String email, String password) {
		this.first_name = first_name;
		this.email = email;
		this.password = password;
		this.role = UserRole.MEMBER;
		this.last_login =  new Date(System.currentTimeMillis());
	}
	
	public UserModel(long user_id, String first_name, String email, UserRole role) {
		this.user_id = user_id;
		this.first_name = first_name;
		this.email = email;
		this.role = role;
		this.last_login =  new Date(System.currentTimeMillis());
	}
	

	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(String role) {
		switch(role) {
		case "MEMBER":
			this.role = UserRole.MEMBER;
			break;
		case "ADMIN":
			this.role = UserRole.ADMIN;
			break;
		case "DISABLED":
			this.role = UserRole.DISABLED;
			break;
		default:
			this.role = UserRole.MEMBER;
			break;
		}
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	
}
