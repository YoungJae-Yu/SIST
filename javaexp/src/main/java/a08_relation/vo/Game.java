package javaexp.a08_relation.vo;

public class Game {
	private String Gname;
	private User user;

	public Game() {
		// TODO Auto-generated constructor stub
	}
	public void starter(User user) {
		this.user = user;
		System.out.println("용사님 "+Gname+"에 접속하신것을 환영합니다!");
		System.out.println("닉네임, 직업, 성별을 입력해주세요!");
		System.out.println(user.getNickname()+"님의 모험을 시작합니다!");
	}
	public void userInfo() {
		System.out.println("#생성된 유저 정보#");
		System.out.println("닉네임:"+user.getNickname());
		System.out.println("직업:"+user.getJob());
		System.out.println("성별:"+user.getGender());
		
	}
	
	public Game(String gname) {
		Gname = gname;
	}

}