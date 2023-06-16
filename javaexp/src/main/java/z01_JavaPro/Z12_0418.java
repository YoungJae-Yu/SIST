package javaexp.z01_JavaPro;

import javaexp.a09_inherit.vo.PreviousLife;
import javaexp.a09_inherit.vo.Rebirth;

public class Z12_0418 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2023-04-18
//		[1단계:개념] 5. 1:다 관계의 필드기준 예제(필드만 선언, 메서드 처리x)를 만들어 보자
//		ex) user 객체와 game 객체 활용
//		Game g1 = new Game("소드아트온라인");
//		g1.starter(new User("아스나","검사","여자"));
//		g1.userInfo();
//		--- 결과 ---
//		용사님 소드아트온라인에 접속하신것을 환영합니다!
//		닉네임, 직업, 성별을 입력해주세요!
//		아스나님의 모험을 시작합니다!
//		#생성된 유저 정보#
//		닉네임:아스나
//		직업:검사
//		성별:여자
//		User 클래스
//		package javaexp.a08_relation.vo;
//
//		public class User { 
//			private String nickname;//게임의 유저 필드 선언
//			private String job;
//			private String gender;
//			public User() {
//				// TODO Auto-generated constructor stub
//			}
//			public User(String nickname, String job, String gender) {
//				this.nickname = nickname;
//				this.job = job;
//				this.gender = gender;
//			}
//			public String getNickname() {
//				return nickname;
//			}
//			public void setNickname(String nickname) {
//				this.nickname = nickname;
//			}
//			public String getJob() {
//				return job;
//			}
//			public void setJob(String job) {
//				this.job = job;
//			}
//			public String getGender() {
//				return gender;
//			}
//			public void setGender(String gender) {
//				this.gender = gender;
//			}
//		}
//		Game 클래스
//		package javaexp.a08_relation.vo;
//
//		public class Game {
//			private String Gname;
//			private User user;
//
//			public Game() {
//				// TODO Auto-generated constructor stub
//			}
//			public void starter(User user) {
//				this.user = user;
//				System.out.println("용사님 "+Gname+"에 접속하신것을 환영합니다!");
//				System.out.println("닉네임, 직업, 성별을 입력해주세요!");
//				System.out.println(user.getNickname()+"님의 모험을 시작합니다!");
//			}
//			public void userInfo() {
//				System.out.println("#생성된 유저 정보#");
//				System.out.println("닉네임:"+user.getNickname());
//				System.out.println("직업:"+user.getJob());
//				System.out.println("성별:"+user.getGender());
//				
//			}
//			
//			public Game(String gname) {
//				Gname = gname;
//			}
//
//		}
//		[1단계:개념] 6. 상속의 기본형식을 알고 접근제어자의 한계와 함께 예제를 만들어 보자.
//		ex) 게임 속 유저가 능력치를 그대로 가지고 환생하였다.. 상속 형태로 만들어보세요
//			하지만 고유 특성이 존재하여 옮겨지지않는 능력도 있다..(한계)
//		Rebirth r1 = new Rebirth();
//		System.out.println(r1.newAbility);//새로운 능력
//		System.out.println(r1.ability1); //상속된 능력
//		System.out.println(r1.ability2); //상속된 능력
//		System.out.println(r1.ability3); //상속된 능력
////		System.out.println(r1.ability4); private 접근제어자로 인하여 능력을 가져오지 못함!
////		System.out.println(r1.ability5); private 접근제어자로 인하여 능력을 가져오지 못함!
//		r1.skills(); //상속된 스킬
//		//부모객체
//		public class PreviousLife { // 
//			public String ability1 = "지력100";
//			public String ability2 = "힘100";
//			public String ability3 = "민첩함100";
//			private String ability4 = "인간의 외형";
//			private String ability5 = "여자친구 있음";
//			
//			public void skills() {
//				System.out.println("먹는다!");
//				System.out.println("잠든다!");
//			}
//
//			public PreviousLife() {
//				// TODO Auto-generated constructor stub
//			}
//			
//		}
//		//자식객체
//		package javaexp.a09_inherit.vo;
//		//환생 후의 능력치
//		public class Rebirth extends PreviousLife { //전생했더니 슬라임이 되었습니다.
//			public String newAbility = "슬라임의 외형 획득!";
//		}

	}

}
