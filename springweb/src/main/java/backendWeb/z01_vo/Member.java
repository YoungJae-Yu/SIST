package backendWeb.z01_vo;
// backendWeb.z01_vo.Member
import java.util.Date;

public class Member {
	private String id;
	private String pass;
	private String name;
	private int point;
	private String auth;
	private Date regdate;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	// backWeb2.z01_vo.Member
	// Member(String id, String pass, String name, String auth, int point) 
	public Member(String id, String pass, String name, String auth, int point) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
		this.auth = auth;
	}


	// 로그인시 사용
	public Member(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	// 등록을 위한 생성자
	public Member(String id, String pass, String name, int point, String auth) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
		this.auth = auth;
	}	
	
	// 로그인 후, 데이터 가져올 때 사용.
	public Member(String id, String pass, String name, int point, String auth, Date regdate) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.point = point;
		this.auth = auth;
		this.regdate = regdate;
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
	
}
