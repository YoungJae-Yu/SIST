package javaexp.a09_inherit;

public class A13_MultiInherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 인터페이스의 다중 상속 지원
		1. 상위로 여러개의 인터페이스를 상속받아서
		2. 하위 실제 클래스는 선언할 수 있다.
		3. 기본형식
			interface 인터페이스1
				추상메서드1
			interface 인터페이스2
				추상메서드2
			class 다중상속한 실제객체 implements 인터페이스1, 인터페이스2{
				추상메서드1 재정의
				추상메서드2 재정의
			}
			ex) Wing인터페이스, Swimming인터페이스
				class MultiSkillRobot implements Wing, Swimming
		 */
		MultiSkill01 ms01 = new MultiSkill01();
		MultiSkill02 ms02 = new MultiSkill02();
		ms01.allSkill();
		ms02.allSkill();
		//ex) StudyWay study(), PlayerWay play()
//				인터페이스를 선언하고, 두개를 implements 한 실제 객체
//				Student01, Student02 를 선언하여 위 인터페이스를
//				재정의 한 내용을 출력하는 메서드를 호출하세요
		Student01 s1 = new Student01();
		Student01 s2 = new Student01();
		s1.study();	s1.play();
		s2.study();	s2.play();
	}

}
interface StudyWay{
	void study();
}
interface PlayerWay{
	void play();
}
class Student01 implements StudyWay, PlayerWay{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("공부를 다 끝내고 놀고있다.");
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("놀기위해 공부하고있다.");
	}
		
}
class Student02 implements StudyWay, PlayerWay{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("공부를 제대로 안하고있다.");
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("공부도 안하고 놀고있다.");
	}
	
}
class MultiSkill01 implements Wing, SwimmingWay{

	@Override
	public void swimming() {
		// TODO Auto-generated method stub
		System.out.println("호수가를 수영하다..");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("우리 동네를 날다.");
		
	}
	public void allSkill() {
		fly(); swimming();
	}
}
class MultiSkill02 implements Wing, SwimmingWay{

	@Override
	public void swimming() {
		// TODO Auto-generated method stub
		System.out.println("바다를 수영하다..");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("우리나라 전국을 날다.");
		
	}
	public void allSkill() {
		fly(); swimming();
	}
}