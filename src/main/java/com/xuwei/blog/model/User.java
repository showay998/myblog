package com.xuwei.blog.model;

public class User extends BaseModel {

	private static final long serialVersionUID = 1L;
	private String userName;// 用户名
	private transient String passwd;// 密码
	private String telphone;// 手机号
	private String email;// 邮箱

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
