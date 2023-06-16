package javaexp.a08_relation.access.story2.neihome;

import javaexp.a08_relation.access.story2.woodhome.WoodCutter;

public class Uncle {
	public void callWoodInfo(){
//		외부 패키지에 있는 클래스는
//		public 접근자 이외에 모두 접근이 불가능하다.
		WoodCutter wc = new WoodCutter();
//		System.out.println("private:"+wc.privSec);
//		System.out.println("default(X):"+wc.outHomeSec);
//		System.out.println("protected:"+wc.inheritSec);
		System.out.println("public:"+wc.announce);
//	
//	}
//	// 상속 클래스
//	public void callWoodInfo2(){
//		System.out.println("private:"+privSec);
//		System.out.println("default(X):"+outHomeSec);
//		System.out.println("protected:"+inheritSec);
//		System.out.println("public:"+announce);
	}
}
