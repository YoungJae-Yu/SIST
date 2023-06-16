package javaexp.a09_inherit.vo;

public class Daughter extends Mother {
	String goodPt = "주위 사람들을 밝게 한다";
	void callTalent() {
		System.out.println("# 딸의 재능 #");
		System.out.println("#상위로 받은 특정");
		System.out.println(charac);//상속이기에 바로 사용 가능
		cooking();//상속받은 메서드라 바로 호출 가능
		System.out.println("#현 객체의 추가 필드#");
		System.out.println(goodPt);
	}
	void callHeight() {
//		System.out.println("키는:"+height);(X)직접 접근할 수 없음
		checkHeight(-5);
		System.out.println("키는:"+getHeight());// 간접적으로 접근하는 형태
	}
}
