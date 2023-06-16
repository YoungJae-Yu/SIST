package javaexp.a05_process;

public class A02_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# if문
		1. 조건문 결과에 따라 중괄호({}) 블럭이나,
		   중괄호가 없을 겨우 바로 옆이나 다음라인 내용을 수행 처리해준다.
		2. 형식
			1) 중괄호 블럭 : 여러 라인이 있는 경우..
				if(조건문){
					조건문에 해당할 때, 코드
					..
					..
				}
			2) 바로 옆에 있는 내용 수행
				if(조건문1) 조건문1일 때, 처리할 내용;
				if(조건문2) 조건문2일 때, 처리할 내용;
		   	3) 바로 밑에 1 line의 내용 수행
		   		if(조건문1)
		   			조건문1일때 수행할 내용..
		   		if(조건문2)
		   			조건문2일때 수행할 내용..
		   */
//		int cnt = 1;
//		System.out.println("flow 진행"+(cnt++));
//		System.out.println("flow 진행"+(cnt++));
//		if(cnt==3) {
//			System.out.println("cnt가 3일 때 처리할 내용1");
//			System.out.println("cnt가 3일 때 처리할 내용2");
//			System.out.println("cnt가 3일 때 처리할 내용3");
//		}
//		System.out.println("flow 진행"+(cnt++));
//		System.out.println("flow 진행"+(cnt++));
//		System.out.println("flow 진행"+(cnt++));
		   
//		ex) 과일 갯수를 2개씩 증가하게 처리하여 곰돌이가 사과를 @@개 먹었다.
//			10번 반복해서 처리하되 4개/8개 일때 바나나도 먹었습니다를 추가 처리되게 하세요..
//			중괄호 블럭 사용..
		int cnt = 0;
		System.out.println("곰돌이가 사과를 "+(cnt+=2)+"개 먹었다.");
		System.out.println("곰돌이가 사과를 "+(cnt+=2)+"개 먹었다.");
		if(cnt==4||cnt==8) {
			System.out.println("바나나도 먹었습니다1");
		}
		System.out.println("곰돌이가 사과를 "+(cnt+=2)+"개 먹었다.");
		System.out.println("곰돌이가 사과를 "+(cnt+=2)+"개 먹었다.");
		if(cnt==4||cnt==8) {
			System.out.println("바나나도 먹었습니다1");
		}
		System.out.println("곰돌이가 사과를 "+(cnt+=2)+"개 먹었다.");
		System.out.println("곰돌이가 사과를 "+(cnt+=2)+"개 먹었다.");
//		. . .
//		바로 옆라인에 중괄호 블럭 없이 사용되는 경우
		int breadCnt=0;
		System.out.println("곰돌이가 비스켓을 "+(++breadCnt)+"개 먹었습니다.");
		System.out.println("곰돌이가 비스켓을 "+(++breadCnt)+"개 먹었습니다.");
		if(breadCnt==2)
			System.out.println("\t수박도 함께 먹었습니다.");
			System.out.println("\t바나나도 함께 먹었습니다.");
//		주의) 중괄호가 없는 조건은 바로 다음 라인까지 해당 조건일 때 수행된다.
//		그 다음에 있는 구문은 조건문과 상관없이 수행된다.
		System.out.println("곰돌이가 비스켓을 "+(++breadCnt)+"개 먹었습니다.");
		System.out.println("곰돌이가 비스켓을 "+(++breadCnt)+"개 먹었습니다.");
		System.out.println("곰돌이가 비스켓을 "+(++breadCnt)+"개 먹었습니다.");
		
//		ex) 바로 옆이나 아래 중괄호 없이 처리하여,
//			카운트업 1~10까지 출력하되, 
//			3일 때는 ### 3입니다 ### 추가 처리(옆에 처리)
//			9일 때는 @@@ 9입니다 @@@ 추가 처리(아래라인 처리)
		int num = 1;
		System.out.println(num++);
		System.out.println(num++);
		if(num==3)
			System.out.print("### 3입니다 ###");
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		System.out.println(num++);
		if(num==9)
			System.out.println("@@@ 9입니다 @@@");
		System.out.println(num++);
		System.out.println(num++);	
	}

}
