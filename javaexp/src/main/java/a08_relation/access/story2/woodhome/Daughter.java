package javaexp.a08_relation.access.story2.woodhome;

public class Daughter extends WoodCutter {
// 상속 + 같은패키지에 있는 클래스는 private이외에 접근이 가능
// 객체 생성과 상속으로 사용
	public void callWoodInfo(){
		WoodCutter wc = new WoodCutter();
//		System.out.println("private:"+wc.privSec);
		System.out.println("default(X):"+wc.outHomeSec);
		System.out.println("protected:"+wc.inheritSec);
		System.out.println("public:"+wc.announce);
	
	}
	// 상속 클래스
	public void callWoodInfo2(){
//		System.out.println("private:"+privSec);
		System.out.println("default(X):"+outHomeSec);
		System.out.println("protected:"+inheritSec);
		System.out.println("public:"+announce);
	}
}
