package javaexp.a09_inherit.absrac2;

import java.util.ArrayList;

public class A01_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot r1 = new Robot("MZ");
		r1.randomAttack();
		r1.addWeapon(new Rocket());
		r1.randomAttack();
		r1.addWeapon(new Missile());
		r1.randomAttack();

	}

}
/*
# 1:다관계 구조 추상 클래스
1. 기본적으로 추상 클래스는 하나의 상위 클래스(Weapon)를 기준으로 여러가지 형태의
하위 클래스(Rocket, Missile..) 만들어지는 것인데, 이것이 이를 다루는 다른 클래스에서
활용할 때, 해당 포함관계를 가진 클래스(Robot vs ArrayList<Weapon>)가 추상클래스를 상송 받는 하위
클래스가 기능적으로 추가되어도 메인 클래스(Robot)는 영향을 미치지 않는 형태의
구조로 처리할 때, 사용한다.
2. 다음의 구조는 추상 클래스를 활용한 1:다완계의 추상 클래스 구조 중에 하나이다.
	1) 메인 클래스를 Robot을 두고, 이 로복의 여러가지 종류를 필드로 설정하고,
	2) 이 Robot이 사용하는 무기를 다양하게 구비할 수 있는 상위
		Weapon을 선언하고, 여러 가지 무기를 추가 처리할 수 있는
		1:다관계 필드를 선언할 수 있다.
		class Robot{
			private String kind; 로봇의 종류
			private ArrayList<Weapon> wlist; 무기의 종류
			void addWeapon(Weapon weapon) 무기 장착
			void 
		}
	3) 추상클래스의 상위 Weapon 선언
		abstract class Weapon{
			private String wname; 무기종류의 이름
			Weapon(String wname){
				this.wname = wname;
			}
			void adaptWeapon(){
				System.out.println(wname+" 장착하다")
			}
			abstract void attack(); 
			//추상 메서드 무기를 사용해서 공격하는 내용..
		}
	4) 추가되는 하위 실제 클래스
		class Missile extends Weapon{
			void attack(){
				미사일로 공격을 하다..
			}
		}
		
# 개발 순서
1. 추상 클래스 만들기
2. 추상 클래스를 상속받은 실제 클래스 만들기
3. 1:다관계 포함 클래스 만들기
4. 메인메서드에서 처리내용 확인
5. 추상 클래스를 상속받은 실제 클래스 여러가지 형태 추가 및
	메인메서드에서 추가처리 내용 확인..
*/
abstract class Weapon{
	private String kind;

	public Weapon(String kind) {
		this.kind = kind;
	}
	// 공통 메서드
	public void adapte() {
		System.out.println(kind+" 장착하다.");
	}
	public String getKind() {
		return kind;
	}
	// 추상 메서드
	public abstract void attack();
	
}
class Missile extends Weapon{

	public Missile() {
		super("미사일");// 상속관계에 있는 때, 상위 생성자 호출.
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+"로 공격력 25으로 공격하다.");
	}
	
}
class Rocket extends Weapon{

	public Rocket() {
		super("로켓포");// 상속관계에 있는 때, 상위 생성자 호출.
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+"로 공격력 20으로 공격하다.");
	}
	
}
class Robot{
	private String kind;
	private ArrayList<Weapon> wlist;
	// 생성시, 로봇의 종류와 물건리스트를 추가할 수 있게 초기 생성
	public Robot(String kind) {
		this.kind = kind;
		wlist = new ArrayList<Weapon>();
	}
	public void addWeapon(Weapon w) {
		wlist.add(w); //list에 하나씩 물건을 추가
		System.out.println(kind+" 로봇에");
		w.adapte(); // 무기 물건 추가 기능 공통 메서드 호출.
	}
	public void showAllWeapon() {
		System.out.println(kind+" 로봇이 가진 무기들!");
		if(wlist.size()>0) {
			for(Weapon wp:wlist) {
				System.out.println(wp.getKind());
			}
		}else {
			checkWewpon();
		}
		System.err.println(wlist.size()+"개 무기 장착");
	}
	private void checkWewpon() {
		System.out.println("무기가 장착되지 않았습니다.");
		System.out.println("무기 장착 후 사용!");
	}
	public void randomAttack() {
		System.out.println(kind+" 로봇에 가진 무기중 임의의 무기로 공격");
		if(wlist.size()>0) {
			int ranIdx = (int)(Math.random()*wlist.size());
			wlist.get(ranIdx).attack();
		}else {
			checkWewpon();
		}
	}
}




















