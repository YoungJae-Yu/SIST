package javaexp.z02_util;

public class A02_Input2 {

	public static void main(String[] args) {
//		일반 한번은 실행해야 한다.
		String panme = args[0];
		int price = Integer.parseInt(args[1]);
		int cnt = Integer.parseInt(args[2]);
		int tot = price*cnt;
		System.out.println("# 구매 정보 #");
		System.out.println("물건명:"+panme);
		System.out.println("가격:"+price);
		System.out.println("갯수:"+cnt);
		System.out.println("총계:"+tot);

//		A03_Input3.java
//		구매한 물건들의 가격을 3개 입력해서
//		3000 2000 1000
//		총비용을 출력하세요

		
	}

}
