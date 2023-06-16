package javaexp.z01_JavaPro;

import java.util.Scanner;

public class Z16_0425 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2023-04-25
		//[1단계:개념] 1. 예외 처리의 기본형식 코드는 수행시키고, 
//						해당 코드가 의미하는 바를 구체적으로 기술하세요.
//		try { // 예외 처리 블럭으로 만약 처리하지 않으면 에러가 남과 동시에 해당 라인에서 진행이 중단됨
//			System.out.println("#코드 블럭#");
//			System.out.println(args[0]);
//		}catch(Exception e) {//예외가 발생했을 때 처리 코드
//			System.out.println(e.getMessage()); //발생한 예외 출력
//			// e.XXX : 여러 기능메서드를 통해서 예외에 대한 상세 내용을 처리한다.
//			System.out.println("#예외 처리 블럭#");
//		}
		//[1단계:확인] 2. args로 입력 받게 하고, 물건명 가격 갯수를 입력 받게 하고
//					입력이 없을 시  "물건정보를 입력하세요!" 라고 예외 처리로 처리되게 하세요.
//		Scanner sc = new Scanner(System.in);
//		System.out.println("물건명, 가격, 갯수 입력하세요.");
//		try {
//			System.out.print("물건명 입력:");
//			String num01 = (sc.nextLine());
//			System.out.print(num01+"의 가겨 입력:");
//			int num02 = Integer.parseInt((sc.nextLine()));
//			System.out.print(num01+"의 갯수 입력:");
//			int num03 = Integer.parseInt((sc.nextLine()));
//			System.out.println("물건명:"+num01);
//			System.out.println("가격:"+num02);
//			System.out.println("갯수:"+num03);
//			int tot = num02 * num03;
//			System.out.println("총계:"+tot);
//		}catch(NumberFormatException e){
//			System.out.println("물건정보를 입력하세요!");
//		}
//		System.out.println("물건 구매 완료.");
		
		//[1단계:개념] 3. 실행예외와 컴파일예외의 차이점을 예제로 설명하세요.
		/* 가장 메모리가 작고 세밀한 예외 부터 먼저 처리하고, (실행예외)
		 * 구체적으로 처리할 예외를 처리 (컴파일예외)
		 * 마지막에 최상위 예외를 처리 (Exception)
		 * = 순서대로 처리된다.
		 */
		try {}catch(NullPointerException e) { //실행예외
			System.out.println("최하위:"+e.getMessage());
//		}catch(ClassNotFundException e) { 컴파일예외
//			System.out.println("차상위:"+e.getMessage());
		}
		//[1단계:개념] 3. 예외처리의 계층 구조에 따른 선언 순서를 기술하세요.
//		실행예외 하위    : NullPointerException,NumberFormatException
//		실행예외        :	RuntimeException
//		컴파일예외 차상위  : ClassNotFundException,InterruptedException
//		최상위  		 : Exception
		//[1단계:확인] 4. args[0], String name=null;name.toString();
//			해당 내용을 구체적 예외는 처리하고, 그외는 Exception처리하는다중예외를 처리하세요.
		String name = null;
		try {
			System.out.println(args[0]);			
//			System.out.println(name.toString());			
		}catch(NullPointerException e) {
			System.out.println("메모리 할당 예외"+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 예외:"+e.getMessage());
		}catch(Exception e) {
			System.out.println("기타 예외:"+e.getMessage());
		}

	}

}

















