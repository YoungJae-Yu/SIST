package javaexp.z02_util;

public class A03_Input3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		A03_Input3.java
//		구매한 물건들의 가격을 3개 입력해서
//		3000 2000 1000
//		총비용을 출력하세요
		
		int Pay1 = Integer.parseInt(args[0]);
		int Pay2 = Integer.parseInt(args[1]);
		int Pay3 = Integer.parseInt(args[2]);

		System.out.println("총 구매비용:"+(Pay1+Pay2+Pay3));
		
	}

}
