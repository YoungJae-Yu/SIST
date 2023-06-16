package javaexp.a08_relation.access.ourhome;

public class Brother {
	void calltp() {
		Mien tp = new Mien();
		System.out.println(tp.travelPlan);
//		System.out.println("private 접근 제어:"+tp.secretShopping); 같은 패키지여도 직접 접근 불가

		}
}
