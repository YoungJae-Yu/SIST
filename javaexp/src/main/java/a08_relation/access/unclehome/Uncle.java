package javaexp.a08_relation.access.unclehome;

import javaexp.a08_relation.access.ourhome.Father;
import javaexp.a08_relation.access.ourhome.Mien;

public class Uncle {
	void calltp() {
		Mien tp = new Mien();
//		default 접근제어자
//		System.out.println(tp.travelPlan);
//		System.out.println("private 접근 제어:"+tp.secretShopping); //다른/같은 패키지여도 직접 접근 불가

		}
	void callFatherInfo1(){
		Father f = new Father();
//		System.out.println("private:"+f.youngerPriv);
//		System.out.println("default:"+f.heath);
//		System.out.println("protected:"+f.inherit);
//		다른 패키지는 public 외에는 접근이 불가하다.
		System.out.println("public:"+f.announce);
	}
	// 상속자
//	void callFatherInfo2(){
//		System.out.println("private:"+youngerPriv);
//		System.out.println("default:"+heath);
//		System.out.println("protected:"+inherit);
//		System.out.println("public:"+announce);
	
}
