package javaexp.a08_relation.access.ourhome.sisterhome;

import javaexp.a08_relation.access.ourhome.Father;

public class Sister extends Father {
	void callFatherInfo1(){
		Father f = new Father();
//		System.out.println("private:"+f.youngerPriv);
//		System.out.println("default:"+f.heath);
//		protected라도 상속해서 처리하는 방식이 아닌 객체 생성 후
//		처리는 접근되지 못한다.
//		System.out.println("protected:"+f.inherit);
		System.out.println("public:"+f.announce);
	}
	// 상속자
	void callFatherInfo2(){
//		상속이라는 패키지 다르면, private, default로 접근하지 못한다.
//		System.out.println("private:"+youngerPriv);
//		System.out.println("default:"+heath);
		System.out.println("protected:"+inherit);
		System.out.println("public:"+announce);
	}
}
