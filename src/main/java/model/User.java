package model;

public class User {

	private String userName;
	private String passWord;
	
	//Constructors
	public User() {}
	
	public User(String username, String password){
		this.userName = username;
		this.passWord = password;
	}
	
	//Getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
