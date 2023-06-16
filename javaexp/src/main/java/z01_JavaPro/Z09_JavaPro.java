package javaexp.z01_JavaPro;

public class Z09_JavaPro {

	public static void main(String[] args) {
//		2023-04-12
//		[1단계:개념] 1. 메서드의 여러가지 처리형태(입력,로직,리턴,복합형태)를 기술하고 간단한 예제로 구현하세요
		Exp1 e1 = new Exp1();
		System.out.println(e1.exp1(13, 145));//리턴값 출력
//		[1단계:확인] 3. 메서드(입력+로직) 선언 예제( class RetExp100 하위에 선언하여 호출하세요)
//	      1) 3개에 입력값 중에 가장 큰수 출력
//	      2) 1개의 입력값으로 70이상과 미만으로 합격/불합격 출력
//	      3) 배열로 파는 물건들을 3개의 문자열 배열로 선언하고, 입력으로 물건명으로 파는 물건 여부를 출력 표시.
		RetExp100 e2 = new RetExp100();
		e2.exp2(3, 6, 9); // 1) 3개에 입력값 중에 가장 큰수 출력
		e2.exp3(80);//2) 1개의 입력값으로 70이상과 미만으로 합격/불합격 출력
		e2.exp4("김치");//3) 배열로 파는 물건들을 3개의 문자열 배열로 선언하고, 입력으로 물건명으로 파는 물건 여부를 출력 표시.
//		[1단계:확인] 4. 메서드(입력+로직+리턴) 선언  예제( class RetExp100 하위에 선언하여 호출하세요)
//	    1) 놀이공원 클래스에서 나이를 입력해서 무료/유료 구분해서 리턴 메서드(5세미만 65이상 무료)
//	    2) 놀이공원 클래스에서 나이에 따라 입장료 10%, 15%, 20% 처리(나이구간 임의 적용)
//	    3) 배열로 등록된 회원 선언하고, 입력된 회원명에 따라 등록여부를 리턴하여 처리하세요.
		System.out.println("입장비용:"+e2.exp5(25)); //1) 놀이공원 클래스에서 나이를 입력해서 무료/유료 구분해서 리턴 메서드(5세미만 65이상 무료)
		System.out.println("할인율:"+e2.exp6(25)+"%"); //2) 놀이공원 클래스에서 나이에 따라 입장료 10%, 15%, 20% 처리(나이구간 임의 적용)
		System.out.println(e2.exp7("유영재")); //2) 놀이공원 클래스에서 나이에 따라 입장료 10%, 15%, 20% 처리(나이구간 임의 적용)
	
		Bus c1 = new Bus(4007);
		c1.totCnt(5);
		c1.totCnt(5);
		c1.totCnt(5);
		
	
	}

}
		
