package javaexp.a08_relation.access.story2.sonhome;

import javaexp.a08_relation.access.story2.woodhome.WoodCutter;

public class Son1 extends WoodCutter {
	public void callWoodInfo(){
		WoodCutter wc = new WoodCutter();
//		System.out.println("private:"+wc.privSec);
//		System.out.println("default(X):"+wc.outHomeSec);
//		상속은 해당 속성을 내가 가지고 있는 것같이 사용할 때를 말한다.
//		외부에 있는 객체를 생성해서 특정 속성을 호출 상속의 범위에서 벗어난다.
//		System.out.println("protected:"+wc.inheritSec);
		System.out.println("public:"+wc.announce);
	
	}
	// 상속 클래스
	public void callWoodInfo2(){
//		private 개인
//		System.out.println("private:"+privSec);
//		X, default 같은패키지
//		System.out.println("default(X):"+outHomeSec);
		System.out.println("protected:"+inheritSec);
		System.out.println("public:"+announce);
	}
}
