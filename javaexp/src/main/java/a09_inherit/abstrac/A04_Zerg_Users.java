package javaexp.a09_inherit.abstrac;

import java.util.ArrayList;

public class A04_Zerg_Users {

	public static void main(String[] args) {
		
		ZergUser z01 = new ZergUser("파랑");
		z01.makeUnit(new Zerggling());
		z01.makeUnit(new Zerggling());
		z01.allAttack();
		ZergUser z02 = new ZergUser("빨강");
		z01.makeUnit(new Dron());
		z01.makeUnit(new Dron());
		z01.makeUnit(new Hydralisk());
		z01.makeUnit(new Hydralisk());
		z02.allAttack();
	}

}
// 1:다관계 추상클래스 포함 객체 처리
class ZergUser{
	private String color;
	private ArrayList<Larba> units;
	public ZergUser(String color) {
		this.color = color+"색 저그";
		units = new ArrayList<Larba>();
	}
	public void makeUnit(Larba larba) {
		units.add(larba);
		System.out.println(color+"유닛"+larba.getUnit()+" 생산하다.");
	}
	public void allAttack() {
		System.out.println(color+" 모든 유닛이 공격을 합니다.");
		if(units.size()>0) {
			System.out.println("전체 유닛 "+units.size()+"공격을 합니다.");
			for(Larba lb:units) {
				lb.move(); 
				lb.attack();
			}
		}
	}
}