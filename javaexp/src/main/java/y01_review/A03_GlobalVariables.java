package javaexp.y01_review;

public class A03_GlobalVariables {

	public static void main(String[] args) {
		/*		
		# 자바에서 사용되는 전역변수와 지역변수
		1. 자바에서는 변수가 {}(중괄호 블럭)단위로 상대적으로
			상위에 선언되너 있는 변수와 하위에 선언되어 있는 변수가
			있는데, 상위에 선언되어 하위에 모든 중괄호 블럭에
			영향을 미치는 변수를 전역변수, 해당 블럭의 매개변수나
			선언된 것으로 해당 블럭에서만 사용되는 변수를 지역변수
			라고 한다.
		2. 코드 대상 유형
			1) 조건문(중첩)
		*/
		int num01 = 1; //전역변수
		if(num01>=0) {
			num01++;
			int num02 = 30;//지역변수
			num02++;
			num01=num02;
		}
//		num02--; 지역변수
		num01++; //전역변수
		if(num01>=2) {
			num01++;
		}
		/*
			2) 반복문(중첩)
			3) 조건문과 반복문 혼합
		*/
		//반복문 데이터에서 활용
		for(int cnt=1; cnt<=10; cnt++) {
			// cnt : 지역변수 : 매개변수에서 int 선언했기때문에.
			// 이 반복문 안에서 사용.
			System.out.print(cnt+",");
		}
//		System.out.println(cnt);
//		for 매개변수 선언된 지역변수, 블럭밖에서는 사용 못함
		System.out.println();
		int no=1;
//		초기값;반복조건;증감연산자
		for(no=5;no<=10;no++) {
			System.out.print(no+",");
		}
		System.out.println("#반복문 끝난 후#");		
		System.out.println(no);		
//		
//		데이터 누적처리(+=, -=, *=, /=, %=)
		int tot=0;
		System.out.println("# 데이터 누적처리");
		for(int cnt=1;cnt<=10;cnt++) {
			tot += cnt;
			System.out.print(cnt+((cnt!=10)?"+":"="));
		}
		System.out.println(tot);
		/*		
			4) 클래스블럭
				- 필드 : 객체가 가지고 있는 모든 구성요소인
					생성자나 메서드에 영향을 미치는 변수/상수
					cf) this.필드명
				- 생성자
				- 메서드
					메서드 내에 조건/반복문 등 프로세스 처리
		3. 활용 형태
			1) 상위 변수는 하위 변수의 대입 다른 블럭에 영향(전역변수)
			2) 상위 변수는 하위 변수에 누적 처리
			3) 클래스에서 선언된 전역변수인 필드는 this.필드명
				형태로 지역변수와 구분한다.
		*/
		
	}

}
