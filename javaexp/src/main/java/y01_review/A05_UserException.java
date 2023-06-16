package javaexp.y01_review;

import java.util.Scanner;

public class A05_UserException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.print("입력할 아이디:");
				String id = sc.nextLine();
				int len = id.length();
				if(len<8 || len>16) {
					throw new InIdExcep(len+"자");
				}
				System.out.println("등록할 id:"+id);
				break;
			}catch(InIdExcep e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("등록 성공");
	}

}
/*
# 사용자 정의 예외 클래스 선언 및 사용
1. 예외 처리 기본 형식
	try{
		if(조건문)
			throw new 사용자정의예외();
	
	}catch(사용자정의예외){
		참조.메서드()
	}
2. 위 내용을 처리하기 위하여 사용자정의예외를 선언한다.
	class 사용자정의예외 extends Exception{
		생성자(){}
		재정의 메서드(){}
	}
3. 활용
	1) 사용자 정의 예외는 일반적으로 api에서 지원되는 예외와
		더불어 특정한 경우에 예외를 던저 해당 정의된 예외 클래스
		에서 만들어지는 객체로 처리하는 경우를 말한다.
	2) 사용자 정의 예외 처리 예시
		- 아이디 패스워드에 입력 유효성 처리
		- 회원 가입 아이디 입력 유효성 처리
		- 특정한 입력값에 대한 유효성 처리(범위값을 넘길 때)
		- 네트웍 서버 접속시, 접속 불가능할 때.
4. 처리 순서
	1) 필요로 하는 내용을 요구사항 정의서에서 명확히 정리
	2) 사용자 정의 클래스에서 처리가 필요한 메시지, 기능내용를 
		구분에서 정리
	3) 사용자 정의 예외 클래스 정의
	4) 해당 내용이 처리될 조건 및 프로세스 정리
	5) try{}catch문 예외 처리 및 사용자 정의 예외 객체 생성
	6) main()에서 테스트 및 완료.
5. 사용예제
	- 회원 가입 아이디 입력 유효성(8~16)범위 안에서 입력처리
		범위에 맞지 않을 때, 다시 입력하게 처리..
	- 메시지 : 입력한 아이디의 글자는 @@ 자입니다. 
	          아이디는 8~16자 사이 입력 가능합니다.
	  기능내용 : getMessage()로 위 메시지 내용 재정의 처리
	- 위 내용 기반 예외 클래스 정의  
	- 해당 내용이 처리될 조건 및 프로세스 정리
		Scanner로 입력시 글자가 8~16아닐 때, 예외 던지기
		
 * */
class InIdExcep extends Exception{
	public InIdExcep(String message) {
		super("입력한 글자 수는 "+message+" 입니다.");
	}
	@Override
	public String getMessage() {
		return "[입력 오류]:"+super.getMessage()+"\n"+
				"아이디는 8~16자 사이 입력 가능합니다.";
	}
}