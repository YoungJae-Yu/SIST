package javaexp.a10_exception;

public class A03_RunTimeException {

	public static void main(String[] args) {
		String name2=null;
		name2.hashCode(); // heap메모에 객체가 없을 때나오는 예외 발생.
		// 해당 라인에서 프로세스 즉시 중단..
		
		
		// TODO Auto-generated method stub
		// 입력되는 문자열 데이터 기능메서드로 처리하는 내용
		System.out.println("프로그램 시작(이름입력)");
		try {
			System.out.println("영문으로 이름을 입력하세요.");
			String name=null; //이름을 입력할 때..
			System.out.println("소문자로 변환된 내용입니다."+name.toLowerCase());// 소문자로 변환
		// 에러가 발생시 복사한 예외를 catch에 입력한다.
		}catch(NullPointerException e) {
			System.out.println("이름 입력이 필요합니다.");
		}catch(Exception e) { //기타 예측하지 못한 예외도 처리
			System.out.println(e.getMessage());//예외의 구체적인 내용 확인
		}
		System.out.println("프로그램 종료");
		
		// ex) A04_RunTime args에 회원아이디와 패스워드를 입력받아
		// 처리되는 프로그램으로 입력이 안될때, 예외 처리하는 내용을 하고.
		// 예외 처리 내용으로 아이디와 패스워드를 입력하세요 라고 표시되게 하세요.
	}

}
