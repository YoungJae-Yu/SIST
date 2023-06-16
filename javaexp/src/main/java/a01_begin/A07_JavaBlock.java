//최상단에 자바클래스가 있는 묶음 위치를 지정
package javaexp.a01_begin;

//파일명과 동일한 클래스를 선언하는 코드
//1.반드시 클래스명을 대문자로 시작한다.
public class A07_JavaBlock {
//2.자바의 코드는 계층구조{}를 정리하여야 가독성을 높일 수 있다.
//	1) 탭간격(일반적)으로 하위 레벨인지 여부를 표시하여 코드해준다.
	
	public static void main(String[] args) {
		System.out.println("안녕!");
		if(true) {
			String name = "홍길동";
			System.out.println(name);
		}
	
//		3. 실행문
//		1) 변수의선언, 값저장, 메서드 호출에 해당하는 코드
//		2)실행문의 끝에는 반드시(**) 세미콜론(;)을 붙여 실행문의 끝 표시
//		3)한라인에 여러 실행문은 세미콜론(;) 구분자로 처리할 수 있다.
		int num01 = 10;
		int num02 = 20;
		int num03 = 30; int num04 = 40;
		int num05,num06,num07,num08;
//		int형으로 다중의 변수를 선언
//		int num05=num06=num07=num08;
		
	}
}
