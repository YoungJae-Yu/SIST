package javaexp.a11_api;

public class A03_StringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# String 클래스에서 사용되는 기능메서드
		1. charAt(int idx) : 특정위치에 문자 리턴.. 
		 */
		String greet = "안녕하세요!! 반갑습니다.";
		System.out.println(greet.charAt(0));
		System.out.println(greet.charAt(1));
		//주의) 배열의 길이는 배열.length, 문자열의 길이 문자열.length()
		for(int idx=0;idx<greet.length();idx++) {
			System.out.println(greet.charAt(idx));
		}
		String data = "1991/10/12";
		// 이 데이터는 생년월일이 있는 데이터이다. 위 charAt를 이용해서
		// 년, 월, 일을 출력하세요..
		System.out.print(data.charAt(0));
		System.out.print(data.charAt(1));
		System.out.print(data.charAt(2));
		System.out.print(data.charAt(3));
		System.out.print("년 ");
		System.out.print(data.charAt(4));
		System.out.print(data.charAt(5));
		System.out.print(data.charAt(6));
		System.out.print("월 ");
		System.out.print(data.charAt(7));
		System.out.print(data.charAt(8));
		System.out.print(data.charAt(9));
		System.out.println("일 ");
		char [] birth = new char[11];
		birth[0] = data.charAt(0);
		birth[1] = data.charAt(1);
		birth[2] = data.charAt(2);
		birth[3] = data.charAt(3);
		birth[4] = '년';
		birth[5] = data.charAt(5);
		birth[6] = data.charAt(6);
		birth[7] = '월';
		birth[8] = data.charAt(8);
		birth[9] = data.charAt(9);
		birth[10] = '일';
		String birthStr = new String(birth);
		System.out.println("생일:"+birthStr);
		/*
		2. getBytes() : 문자열을 byte배열로 가져온다. 
		 */
		String str1 = "Hello";
		byte[] bytes01 = str1.getBytes();
		for(byte b:bytes01) {
			System.out.print(b+"(");
			System.out.print((char)b+")");
		}
		System.out.println();
	}

}
