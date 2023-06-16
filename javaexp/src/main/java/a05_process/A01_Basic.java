package javaexp.a05_process;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 # 코드 실행 흐름 제어
		 1. 정상적인 코드 실행 흐름
		 	1) main() 메서드의 시작인 중괄호({})에서 시작하여 끝까지 진행한다.
		 	2) 위에서부터 아래로 코드흐름에 따라 진행한다.
		 	3) 대입연산자의 경우에는 오른쪽에서 왼쪽으로 흐름이 처리된다.
		 	4) 그외에 경우에는 대부분 왼쪽에서 오른쪽으로 코드를 처리해준다.
		 		ex) 조건문/논리연산식/다항연산식
		 		
		 2. 제어문의 역할
		 	코드의 실행 흐름을 개발자가 원하는 방향으로 변경할 수 있도록 도와준다.
		 	
		 		
		 		
		 */	
		System.out.println("#순차 구조에 의한 처리 흐름#");
		System.out.println("맛있는 라면 끓이기");
		System.out.println("1. 적정한물과 스프를 넣고 끓인다.");
		System.out.println("1-1. 물이 끓는지 여부 확인(조건문처리).");
		System.out.println("2. 끓고 있으면 라면을 넣는다.");
		System.out.println("3. 계란과 파를 넣는다.");
		System.out.println("4. 그릇을 준비하여 옮긴다.");
		System.out.println("5. 맛있게 먹는다.");
		/*
		# 제어문의 종류
		1. 조건문
			1) if, switch문
			2) 기본형식
				if(비교연산식|논리연산식){
					비교연산식이나 논리연산식이 true일 떄 처리
				}
				switch(기존데이터){ 
					25/100 특정 변수에 할당된 수/문자열을 기준
					case 데이터1:
						처리할 내용 code기술
						break;
					case 데이터2:
						처리할 내용 code기술
						break;
					...
					default:
						위에 지정한 case에 해당하지 않을 때, 처리할 내용 기술
						
				
				}
		2. 반복문
			1) for문, while문, do-while문
			2) 기본형식
				- for문
					for(초기값;반복조건;증/감연산자) {
						반복처리할 내용
					}
					ex)
					for(int cnt=1;cnt<=10;cnt++){
						System.out.println(cnt);
					}
				- while문 : 특정 조건일 떄, 반복을 중지하는 내부적 입력데이터 처리에 따른
							반복여부를 처리할 때 주로 사용된다.
					while(반복조건) {
						반복수행할 내용
					}
					while(data!=-1){
						data = sc.nextInt();
					}
			
				- do while문 : while문과 비슷하나, 일단, 반복처리할 구문을 최소한번은
							  수행하고 반복을 처리하고자 할 때 주로 사용된다.
					do{
						// 일단 1번은 수행하고,
						// 마지막에 반복수행할 조건일 때, 수행처리
					}
					do{
						menu = sc.nextLine()
						// 메뉴를 리스트하고, 메뉴를 선택할 때,
						// Q가 아닐 때까지 반복수행..
					}while(!menu.equals("Q"));	
			3) continue, break;
				1) continue
					반복문안에서 특정 반복단계에서 해당 조건 구문을 만날 때,
					continue이후 내용을 수행하지 않고, 다음 반복을 처리할 때 사용된다.
					ex)
					for(int cnt=1;cnt<=10;cnt++){
						if(cnt == 5){
							continue;
						}
						System.out.println("카운트:"+cnt);
					}
//					1,2,3,4,(5),6,7,8,9,10...카운트 5 제외
 				2) break;
 					특정 반복 구문에서 조건과 함께 처리되어 반복 수행을 중단 처리한다.
					while(true){
						menu = sc.nextLine();
						if(menu.equals("Q")){
							break;
						}
						System.out.println("선택된 메뉴:"+menu);
					}
					입력은Q를 했을 때, 더 이상 반복수행하지 않는다.
		3. 중첩 조건문/반복문
			1) 제어문의 중괄호 내부에 다른 제어문 작성이 가능하다.
				- 다양한 흐름 발생 가능
			2) 유형 : 아래와 같이 여러가지 중첩적으로 제어문을 만들어 보자.
				- 조건문
					조건문
					ex)
					if(gender.equals("남"){
						if(age>=18){
							신사..
						}else{
							소년
						}
					}else{
						if(age>=18){
							숙녀
						}else{
							소녀
						}
						
				- 반복문
					반복문
					구구단
					for(int grade=2;grade<=9;grade++){
						System.out.print(grade+"단");
						for(int cnt = 1;cnt<=9;cnt++){
							System.out.print(grade);
							System.out.print("*");
							System.out.print(cnt);
							System.out.print("=");
							System.out.print(grade*cnt);
						}
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		*/	
	}

}
