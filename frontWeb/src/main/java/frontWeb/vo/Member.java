package frontWeb.vo;

import java.util.Date;

public class Member {
	private String id;
	private String pass;
	private String name;
	private int point;
	private String auth;
	private Date regdate;
	// 로그인시 사용
	public Member(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	// 로그인 후 데이터 가져올 때 사용.
	public Member(String id, String pass, String name, int point, String auth, Date regdate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
		this.auth = auth;
		this.regdate = regdate;
	}
	public Member(String id, String pass, String name, int point, String auth) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
		this.auth = auth;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
}
