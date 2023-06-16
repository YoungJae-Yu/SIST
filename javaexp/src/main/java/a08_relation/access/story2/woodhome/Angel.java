package javaexp.a08_relation.access.story2.woodhome;

public class Angel {
	public void callWoodInfo(){
		WoodCutter wc = new WoodCutter();
//		같은 패키지기에 private만 접근이 안된다.
//		System.out.println("private:"+wc.privSec);
		System.out.println("default(X):"+wc.outHomeSec);
		System.out.println("protected:"+wc.inheritSec);
		System.out.println("public:"+wc.announce);
	
	}
	// 상속 클래스
//	public void callWoodInfo2(){
//		System.out.println("private:"+privSec);
//		System.out.println("default(X):"+outHomeSec);
//		System.out.println("protected:"+inheritSec);
//		System.out.println("public:"+announce);
//	}
}
