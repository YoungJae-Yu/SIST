package javaexp.a06_memory;

public class A07_String {

	public static void main(String[] args) {
		/*
		# String의 메모리 활용
		1. String은 char의 배열인 char[]이 고정화되어
			많이 사용하게 됨으로 데이터 유형으로 고착화되어
			유형이 만들어진 것이다.
		2. 문자열은 여러가지 프로그래밍에서 사용되기에 지원하는 
			기능메서드도 많이 필요하여 타입으로 설정이 되었다.
		3. 자바에서 메모리 관리
			1) 객체로 heap에 할당되어 사용..
			2) 자바의 Strin
				- String name1 = "홍길동"
				- String name4 = "홍길동"
				- String name5 = "홍길동"
					직접적으로 데이터를 할당하는 경우는 
					실무적으로 거의 없다. 프로그램 기초시..
					"홍길동" 동일한 이름이 있는 곳은 
					모든 heap영역에 하나만 설정이 된다.
					name1,name4,name5 동일한 heap메모리를 바라본다.
					name1==name4 문자를 비교하는 것이 아니고
						주소값을 비교..
				- String name2 = new String("홍길동");
				- String name3 = new String("");
					new가 들어가는 코드 모두 heap영역에
					새롭게 메모리를 만든다.
					name2==name3 false
					name1==name2 false
			3) 문자열에 대한 내용 자체에 대한 비교할 때는
				.equals()란 메서드를 이용할 때
				주소값 상관없이 내용을 비교하여 같은지 여부를
				retrun 한다.(true/false)
		*/		
		
	}

}
