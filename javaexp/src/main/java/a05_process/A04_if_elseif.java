package javaexp.a05_process;

public class A04_if_elseif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# if else if문
		1. 여러가지 분기조건을 처리할 때, 사용되는 구문을 말한다.
		2. 기본형식
			if(조건1){
				조건1에 해당하는 코드 처리
			}else if(조건2){
				조건1이 아니고, 조건2에 해당하는 코드 처리
			}else if(조건3){
				위에 나열된 조건이 아니고 조건3에 해당하는 코드 처리
			}...
			
			}else{
				상단에 나열된 조건이외의 경우 처리할 코드 수행
			}	
			
		*/	
		int point = (int)(Math.random()*101); //0~100임의 숫자
		System.out.println("점수:"+point);
		if(point>=90) {
			System.out.println("A 학점!!");
		}else if(point>=80){ // if(point<90 && point>=80)
			System.out.println("B 학점!!");			
		}else if(point>=70){
			System.out.println("C 학점!!");			
		}else if(point>=60){
			System.out.println("D 학점!!");			
		}else {
			System.out.println("F 학점!!");			
		}
		
//		ex) 0,1,2가 임의로 나오게 하여, 0이면 가위 1이면 바위, 2이면 보가 처리되어
//			임의로 컴퓨터가 낸 가위/바위/보를 출력하세요.
		int point1 = (int)(Math.random()*3); //0~2임의 숫자
		System.out.print("컴퓨터의 가위/바위/보 : ");
		if(point1==0) {
			System.out.println("가위");
		}else if(point1==1){ 
			System.out.println("바위");			
		}else {
			System.out.println("보");			
		}
	
	}
	
}
