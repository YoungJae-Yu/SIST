package javaexp.a06_memory;

public class A06_NullPointer {

	public static void main(String[] args) {
		/*
		# NullPointer
		1. heap영역을 사용하는 객체 메모리가 할당하지 않을 때
			해당 객체의 변수를 null로 초기화 한다.
		2. 이 때, null이라는 말, 자체는 heap영역에
			아직 할당하지 않았다는 의미를 가지고 있다.
		3. 이 상황에서 해당 객체가 가지고 있는 구성요소를 호출하면
			NullPointerException라는 에러가 발생한다.
		4. 자바의 객체메모리는 다음과 같은 순서로 메모리를 할당한다.
			1) 객체유형 객체명; - 객체의 선언
				ex) int[] arry;
					String str01;
					String str02;
				// arry[0] 호출 시 컴파일 단계도 가지 못한다.
			2) 초기화 처리
				arry = null; null로 초기화 ==> 사용가능
				str01 = new String("안녕");
					heap영역에 데이터할당 ==> 사용 및 호출가능
				str02 = null;
			3) 사용
				arry[0] = 25; 호출 및 할당
					이 경우 NullPointerException이라는
					run time error 발생
				str01 = "반가워요"; 다른 객체 할당 (주소값 변경)
				System.out.println(str02);
				에러 발생하지 않고, heap영역에 할당되지 않았다고 null이라고 출력
				System.out.println(str02.toString());
				실행에러 발생 더 이상 프로그램이 수행되지 않음.
		*/
//		선언 ==> 초기화(null, 객체할당) ==> 사용
//		1. 선언만 하고 초기화 하지 않고는 사용불가(컴파일에러)
//		2. null로 초기화하고,
//			1) 객체자체를 호출(실행에러발생하지 않고) : null
//			2) 객체의 구성요소  index, 속성 : (런타임에러)-실행에러
//				ArrayIndexOutOfBoundsException
//				NullPointerException
//		3. 객체를 생성
//			1) 해당 객체가 가지고 있는 범위 안에 배열/속성 : 호출
//			2) 해당 객체가 가지고 있지 않는 범위의 배열index/속성
//				ArrayIndexOutOfBoundsException
//				NullPointerException
//				특히 for(int idx=0;idx<=배열명.length;idx++)
//					배열의 index는 배열의 크기보다 1작다.
//					배열명[배열크기](X) 호출/할당 에러 발생..
//					String []arry = new String[배열의 크기](O)
		int []intArry; //선언
		String str01;
		String str02;
//		System.out.println(intArry);
//		객체는 초기화를 하여야 컴파일(기계어)로 바뀌어서 메모리에 올릴 수 있다.
		intArry=null; //초기화
		str01=null;
		str02="홍길동";
//		전체 해당 객체의 이름으로 호출하면 null로 표기해준다.
		System.out.println(intArry);
		System.out.println(str01);
		System.out.println(str02);
//		heap영역에 할당되지 않는 객체의 구성요소 호출
		System.out.println("# heap영역 #");
//		배열의 경우 index번호
//		System.out.println(intArry[0]);
//		java.lang.NullPointerException
//		객체의 경우 기능 메서드, 필드(객체의 전역데이터)
//		System.out.println(str01.charAt(0));
//		heap영역에 할당한 경우 정상 처리
		System.out.println(str02.charAt(0));
//		홍길동 : 기능메서드가 지원하는 메모리 범위까지만 호출된다.
//		호출된다 : index 2까지
		System.out.println(str02.charAt(2));
		intArry = new int[3];
		System.out.println(intArry[0]);
		System.out.println(intArry[1]);
		System.out.println(intArry[2]);
//		System.out.println(intArry[3]);
		
//		ex) 문자열로 물건명 3개를 할당하는 배열을 선언하고,
//		각 index별로 호출하고, index범위가 초과할 때, 나오는 에러를 확인하세요.
		String [] name = {"사과","바나나","자두"};		
		System.out.println(name);
//		[Ljava.lang.String;@58ceff1
//			데이터유형 @16진수로 heap영역 주소..
		System.out.println(name[0]);
		System.out.println(name[1]);
		System.out.println(name[2]);
//		System.out.println(name[3]);
		//java.lang.ArrayIndexOutOfBoundsException
//		배열의 범위를 초과할 때 발생
//		NullPointerException
//		해당 데이터에 구성요소에 대한 메모리가 없어 에러발생
	}

}