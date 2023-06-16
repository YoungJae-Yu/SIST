package javaexp.a08_relation;

import javaexp.a08_relation.vo.Car;
import javaexp.a08_relation.vo.CarRacer;
import javaexp.a08_relation.vo.Computer;
import javaexp.a08_relation.vo.Cpu;
import javaexp.a08_relation.vo.HPUser;
import javaexp.a08_relation.vo.HandPhone;
import javaexp.a08_relation.vo.Ram;

public class A03_ObjVsObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandPhone hp = new HandPhone("삼성",1200000);
		
		HPUser hs = new HPUser("홍길동");
		String name = "홍길동";
		hs.setName(name);
		hs.setName("마길동");
		hs.buyPhone(hp);
		hs.buyPhone(new HandPhone("아이폰",1500000));
		hs.callbyPhone();
		
//		Car, CarRacer객체 생성..
		CarRacer cr = new CarRacer("김형식");
		cr.buyCar(new Car("그랜저",3000));
		cr.drivingCar();
/*
ex1) 1:1관계
package havaexp.a08_ralation.vo에 추가하세요.
	
	Cpu(제조사, 사양, showInf() 제조사 사양 출력) 클래스를 선언
	Computer(종류(조립/완성품), Cpu, addCpu(...),
		showCom 컴퓨터가 cpu가 없다/ cpu의 정보는...)
		
1. javaexp.a08_relation.vo에
	1) Cpu 클래스 선언 및 필드/생성자/메서드 추가
		주의 메서드 : showInf()에서 제조사 사양 출력
	2) Computer 클래스 선언 Cpu클래스를 포함한 필드 선언 생성자 기능메서드 선언
		주의 메서드 : addCpu() Cpu객체 할당
				   showCom() 통해서 Cpu 객체가 할당되어 있을 때와
				   그렇지 않을 때를 구분하여 처리.
 */
		Cpu cp1 = new Cpu("인텔","i7 3.4Ghz");
		Ram rm1 = new Ram("인텔",16);
		Computer com1 = new Computer("조립");
		com1.addCpu(cp1);
		com1.addRam(rm1);
		com1.showCom();
	}

}