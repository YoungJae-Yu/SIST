package javaexp.a05_process;

public class A09_for_if {

	public static void main(String[] args) {
		/*
		# for문에서 if문 활용
		1. 반복처리시 여러가지 화면 처리나 로직에 의해서
			조건문을 활용할 수 있다.
		2. 대부분의 조건처리를 통해 원하는 결과를 알고리즘에 의해 
			처리되는 경우가 많다.
		3. for문에서 if문 처리 유형
			1) 화면 처리 형식 변경
				- 출력 형식의 내용을 변경 처리하는 경우를 말한다.
		*/
//		출력형식 변경 1~100까지 출력하되, 5단위로 줄바꿈 처리
//		for문(1~100), 
//		if(cnt%5==0) 5로 나누었을 때, 0일 5단위 처리
		for(int cnt=1;cnt<=100;cnt++) {
			System.out.print(cnt+"\t");
//			탭간격을 출력 처리
			if(cnt%5==0) { //5로 나누었을 때, 0
				System.out.println(); // 줄바꿈처리
			}
		}
		/*
		2. 연산처리 결과 아래 형식
		1 + 2 + 3... 10 = 55
		기본적인 데이터는 +로 출력 마지막 데이터는 =으로 처리
		 */
		int tot = 0;
		for(int cnt=1;cnt<=10;cnt++) {
			System.out.print(cnt);
			if(cnt==10) {
				System.out.print(" = "+tot);
			}else {
				System.out.print(" + ");	
			}
		}
		System.out.println();
		
//		ex) 1~20까지 출력하되, 3의 배수에는 숫자대신 짝! 출력
//		1,2,짝,4,5,짝..
		for(int cnt=1;cnt<=20;cnt++) {
			System.out.print(cnt+",");
			if(cnt%3==0) {
				System.out.print("짝!,");	
			}
		}
		System.out.println(); 
		
//		ex2) 1~100까지 출력하되, 홀수의 합산과 짝수의 합산을
//		따로 하여 출력하세요
//		1...100
//		홀수의 합산 : @@ cnt%2==1 || cnt%2==0
//		짝수의 합산 : @@
		int tot1 = 0;
		int tot2 = 0;
		for(int cnt=1;cnt<=100;cnt++) {
			if(cnt%2==1) { //홀수 일때, 합산할 내용
				tot1 += cnt;
			}else { //짝수 일때, 합산할 내용
				tot2 += cnt;
			}
		}
		System.out.println("홀수의 합산 : "+tot1);
		System.out.println("짝수의 합산 : "+tot2);
	}
}
