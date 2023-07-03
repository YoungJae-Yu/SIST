package project.janjan.VO;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String address;
	private String contact;
	private String email;
	private int auth;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public Member(String id, String pwd, String name, String address, String contact, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.email = email;
	}


	public Member(String id) {
		super();
		this.id = id;
	}

	public Member(String id, String pwd, String contact) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public Member(String id, String pwd, String name, String address, String contact, String email, int auth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.auth = auth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
