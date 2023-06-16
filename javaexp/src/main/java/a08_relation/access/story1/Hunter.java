package javaexp.a08_relation.access.story1;

import javaexp.a08_relation.access.story1.friendship.WoodCutter;

public class Hunter {
	void callWoodCutterInfo() {
//		public class WoodCutter
//		==> WoodCutter wc 가능
//		default 생성자 : public woodCutter(){}
//		==> new WoodCutter(); 가능
		
		WoodCutter wc = new WoodCutter();
//		System.out.println("private 접근 제어:"+wc.hiddenCloth);
		
		
//		패키지가 다르므로 default 접근제어자의 구성요소는
//		접근이 불가능 하다.(에러발생)
//		System.out.println("default 접근 제어:"+wc.hiddenDeer);
	}
}
/*
 * javaexp.a08_relation.access
 * ourhome 패키지 생성
 * 		Father, Mother, Brother
 * 		Mien
 * 			X 우리가족여행계획 : 변수로 설정할당
 * unclehome 패키지 생성
 * 		Uncle
 * 
 * 		Mine 클래스에 대한 우리가족여행계획 호출 처리 메서드가
 * 		가능한 범위 확인
 * 
 * 
 * 
 * 
 */

