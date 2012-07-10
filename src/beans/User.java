package beans;

import java.io.*;

public class User implements Serializable {
	private int userID_;
	private String username_;
	private String nickname_;
	private String password_;

	public User() {}

	public User(int userID, String username, String nickname, String password) {
		this.userID_ = userID;
		this.username_ = username;
		this.nickname_ = nickname;
		this.password_ = password;
	}

	public int getUserID() {
		return userID_;
	}

	public void setUserID(int userID) {
		this.userID_ = userID;
	}

	public String getUsername() {
		return username_;
	}

	public void setUsername(String username) {
		this.username_ = username;
	}
	public String getNickname() {
		return nickname_;
	}

	public void setNickname(String nickname) {
		this.nickname_ = nickname;
	}

	public String getPassword(){
		return password_;
	}
	
	public void setPassword(String password){
		this.password_ = password;
	}
	public boolean checkPassword(String password) {
		return password != null && password.equals(this.password_);
	}
	

	public String toString() {
		return userID_ + ":" + username_ + ":" + nickname_ + ":"+password_;
	}
}