//		2023-04-12
//		[1단계:개념] 1. 메서드의 여러가지 처리형태(입력,로직,리턴,복합형태)를 기술하고 간단한 예제로 구현하세요
//		ex) 놀이기구 입장 가능여부를 입력, 로직처리, 리턴을 통해서 출력
class Exp1{
	String exp1(int age, int height) {//외부 입력 데이터를 받아서 매개변수로 데이터 처리
		String result="입장불가..";
		// 로직 처리(저장, 출력, 조건문) : 나이와 키가 맞아야 입장가능
		if(age<=14 && height<=150) {
			result="입장가능!";
		}
		return result;// 결과 리턴처리
	}
//	[1단계:개념] 2. 생성자로 데이터를 사용할 때와 메서드를 데이터를 사용할 때, 어떤 차이점이 있는지 예제로 기술하세요.
//	생성자는 주로 해당 객체를 생성해서 초기값이 설정할 필요가 있을 때 주로 사용된다.
//	ex) Person : 사람이름, 초기할당 정보
//		age(0) - 숫자형데이터는 기본적으로 0이기에 설정 불필요
//		Car : 자동차의 종류, 기본 배기량.. 최고속도..
//	메서드는 주로 해당 객체 생성 후, 변경되는 데이터를 처리할 때 사용된다..
//		gerAge() : 나이를 먹다.
//		chLoc("서울") : 사는 곳이 변경되다..
//		speedUp(30) 속도가 증가되다.
//		drivingPerson("친구1") : 사람을 태우다.
	int num1;
	public Exp1(int num1) {// 생성자 : 생성자는 주로 객체를 생성할 때, 초기 데이터를 설정할 때, 사용
		this.num1 = num1;
	}	
	public Exp1() {
		// TODO Auto-generated constructor stub
	}
	int num2(int num1) {//메서드는 계속 기능적인 처리를 하여, 외부에 변경되는 데이터를 입력받거나 해당 데이터를 로직에 의해 리턴할 때, 주로 활용
		return 0;
	}
}		
//		[1단계:확인] 3. 메서드(입력+로직) 선언 예제( class RetExp100 하위에 선언하여 호출하세요)
//		      1) 3개에 입력값 중에 가장 큰수 출력
//		      2) 1개의 입력값으로 70이상과 미만으로 합격/불합격 출력
//		      3) 배열로 파는 물건들을 3개의 문자열 배열로 선언하고, 입력으로 물건명으로 파는 물건 여부를 출력 표시.
class RetExp100{
	void exp2(int n1, int n2, int n3) {
		/*
		num01이 가장 큰 경우,
		int maxNum = 0;
		if(num01>maxNum) {
			maxNum = num01;
		}
		if(num02>maxNum) {
			maxNum = num02;
		}
		if(num03>maxNum) {
			maxNum = num03;
		}
		System.out.println("가장 큰 수:"+maxNum);
		 */
		if(n1>n2 && n1>n3) { //1) 3개 입력값 중 가장 큰 수 출력
			System.out.println(n1);
		}else if(n2>n1 && n2>n3) {
			System.out.println(n2);			
		}
		System.out.println(n3);		
	}
	void exp3(int n1) {
		if(n1>=70) { //2) 1개의 입력값으로 70이상과 미만으로 합격/불합격 출력
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
	void exp4(String pn1) {//3) 배열로 파는 물건들을 3개의 문자열 배열로 선언하고, 입력으로 물건명으로 파는 물건 여부를 출력 표시.
		String[] pl = {"사과","바나나","딸기"};// 배열로 선언
		for(int cnt=0;cnt<=pl.length;cnt++) {
			if(pn1==pl[0]) {
				System.out.println(pn1+"는 파는 물건입니다!!");
				break;
			}else if(pn1==pl[1]) {
				System.out.println(pn1+"는 파는 물건입니다!!");
				break;
			}else if(pn1==pl[2]) {
				System.out.println(pn1+"는 파는 물건입니다!!");	
				break;
			}else {
				System.out.println(pn1+"는 판매하지 않아요...");	
				break;
			}
		}
	}
//	[1단계:확인] 4. 메서드(입력+로직+리턴) 선언  예제( class RetExp100 하위에 선언하여 호출하세요)
//    1) 놀이공원 클래스에서 나이를 입력해서 무료/유료 구분해서 리턴 메서드(5세미만 65이상 무료)
//    2) 놀이공원 클래스에서 나이에 따라 입장료 10%, 15%, 20% 처리(나이구간 임의 적용)
//    3) 배열로 등록된 회원 선언하고, 입력된 회원명에 따라 등록여부를 리턴하여 처리하세요.
	String exp5(int age) {
		String rst ="유료";// 1) 놀이공원 클래스에서 나이를 입력해서 무료/유료 구분해서 리턴 메서드(5세미만 65이상 무료)
		if(age<5 && age>=65) rst="무료";
		return rst;
	}
	int exp6(int age) { 
		int rst = 0;
		if(age<7) { //2) 놀이공원 클래스에서 나이에 따라 입장료 10%, 15%, 20% 처리(나이구간 임의 적용)
			int rst1 = 20;//7세 미만 20%, 8세 이상 19세 미만 15%, 20세 이상 10%
			return rst1;
		}else if(age<19 && age>=8) {
			int rst1 = 15;
			return rst1;
		}else if(age>=20) {
			int rst1 = 10;
			return rst1;
		}
		return rst;
	}
	String exp7(String name) {//3) 배열로 등록된 회원 선언하고, 입력된 회원명에 따라 등록여부를 리턴하여 처리하세요.
		String[] uname = {"홍길동","김길동","유영재"};
		
		for(int cnt=0;cnt<=uname.length;cnt++) {
			if(name==uname[0]) {
				String nm = uname[0];
				return nm+"님은 등록된 회원입니다.";
			}else if(name==uname[1]) {
				String nm = uname[1];
				return nm+"님은 등록된 회원입니다.";
			}else if(name==uname[2]) {
				String nm = uname[2];
				return nm+"님은 등록된 회원입니다.";
			}else {
				return name+"님은 등록된 회원이 아닙니다.";
			}
		}
		return name;
	}
}	
//	[1단계:확인] 5. 클래스(필드,생성자,메서드) 선언  예제( class RetExp100 하위에 선언하여 호출하세요)
//    1) 버스클래스로 필드(버스번호,탑승자수) 버스번호 생성자 선언, 탑승자인원수 누적메서드 리턴 현재 총탑승자수
//       탑승메서드(매개변수 탑승자인원, 리턴 현재 총탑승자수) 
//       버스번호 @@번 @@명이 탑승했습니다. 
class Bus{
	int busOpCnt = 0;
	int busNum;
	public Bus(int busNum) {
		this.busNum = busNum;
	}
	public void busNum() {
		// TODO Auto-generated method stub
	}
	int totCnt(int OpCnt){
		busOpCnt += OpCnt;
		System.out.println("버스번호 "+busNum+"번 "+OpCnt+"명이 탑승했습니다.");
		System.out.println("누적 탑승자 수:"+busOpCnt);
		return busOpCnt;
	}
	
}
//		[1단계:개념] 6. 클래스내 일반변수, static 변수, final 상수, static final 상수의 차이점을 기본 예제로 설명하세요.
//		[1단계:확인] 7. 상대적경로 이동과 절대적 경로 이동예제를 하나씩 만들어 이동처리하세요


