package javaexp.z01_JavaPro;

public class Z08_JavaPro {

	public static void main(String[] args) {

//		[1단계:개념] 7. 매서드의 구성요소와 해당 구성요소의 특징을 기본 예제를 만들어서 설명하세요.
//		ex) 
//		class Exp{
//			int ret01;
//			String ret02;
//			public Exp(int ret01, String ret02) {// 메서드명(매개변수)
//				this.ret01 = ret01;// 프로세스 처리
//				//매개변수를 받아서, 전역변수에 할당하거나, 특정 조건 처리/반복처리를 하는 등
//				this.ret02 = ret02;
//			}
//			int getExp1() {
//				return 1;//정수 리턴값
//			}
//			String getExp2() {
//				return "영";// 문자열 리턴값
//			}
//			
//		}
//  [1단계:확인] 8. 메서드의 리턴유형을 정수,실수,문자열,boolean을 선언하여 실제 데이터를 리턴하고, 메인메서드에서 호출하세요
		Exp e1 = new Exp(1,1.1,"유영재",false); 
		System.out.println("정수 리턴값:"+e1.ret01);
		System.out.println("실수 리턴값:"+e1.ret02);
		System.out.println("문자열 리턴값:"+e1.ret03);
		System.out.println("boolean 리턴값:"+e1.ret04);
//	[1단계:확인] 9. Product88이라는 클래스를 선언하고, 생성자를 통해 물건명, 가격, 갯수를 초기화하게 했다.
//      이 때, 메서드1 물건명 리턴, 메서드2 가격리턴, 메서드3는 가격과갯수를 연산한 총계를 리턴하게
//      선언하고 해당 메서드를 호출하여 리턴값을 확인하세요.
		Product88 e2 = new Product88("BBQ후라이드",20000,3); // 메서드 호출 및 값 확인
		System.out.println("물건명:"+e2.retName());
		System.out.println("가격:"+e2.retPrice());
		System.out.println("총계:"+e2.retTot());
//	[1단계:확인] 10. BBPlayer라는 클래스를 선언하고, 생성자를 통해 필드값 이름, 팀명, 타석, 안타를 초기화하게 하고,
//      메서드1에서는 이름과 팀명을 리턴, 메서드2에서는 타율(안타/타석)을 리턴하여 호출되게 하여
//      메인메서드를 통해서 출력하세요.
		BBPlayer e3 = new BBPlayer("박찬호","KIA타이거즈",24,5);
		System.out.println("야구선수:"+e3.names());
		System.out.println("타율:"+e3.btAg());
		
	}
}
//[1단계:확인] 8. 메서드의 리턴유형을 정수,실수,문자열,boolean을 선언하여 실제 데이터를 리턴하고, 메인메서드에서 호출하세요
class Exp{
	int ret01;
	double ret02;
	String ret03;
	boolean ret04;
	
	public Exp(int ret01, double ret02, String ret03, boolean ret04) {
		this.ret01 = ret01;
		this.ret02 = ret02;
		this.ret03 = ret03;
		this.ret04 = ret04;
	}
	int getExp1() {
		return ret01;
	}
	int getExp2() {
		return ret01;
	}
	String getExp3() {
		return ret03;
	}
	boolean getExp4() {
		return ret04;
	}
}
//[1단계:확인] 9. Product88이라는 클래스를 선언하고, 생성자를 통해 물건명, 가격, 갯수를 초기화하게 했다.
//      이 때, 메서드1 물건명 리턴, 메서드2 가격리턴, 메서드3는 가격과갯수를 연산한 총계를 리턴하게
//      선언하고 해당 메서드를 호출하여 리턴값을 확인하세요.
class Product88{//Product88 클래스 선언
	String name;
	int price;
	int cnt;
	public Product88(String name, int price, int cnt) {//생성자를 통해 초기화
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	String retName() {//메서드1 물건명 리턴
		return name;
	}
	int retPrice() {//메서드2 가격 리턴
		return price;
	}
	int retTot() {//메서드3 총계(가격*갯수) 리턴
		return price*cnt;
	}
}
//[1단계:확인] 10. BBPlayer라는 클래스를 선언하고, 생성자를 통해 필드값 이름, 팀명, 타석, 안타를 초기화하게 하고,
//      메서드1에서는 이름과 팀명을 리턴, 메서드2에서는 타율(안타/타석)을 리턴하여 호출되게 하여
//      메인메서드를 통해서 출력하세요.
class BBPlayer{//BBPlayer 클래스 선언
	String name;
	String teamName;
	double bat;
	double hits;
	public BBPlayer(String name, String teamName, double bat, double hits) {// 생성자로 초기화
		this.name = name;
		this.teamName = teamName;
		this.bat = bat;
		this.hits = hits;
	}
	String names() {// 메서드1 이름과 팀명 리턴
		return name+"/"+teamName;
	}
	double btAg() {//메서드2 타율(안타/타석) 리턴
		
		return hits/bat;
	}	
}






















