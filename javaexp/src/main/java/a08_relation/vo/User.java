package javaexp.a08_relation.vo;

public class User { 
	private String nickname;//게임의 유저 필드 선언
	private String job;
	private String gender;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String nickname, String job, String gender) {
		this.nickname = nickname;
		this.job = job;
		this.gender = gender;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
