package javaexp.a07_classObject;

public class A08_MethodRetExp {

	public static void main(String[] args) {


		Product11 p01 = new Product11();
		// 생성자는 호출시마다 다른 heap영역을 만들기 때문에
		// 참조값이 달라져서 하나의 객체에 하나의 생성자만 사용할 수 있지만
		// 메서드는 참조명.메서드명(데이터..)로 같은
		// heap영역 위치에서 동일한 메서드를 2~3번 이상 호출
		// 하더라도 메모리 변경이 없다.
		int tot01 = p01.totPay("사과", 2000, 5);
		System.out.println("총비용1:"+tot01);
		System.out.println("총비용2:"+p01.totPay("오렌지", 2500, 3));
		int tot02 = p01.totPay("수박", 12000, 3);
		System.out.println("총비용3:"+tot02);
		
		Product11 p02 = new Product11();
		int dc = p02.totPay2(5000, 0.7);
		System.out.println("할인 적용된 가격:"+dc);
		
		Student01 p03 = new Student01();
		double av1 = p03.records("유영재", 71, 65, 63);
		System.out.println("평균점수:"+av1);
	}

}
//물건 객체를 생성해서, 구매할 물건과 가격 갯수를
//입력 받아, 총 비용을 리턴하는 처리를 해보자.
class Product11{
	int totPay(String pname, int price, int cnt) {
		System.out.println("입력한 물건명:"+pname);
		System.out.println("가격:"+price);
		System.out.println("갯수:"+cnt);
		int tot = price*cnt;
		return tot;
	}
//	ex) 물건가격, 할인율을 입력받아서, 할인율이 적용된 금액을
//		정수형(int) 리턴하여 main()에서 호출하세요
//		100% ==> 1.0, 50% ==> 0.5
//		3000원 10% 3000*0.1(할인금액) 3000 - 3000*0.1
	int totPay2(int price, double dc) {
		System.out.println("가격:"+price);
		System.out.println("할인율:"+dc+"%");
		int dcPay = (int)(price*dc);
		return price-dcPay;
	}
}
// ex) Student01 records()메서드에 이름, 국어, 영어, 수학
//		입력받고, 해당 내용 출력, 평균(double)을 리턴 처리하세요.
class Student01{
	double records(String name, int kor, int eng, int mt) {
		System.out.println("이름:"+name);
		System.out.println("국어점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학점수:"+mt);
		int tot = kor+eng+mt;
		System.out.println("총점:"+tot);
		return tot/3.0;
	}
}