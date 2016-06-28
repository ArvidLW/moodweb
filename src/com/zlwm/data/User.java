package com.zlwm.data;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private String phoneNum;
	private String email;
	private String headImage;
	
	public User(int id, String userName, String passWord, String phoneNum, String email, String headImage) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.userName=userName;
		this.passWord=passWord;
		this.phoneNum=phoneNum;
		this.email=email;
		this.headImage=headImage;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPsw() {
		return passWord;
	}

	public void setPsw(String passWord) {
		this.passWord = passWord;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
}
